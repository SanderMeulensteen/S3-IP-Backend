package com.example.superelf.controller;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.service.ClubService;
import com.example.superelf.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/clubs")
public class ClubController {
    private final ClubService clubService;
    private final CompetitionService competitionService;

    @Autowired
    public ClubController(ClubService clubService, CompetitionService competitionService) {
        this.clubService = clubService;
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<Club> getClubs() {
        return clubService.getClubs();
    }

    @GetMapping(path = "{clubId}")
    public Optional<Club> getClubById(@PathVariable("clubId") Integer clubId){
        return clubService.findClubById(clubId);
    }

    @PostMapping
    public ResponseEntity<String> addNewClub(@RequestBody Club club){
        Competition competition = competitionService.getCompetitionById(club.competition.id);
        club.setCompetition(competition);
        clubService.addNewClub(club);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ club.id + " }");
    }

    @DeleteMapping(path = "{clubId}")
    public ResponseEntity<String> deleteClub(@PathVariable("clubId") Integer clubId){
        clubService.deleteClub(clubId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ clubId + " }");
    }

    @PutMapping(path = "{clubId}")
    public ResponseEntity<String> updateClub(@PathVariable("clubId") Integer clubId,
                                               @RequestBody Club club){
        Competition competition = competitionService.getCompetitionById(club.competition.id);
        clubService.updateClub(clubId, competition, club.clubName);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ clubId + " }");
    }
}
