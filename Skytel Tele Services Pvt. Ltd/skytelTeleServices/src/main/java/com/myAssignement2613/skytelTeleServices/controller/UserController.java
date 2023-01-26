package com.myAssignement2613.skytelTeleServices.controller;

import com.myAssignement2613.skytelTeleServices.payload.ResultDto;
import com.myAssignement2613.skytelTeleServices.payload.UserDto;
import com.myAssignement2613.skytelTeleServices.payload.UserResponse;
import com.myAssignement2613.skytelTeleServices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //1. POST to /user: To save user's name, email and date of birth in database
    @PostMapping
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.createNewUsers(userDto), HttpStatus.CREATED);
    }

    //2. GET to /user?limit={n}: To return n number of user details
    @GetMapping
    public UserResponse getAllUsersDetails(
            @RequestParam(value="pageNo",defaultValue = "0",required = false)int pageNo,
            @RequestParam(value="limit",defaultValue = "10",required = false)int pageSize
    ){
        UserResponse userResponse = userService.findallUsersDetails(pageNo, pageSize);
        return userResponse;
    }

    //3. GET to /user/ages?gt={n}: To return user names and ages whose age is greater than n
    @GetMapping("/ages")
    public List<ResultDto> age(
            @RequestParam(name = "gt",defaultValue = "10",required = false)int gt
    ){
        List<ResultDto> resultDtos = userService.findUsers(gt);
        return resultDtos;
    }
}
