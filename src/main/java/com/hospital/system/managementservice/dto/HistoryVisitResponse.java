package com.hospital.system.managementservice.dto;

import java.util.Date;

@SuppressWarnings("all")
public interface HistoryVisitResponse {
    String getDoctorName();
    Date getVisistDate();
    String getDiagnosis();


}
