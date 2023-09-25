package com.example.Dosify.controller;

import com.example.Dosify.dto.RequestDto.CentreRequestDto;
import com.example.Dosify.dto.ResponseDto.CentreResponseDto;
import com.example.Dosify.service.VaccinationCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/centre")
public class VaccinationCentreController {
    @Autowired
    VaccinationCentreService vaccinationCentreService;
    @PostMapping("/add")
    public ResponseEntity addVaccinationCentre(@RequestBody CentreRequestDto centreRequestDto)
    {
       CentreResponseDto centreResponseDto =vaccinationCentreService.addCentre(centreRequestDto);
       return new ResponseEntity<>(centreResponseDto, HttpStatus.CREATED);

    }
}
