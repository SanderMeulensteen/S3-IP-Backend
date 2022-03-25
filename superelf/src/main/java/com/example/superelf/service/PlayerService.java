package com.example.superelf.service;

import com.example.superelf.model.Player;
import com.example.superelf.repositories.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    private final IPlayerRepository playerRepository;

    @Autowired
    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerByName = playerRepository
                .findPlayerByName(player.getName());
        if(playerByName.isPresent()) {
            throw new IllegalStateException("Player name already in use");
        }
        playerRepository.save(player);
    }

    public void deleteStudent(Integer playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("Player with id " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updateStudent(Integer playerId, Integer clubId, String name, Integer position) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(()-> new IllegalStateException(
                        "Player with id " + playerId + " does not exist"));

        if(clubId != null && clubId != 0){
            player.setClubId(clubId);
        }
        if(name != null && name.length() > 0 && !Objects.equals(player.getName(), name)){
            player.setName(name);
        }
        if(position != null && position != 0 && !Objects.equals(player.getPosition(), position)){
            player.setPosition(position);
        }
    }
}
