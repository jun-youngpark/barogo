package com.demo.barogo.jpa.entity;

import com.demo.barogo.common.Vaild;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Users extends AuditorEntity {
    @Id
    @Column(length = 128)
    private String id;
    @Column(length = 256,nullable = false)
    private String passwd;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 128)
    private String email;
    @Column(length = 128)
    private String phone;
    @Column(length = 500)
    private String address;
    @Column(length = 10)
    private String zipCode;
    @Column(length = 50)
    private String grade;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public Users(String id, String passwd, String name, String email, String phone, String address, String zipCode, String grade, Role role) {
        this.id = id;
        this.passwd = passwd;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.zipCode = zipCode;
        this.grade = grade;
        this.role = role;
    }



}