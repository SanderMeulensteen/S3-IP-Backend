package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
import com.example.superelf.repositories.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PositionService {

    private final IPositionRepository positionRepository;
    private final PlayerService playerService;

    @Autowired
    public PositionService(IPositionRepository positionRepository, PlayerService playerService) {
        this.positionRepository = positionRepository;
        this.playerService = playerService;
    }

    public Position getPositionById(Integer Id) {
        boolean exists = positionRepository.existsById(Id);
        if(!exists) {
            throw new IllegalStateException("Position with id " + Id + " does not exist!");
        }
        return positionRepository.getById(Id);
    }

    public List<Position> getPositions() {
            return positionRepository.findAll();
    }

    public Optional<Position> findPositionById(Integer positionId) {
        boolean exists = positionRepository.existsById(positionId);
        if(!exists) {
            throw new IllegalStateException("Position with id " + positionId + " does not exist!");
        }
        return positionRepository.findById(positionId);
    }

    public void deletePosition(Integer positionId) {
        boolean exists = positionRepository.existsById(positionId);
        if(!exists) {
            throw new IllegalStateException("Position with id " + positionId + " does not exist!");
        }
        if(positionId != 1){
            for (Player player : playerService.getPlayers()) {
                Position position = getPositionById(1);
                if(player.position.id == positionId){
                    player.setPosition(position);
                }
            }
            positionRepository.deleteById(positionId);
        }
        else{
            throw new IllegalStateException("This position cannot be deleted!");
        }
    }
    @Transactional
    public void updatePosition(Integer positionId, String positionName) {
        Position position = positionRepository.findById(positionId)
                .orElseThrow(()-> new IllegalStateException(
                        "Position with id " + positionId + " does not exist!"));
        if(positionName != null && positionName.length() > 0 && !Objects.equals(position.getPositionName(), positionName)){
            position.setPositionName(positionName);
        }
    }

    public void addNewPosition(Position position) {
        Optional<Position> positionByName = positionRepository
                .findPositionByName(position.getPositionName());
        if(positionByName.isPresent()) {
            throw new IllegalStateException("Position name already in use!");
        }
        positionRepository.save(position);
    }
}
