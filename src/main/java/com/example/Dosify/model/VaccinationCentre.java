package com.example.Dosify.model;

import com.example.Dosify.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class VaccinationCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="name")
    String name;
    @Column(name="location")
    String location;
    @Column(name="centre_type")
    @Enumerated(EnumType.STRING)
    CenterType centreType;

    @OneToMany(mappedBy ="vaccinationCentre",cascade = CascadeType.ALL)
    List<Doctor> doctors= new ArrayList<>();

}
