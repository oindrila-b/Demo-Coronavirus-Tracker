package com.example.covid19tracker.controllers;

import com.example.covid19tracker.models.LocationStats;
import com.example.covid19tracker.service.CoronavirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CovidTrackerController {

    @Autowired
    CoronavirusDataService coronavirusDataService;

    @GetMapping(value = "/")
    public String  homePage(Model model) {
        List<LocationStats> allStats = coronavirusDataService.getAllStats();
        int totalCasesReported = allStats.stream().mapToInt(stat -> stat.getLatestCasesReported()).sum();
        int totalNewCasesReported = allStats.stream().mapToInt(stat -> stat.getDiffInReportedCases()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalCasesReported);
        model.addAttribute("totalNewReportedCases", totalNewCasesReported);
        return "homePage";
    }
}
