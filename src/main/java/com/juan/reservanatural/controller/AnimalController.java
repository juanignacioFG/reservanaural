package com.juan.reservanatural.controller;

import com.juan.reservanatural.model.Animal;
import com.juan.reservanatural.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> obtenerTodosLosAnimales() {
        return animalService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> obtenerAnimalPorId(@PathVariable Long id) {
        Optional<Animal> animal = animalService.obtenerPorId(id);
        return animal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Animal guardarAnimal(@RequestBody Animal animal) {
        return animalService.guardarAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAnimal(@PathVariable Long id) {
        animalService.eliminarAnimal(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Animal> actualizarAnimal(@PathVariable Long id, @RequestBody Animal animalActualizado) {
        Optional<Animal> animalExistente = animalService.obtenerPorId(id);
        if (animalExistente.isPresent()) {
            Animal animal = animalExistente.get();
            animal.setNombre(animalActualizado.getNombre());
            animal.setTipo(animalActualizado.getTipo());
            animal.setFamilia(animalActualizado.getFamilia());
            animal.setGenero(animalActualizado.getGenero());
            animal.setPaisOrigen(animalActualizado.getPaisOrigen());
            animal.setFechaIngreso(animalActualizado.getFechaIngreso());
            animal.setImagen(animalActualizado.getImagen());
            return ResponseEntity.ok(animalService.guardarAnimal(animal));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
