package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.model.Formation;
import com.example.superelf.repositories.ICompetitionRepository;
import com.example.superelf.repositories.IFormationRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.Normalizer;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FormationService {
    private final IFormationRepository formationRepository;

    @Autowired
    public FormationService(IFormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    public Formation getFormationById(Integer Id) {
        boolean exists = formationRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("Formation with id " + Id + " does not exist");
        }
        return formationRepository.getById(Id);
    }

    public List<Formation> getFormations() {
        return formationRepository.findAll();
    }

    public Optional<Formation> findFormationById(Integer formationId) {
        boolean exists = formationRepository.existsById(formationId);
        if(!exists) {
            throw new IllegalStateException("Formation with id " + formationId + " does not exist");
        }
        return formationRepository.findById(formationId);
    }

    public void addNewFormation(Formation formation) {
        Optional<Formation> formationByName = formationRepository
                .findFormationByName(formation.getFormationName());
        if(formationByName.isPresent()) {
            throw new IllegalStateException("Formation name already in use");
        }
        if(formation.formationName != null && formation.formationName.length() > 0 &&
                ((formation.defenders >= 0 && formation.defenders <= 10) && (formation.midfielders >= 0 && formation.midfielders <= 10) &&
                (formation.forwards >= 0 && formation.forwards <= 10) && (formation.defenders + formation.midfielders + formation.forwards == 10))){
            formationRepository.save(formation);
        }else{
            throw new IllegalStateException("The total or individual number of players are wrong");
        }
    }

    public void deleteFormation(Integer formationId) {
        boolean exists = formationRepository.existsById(formationId);
        if(!exists) {
            throw new IllegalStateException("Formation with id " + formationId + " does not exist");
        }
        formationRepository.deleteById(formationId);
    }

    @Transactional
    public void updateFormation(Integer formationId, String formationName, Integer defenders, Integer midfielders, Integer forwards) {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(()-> new IllegalStateException(
                        "Formation with id " + formationId + " does not exist"));

        if(formationName != null && formationName.length() > 0 && !Objects.equals(formation.getFormationName(), formationName) &&
                (defenders >= 0 && defenders <= 10) && (midfielders >= 0 && midfielders <= 10) && (forwards >= 0 && forwards <= 10) &&
                (defenders + midfielders + forwards == 10)){
            formation.setFormationName(formationName);
            formation.setDefenders(defenders);
            formation.setMidfielders(midfielders);
            formation.setForwards(forwards);
        }else{
            throw new IllegalStateException("The total or individual number of players are wrong");
        }
    }
}
