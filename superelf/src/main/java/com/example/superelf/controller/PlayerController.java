package com.example.superelf.controller;

import com.example.superelf.model.Club;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
import com.example.superelf.service.ClubService;
import com.example.superelf.service.PlayerService;
import com.example.superelf.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addNewPlayer(@RequestBody Player player){
        Club club = clubService.getClubById(player.club.id);
        Position position = positionService.getPositionById(player.position.id);
        player.setClub(club);
        player.setPosition(position);
        playerService.addNewPlayer(player);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ player.id + " }");
    }

    @DeleteMapping(path = "{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable("playerId") Integer playerId){
        playerService.deletePlayer(playerId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ playerId + " }");
    }

    @PutMapping(path = "{playerId}")
    public ResponseEntity<String> updatePlayer(@PathVariable("playerId") Integer playerId,
                                       @RequestBody Player player){
        Club club = clubService.getClubById(player.club.id);
        Position position = positionService.getPositionById(player.position.id);
        playerService.updatePlayer(playerId, club, player.name, position);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ playerId + " }");
    }
}
