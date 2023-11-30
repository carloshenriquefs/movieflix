package com.movieflix.repositories;

import com.movieflix.entities.Genre;
import com.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(nativeQuery = true, value = "SELECT title, sub_title, movie_year, img_url " +
            "FROM tb_movie " +
            "ORDER BY title ASC ")
    Page<Movie> findMovieByGenre(Genre genre, Pageable pageable);
}
