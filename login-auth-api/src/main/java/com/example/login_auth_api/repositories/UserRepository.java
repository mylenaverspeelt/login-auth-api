package com.example.login_auth_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login_auth_api.domain.User;

public interface UserRepository extends JpaRepository<User,String>{

}
