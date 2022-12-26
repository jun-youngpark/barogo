package com.demo.barogo.delivery.dto;

import com.demo.barogo.common.Vaild.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "배달 수정 API ", description = "배달 수정 API 대한 항목입니다")
public class DeliveryUpdateRequestDto {

    @NotNull(message = "배달 번호를 입력해주세요." ,groups = update.class)
    @ApiModelProperty(value = "배달번호", example = "5")
    private Long deliveryNo;

    @ApiModelProperty(value = "수정할 배송지", example = "서울특별시 구로구 지하이시티")
    @NotNull(message = "베송지를 입력해주세요" ,groups = update.class)
    private String deliveryAddress;

    @ApiModelProperty(value = "수정할 배송지 우편번호", example = "21231")
    @NotNull(message = "배송지 우편번호를 입력해주세요" ,groups = update.class)
    private String deliveryZipCode;

    private String deliverSts;


    @Builder
    public DeliveryUpdateRequestDto(Long deliveryNo, String deliveryAddress, String deliveryZipCode, String deliverSts) {
        this.deliveryNo = deliveryNo;
        this.deliveryAddress = deliveryAddress;
        this.deliveryZipCode = deliveryZipCode;
        this.deliverSts = deliverSts;
    }


    public DeliveryUpdateRequestDto updateAddress() {
    return DeliveryUpdateRequestDto.builder()
            .deliveryNo(deliveryNo)
            .deliveryAddress(deliveryAddress)
            .deliveryZipCode(deliveryZipCode)
            .build();
    }
}
