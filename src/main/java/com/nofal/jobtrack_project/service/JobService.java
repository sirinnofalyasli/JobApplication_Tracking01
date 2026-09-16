package com.nofal.jobtrack_project.service;

import com.nofal.jobtrack_project.entity.Job;
import com.nofal.jobtrack_project.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public Job save(Job job){
        return jobRepository.save(job);
    }
    public List<Job> findAll(){
        return jobRepository.findAll();
    }
    public Job findById(Integer id){
        Optional<Job> optionalJob = jobRepository.findById(id);
        if(optionalJob.isPresent()){
            return optionalJob.get();
        } else {
            throw new RuntimeException("Job not found. " + id);
        }
    }
    public void deleteById(Integer id){
        if(!jobRepository.existsById(id)){
            throw new RuntimeException("Job not found. " + id);
        }
        jobRepository.deleteById(id);
    }
        }
