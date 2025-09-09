package com.demo.spring_boot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//Request method using specified path
@RequestMapping("api/v1/software-engineer")

public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    //GET method
    @GetMapping
    public ResponseEntity<List<SoftwareEngineer>> getEngineers() {
        return ResponseEntity.ok(softwareEngineerService.getAllSoftwareEngineers());
    }

    @GetMapping("{id}")
    public ResponseEntity<SoftwareEngineer> getEngineerByID(@PathVariable Integer id) {
        return ResponseEntity.ok(softwareEngineerService.getSoftwareEngineerById(id));
    }

    @PostMapping
    public ResponseEntity<SoftwareEngineer> addNewSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer
    ) {
        SoftwareEngineer created = softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<SoftwareEngineer> updateSoftwareEngineer(
            @PathVariable Integer id,
            @RequestBody SoftwareEngineer softwareEngineer
    ) {
        SoftwareEngineer updated = softwareEngineerService.updateSoftwareEngineer(id, softwareEngineer);
        return ResponseEntity.ok(updated);
    }
}
