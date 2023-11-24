package com.movieflix.services;

import com.movieflix.dtos.GenreDTO;
import com.movieflix.entities.Genre;
import com.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDTO> findAll() {
        List<Genre> genre = genreRepository.findAll();
        return genre.stream().map(x -> new GenreDTO(x)).toList();
    }
}
