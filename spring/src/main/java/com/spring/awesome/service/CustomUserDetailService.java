package com.spring.awesome.service;

import java.util.Optional;
import java.util.List;

import com.spring.awesome.model.User;
import com.spring.awesome.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Carregando load com permissões a partir do usuário no banco de dados
 */
@Service // Necesário para Autowirede funcionar e marcar classe como classe de serviço
public class CustomUserDetailService implements UserDetailsService {

  private final UserRepository userRepository;

  @Autowired
  public CustomUserDetailService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = Optional.ofNullable(userRepository.findByUsername(username))
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
    List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

    return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
        user.isAdmin() ? authorityListAdmin : authorityListUser);
  }
}