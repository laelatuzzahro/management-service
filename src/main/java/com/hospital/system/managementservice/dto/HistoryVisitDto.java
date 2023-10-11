package com.hospital.system.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryVisitDto {

    private Date dateVisit;
    private String doctorName;
    private String diagnosis;


}
