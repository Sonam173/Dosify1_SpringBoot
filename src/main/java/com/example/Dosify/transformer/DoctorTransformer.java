package com.example.Dosify.transformer;

import com.example.Dosify.dto.RequestDto.DoctorRequestDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import com.example.Dosify.dto.ResponseDto.DoctorResponseDto;
import com.example.Dosify.model.Doctor;
import com.example.Dosify.model.VaccinationCentre;

public class DoctorTransformer {
    public static Doctor DoctorRequestDtoToDoctor(DoctorRequestDto doctorRequestDto)
    {
        return  Doctor.builder()
                .name(doctorRequestDto.getName())
                .age(doctorRequestDto.getAge())
                .mobNo(doctorRequestDto.getMobNo())
                .gender(doctorRequestDto.getGender())
                .emailId(doctorRequestDto.getEmailId())
                .build();

    }

    public static DoctorResponseDto DoctorToDoctorResponseDto(Doctor doctor) {

        CentreResponseDto centreResponseDto= VaccinationCentreTransformer.centreToCentreResponseDto(doctor.getVaccinationCentre());
        return DoctorResponseDto.builder()
                .name(doctor.getName())
                .emailId(doctor.getEmailId())
                .mobNo(doctor.getMobNo())
                .centreResponseDto(centreResponseDto)
                .build();
    }
}

