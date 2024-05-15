package com.afklm.greenrulestesting.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aircraft")
@RequiredArgsConstructor
@Data
public class Aircraft {

    @Id
    private Long id;

    @Column(name = "aircraft_type")
    private String aircraftType;

    @Column(name = "aircraft_name")
    private String aircraftName;

}
