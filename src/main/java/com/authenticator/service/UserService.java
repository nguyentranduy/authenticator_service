package com.authenticator.service;

import com.authenticator.entity.User;

public interface UserService {

	User findByUsernameAndPassword(String username, String password);
}
