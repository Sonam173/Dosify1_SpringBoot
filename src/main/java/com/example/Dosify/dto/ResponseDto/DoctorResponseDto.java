package com.example.Dosify.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class DoctorResponseDto {
    String name;
    String emailId;
    String mobNo;

    CentreResponseDto centreResponseDto;

}
