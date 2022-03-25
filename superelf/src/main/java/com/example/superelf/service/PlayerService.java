package com.example.superelf.service;

import com.example.superelf.model.Player;
import com.example.superelf.repositories.IPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
