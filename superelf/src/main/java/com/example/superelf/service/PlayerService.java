package com.example.superelf.service;

import com.example.superelf.model.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    public List<Player> getPlayers() {
        return List.of(
                new Player(
                        1L,
                        "Mario Götze",
                        "Psv",
                        "Midfielder"
                ),
                new Player(
                        2L,
                        "Melle Meulensteen",
                        "RKC Waalwijk",
                        "Defender"
                ),
                new Player(
                        3L,
                        "Henk Veerman",
                        "FC Utrecht",
                        "Forward"
                ),
                new Player(
                        4L,
                        "Lars Unnerstall",
                        "FC Twente",
                        "Goalkeeper"
                )
        );
    }
}
