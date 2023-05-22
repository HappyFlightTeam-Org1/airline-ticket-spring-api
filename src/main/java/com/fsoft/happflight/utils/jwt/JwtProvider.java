package com.fsoft.happflight.utils.jwt;

import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private static final String JWT_SECRET_KEY = "MOCK_PROJECT";

    private static final long EXPIRY_DURATION = 30L * 86400 * 1000;


}
