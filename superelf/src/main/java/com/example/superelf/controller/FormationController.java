package com.example.superelf.controller;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.model.Formation;
import com.example.superelf.service.CompetitionService;
import com.example.superelf.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/formations")
public class FormationController {
    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping
    public List<Formation> getFormations() {
        return formationService.getFormations();
    }

    @GetMapping(path = "{formationId}")
    public Optional<Formation> getClubById(@PathVariable("formationId") Integer formationId){
        return formationService.findFormationById(formationId);
    }

    @PostMapping
    public ResponseEntity<String> addNewClub(@RequestBody Formation formation){
        formationService.addNewFormation(formation);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ formation.id + " }");
    }

    @DeleteMapping(path = "{formationId}")
    public ResponseEntity<String> deleteClub(@PathVariable("formationId") Integer formationId){
        formationService.deleteFormation(formationId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ formationId + " }");
    }

    @PutMapping(path = "{formationId}")
    public ResponseEntity<String> updateClub(@PathVariable("formationId") Integer formationId,
                                             @RequestBody Formation formation){
        formationService.updateFormation(formationId, formation.formationName, formation.defenders, formation.midfielders, formation.forwards);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ formationId + " }");
    }
}
