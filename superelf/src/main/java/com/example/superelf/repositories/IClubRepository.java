package com.example.superelf.repositories;

import com.example.superelf.model.Club;
import com.example.superelf.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClubRepository extends JpaRepository<Club,Integer> {
    @Query("SELECT x FROM Club x WHERE x.clubName = ?1")
    Optional<Club> findClubByName(String clubName);
}
