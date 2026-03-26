package com.aiJobResume.Selection.controller;

import com.aiJobResume.Selection.dto.request.AuthRequest;
import com.aiJobResume.Selection.dto.request.UserRegistrationRequest;
import com.aiJobResume.Selection.dto.response.AuthResponse;
import com.aiJobResume.Selection.dto.response.UserResponse;
import com.aiJobResume.Selection.security.CustomUserDetails;
import com.aiJobResume.Selection.security.JwtService;
import com.aiJobResume.Selection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegistrationRequest request) {
        UserResponse response = userService.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(userDetails);

        UserResponse userResponse = userService.getUserByEmail(userDetails.getUsername());

        AuthResponse authResponse = AuthResponse.builder()
                .token(jwtToken)
                .user(userResponse)
                .build();

        return ResponseEntity.ok(authResponse);
    }
}
