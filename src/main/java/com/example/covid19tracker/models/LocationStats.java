package com.example.covid19tracker.models;

import lombok.Data;

@Data
public class LocationStats {

    private String state;
    private String country;
    private int latestCasesReported;
    private int diffInReportedCases;
}
