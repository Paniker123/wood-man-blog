package com.woodman.woodmanblog.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Create by vitalii 4.11.18
 */

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    /**
     * Look ${app.mJwtSecret} at application.properties
     */

    @Value("${app.jwtSecret}")
    private String mJwtSecret;

    /**
     * Look ${app.mJwtExpirationInMs} at application.properties
     */
    @Value("${app.jwtExpirationInMs}")
    private int mJwtExpirationInMs;


    public String generateToken(Authentication authentication) {
        var userPrincipal = (UserPrincipal) authentication.getPrincipal();

        var currentTime = new Date();
        var expiringDate = new Date(currentTime.getTime() + mJwtExpirationInMs);

        return Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(currentTime)
                .setExpiration(expiringDate)
                .signWith(SignatureAlgorithm.HS256, mJwtSecret)
                .compact();

    }

    public Long getUserIdFromJWT(String token) {
        return Long.parseLong(Jwts.parser()
                .setSigningKey(mJwtSecret)
                .parseClaimsJwt(token)
                .getBody().getSubject());
    }

    public ValidationToken validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(mJwtSecret).parseClaimsJws(authToken);
            return new ValidationToken(true, "Is valid");
        } catch (SignatureException
                | MalformedJwtException
                | ExpiredJwtException
                | UnsupportedJwtException
                | IllegalArgumentException
                ex) {
            logger.error(ex.getMessage());
            return new ValidationToken(false, ex.getMessage());
        }
    }

    public class ValidationToken {
        private boolean isValid;
        private String message;

        ValidationToken(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }
    }

}
