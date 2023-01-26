package com.myAssignement2613.skytelTeleServices.service.impl;

import com.myAssignement2613.skytelTeleServices.entity.User;
import com.myAssignement2613.skytelTeleServices.payload.ResultDto;
import com.myAssignement2613.skytelTeleServices.payload.UserDto;
import com.myAssignement2613.skytelTeleServices.payload.UserResponse;
import com.myAssignement2613.skytelTeleServices.repository.UserRepository;
import com.myAssignement2613.skytelTeleServices.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //=====================Q.1 For Create new User======================================================
    @Override
    public UserDto createNewUsers(UserDto userDto) {
        User user = mapToUserEntity(userDto);
        User newUser = userRepository.save(user);
        UserDto newUserDto = mapToUserDto(newUser);
        return newUserDto;
    }
    //====================Q.2 For Read all User Details=================================================
    @Override
    public UserResponse findallUsersDetails(int pageNo,int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> userList = userPage.getContent();

        List<UserDto> userDtoList = userList.stream().map(
                users -> mapToUserDto(users)).collect(Collectors.toList());

        UserResponse userResponse=new UserResponse();
        userResponse.setGetAllDetails(userDtoList);
        userResponse.setPageNo(userPage.getNumber());
        userResponse.setPageSize(userPage.getSize());
        userResponse.setTotalPages(userPage.getTotalPages());
        userResponse.setTotalElements(userPage.getTotalElements());
        userResponse.setLastPage(userPage.isLast());
        return userResponse;
    }
    //======================Q.3 Read name and age from users table=======================================
    @Override
    public List<ResultDto> findUsers(int age) {
        List<User> userList = userRepository.findByAgeGreaterThan(age);

        List<ResultDto> resultDtoList = userList.stream()
                .map(result -> {
                    ResultDto resultDto = new ResultDto();
                    resultDto.setName(result.getName());
                    resultDto.setAge(result.getAge());
                    return resultDto;
                })
                .collect(Collectors.toList());
        return resultDtoList;
        }
    //<-!-convert ENTITY to DTO-!->*********************************************************************
    private UserDto mapToUserDto(User newUser) {
        UserDto userDto=new UserDto();
        userDto.setId(newUser.getId());
        userDto.setName(newUser.getName());
        userDto.setEmail(newUser.getEmail());
        userDto.setDate_of_birth(newUser.getDate_of_birth());
        userDto.setAge(newUser.getAge());
        return userDto;
    }
    //<-!-convert DTO to ENTITY-!->*********************************************************************
    private User mapToUserEntity(UserDto userDto) {
        User user=new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setDate_of_birth(userDto.getDate_of_birth());
        user.setAge(userDto.getAge());
        return user;
    }
}
