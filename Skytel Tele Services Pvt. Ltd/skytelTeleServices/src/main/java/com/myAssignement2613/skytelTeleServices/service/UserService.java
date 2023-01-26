package com.myAssignement2613.skytelTeleServices.service;

import com.myAssignement2613.skytelTeleServices.payload.ResultDto;
import com.myAssignement2613.skytelTeleServices.payload.UserDto;
import com.myAssignement2613.skytelTeleServices.payload.UserResponse;

import java.util.List;

public interface UserService {
    //________________________Q.1 create user_________________________________________________
    public UserDto createNewUsers(UserDto userDto);

    //------------------------Q.2 get All User Details----------------------------------------
    public UserResponse findallUsersDetails(int pageNo, int pageSize);

    //------------------------Q.3 get user name and age whose age is gt than n----------------------------------------
    List<ResultDto> findUsers(int age);
}
