package com.example.controller;



import com.example.entity.Verification;
import com.example.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Verification")
public class VerificationController {

    private VerificationService verificationService;

    @Autowired
    public VerificationController(VerificationService verificationService){
        //...
        this.verificationService = verificationService;
    }

    @PostMapping
    public Verification add(@RequestBody Verification verification){
        return this.verificationService.add(verification);
    }

    @PutMapping
    public Verification update(@RequestBody Verification verification){
        return this.verificationService.update(verification);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Long id){
        return this.verificationService.deleteById(id);
    }
}
