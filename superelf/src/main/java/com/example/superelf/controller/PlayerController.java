package com.example.superelf.controller;

import com.example.superelf.model.Player;
import com.example.superelf.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    public void addNewPlayer(@RequestBody Player player){
        playerService.addNewPlayer(player);
    }

    @DeleteMapping(path = "{playerId}")
    public void deletePlayer(@PathVariable("playerId") Integer playerId){
        playerService.deleteStudent(playerId);
    }

    @PutMapping(path = "{playerId}")
    public void updatePlayer(@PathVariable("playerId") Integer playerId,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer clubId,
                             @RequestParam(required = false) Integer position
                             ){
        playerService.updateStudent(playerId, clubId, name, position);
    }
}
