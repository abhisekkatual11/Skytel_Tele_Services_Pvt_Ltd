package com.myAssignement2613.skytelTeleServices.entity;

//import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractClass {

    private String name;

    @Column(name="EMAIL_ID",nullable = false,length = 128,unique = true)
    private String email;

    @Column(name="DOB",nullable = false)
    private String date_of_birth;

    private int age;
}
