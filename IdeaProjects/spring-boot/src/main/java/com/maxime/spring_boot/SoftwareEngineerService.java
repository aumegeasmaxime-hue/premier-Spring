package com.maxime.spring_boot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository repository;

    public SoftwareEngineerService(SoftwareEngineerRepository repository) {
        this.repository = repository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return repository.findAll();
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Software Engineerwith id " + id + " not found"));

    }

    public void createANewSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        repository.save(softwareEngineer);
        repository.
    }
}
