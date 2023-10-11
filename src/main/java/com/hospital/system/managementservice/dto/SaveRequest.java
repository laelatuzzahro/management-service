package com.hospital.system.managementservice.dto;

import com.hospital.system.managementservice.model.Doctor;
import com.hospital.system.managementservice.model.HistoryVisit;
import com.hospital.system.managementservice.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveRequest {

    private Patient patient;
    private Doctor doctor;
    private HistoryVisit historyVisit;
}
