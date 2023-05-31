package com.salary_tool.salary_backend;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3000/admin"})
public class SalaryController {

    @PostMapping("/processNumbers")
    public ResponseEntity<SalaryDTO> processNumbers(@RequestBody SalaryInDTO numbers) {
        SalaryDTO salaryResults; // 1=SalaryTotal   2=SeniorityPlus   3= loyaltyPlus   4=responsibilityPlus
        salaryResults=SalaryFunctions.calculateSalary(numbers);
        return ResponseEntity.ok(salaryResults);
    }
}

