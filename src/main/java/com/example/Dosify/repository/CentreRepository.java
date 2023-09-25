package com.example.Dosify.repository;

import com.example.Dosify.model.VaccinationCentre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentreRepository extends JpaRepository<VaccinationCentre,Integer> {
}
