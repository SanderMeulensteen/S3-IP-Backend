package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.repositories.IClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    private final IClubRepository clubRepository;

    @Autowired
    public ClubService(IClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public Club getClubById(Integer Id) {
        return clubRepository.getById(Id);
    }
}
