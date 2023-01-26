package com.myAssignement2613.skytelTeleServices.entity;

//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//@Data
@Getter
@Setter
@MappedSuperclass
public class AbstractClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
