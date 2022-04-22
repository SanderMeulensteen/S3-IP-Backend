package com.example.superelf.repositories;

import com.example.superelf.model.Competition;
import com.example.superelf.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICompetitionRepository extends JpaRepository<Competition,Integer> {
    @Query("SELECT x FROM Competition x WHERE x.competitionName = ?1")
    Optional<Competition> findCompetitionByName(String competitionName);
}
