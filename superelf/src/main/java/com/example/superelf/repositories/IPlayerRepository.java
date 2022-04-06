package com.example.superelf.repositories;

import com.example.superelf.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlayerRepository
        extends JpaRepository<Player,Integer> {
    @Query("SELECT x FROM Player x WHERE x.name = ?1")
    Optional<Player> findPlayerByName(String name);
}
