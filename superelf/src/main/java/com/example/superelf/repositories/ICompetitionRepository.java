package com.example.superelf.repositories;

import com.example.superelf.model.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompetitionRepository extends JpaRepository<Competition,Integer> {
}
