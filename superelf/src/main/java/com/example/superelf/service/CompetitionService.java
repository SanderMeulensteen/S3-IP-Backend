package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.repositories.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private final ICompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(ICompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Competition getCompetitionById(Integer Id) {
        boolean exists = competitionRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("Competition with id " + Id + " does not exist");
        }
        return competitionRepository.getById(Id);
    }

    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }
}
