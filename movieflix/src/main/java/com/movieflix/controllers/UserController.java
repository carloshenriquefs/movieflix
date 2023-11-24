package com.movieflix.controllers;

import com.movieflix.dtos.UserDTO;
import com.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAnyRole('VISITOR', 'MEMBER')")
    @GetMapping(value = "/profile")
    public ResponseEntity<UserDTO> getProfile() {
        UserDTO dto = userService.getProfile();
        return ResponseEntity.ok(dto);
    }
}
