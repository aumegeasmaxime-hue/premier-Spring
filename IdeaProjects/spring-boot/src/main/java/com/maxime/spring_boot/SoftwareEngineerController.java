package com.maxime.spring_boot;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/software-engineers")

public class SoftwareEngineerController {
    private final SoftwareEngineerService service;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService){
        this.service = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getAllSoftwareEngineers (){
        return service.getAllSoftwareEngineers();
/*
        return List.of(

                new SoftwareEngineer(1, "bob" , "java,javaSpring"),
                new SoftwareEngineer(2, "Joe" , "java,javaSpring"),
                new SoftwareEngineer( 3, "Zette" , "java,javaSpring")


        );

*/
    }
    @GetMapping("/{id}")
    public SoftwareEngineer getSoftwareEngineerById(
            @PathVariable Integer id
    ){
        return service.getSoftwareEngineerById(id);
    }
    @PostMapping
    public void addSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer){
        service.createANewSoftwareEngineer(softwareEngineer);
    }
    @PutMapping("/{id}")
    public SoftwareEngineer updateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody SoftwareEngineer updatedEngineer
    ) {
        return service.updateSoftwareEngineer(id, updatedEngineer);
    }
    @PatchMapping("v1/{id}")
    public void partialUpdateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody Map<String,Object> update
            )
    {
        //service.partialUpdateSoftwareEngineerV1(id,update);
        service.partialUpdateSoftwareEngineerV2(id,update);
    }
    @DeleteMapping("/{id}")
    public void deleteSoftwareEngineer(
            @PathVariable Integer id
            )
    {
        service.deleteSoftwareEngineer(id);
    }













}
