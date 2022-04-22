package com.example.superelf.controller;

import com.example.superelf.model.Competition;
import com.example.superelf.model.Position;
import com.example.superelf.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/competitions")
public class CompetitionController {
    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<Competition> getCompetitions() {
        return competitionService.getCompetitions();
    }

    @GetMapping(path = "{competitionId}")
    public Optional<Competition> getCompetitionById(@PathVariable("competitionId") Integer competitionId){
        return competitionService.findCompetitionById(competitionId);
    }

    @PostMapping
    public ResponseEntity<String> addNewCompetition(@RequestBody Competition competition){
        competitionService.addNewCompetition(competition);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ competition.id + " }");
    }

    @DeleteMapping(path = "{competitionId}")
    public ResponseEntity<String> deleteCompetition(@PathVariable("competitionId") Integer competitionId){
        competitionService.deleteCompetition(competitionId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ competitionId + " }");
    }

    @PutMapping(path = "{competitionId}")
    public ResponseEntity<String> updateCompetition(@PathVariable("competitionId") Integer competitionId,
                                               @RequestBody Competition competition){
        competitionService.updateCompetition(competitionId, competition.competitionName);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ competitionId + " }");
    }
}
