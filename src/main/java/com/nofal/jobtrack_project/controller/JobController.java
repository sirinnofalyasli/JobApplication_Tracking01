package com.nofal.jobtrack_project.controller;

import com.nofal.jobtrack_project.entity.Job;
import com.nofal.jobtrack_project.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired // dependency injection
    public JobController(JobService jobService){
        this.jobService = jobService;
    }
    @GetMapping // get all jobs
    public List<Job> findAll(){
        return jobService.findAll();
    }
    @GetMapping("/{id}") // get by id
    public Job findById(@PathVariable Integer id){
        return jobService.findById(id);
    }
    @PutMapping("/{id}") // update
    public Job update(@PathVariable Integer id, @RequestBody Job job){
        Job existingJob = jobService.findById(id);

        existingJob.setJobTitle(job.getJobTitle());
        existingJob.setJobWorkstyle(job.getJobWorkstyle());

        jobService.save(existingJob);
        return existingJob;
    }
    @PostMapping // create
    public Job save(@RequestBody Job job) {
        return jobService.save(job);
    }
    @DeleteMapping("/{id}") // delete by id
    public void delete(@PathVariable Integer id){
        jobService.deleteById(id);
    }
}

