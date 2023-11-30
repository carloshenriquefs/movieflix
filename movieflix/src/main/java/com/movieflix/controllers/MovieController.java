package com.movieflix.controllers;

import com.movieflix.dtos.MovieCardDTO;
import com.movieflix.dtos.MovieDetailsDTO;
import com.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
    public ResponseEntity<MovieDetailsDTO> findById(@PathVariable Long id) {
        MovieDetailsDTO dto = movieService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
    public ResponseEntity<Page<MovieCardDTO>> findAllPagedMovieByTitle(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable) {
        Page<MovieCardDTO> movies = movieService.findAllPageMovieByTitle(genreId, pageable);
        return ResponseEntity.ok().body(movies);
    }


}
