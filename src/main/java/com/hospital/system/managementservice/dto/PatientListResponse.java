package com.hospital.system.managementservice.dto;

import com.hospital.system.managementservice.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientListResponse {
    private List<Patient> listPatient;
}
