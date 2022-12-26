package com.demo.barogo;

import com.demo.barogo.delivery.DeliveryController;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DeliveryControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void before() throws Exception {
    }

    @AfterEach
    public void after() throws Exception {
    }

/** 
* 
* Method: search(@RequestBody DeliveryRequestDto requestDto) 
* 
*/ 
    @Test
    public void testSearch() throws Exception {
        String content = """
                {
                    "searchStartAt": "2022-12-24 00:00:00",
                    "searchEndAt": "2022-12-27 09:00:00" ,
                    "ordererId":"barogo1"
                }
                      """;
        ResultActions result = mockMvc.perform(
                get("/v1/api/delivery/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(DeliveryController.class))
                .andExpect(handler().methodName("search"))
                .andExpect(jsonPath("$.success",equalTo("OK")));

    }

    /**
    *
    * Method: update_address(@RequestBody DeliveryUpdateRequestDto requestDto)
    *
    */
    @Test
    public void testUpdate_address() throws Exception {
        String content = """
                {
                    "searchStartAt": "2022-12-24 00:00:00",
                    "searchEndAt": "2022-12-27 09:00:00" ,
                    "ordererId":"barogo1"
                }
                      """;
        ResultActions result = mockMvc.perform(
                get("/v1/api/delivery/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(content)
        );
        result.andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(DeliveryController.class))
                .andExpect(handler().methodName("search"))
                .andExpect(jsonPath("$.success",equalTo("OK")));
    }


} 
