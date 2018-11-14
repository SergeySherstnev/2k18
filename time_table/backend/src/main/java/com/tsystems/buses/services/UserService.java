package com.tsystems.buses.services;

import com.tsystems.buses.controller.NotFoundException;
import com.tsystems.buses.entity.PortalUser;
import com.tsystems.buses.entity.enums.UserRoleEnum;
import com.tsystems.buses.model.PortalUserDto;
import com.tsystems.buses.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Mapper mapper;

    public List<PortalUserDto> getUsers() {
        List<PortalUser> portalUsers = (List<PortalUser>) userRepository.findAll();
        List<PortalUserDto> portalUserDtos = new ArrayList<>();
        for(PortalUser portalUser : portalUsers){
            portalUserDtos.add(mapper.map(portalUser, PortalUserDto.class));
        }
        return portalUserDtos;
    }

    public PortalUserDto findByLoginId(String loginId) {
        PortalUser portalUser = new PortalUser();
        try {
            portalUser = userRepository.findByLoginId(loginId).get(0);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            portalUser = null;
        }
        if (portalUser != null) {
            PortalUserDto projectDto = mapper.map(userRepository.findByLoginId(loginId).get(0), PortalUserDto.class);
            return projectDto;
        }
        else {
            return null;
        }
    }

    public PortalUserDto getUserById(Long id) {
        PortalUserDto projectDto = mapper.map(userRepository.findById(id), PortalUserDto.class);
        return projectDto;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        PortalUserDto userDto = findByLoginId(id);
        UserDetails userDetails = null;

        if (userDto != null) {
            Set<GrantedAuthority> roles = new HashSet();
            roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
            userDetails = new User(userDto.getLoginId(), userDto.getPassword(), roles);
            return userDetails;
        }
        else
            throw new UsernameNotFoundException("User not found");

//        return userDetails;
    }
}
