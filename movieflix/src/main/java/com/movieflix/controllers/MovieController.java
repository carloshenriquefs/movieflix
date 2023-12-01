package com.movieflix.controllers;

import com.movieflix.dtos.MovieCardDTO;
import com.movieflix.dtos.MovieDetailsDTO;
import com.movieflix.dtos.ReviewDTO;
import com.movieflix.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Page<MovieCardDTO>> findAllPageMovieByGenre(
            @RequestParam(value = "genreId", defaultValue = "0") Long genreId,
            Pageable pageable) {
        Page<MovieCardDTO> movies = movieService.findAllPageMovieByGenre(genreId, pageable);
        return ResponseEntity.ok().body(movies);
    }

    @GetMapping(value = "/{id}/reviews")
    @PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
    public ResponseEntity<List<ReviewDTO>> findByReviewMovieId(@PathVariable Long id) {
        List<ReviewDTO> list = movieService.findByReviewMovieId(id);
        return ResponseEntity.ok().body(list);
    }
}
