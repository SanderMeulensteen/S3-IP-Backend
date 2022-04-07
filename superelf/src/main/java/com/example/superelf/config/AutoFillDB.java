package com.example.superelf.config;

import com.example.superelf.model.Club;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
import com.example.superelf.repositories.IClubRepository;
import com.example.superelf.repositories.IPlayerRepository;
import com.example.superelf.repositories.IPositionRepository;
import com.example.superelf.service.ClubService;
import com.example.superelf.service.PlayerService;
import com.example.superelf.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AutoFillDB {

    private final ClubService clubService;
    private final PositionService positionService;

    @Autowired
    public AutoFillDB(PlayerService playerService, ClubService clubService, PositionService positionService) {
        this.clubService = clubService;
        this.positionService = positionService;
    }

    @Bean
    CommandLineRunner commandLineRunner(IPositionRepository positionRepository,IClubRepository clubRepository,IPlayerRepository playerRepository){
        return args -> {
            Position goalkeeper = new Position("Goalkeeper");
            Position defender = new Position("Defender");
            Position midfielder = new Position("Midfielder");
            Position forward = new Position("Forward");
            positionRepository.saveAll(List.of(goalkeeper,defender,midfielder,forward));
            Club psv = new Club(1,"PSV");
            Club ajax = new Club(1,"Ajax");
            clubRepository.saveAll(List.of(psv,ajax));
            Player mario = new Player (
                    "Mario Götze",
                    clubService.getClubById(1),
                    positionService.getPositionById(3));
            Player antony = new Player (
                    "Antony",
                    clubService.getClubById(2),
                    positionService.getPositionById(4));
            Player cody = new Player (
                    "Cody Gakpo",
                    clubService.getClubById(1),
                    positionService.getPositionById(4));
            playerRepository.saveAll(List.of(mario,antony,cody));
        };
    }

}
