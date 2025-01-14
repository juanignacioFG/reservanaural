package com.juan.reservanatural.services;

import com.juan.reservanatural.model.Animal;
import com.juan.reservanatural.model.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> obtenerTodos() {
        return animalRepository.findAll();
    }

    public Optional<Animal> obtenerPorId(Long id) {
        return animalRepository.findById(id);
    }

    public Animal guardarAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public void eliminarAnimal(Long id) {
        animalRepository.deleteById(id);
    }
}
