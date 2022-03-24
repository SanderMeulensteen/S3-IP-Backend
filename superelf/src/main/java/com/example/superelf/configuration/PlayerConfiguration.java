package com.example.superelf.configuration;

import com.example.superelf.model.Player;
import com.example.superelf.repositories.IPlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayerConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(IPlayerRepository playerRepository) {
        return args -> {

        };
    }
}
