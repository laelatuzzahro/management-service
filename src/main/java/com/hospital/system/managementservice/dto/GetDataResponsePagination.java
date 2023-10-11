package com.hospital.system.managementservice.dto;

import com.hospital.system.managementservice.model.Doctor;
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
public class GetDataResponsePagination {

    private int totalPages;
    private long totalElements;
    private int numberOfElements;
    private int pageNumber;
    private List<Patient> contentPatient;
    private List<Doctor> contentDoctor;
}
