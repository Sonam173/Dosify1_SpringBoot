package com.example.Dosify.service.impl;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.dto.RequestDto.AppointmentRequestDto;
import com.example.Dosify.dto.ResponseDto.AppointmentResponseDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import com.example.Dosify.exception.DoctorNotFoundException;
import com.example.Dosify.exception.NotEligibleForDoseException;
import com.example.Dosify.exception.UserNotFoundException;
import com.example.Dosify.model.*;
import com.example.Dosify.repository.DoctorRepository;
import com.example.Dosify.repository.UserRepository;
import com.example.Dosify.service.AppointmentService;
import com.example.Dosify.service.Dose1Service;
import com.example.Dosify.service.Dose2Service;
import com.example.Dosify.transformer.VaccinationCentreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Dose1Service dose1Service;
    @Autowired
    Dose2Service dose2Service;

    @Override
    public AppointmentResponseDto bookAppointment(AppointmentRequestDto appointmentRequestDto) throws UserNotFoundException, DoctorNotFoundException, NotEligibleForDoseException {
        Optional<User> optionalUser = userRepository.findById(appointmentRequestDto.getUserId());
        if (!optionalUser.isPresent())/// checking user is exist or not
        {
            throw new UserNotFoundException("user does not exist!");
        }


        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentRequestDto.getDoctorId());
        if (!optionalDoctor.isPresent())// if doctor not present , what will do
        {
            throw new DoctorNotFoundException("doctor does not exist!");
        }


        // if both will exist
        User user = optionalUser.get();
        Doctor doctor = optionalDoctor.get();


        // check which dose , user booked
        if (appointmentRequestDto.getDoseNo() == DoseNo.DOSE_1)// for dose1
        {
            Dose1 dose1 = dose1Service.createDose1(user, appointmentRequestDto.getVaccineType());
            user.setDose1Taken(true);
            user.setDose1(dose1);
        }
        else
        {
            //dose2
            if (!user.isDose1Taken())// if user not taken dose1 throw exception
                 {
                throw new NotEligibleForDoseException("Sorry! You are not eligible for dose2");
                }
            Dose2 dose2 = dose2Service.createDose2(user, appointmentRequestDto.getVaccineType());
            user.setDose2Taken(true);
            user.setDose2( dose2);
        }
        Appointment appointment = Appointment.builder()
                .appointmentNo(String.valueOf(UUID.randomUUID()))
                .doseNo(appointmentRequestDto.getDoseNo())
                .user(user)
                .doctor(doctor)
                .build();
        doctor.getAppointments().add(appointment);
        user.getAppointments().add(appointment);
        userRepository.save(user);// save dose1/dose2 and appointment

        //prepare response dto
        CentreResponseDto centreResponseDto = VaccinationCentreTransformer.centreToCentreResponseDto(doctor.getVaccinationCentre());

        return AppointmentResponseDto.builder()
                .username(user.getName())
                .appointmentNo(appointment.getAppointmentNo())
                .dateOfAppointment(appointment.getDateOfAppointment())
                .doseNo(appointment.getDoseNo())
                .doctorName(doctor.getName())
                .centreResponseDto(centreResponseDto)
                .vaccineType(appointmentRequestDto.getVaccineType())
                .build();
    }
}

