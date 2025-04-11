package com.example.demo.controller;

import com.example.demo.model.Pet;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/{petId}/procedure")
    public ResponseEntity<String> getPetProcedure(@PathVariable Integer petId) {
        String procedure = petService.getPetProcedure(petId.longValue()); // Pass id to the service
        if (ObjectUtils.isEmpty(procedure)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(procedure);
        }
    }

    @PutMapping("/{petId}/procedure")
    public ResponseEntity<Pet> updatePetProcedure(@PathVariable Long petId, @RequestBody Pet petDetails) {
        Pet updatedPet = petService.updatePetProcedure(petId, petDetails);
        if (ObjectUtils.isEmpty(updatedPet)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedPet);
        }
    }
}