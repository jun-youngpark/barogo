package com.demo.barogo.common.Const;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DeliverSts {
    WAIT("WAIT", "배달대기"),
    ASSIGN("ASSIGN", "드라이버 배정"),
    DELIVERY("DELIVERY", "배달중"),
    COMPLETION("COMPLETION", "배달완료");
    private final String code;
    private final String value;

    DeliverSts(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String from(String data) {
        return Arrays.stream(DeliverSts.values())
                .filter(x -> data.equals(x.getCode()))
                .findAny()
                .get().getValue();
    }
}
