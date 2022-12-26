package com.demo.barogo.config.auth;

import com.demo.barogo.jpa.entity.Users;
import com.demo.barogo.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class BasicUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        Users users = userRepository.findById(userid).orElseThrow(() -> new UsernameNotFoundException("회원가입되지 않은 아이디입니다."));
        return createUserDetails(users);
    }

    private UserDetails createUserDetails(Users users) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(users.getRole().toString());
        return new User(
                String.valueOf(users.getId()),
                users.getPasswd(),
                Collections.singleton(grantedAuthority)
        );
    }
}