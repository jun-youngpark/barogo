package com.demo.barogo.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Orders extends AuditorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNo;
    private LocalDateTime orderAt;
    private Integer orderAmt;
    private Integer deleiverAmt;
    @Column(length = 128)
    private String orderId;

}