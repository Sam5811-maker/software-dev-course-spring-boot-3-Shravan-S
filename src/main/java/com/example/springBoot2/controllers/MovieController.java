package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class MovieController {
    private final com.example.springBoot2.repositories.MovieRepository movieRepository;

    public MovieController(com.example.springBoot2.repositories.MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // GET all movies
    @GetMapping
    public List<Movie> getAllItems() {
        return movieRepository.findAll();
    }

    // GET movie by ID
    @GetMapping("/{id}")
    public Optional<Movie> getItem(@PathVariable int id) {
        return movieRepository.findById(id);
    }

    // POST a new movie
    @PostMapping
    public Movie addItem(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // PUT update existing movie
    @PutMapping("/{id}")
    public Movie updateItem(@PathVariable int id, @RequestBody Movie updatedMOvie) {
        updatedMOvie.setId(id);
        return movieRepository.save(updatedMOvie);
    }

    // DELETE a movie
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        movieRepository.deleteById(id);
    }
}
