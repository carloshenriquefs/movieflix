package com.movieflix.services;

import com.movieflix.dtos.ReviewDTO;
import com.movieflix.entities.Review;
import com.movieflix.entities.User;
import com.movieflix.repositories.MovieRepository;
import com.movieflix.repositories.ReviewRepository;
import com.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.movieflix.constants.Constants.UNATHORIZED_USER;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AuthService authService;

    @Transactional
    public ReviewDTO saveReview(ReviewDTO reviewDTO) {
        try {
            Review newReview = new Review();
            copyDtoToEntity(reviewDTO, newReview);
            return new ReviewDTO(newReview);
        } catch (RuntimeException e) {
            throw new UnauthorizedException(UNATHORIZED_USER);
        }
    }

    private void copyDtoToEntity(ReviewDTO reviewDTO, Review reviewEntity) {
        User user = authService.authenticated();
        reviewEntity.setId(reviewDTO.getId());
        reviewEntity.setText(reviewDTO.getText());
        reviewEntity.setMovie(movieRepository.getReferenceById(reviewDTO.getMovieId()));
        reviewEntity.setUser(user);
        reviewRepository.save(reviewEntity);
    }
}
