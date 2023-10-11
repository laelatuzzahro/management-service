package com.hospital.system.managementservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history_visit")
public class HistoryVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_patient")
    private Long idPatient;

    @Column(name = "id_doctor")
    private Long idDoctor;

    @Column(name = "visit_date")
    private Date visitDate;

    @Column(name = "diagnosis")
    private String diagnosis;




}
