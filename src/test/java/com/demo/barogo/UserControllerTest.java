package com.demo.barogo;


import com.demo.barogo.user.UserController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void before() throws Exception {
    }

    @AfterEach
    public void after() throws Exception {
    }


    @Test
    public void testSignUp() throws Exception {
        String content = """
                {
                "id": "barogogo1",
                "passwd": "Pwd#12345678793412",
                "name": "바로고1",
                "address": "인천광역시 연수구 테크노파크로 151",
                "email": "test@tesgt.com" \s
                ,"phone":"010-1234-1234"
                }
                  """;
        ResultActions result = mockMvc.perform(
                post("/v1/api/user/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(UserController.class))
                .andExpect(handler().methodName("save"))
                .andExpect(jsonPath("$.success",equalTo("OK")));

    }

    /**
    *
    * Method: signIn(@RequestBody SignUpRequestDto requestDto)
    *
    */
    @Test
    public void testSignIn() throws Exception {
        String content = """
                {
                    "id":"barogogo1",
                    "passwd":"Pwd#12345678793412"
                  """;
        ResultActions result = mockMvc.perform(
                post("/v1/api/user/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(UserController.class))
                .andExpect(handler().methodName("save"))
                .andExpect(jsonPath("$.success",equalTo("OK")));
    }


} 
