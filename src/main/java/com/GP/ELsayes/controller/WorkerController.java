package com.GP.ELsayes.controller;

import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren.ManagerRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren.WorkerRequest;

import com.GP.ELsayes.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    @Autowired
     private WorkerService workerService;

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody @Valid WorkerRequest workerRequest) {
        return new ResponseEntity<>(this.workerService.add(workerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id/{workerId}")
    public ResponseEntity<?> getById(@PathVariable Long workerId){
        return new ResponseEntity<>(this.workerService.getById(workerId),HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.workerService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{workerId}")
    public ResponseEntity<?> update(@RequestBody WorkerRequest workerRequest, @PathVariable Long workerId){
        return new ResponseEntity<>(this.workerService.update(workerRequest , workerId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{workerId}")
    public ResponseEntity<?> delete(@PathVariable Long workerId){
        this.workerService.delete(workerId);
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.ACCEPTED);
    }
}