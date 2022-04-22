package com.example.superelf.repositories;

import com.example.superelf.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPositionRepository extends JpaRepository<Position,Integer> {
    @Query("SELECT x FROM Position x WHERE x.positionName = ?1")
    Optional<Position> findPositionByName(String positionName);
}
