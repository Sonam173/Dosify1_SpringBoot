package com.example.Dosify.service.impl;

import com.example.Dosify.dto.RequestDto.DoctorRequestDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import com.example.Dosify.dto.ResponseDto.DoctorResponseDto;
import com.example.Dosify.exception.CentreNotPresentException;
import com.example.Dosify.model.Doctor;
import com.example.Dosify.model.VaccinationCentre;
import com.example.Dosify.repository.CentreRepository;
import com.example.Dosify.repository.DoctorRepository;
import com.example.Dosify.service.DoctorService;
import com.example.Dosify.transformer.DoctorTransformer;
import com.example.Dosify.transformer.VaccinationCentreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    CentreRepository centreRepository;
    public DoctorResponseDto addDoctor(DoctorRequestDto doctorRequestDto) throws CentreNotPresentException {

        Optional<VaccinationCentre> optionalCenter = centreRepository.findById(doctorRequestDto.getCentreId());
        if(!optionalCenter.isPresent()){
            throw new CentreNotPresentException("Invalid center id!");
        }

        VaccinationCentre center = optionalCenter.get();

        // dto -> entity
        Doctor doctor = DoctorTransformer.DoctorRequestDtoToDoctor(doctorRequestDto);
        doctor.setVaccinationCentre(center);


        // add doctor to current list of doctors at that center
        center.getDoctors().add(doctor);

        VaccinationCentre savedCenter = centreRepository.save(center);  // saves both center and doctor

        // prepare response Dto
        return DoctorTransformer.DoctorToDoctorResponseDto(doctor);
    }
}
