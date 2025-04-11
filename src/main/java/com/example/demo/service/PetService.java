package com.example.demo.service;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public String getPetProcedure(Long id) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            if (pet.isHasPlan()) {
                return "banho+hidratacao+tosa higienica + 3 banhos";
            } else {
                return pet.getProcedureType();
            }
        }
        return "Pet not found";
    }

    public Pet updatePetProcedure(Long petId, Pet petDetails) {
        Optional<Pet> petOptional = petRepository.findById(petId);
        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            pet.setProcedureType(petDetails.getProcedureType());
            return petRepository.save(pet);
        }
        return null;
    }
}