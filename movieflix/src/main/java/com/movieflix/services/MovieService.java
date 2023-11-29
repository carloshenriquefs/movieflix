package com.movieflix.services;

import com.movieflix.dtos.MovieDetailsDTO;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.GenreRepository;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.movieflix.constants.Constants.MOVIE_NOT_FOUND;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Transactional(readOnly = true)
    public MovieDetailsDTO findById(Long id) {
        Optional<Movie> dto = movieRepository.findById(id);
        Movie entity = dto.orElseThrow(() -> new ResourceNotFoundException(MOVIE_NOT_FOUND));

        return new MovieDetailsDTO(entity);
    }
}
