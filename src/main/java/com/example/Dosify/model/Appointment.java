package com.example.Dosify.model;

import com.example.Dosify.Enum.DoseNo;
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
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="appointment_no")
    String appointmentNo;// genrate using uuid
    @CreationTimestamp
    Date dateOfAppointment;
    @Column(name="dose_no")
    @Enumerated(EnumType.STRING)
    DoseNo doseNo;
    @ManyToOne
    @JoinColumn
    User user;
    @ManyToOne
    @JoinColumn
    Doctor doctor;



}
