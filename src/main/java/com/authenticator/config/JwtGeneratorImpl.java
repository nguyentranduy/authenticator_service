package com.authenticator.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.authenticator.entity.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGeneratorImpl implements JwtGenerator {
	
	@Value("${jwt.secret}")
    private String secret;

	@Override
	public Map<String, Object> generateToken(User user) {
		String jwtToken="";
        jwtToken = Jwts.builder().setSubject(user.getUsername())
        		.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secret").compact();
        Map<String, Object> jwtTokenGen = new HashMap<>();
        jwtTokenGen.put("token", jwtToken);
        jwtTokenGen.put("user", user);
        return jwtTokenGen;
	}
}
