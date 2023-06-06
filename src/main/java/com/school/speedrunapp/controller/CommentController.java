package com.school.speedrunapp.controller;

import com.school.speedrunapp.controller.resources.CommentResource;
import com.school.speedrunapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController
{
    private final CommentService commentService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return ResponseEntity.ok(commentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CommentResource resource) {
        CommentResource saved = commentService.save(resource);

        return ResponseEntity.created(
                UriComponentsBuilder.fromPath("/api/v1/comments/{id}").buildAndExpand(saved.getId()).toUri()
        ).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody CommentResource commentResource) {
        return ResponseEntity.ok(commentService.update(commentResource, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getByOpId(@PathVariable long id) { return ResponseEntity.ok(commentService.getByOpId(id)); }

    @GetMapping("/speedrun/{id}")
    public ResponseEntity<?> getBySpeedrunId(@PathVariable long id) { return ResponseEntity.ok(commentService.getBySpeedrunId(id)); }

}
