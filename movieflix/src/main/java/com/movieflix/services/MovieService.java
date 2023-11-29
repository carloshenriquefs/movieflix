package com.movieflix.services;

import com.movieflix.dtos.MovieDetailsDTO;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.GenreRepository;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    @PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
    public MovieDetailsDTO findById(Long id) {
        Optional<Movie> dto = movieRepository.findById(id);
        Movie entity = dto.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        return new MovieDetailsDTO(entity);
    }
}
