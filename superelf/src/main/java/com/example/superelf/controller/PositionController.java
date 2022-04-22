package com.example.superelf.controller;

import com.example.superelf.model.Position;
import com.example.superelf.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "api/positions")
public class PositionController {
    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> getPositions() {
        return positionService.getPositions();
    }

    @GetMapping(path = "{positionId}")
    public Optional<Position> getPositionById(@PathVariable("positionId") Integer positionId){
        return positionService.findPositionById(positionId);
    }

    @PostMapping
    public ResponseEntity<String> addNewPosition(@RequestBody Position position){
        positionService.addNewPosition(position);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ position.id + " }");
    }

    @DeleteMapping(path = "{positionId}")
    public ResponseEntity<String> deletePosition(@PathVariable("positionId") Integer positionId){
        positionService.deletePosition(positionId);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ positionId + " }");
    }

    @PutMapping(path = "{positionId}")
    public ResponseEntity<String> updatePosition(@PathVariable("positionId") Integer positionId,
                                               @RequestBody Position position){
        positionService.updatePosition(positionId, position.positionName);
        return ResponseEntity.status(HttpStatus.OK)
                .body("{ \"id\": "+ positionId + " }");
    }
}
