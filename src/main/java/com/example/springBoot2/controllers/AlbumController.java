package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final com.example.springBoot2.repositories.AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // GET all albums
    @GetMapping
    public List<Album> getAllItems() {
        return albumRepository.findAll();
    }

    // GET album by ID
    @GetMapping("/{id}")
    public Optional<Album> getItem(@PathVariable int id) {
        return albumRepository.findById(id);
    }

    // POST a new Album
    @PostMapping
    public Album addItem(@RequestBody Album album) {
        return albumRepository.save(album);
    }

    // PUT update existing album
    @PutMapping("/{id}")
    public Album updateItem(@PathVariable int id, @RequestBody Album updatedAlbum) {
        updatedAlbum.setId(id);
        return albumRepository.save(updatedAlbum);
    }

    // DELETE a album
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        albumRepository.deleteById(id);
    }
}
