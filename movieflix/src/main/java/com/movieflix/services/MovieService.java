package com.movieflix.services;

import com.movieflix.dtos.MovieCardDTO;
import com.movieflix.dtos.MovieDetailsDTO;
import com.movieflix.entities.Movie;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieCardDTO> byGenre(Pageable pageable) {
        Page<Movie> list = movieRepository.findAll(pageable);
        return list.map(x -> new MovieCardDTO(x));
    }

    @Transactional(readOnly = true)
    public MovieDetailsDTO findById(Long id) {
        Optional<Movie> dto = movieRepository.findById(id);
        Movie entity = dto.orElseThrow(() -> new ResourceNotFoundException("Movie not found"));;
        return new MovieDetailsDTO(entity);
    }
}
