package com.authenticator.config;

import java.util.Map;

import com.authenticator.entity.User;

public interface JwtGenerator {

	 Map<String, Object> generateToken(User user);
}
