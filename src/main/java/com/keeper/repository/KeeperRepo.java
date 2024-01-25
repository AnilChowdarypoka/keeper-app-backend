package com.keeper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keeper.entity.Keeper;


public interface KeeperRepo extends JpaRepository<Keeper, Long> {
    List<Keeper> findByUserEmail(String email);
}

