package com.example.superelf.controller;

import com.example.superelf.model.Club;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
import com.example.superelf.service.ClubService;
import com.example.superelf.service.PlayerService;
import com.example.superelf.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/players")
public class PlayerController {

    private final PlayerService playerService;
    private final ClubService clubService;
    private final PositionService positionService;

    @Autowired
    public PlayerController(PlayerService playerService, ClubService clubService, PositionService positionService) {
        this.playerService = playerService;
        this.clubService = clubService;
        this.positionService = positionService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping(path = "{playerId}")
    public Optional<Player> getPlayerById(@PathVariable("playerId") Integer playerId){
        return playerService.findPlayerById(playerId);
    }

    @PostMapping
    public void addNewPlayer(@RequestParam(required = true) String name,
                             @RequestParam(required = true) Integer clubId,
                             @RequestParam(required = true) Integer positionId){
        Club club = clubService.getClubById(clubId);
        Position position = positionService.getPositionById(positionId);
        Player player = new Player(name,club,position);
       playerService.addNewPlayer(player);
    }

    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") Integer playerId){
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path = "{playerId}")
    public void updatePlayer(@PathVariable("playerId") Integer playerId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer clubId,
                             @RequestParam(required = false) Integer positionId
                             ){
        Club club = clubService.getClubById(clubId);
        Position position = positionService.getPositionById(positionId);
        playerService.updatePlayer(playerId, club, name, position);
    }
}
