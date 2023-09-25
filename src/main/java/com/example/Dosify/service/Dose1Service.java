package com.example.Dosify.service;

import com.example.Dosify.Enum.VaccineType;
import com.example.Dosify.model.Dose1;
import com.example.Dosify.model.User;
import org.springframework.stereotype.Service;

@Service
public interface Dose1Service {
    public Dose1 createDose1(User user, VaccineType vaccineType);
}
