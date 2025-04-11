package com.example.demo.config;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.repository.OwnerRepository;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TestDataInitializer implements CommandLineRunner {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create an owner
        Owner owner1 = Owner.builder()
                .name("John Doe")
                .contactInformation("john.doe@example.com")
                .build();
        ownerRepository.save(owner1);

        // Create pets and link them to the owner
        Pet pet1 = Pet.builder()
                .name("Buddy")
                .breed("Golden Retriever")
                .procedureType("banho")
                .hasPlan(false)
                .owner(owner1)
                .build();

        Pet pet2 = Pet.builder()
                .name("Whiskers")
                .breed("Siamese")
                .procedureType("banho+hidratacao")
                .hasPlan(true)
                .owner(owner1)
                .build();

        petRepository.saveAll(Arrays.asList(pet1, pet2));
    }
}