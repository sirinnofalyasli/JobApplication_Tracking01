package com.nofal.jobtrack_project.service;

import com.nofal.jobtrack_project.entity.User;
import com.nofal.jobtrack_project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User save(User user){
        return userRepository.save(user);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("User bulunamadı. " + id);
        }
    }
    public void deleteById(Integer id) {
            if(!userRepository.existsById(id)){
               throw new RuntimeException("User bulunamadı. " + id);
            }
            userRepository.deleteById(id);
        }
    }

