package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
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

    public Optional<Player> findPlayerById(Integer playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("Player with id " + playerId + " does not exist");
        }
        return playerRepository.findById(playerId);
    }

    public void addNewPlayer(Player player) {
        Optional<Player> playerByName = playerRepository
                .findPlayerByName(player.getName());
        if(playerByName.isPresent()) {
            throw new IllegalStateException("Player name already in use");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(Integer playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if(!exists) {
            throw new IllegalStateException("Player with id " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(Integer playerId, Club club, String name, Position position) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(()-> new IllegalStateException(
                        "Player with id " + playerId + " does not exist"));

        if(club != null){
            player.setClub(club);
        }
        if(name != null && name.length() > 0 && !Objects.equals(player.getName(), name)){
            player.setName(name);
        }
        if(position != null && !Objects.equals(player.getPosition(), position)){
            player.setPosition(position);
        }
    }
}
