package com.example.projetSpring.controller;


import com.example.projetSpring.model.Prime;
import com.example.projetSpring.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/primes")
public class PrimeController {

    @Autowired
    private PrimeService primeService;

    @GetMapping
    public List<Prime> getAllPrimes() {
        return primeService.getAllPrimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prime> getPrimeById(@PathVariable Long id) {
        Optional<Prime> prime = primeService.getPrimeById(id);
        return prime.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prime createPrime(@RequestBody Prime prime) {
        return primeService.createPrime(prime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prime> updatePrime(@PathVariable Long id, @RequestBody Prime primeDetails) {
        Prime updatedPrime = primeService.updatePrime(id, primeDetails);
        return ResponseEntity.ok(updatedPrime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrime(@PathVariable Long id) {
        primeService.deletePrime(id);
        return ResponseEntity.noContent().build();
    }
}