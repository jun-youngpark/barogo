package com.demo.barogo.jpa.entity;
import com.demo.barogo.common.Const.DeliverSts;
import com.demo.barogo.common.exception.ApiException;
import com.demo.barogo.delivery.dto.DeliveryResponseDto;
import com.demo.barogo.delivery.dto.DeliveryUpdateRequestDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery extends AuditorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryNo;
    @Column(length = 500 , nullable = false)
    private String deliveryAddress;
    @Column(length = 20 , nullable = false)
    private String deliveryZipCode;
    private Integer deliveryAmt;
    @Column(nullable = false)
    private LocalDateTime deliveryAt;
    @Column(length = 128)
    private String ordererId;
    private Long orderNo;
    @Column(length = 20)
    private String deliverSts;


    public DeliveryResponseDto search() {
        return DeliveryResponseDto.builder()
                .deliveryNo(deliveryNo)
                .deliveryAddress(deliveryAddress)
                .deliveryZipCode(deliveryZipCode)
                .deliveryAmt(deliveryAmt)
                .ordererId(ordererId)
                .orderNo(orderNo)
                .deliveryAt(deliveryAt)
                .deliverSts(deliverSts)
                .build();
    }



    public void updateAddress(DeliveryUpdateRequestDto requestDto) {
        if(DeliverSts.DELIVERY.getCode().equals(this.deliverSts) || DeliverSts.COMPLETION.getCode().equals(this.deliverSts)) {
            throw new ApiException("배달이 진행되어 주소 변경이 불가능합니다");
        }
        deliveryNo = requestDto.getDeliveryNo();
        deliveryAddress = requestDto.getDeliveryAddress();
        deliveryZipCode = requestDto.getDeliveryZipCode();
    }
}