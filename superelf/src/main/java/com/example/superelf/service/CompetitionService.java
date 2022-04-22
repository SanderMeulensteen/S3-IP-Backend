package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
import com.example.superelf.repositories.ICompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompetitionService {

    private final ICompetitionRepository competitionRepository;
    private final ClubService clubService;

    @Autowired
    public CompetitionService(ICompetitionRepository competitionRepository, ClubService clubService) {
        this.competitionRepository = competitionRepository;
        this.clubService = clubService;
    }

    public Competition getCompetitionById(Integer Id) {
        boolean exists = competitionRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("Competition with id " + Id + " does not exist!");
        }
        return competitionRepository.getById(Id);
    }

    public List<Competition> getCompetitions() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> findCompetitionById(Integer competitionId) {
        boolean exists = competitionRepository.existsById(competitionId);
        if(!exists) {
            throw new IllegalStateException("Competition with id " + competitionId + " does not exist!");
        }
        return competitionRepository.findById(competitionId);
    }

    public void addNewCompetition(Competition competition) {
        Optional<Competition> competitionByName = competitionRepository
                .findCompetitionByName(competition.getCompetitionName());
        if(competitionByName.isPresent()) {
            throw new IllegalStateException("Competition name already in use!");
        }
        competitionRepository.save(competition);
    }

    public void deleteCompetition(Integer competitionId) {
        boolean exists = competitionRepository.existsById(competitionId);
        if(!exists) {
            throw new IllegalStateException("Competition with id " + competitionId + " does not exist!");
        }
        if(competitionId != 1){
            for (Club club : clubService.getClubs()) {
                Competition competition = getCompetitionById(1);
                if(club.competition.id == competitionId){
                    club.setCompetition(competition);
                }
            }
            competitionRepository.deleteById(competitionId);
        }
        else{
            throw new IllegalStateException("This competition cannot be deleted!");
        }
    }

    @Transactional
    public void updateCompetition(Integer competitionId, String competitionName) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(()-> new IllegalStateException(
                        "Competition with id " + competitionId + " does not exist!"));
        if(competitionName != null && competitionName.length() > 0 && !Objects.equals(competition.getCompetitionName(), competitionName)){
            competition.setCompetitionName(competitionName);
        }
    }
}
