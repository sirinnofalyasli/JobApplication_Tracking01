package com.nofal.jobtrack_project.controller;


import com.nofal.jobtrack_project.entity.Company;
import com.nofal.jobtrack_project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")

public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }
    @GetMapping // get all companies
    public List<Company> findAll(){
        return companyService.findAll();
    }
    @GetMapping("/{id}") // get by id
    public Company findById(@PathVariable Integer id){
        return companyService.findById(id);
    }
    @PostMapping("/") // create new company
    public Company save(@RequestBody Company company){
        return companyService.save(company);
    }
    @PutMapping("/{id}") // update
    public Company update(@PathVariable Integer id, @RequestBody Company company){
        Company existingCompany = companyService.findById(id);

        existingCompany.setCompanyName(company.getCompanyName());
        existingCompany.setCompanyLocation(company.getCompanyLocation());

        companyService.save(existingCompany);
        return existingCompany;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        companyService.deleteById(id);
    }

}
