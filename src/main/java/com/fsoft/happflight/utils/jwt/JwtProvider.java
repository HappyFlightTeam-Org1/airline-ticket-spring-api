package com.fsoft.happflight.utils.jwt;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtProvider {
    private static final String JWT_SECRET_KEY = "MOCK_PROJECT";

    private static final long EXPIRY_DURATION = 30L * 86400 * 1000;

    private static final long RESET_EXPIRY_DURATION = 10L * 60 * 1000;

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRY_DURATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
    }

    public static String generateResetToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + RESET_EXPIRY_DURATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(JWT_SECRET_KEY)
                .parseClaimsJws(token);
            return true;
        }
        catch (MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
