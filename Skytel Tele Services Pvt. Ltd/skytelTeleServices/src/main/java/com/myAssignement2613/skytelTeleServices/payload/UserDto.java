package com.myAssignement2613.skytelTeleServices.payload;

import com.myAssignement2613.skytelTeleServices.entity.AbstractClass;
import lombok.*;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends AbstractClass {
    private String name;
    private String email;
    private String date_of_birth;
    private int age;
}
