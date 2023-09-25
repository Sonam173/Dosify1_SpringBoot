package com.example.Dosify.model;

import com.example.Dosify.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Dose2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="dose_id")
    String doseId;
    @Column(name="vaccine_type")
    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;
    @CreationTimestamp
    Date VaccinationDate;
    @OneToOne
    @JoinColumn
    User user;
}
