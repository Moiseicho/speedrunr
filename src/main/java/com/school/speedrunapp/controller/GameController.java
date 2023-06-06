package com.school.speedrunapp.controller;

import com.school.speedrunapp.entity.Game;
import com.school.speedrunapp.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController
{
    private final GameService gameService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(gameService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Game game) {
        Game saved = gameService.save(game);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/games/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Game game) {
        return ResponseEntity.ok(gameService.update(game, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        gameService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getByName(@PathVariable String name){ return ResponseEntity.ok(gameService.getByName(name)); }
}
