package com.example.superelf.repositories;

import com.example.superelf.model.Club;
import com.example.superelf.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IFormationRepository extends JpaRepository<Formation,Integer> {
    @Query("SELECT x FROM Formation x WHERE x.formationName = ?1")
    Optional<Formation> findFormationByName(String formationName);
}
