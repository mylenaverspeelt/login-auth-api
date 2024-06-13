package com.example.login_auth_api.infra.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.login_auth_api.domain.User;
import com.example.login_auth_api.repositories.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = this.repository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario nao foi encontrado"));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				new ArrayList<>());

	}
}
