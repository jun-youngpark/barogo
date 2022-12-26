package com.demo.barogo.delivery;

import com.demo.barogo.common.exception.ApiException;
import com.demo.barogo.delivery.dto.DeliveryRequestDto;
import com.demo.barogo.delivery.dto.DeliveryResponseDto;
import com.demo.barogo.delivery.dto.DeliveryUpdateRequestDto;
import com.demo.barogo.jpa.entity.Delivery;
import com.demo.barogo.jpa.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public List<DeliveryResponseDto> search(DeliveryRequestDto requestDto) {
        requestDto.checkPeriod();
        return deliveryRepository.findByDeliveryAtBetweenAndOrdererId(requestDto.getSearchStartAt()
                ,requestDto.getSearchEndAt(),requestDto.getOrdererId())
                .stream().map(Delivery::search)
                .collect(Collectors.toList());
    }

    public DeliveryResponseDto updateAddress(DeliveryUpdateRequestDto requestDto) {
        Delivery delivery = deliveryRepository.findById(requestDto.getDeliveryNo()).orElseThrow(()
                -> new ApiException("존재하지않는 배송입니다."));
        delivery.updateAddress(requestDto);
        return  deliveryRepository.save(delivery).search();
    }
}





