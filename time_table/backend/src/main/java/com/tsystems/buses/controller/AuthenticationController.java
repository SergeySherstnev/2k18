package com.tsystems.buses.controller;

import org.dozer.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsystems.buses.model.AccountDto;
import com.tsystems.buses.model.PortalUserDto;
import com.tsystems.buses.security.JwtAuthenticationRequest;
import com.tsystems.buses.security.TokenHelper;
import com.tsystems.buses.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@RestController
@RequestMapping( value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE )
public class AuthenticationController {

    @Autowired
    TokenHelper tokenHelper;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private Mapper mapperDozer;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody JwtAuthenticationRequest authenticationRequest,
            HttpServletResponse response
    ) throws AuthenticationException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        String reqUsername = authenticationRequest.getUsername();
        String reqPassword = authenticationRequest.getPassword();

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        reqUsername,
                        reqPassword,
                        Collections.emptyList()
                )
        );

        // Inject into security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // token creation
        String jws = tokenHelper.generateToken( reqUsername);
        PortalUserDto byLoginId = userDetailsService.findByLoginId(reqUsername);
        AccountDto objDto = mapperDozer.map(byLoginId, AccountDto.class);
        objDto.setToken(jws);

        String reqBody = mapper.writeValueAsString(objDto);
        // Return the token
        return ResponseEntity.ok(reqBody);
    }

}
