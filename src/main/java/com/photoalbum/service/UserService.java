package com.photoalbum.service;

import com.photoalbum.dao.UserRepository;
import com.photoalbum.model.Users;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession httpSession;

    public Users findByUserNameAndPassword(String userName, String password) {
        httpSession.setAttribute("userName", userName);
        return userRepository.findByUserNameAndPassword(userName, password);
    }

}
