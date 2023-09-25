package com.example.Dosify.dto.ResponseDto;

import com.example.Dosify.Enum.DoseNo;
import com.example.Dosify.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {
    String username;
    String appointmentNo;
    Date dateOfAppointment;
    DoseNo doseNo;
    CentreResponseDto centreResponseDto;
    String doctorName;
    VaccineType vaccineType;
}
