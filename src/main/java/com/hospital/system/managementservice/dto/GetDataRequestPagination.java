package com.hospital.system.managementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetDataRequestPagination {

    private Integer pageNumber;
    private Integer pageSize;
    private String sortBy;
    private String direction;
}

