package com.nofal.jobtrack_project.controller;

import com.nofal.jobtrack_project.entity.Application;
import com.nofal.jobtrack_project.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")

public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping // creating
    public Application save(@RequestBody Application application){

        return applicationService.save(application);
    }
    @GetMapping("/") // get all applications
    public List<Application> findAll(){
        return applicationService.findAll();
    }
    @GetMapping("/{id}") // get by id
    public Application findById(@PathVariable Integer id){
        return applicationService.findById(id);
    }
    @PutMapping("/") // updating
    public Application update(@RequestBody Application application, @PathVariable Integer id){
        Application existingApplication = applicationService.findById(id);

        existingApplication.setApplicationDate(application.getApplicationDate());
        existingApplication.setApplicationStatus(application.getApplicationStatus());
        existingApplication.setApplicationLink(application.getApplicationLink());

        return applicationService.save(existingApplication);

    }
    @DeleteMapping("/{id}") // delete by id

    public void  delete(@PathVariable Integer id){
        applicationService.deleteById(id);
    }
}
