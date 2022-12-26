package com.demo.barogo.user.dto;

import com.demo.barogo.common.Vaild.create;
import com.demo.barogo.jpa.entity.Role;
import com.demo.barogo.jpa.entity.Users;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "회원가입 API ", description = "회원가입에 대한 항목입니다")
public class SignUpRequestDto {

    @ApiModelProperty(value = "아이디", example = "barogogo1")
    @NotNull(message = "아이디를 입력해주세요" , groups = create.class)
    private String id;

    @ApiModelProperty(value = "비밀번호", example = "Barogo123#")
    @NotNull(message = "비밀번호를 입력해주세요" , groups = create.class)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{12,}",
            message = "비밀번호는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로" +
                    "  12자리 이상의 문자열로 생성해야 합니다." , groups = create.class)
    private String passwd;

    @ApiModelProperty(value = "이름", example = "김길동")
    @NotNull(message = "이름을 입력해주세요" , groups = create.class)
    private String name;

    @ApiModelProperty(value = "이메일주소", example = "test@test.com")
    private String email;

    @ApiModelProperty(value = "핸드폰번호", example = "010-1234-1234")
    private String phone;

    @ApiModelProperty(value = "주소", example = "서울시 강서구 까치산 아파트")
    @NotNull(message = "주소를 입력해주세요" , groups = create.class)
    private String address;

    @ApiModelProperty(value = "우편번호", example = "50012")
    private String zipCode;

    public Users toUsers(PasswordEncoder passwordEncoder) {
        return Users.builder()
                .id(id)
                .passwd(passwordEncoder!=null?passwordEncoder.encode(passwd):null)
                .name(name)
                .email(email)
                .phone(phone)
                .address(address)
                .zipCode(zipCode)
                .role(Role.ROLE_USER)
                .build();
    }


}
