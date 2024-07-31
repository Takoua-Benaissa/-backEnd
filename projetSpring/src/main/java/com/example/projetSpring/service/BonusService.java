package com.example.projetSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projetSpring.model.Bonus;
import com.example.projetSpring.repository.BonusRepository;

import java.util.List;

@Service
public class BonusService {

    @Autowired
    private BonusRepository bonusRepository;

    public List<Bonus> getAllBonuses() {
        return bonusRepository.findAll();
    }

    public Bonus getBonusById(Long id) {
        return bonusRepository.findById(id).orElse(null);
    }

    public Bonus saveBonus(Bonus bonus) {
        return bonusRepository.save(bonus);
    }

    public void deleteBonus(Long id) {
        bonusRepository.deleteById(id);
    }
}
