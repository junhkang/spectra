package com.example.spectra.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("queryDTO")
public class QueryDTO {
    private String query;
    private double totalExecTime;
    private int calls;
    private double minExecTime;
    private double meanExecTime;
    private double stddevExecTime;
    private long rows;
}
