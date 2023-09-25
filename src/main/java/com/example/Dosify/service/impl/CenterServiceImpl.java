package com.example.Dosify.service.impl;

import com.example.Dosify.dto.RequestDto.CentreRequestDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import com.example.Dosify.model.VaccinationCentre;
import com.example.Dosify.repository.CentreRepository;
import com.example.Dosify.service.VaccinationCentreService;
import com.example.Dosify.transformer.VaccinationCentreTransformer;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterServiceImpl implements VaccinationCentreService {
    @Autowired
    CentreRepository centreRepository;
    @Override
    public CentreResponseDto addCentre(CentreRequestDto centreRequestDto) {
        // dto - entity
        VaccinationCentre vaccinationCentre= VaccinationCentreTransformer.centreRequestDtoToCentre(centreRequestDto);

        // save your db
        VaccinationCentre  savedCentre=centreRepository.save(vaccinationCentre);


        // entity to responsedto
        return VaccinationCentreTransformer.centreToCentreResponseDto(savedCentre);
    }
}
