package com.movieflix.repositories;

import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT obj FROM Movie obj " +
            "WHERE :genre IS NULL OR obj.genre = :genre " +
            "ORDER BY obj.title ASC ")
    Page<Movie> findMovieByGenre(@Param("genre") Genre genre, Pageable pageable);
}
