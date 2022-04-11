package com.example.superelf.config;

import com.example.superelf.model.Club;
import com.example.superelf.model.Competition;
import com.example.superelf.model.Player;
import com.example.superelf.model.Position;
import com.example.superelf.repositories.IClubRepository;
import com.example.superelf.repositories.ICompetitionRepository;
import com.example.superelf.repositories.IPlayerRepository;
import com.example.superelf.repositories.IPositionRepository;
import com.example.superelf.service.ClubService;
import com.example.superelf.service.CompetitionService;
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
    private final CompetitionService competitionService;

    @Autowired
    public AutoFillDB(PlayerService playerService, ClubService clubService, PositionService positionService, CompetitionService competitionService) {
        this.clubService = clubService;
        this.positionService = positionService;
        this.competitionService = competitionService;
    }

    @Bean
    CommandLineRunner commandLineRunner(
            IPositionRepository positionRepository,
            IClubRepository clubRepository,
            IPlayerRepository playerRepository,
            ICompetitionRepository competitionRepository){
        return args -> {
//            place positions in DB
            Position goalkeeper = new Position("Goalkeeper");
            Position defender = new Position("Defender");
            Position midfielder = new Position("Midfielder");
            Position forward = new Position("Forward");
            positionRepository.saveAll(List.of(goalkeeper,defender,midfielder,forward));
//            place some competitions in DB
            Competition noCompetition = new Competition("No Competition");
            Competition eredivisie = new Competition("Eredivisie");
            competitionRepository.saveAll(List.of(noCompetition,eredivisie));
//            place some clubs in DB
            Club noClub = new Club(competitionService.getCompetitionById(1),"No club");
            Club psv = new Club(competitionService.getCompetitionById(2),"PSV");
            Club ajax = new Club(competitionService.getCompetitionById(2),"Ajax");
            clubRepository.saveAll(List.of(noClub,psv,ajax));
//            place some players in DB
            Player mario = new Player (
                    "Mario Götze",
                    clubService.getClubById(2),
                    positionService.getPositionById(3));
            Player antony = new Player (
                    "Antony",
                    clubService.getClubById(3),
                    positionService.getPositionById(4));
            Player cody = new Player (
                    "Cody Gakpo",
                    clubService.getClubById(2),
                    positionService.getPositionById(4));
            playerRepository.saveAll(List.of(mario,antony,cody));
        };
    }
}
