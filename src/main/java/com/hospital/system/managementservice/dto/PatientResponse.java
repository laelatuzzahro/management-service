package com.hospital.system.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {

    private String nama;
    private String nik;
    private String address;
    private List<HistoryVisitDto> historyVisitList;
}
