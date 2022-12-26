package com.demo.barogo.delivery.dto;

import com.demo.barogo.common.Vaild;
import com.demo.barogo.common.Vaild.*;
import com.demo.barogo.common.exception.ApiException;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "배달 조회 API ", description = "배달 조회 API 대한 항목입니다. 배달 조회 최대 기간은 3일입니다.")
public class DeliveryRequestDto {

    @NotNull(message = "배달조회 시작일을 입력해주세요",groups = get.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "배달 조회 시작 시간", example = "2022-12-24 00:00:00")
    private LocalDateTime searchStartAt;

    @ApiModelProperty(value = "배달 조회 종료 시간", example = "2022-12-27 00:00:00")
    @NotNull(message = "배달조회 종료일을 입력해주세요" ,groups = get.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime searchEndAt;

    @NotNull(message = "아이디를 입력해주세요." ,groups = get.class)
    private String ordererId;


    public void checkPeriod(){
        if (Period.between(searchStartAt.toLocalDate(), searchEndAt.toLocalDate()).getDays() > 3) {
            throw new ApiException("배달 조회 기간은 최대 3일 입니다.");
        }
    }




}
