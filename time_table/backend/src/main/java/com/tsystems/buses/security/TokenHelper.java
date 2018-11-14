package com.tsystems.buses.security;

import com.tsystems.buses.model.PortalUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenHelper {

    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
    private static final long EXPIRATIONTIME = 1000 * 60 * 30; // 30 minutes
    static final String SECRET = "Secret";
    static final String APP_NAME = "City Routes";
    static final String AUTH_HEADER = "Authorization";

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

//    public String refreshToken(String token, Device device) {
//        String refreshedToken;
//        Date a = timeProvider.now();
//        try {
//            final Claims claims = this.getAllClaimsFromToken(token);
//            claims.setIssuedAt(a);
//            refreshedToken = Jwts.builder()
//                    .setClaims(claims)
//                    .setExpiration(generateExpirationDate(device))
//                    .signWith( SIGNATURE_ALGORITHM, SECRET )
//                    .compact();
//        } catch (Exception e) {
//            refreshedToken = null;
//        }
//        return refreshedToken;
//    }

    public String generateToken(String username) {
        return Jwts.builder()
                .setIssuer( APP_NAME )
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith( SIGNATURE_ALGORITHM, SECRET )
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {

        final String username = getUsernameFromToken(token);
        return (
                username != null && username.equals(userDetails.getUsername())
        );
    }


    public String getToken( HttpServletRequest request ) {
        /**
         *  Getting the token from Authentication header
         *  e.g Bearer your_token
         */
        String authHeader = getAuthHeaderFromHeader( request );
        if ( authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public String getAuthHeaderFromHeader( HttpServletRequest request ) {
        return request.getHeader(AUTH_HEADER);
    }
}
