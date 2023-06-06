package com.school.speedrunapp.controller;

import com.school.speedrunapp.controller.resources.SpeedrunResource;
import com.school.speedrunapp.service.SpeedrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/speedruns")
@RequiredArgsConstructor
public class SpeedrunController
{
    private final SpeedrunService speedrunService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(speedrunService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(speedrunService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody SpeedrunResource speedrunResource) {
        SpeedrunResource saved = speedrunService.save(speedrunResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/speedruns/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody SpeedrunResource speedrunResource) {
        return ResponseEntity.ok(speedrunService.update(speedrunResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        speedrunService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/game/{id}")
    public ResponseEntity<?> getByGameId(@PathVariable long id) { return ResponseEntity.ok(speedrunService.getByGameId(id)); }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable long id) { return ResponseEntity.ok(speedrunService.getByUserId(id)); }
    @GetMapping("/game/{gid}/category/{cid}")
    public ResponseEntity<?> getByGameAndCategoryId(@PathVariable long gid, @PathVariable long cid) { return ResponseEntity.ok(speedrunService.getByGameIdAndCategoryId(gid, cid)); }

}
