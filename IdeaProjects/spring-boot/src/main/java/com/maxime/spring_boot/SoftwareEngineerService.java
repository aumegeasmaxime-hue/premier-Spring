package com.maxime.spring_boot;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    }
    /*
    public void updateSoftwareEngineer(Integer id,SoftwareEngineer softwareEngineer) {
        repository.findById(id);
        repository.save(softwareEngineer);
    }

     */
    public SoftwareEngineer updateSoftwareEngineer(Integer id, SoftwareEngineer updatedEngineer) {
        SoftwareEngineer existingEngineer = getSoftwareEngineerById(id);
        if (updatedEngineer.getName() == null){
            existingEngineer.setName(existingEngineer.getName());
        }
        else {
            existingEngineer.setName(updatedEngineer.getName());
        }
        if (updatedEngineer.getTechStack() == null){
            existingEngineer.setTechStack(existingEngineer.getTechStack());
        }
        else {
            existingEngineer.setTechStack(updatedEngineer.getTechStack());
        }

        return repository.save(existingEngineer);
    }

    public void partialUpdateSoftwareEngineerV1(Integer id, Map<String, Object> update) {
        findSoftwareEngineerById(id).
                map(softwareEngineer -> {
            update.forEach((key,value)->{
                switch (key){
                    case "name": softwareEngineer.setName((String)value);break;
                    case "techStack": softwareEngineer.setTechStack((String)value);break;
                    default:
                        throw new IllegalArgumentException("invalid field: "+ key);
                }
            });
            return repository.save(softwareEngineer);
        });

    }

    private Optional<SoftwareEngineer> findSoftwareEngineerById(Integer id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(
                        ()->new IllegalArgumentException("Software Engineerwith id " + id + " not found")
                ));
    }
}
