package com.example.superelf.repositories;

import com.example.superelf.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClubRepository extends JpaRepository<Club,Integer> {
}
