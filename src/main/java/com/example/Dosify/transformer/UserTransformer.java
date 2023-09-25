package com.example.Dosify.transformer;

import com.example.Dosify.dto.RequestDto.UserRequestDto;
import com.example.Dosify.dto.ResponseDto.UserResponseDto;
import com.example.Dosify.model.User;

public class UserTransformer {
    public static User userRequestDtoToUser(UserRequestDto userRequestDto)
    {
       return User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .emailId(userRequestDto.getEmailId())
                .gender(userRequestDto.getGender())
                .mobNo(userRequestDto.getMobNo())
                .build();
    }
    public static UserResponseDto UserToUserResponseDto(User user)
    {
        return UserResponseDto.builder()
                .name(user.getName())
                .message("Congrats you are registered on Dosify")
                .build();

    }
}
