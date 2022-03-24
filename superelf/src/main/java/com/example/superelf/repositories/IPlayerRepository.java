package com.example.superelf.repositories;

import com.example.superelf.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository
        extends JpaRepository<Player,Integer> {
}
