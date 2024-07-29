package com.example.projetSpring.service;


import com.example.projetSpring.model.Prime;
import com.example.projetSpring.repository.PrimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrimeService {

    @Autowired
    private PrimeRepository primeRepository;

    public List<Prime> getAllPrimes() {
        return primeRepository.findAll();
    }

    public Optional<Prime> getPrimeById(Long id) {
        return primeRepository.findById(id);
    }

    public Prime createPrime(Prime prime) {
        return primeRepository.save(prime);
    }

    public Prime updatePrime(Long id, Prime primeDetails) {
        Prime prime = primeRepository.findById(id).orElseThrow(() -> new RuntimeException("Prime not found"));
        prime.setEmployeeId(primeDetails.getEmployeeId());
        prime.setAmount(primeDetails.getAmount());
        prime.setDateIssued(primeDetails.getDateIssued());
        return primeRepository.save(prime);
    }

    public void deletePrime(Long id) {
        primeRepository.deleteById(id);
    }
}