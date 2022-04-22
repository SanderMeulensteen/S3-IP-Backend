package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.model.Player;
import com.example.superelf.repositories.IClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClubService {

    private final IClubRepository clubRepository;
    private final PlayerService playerService;

    @Autowired
    public ClubService(IClubRepository clubRepository, PlayerService playerService) {
        this.clubRepository = clubRepository;
        this.playerService = playerService;
    }

    public Club getClubById(Integer Id) {
        boolean exists = clubRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("Club with id " + Id + " does not exist!");
        }
        return clubRepository.getById(Id);
    }

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> findClubById(Integer clubId) {
        boolean exists = clubRepository.existsById(clubId);
        if(!exists) {
            throw new IllegalStateException("Club with id " + clubId + " does not exist!");
        }
        return clubRepository.findById(clubId);
    }

    public void addNewClub(Club club) {
        Optional<Club> clubByName = clubRepository
                .findClubByName(club.getClubName());
        if(clubByName.isPresent()) {
            throw new IllegalStateException("Club name already in use!");
        }
        clubRepository.save(club);
    }

    public void deleteClub(Integer clubId) {
        boolean exists = clubRepository.existsById(clubId);
        if(!exists) {
            throw new IllegalStateException("Club with id " + clubId + " does not exist!");
        }
        if(clubId != 1){
            for (Player player : playerService.getPlayers()) {
                Club club = getClubById(1);
                if(player.club.id == clubId){
                    player.setClub(club);
                }
            }
            clubRepository.deleteById(clubId);
        }
        else{
            throw new IllegalStateException("This club cannot be deleted!");
        }

    }

    @Transactional
    public void updateClub(Integer clubId, Competition competition, String clubName) {
        Club club = clubRepository.findById(clubId)
                .orElseThrow(()-> new IllegalStateException(
                        "Club with id " + clubId + " does not exist!"));

        if(competition != null){
            club.setCompetition(competition);
        }
        if(clubName != null && clubName.length() > 0 && !Objects.equals(club.getClubName(), clubName)){
            club.setClubName(clubName);
        }
    }
}
