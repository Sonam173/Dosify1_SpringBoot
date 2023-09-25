package com.example.Dosify.service;

import com.example.Dosify.dto.RequestDto.DoctorRequestDto;
import com.example.Dosify.dto.RequestDto.UserRequestDto;
import com.example.Dosify.dto.ResponseDto.DoctorResponseDto;
import com.example.Dosify.dto.ResponseDto.UserResponseDto;
import com.example.Dosify.exception.CentreNotPresentException;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
    public DoctorResponseDto addDoctor(DoctorRequestDto DoctorRequestDto) throws CentreNotPresentException;
}
