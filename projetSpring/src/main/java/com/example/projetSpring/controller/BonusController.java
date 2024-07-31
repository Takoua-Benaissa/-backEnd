package com.example.projetSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.projetSpring.model.Bonus;
import com.example.projetSpring.service.BonusService;

import java.util.List;

@RestController
@RequestMapping("/bonuses")
public class BonusController {

    @Autowired
    private BonusService bonusService;

    @GetMapping
    public List<Bonus> getAllBonuses() {
        return bonusService.getAllBonuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bonus> getBonusById(@PathVariable Long id) {
        Bonus bonus = bonusService.getBonusById(id);
        if (bonus != null) {
            return ResponseEntity.ok(bonus);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Bonus createBonus(@RequestBody Bonus bonus) {
        return bonusService.saveBonus(bonus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBonus(@PathVariable Long id) {
        bonusService.deleteBonus(id);
        return ResponseEntity.ok().build();
    }
}
