package com.demo.barogo.delivery;

import com.demo.barogo.common.ControllerHandler;
import com.demo.barogo.common.Vaild.*;
import com.demo.barogo.delivery.dto.DeliveryRequestDto;
import com.demo.barogo.delivery.dto.DeliveryUpdateRequestDto;
import com.demo.barogo.user.dto.SignUpRequestDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*
* */
@RestController
@RequestMapping("/v1/api/delivery")
@Api("배달 API")
public class DeliveryController extends ControllerHandler {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @ApiOperation(value="배달조회 API", notes="배달 내역을 조회 합니다")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 400, message = "잘못된 요청값"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestBody @ApiParam(value = "배달 조회")
                                        @Validated(get.class) DeliveryRequestDto requestDto) {
        return success(deliveryService.search(requestDto));
    }

    @ApiOperation(value="배송지 변경 API", notes="배송지를 변경 합니다" +
            "* 예외 : 배달중이거나 배달 완료인 배송 건은 변경이 불가능합니다. ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 400, message = "잘못된 요청값"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PutMapping("/update/address")
    public ResponseEntity<?> update_address(@RequestBody @ApiParam(value = "배송지 변경")
                                                @Validated(update.class) DeliveryUpdateRequestDto requestDto) {
        return success(deliveryService.updateAddress(requestDto.updateAddress()));
    }



}
