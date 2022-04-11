package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.repositories.IClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final IClubRepository clubRepository;

    @Autowired
    public ClubService(IClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club getClubById(Integer Id) {
        boolean exists = clubRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("Club with id " + Id + " does not exist");
        }
        return clubRepository.getById(Id);
    }

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }
}
