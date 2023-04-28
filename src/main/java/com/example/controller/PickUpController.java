package com.example.controller;

import com.example.entity.PickUp;
import com.example.service.PickUpService;
import com.example.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/pickup")
public class PickUpController {

        private PickUpService pickUpService;

        @Autowired
        public PickUpController(PickUpService pickUpService){
            this.pickUpService = pickUpService;
        }

        @GetMapping("/all")
        public List<PickUp> findAll(){
            return this.pickUpService.findAll();
        }

        @PostMapping
        public PickUp add(@RequestBody PickUp pickUp){
            return this.pickUpService.addPickUp(pickUp);
        }

        @DeleteMapping("/{id}")
        public String delete(@PathVariable Long id){
            this.pickUpService.deleteById(id);
            return "Deleted Successfully";
        }

        @PutMapping
        public PickUp update(@RequestBody PickUp pickUp){
            return this.pickUpService.updatePickUp(pickUp);
        }

        @GetMapping("/{id}")
        public PickUp findById(@PathVariable Long id){
            return this.pickUpService.findById(id);
        }
}
