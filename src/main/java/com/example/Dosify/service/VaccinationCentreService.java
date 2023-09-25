package com.example.Dosify.service;

import com.example.Dosify.dto.RequestDto.CentreRequestDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface VaccinationCentreService {
   public CentreResponseDto addCentre(CentreRequestDto centreRequestDto);
}