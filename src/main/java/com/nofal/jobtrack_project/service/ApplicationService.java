package com.nofal.jobtrack_project.service;

import ch.qos.logback.core.read.ListAppender;
import com.nofal.jobtrack_project.entity.Application;
import com.nofal.jobtrack_project.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    public Application save(Application application){
        return applicationRepository.save(application);
    }
    public List<Application>  findAll(){
        return applicationRepository.findAll();
    }
    public Application findById(Integer id) {
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        if (optionalApplication.isPresent()) {
            return optionalApplication.get();
        } else {
            throw new RuntimeException("Application not found. " + id);
        }
    }
    public void deleteById(Integer id){
        if(!applicationRepository.existsById(id)){
            throw new RuntimeException("Application not found. "+ id);
        }
        applicationRepository.deleteById(id);
    }
    }

