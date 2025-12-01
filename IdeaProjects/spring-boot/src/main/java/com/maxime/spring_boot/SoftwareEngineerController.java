package com.maxime.spring_boot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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












}
