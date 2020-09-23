package com.iranargham.atmmonitoring.service;


import com.iranargham.atmmonitoring.repository.OauthUserRepository;
import com.iranargham.atmmonitoring.repository.OauthUserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EnhanceUserDetailsService implements UserDetailsService {

    private OauthUserRepository oauthUserRepository;
    private final OauthUserRolesRepository oauthUserRolesRepository;


    @Autowired
    public EnhanceUserDetailsService(OauthUserRepository oauthUserRepository, OauthUserRolesRepository oauthUserRolesRepository) {
        this.oauthUserRepository = oauthUserRepository;
        this.oauthUserRolesRepository = oauthUserRolesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Set<GrantedAuthority> grantedAuthorities = (oauthUserRolesRepository.findRoleByUserName(username)).stream()
                .map(SimpleGrantedAuthority::new).collect(Collectors.toSet());

        return oauthUserRepository
                .findByUserName(username)
                .map(user -> new User(user.getUserName(), user.getPassword(), grantedAuthorities))
                .orElseThrow(() -> new UsernameNotFoundException("Could not find " + username));


    }

}
