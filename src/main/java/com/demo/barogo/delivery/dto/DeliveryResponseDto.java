package com.demo.barogo.delivery.dto;

import com.demo.barogo.common.Const.DeliverSts;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(value = "배달 조회")
public class DeliveryResponseDto {
    @ApiModelProperty(value = "배달번호")
    private Long deliveryNo;
    @ApiModelProperty(value = "배송지")
    private String deliveryAddress;
    @ApiModelProperty(value = "배송지 우편번호")
    private String deliveryZipCode;
    @ApiModelProperty(value = "배달 비용")
    private Integer deliveryAmt;
    @ApiModelProperty(value = "배송 요청 시간")
    private LocalDateTime deliveryAt;
    @ApiModelProperty(value = "주문자 ID")
    private String ordererId;
    @ApiModelProperty(value = "주문 번호")
    private Long orderNo;
    @ApiModelProperty(value = "배달 상태")
    private String deliverSts;

    @Builder
    public DeliveryResponseDto(Long deliveryNo, String deliveryAddress, String deliveryZipCode, Integer deliveryAmt, LocalDateTime deliveryAt, String ordererId, Long orderNo, String deliverSts) {
        this.deliveryNo = deliveryNo;
        this.deliveryAddress = deliveryAddress;
        this.deliveryZipCode = deliveryZipCode;
        this.deliveryAmt = deliveryAmt;
        this.deliveryAt = deliveryAt;
        this.ordererId = ordererId;
        this.orderNo = orderNo;
        this.deliverSts = DeliverSts.from(deliverSts);
    }


}
