package com.example.Dosify.service.impl;

import com.example.Dosify.dto.RequestDto.UserRequestDto;
import com.example.Dosify.dto.ResponseDto.UserResponseDto;
import com.example.Dosify.model.User;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.UserService;
import com.example.Dosify.transformer.UserTransformer;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        //first convert request dto to entity

       // User user= new User();
       // user.setName(userRequestDto.getName());
      //  user.setAge(userRequestDto.getAge());
       // user.setEmailId(userRequestDto.getEmailId());
      //  user.setGender(userRequestDto.getGender());
      //  user.setMobNo(userRequestDto.getMobNo());


        // user object using builder
        User user= UserTransformer.userRequestDtoToUser(userRequestDto);


        // save the object in db
       User savedUser= userRepository.save(user);


       //entity to response dto
       // UserResponseDto userResponseDto= new UserResponseDto();
       // userResponseDto.setName(savedUser.getName());
      //  userResponseDto.setMessage("Congrats you are registered on Dosify");
      //  return userResponseDto;


        UserResponseDto userResponseDto=UserTransformer.UserToUserResponseDto(savedUser) ;
        return userResponseDto;




    }
}
