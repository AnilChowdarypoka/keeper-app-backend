package com.keeper.controller;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.keeper.entity.Keeper;
import com.keeper.repository.KeeperRepo;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/keepers")
@CrossOrigin(origins = "http://localhost:3000")
public class KeeperController {

    private final KeeperRepo keeperRepository;

    @Autowired
    public KeeperController(KeeperRepo keeperRepository) {
        this.keeperRepository = keeperRepository;
    }
   
//
    @GetMapping
    public List<Keeper> getAllKeepers() {
        return keeperRepository.findAll();
    }

    @GetMapping("/by-email")
    public List<Keeper> getKeepersByEmail(@RequestParam String email) {
        return keeperRepository.findByUserEmail(email);
    }

    @GetMapping("/{id}")
    public Keeper getKeeperById(@PathVariable Long id) {
        return keeperRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Keeper createKeeper(@RequestBody Keeper keeper) {
        return keeperRepository.save(keeper);
    }

    @PutMapping("/{id}")
    public Keeper updateKeeper(@PathVariable Long id, @RequestBody Keeper updatedKeeper) {
        Keeper existingKeeper = keeperRepository.findById(id).orElse(null);
        if (existingKeeper != null) {
            existingKeeper.setTitle(updatedKeeper.getTitle());
            existingKeeper.setContent(updatedKeeper.getContent());
            existingKeeper.setUserEmail(updatedKeeper.getUserEmail()); // Update userEmail
            return keeperRepository.save(existingKeeper);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteKeeper(@PathVariable Long id) {
        keeperRepository.deleteById(id);
    }


}

