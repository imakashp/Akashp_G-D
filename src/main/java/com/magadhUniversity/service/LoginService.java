package com.magadhUniversity.service;

import com.magadhUniversity.model.User;

public interface LoginService {
    User validateUser(String username, String password);
}
