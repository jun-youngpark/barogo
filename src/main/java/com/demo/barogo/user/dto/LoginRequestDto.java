package com.demo.barogo.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "로그인 API ", description = "로그인에 대한 항목입니다 (JWT)")
public class LoginRequestDto {

    @ApiModelProperty(value = "아이디", example = "barogogo1")
    private String id;

    @ApiModelProperty(value = "비밀번호", example = "Barogo123#")
    private String passwd;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(id, passwd);
    }
}
