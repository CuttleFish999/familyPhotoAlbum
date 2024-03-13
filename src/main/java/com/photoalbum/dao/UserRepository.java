package com.photoalbum.dao;

import com.photoalbum.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // 通过用户名查找用户
    Users findByUserName(String userName);

    // 通过电子邮件查找用户
    Users findByEmail(String email);

    Users findByUserNameAndPassword(String userName, String password);
}