package com.example.Dosify.transformer;

import com.example.Dosify.dto.RequestDto.CentreRequestDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import com.example.Dosify.model.VaccinationCentre;

public class VaccinationCentreTransformer {
    public static VaccinationCentre centreRequestDtoToCentre(CentreRequestDto centreRequestDto)
    {
        return  VaccinationCentre.builder()
                .name(centreRequestDto.getName())
                .location(centreRequestDto.getLocation())
                .centreType(centreRequestDto.getCentreType())
                .build();
    }
    public static CentreResponseDto centreToCentreResponseDto(VaccinationCentre centre)
    {
        return CentreResponseDto.builder()
                .name(centre.getName())
                .location(centre.getLocation())
                .centreType(centre.getCentreType())
                .build();
    }

}
