package com.school.speedrunapp.controller;

import com.school.speedrunapp.controller.resources.BanResource;
import com.school.speedrunapp.service.BanService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.security.auth.Subject;

@RestController
@RequestMapping("/api/v1/bans")
@RequiredArgsConstructor
public class BanController
{
    private final BanService banService;

    @GetMapping
    public ResponseEntity<?> getAll() { return ResponseEntity.ok(banService.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) { return ResponseEntity.ok(banService.getById(id)); }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BanResource banResource)
    {
        BanResource saved = banService.save(banResource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/bans/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody BanResource banResource)
    {
        return ResponseEntity.ok(banService.update(banResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id)
    {
        banService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAllByName(@PathVariable String name){ return ResponseEntity.ok(banService.getAllByName(name)); }

    @GetMapping("/permaBans")
    public ResponseEntity<?> getPermaBans(){ return ResponseEntity.ok(banService.getPermaBans()); }

}
