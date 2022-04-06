package com.example.superelf.service;

import com.example.superelf.model.Club;
import com.example.superelf.model.Position;
import com.example.superelf.repositories.IClubRepository;
import com.example.superelf.repositories.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    private final IPositionRepository positionRepository;

    @Autowired
    public PositionService(IPositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position getPositionById(Integer Id) {
        return positionRepository.getById(Id);
    }
}
