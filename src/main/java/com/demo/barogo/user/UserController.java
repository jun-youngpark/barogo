package com.demo.barogo.user;

import com.demo.barogo.common.ControllerHandler;
import com.demo.barogo.common.Vaild.create;
import com.demo.barogo.user.dto.LoginRequestDto;
import com.demo.barogo.user.dto.SignUpRequestDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* */
@RestController
@RequestMapping("/v1/api/user")
@Api("사용자(딜리버리) API")
public class UserController extends ControllerHandler {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value="회원가입 API", notes="회원가입을 합니다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 400, message = "잘못된 요청값"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody @ApiParam(value = "회원 가입 요청")
                                        @Validated(create.class) SignUpRequestDto requestDto) {
        return success(userService.SignUp(requestDto).getName());
    }

    @ApiOperation(value="로그인 API", notes="로그인을 합니다  ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 400, message = "잘못된 요청값"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody LoginRequestDto requestDto) {
        return  success(userService.signIn(requestDto));
    }



}
