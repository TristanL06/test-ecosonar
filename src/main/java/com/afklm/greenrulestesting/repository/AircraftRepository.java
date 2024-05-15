package com.afklm.greenrulestesting.repository;

import com.afklm.greenrulestesting.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
