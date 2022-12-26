package com.demo.barogo.user;

import com.demo.barogo.common.exception.ApiException;
import com.demo.barogo.config.auth.JwtTokenProvider;
import com.demo.barogo.config.auth.TokenDto;
import com.demo.barogo.jpa.entity.Users;
import com.demo.barogo.jpa.repository.UserRepository;
import com.demo.barogo.user.dto.LoginRequestDto;
import com.demo.barogo.user.dto.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;


    public Users SignUp(SignUpRequestDto dto) {
        userRepository.findById(dto.getId()) .ifPresent(e -> {
                    throw new ApiException("이미 가입된 회원 아이디 입니다.");
        }) ;

        return userRepository.save(dto.toUsers(passwordEncoder));
    }

    @Transactional
    public TokenDto signIn(LoginRequestDto loginRequestDto) {
        UsernamePasswordAuthenticationToken authenticationToken = loginRequestDto.toAuthentication();
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto = tokenProvider.generateTokenDto(authentication);
        return tokenDto;
    }

}





