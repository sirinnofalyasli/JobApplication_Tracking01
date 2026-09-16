package com.nofal.jobtrack_project.service;

import com.nofal.jobtrack_project.entity.Company;
import com.nofal.jobtrack_project.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public Company save(Company company){
        return companyRepository.save(company);
    }
    public List<Company>  findAll(){
        return companyRepository.findAll();
    }
    public Company findById(Integer id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            return optionalCompany.get();
        }
        throw new RuntimeException("Company not found. " + id);
    }
    public void deleteById(Integer id){
        if(!companyRepository.existsById(id)){
            throw new RuntimeException("Company not found. " + id);
        }
        companyRepository.deleteById(id);
    }
}
