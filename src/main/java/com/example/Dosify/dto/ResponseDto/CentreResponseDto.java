package com.example.Dosify.dto.ResponseDto;

import com.example.Dosify.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class CentreResponseDto {
    String name;
    String location;
    CenterType centreType;
}
