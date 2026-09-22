package com.pulsefit.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.ResponseEntity;

class AuthControllerTest {

    @Test
    void loginReturnsJwt() {

        AuthController controller =
                new AuthController(new BCryptPasswordEncoder());

        ResponseEntity<?> response =
                controller.login(
                        new AuthController.LoginRequest(
                                "admin",
                                "admin123"
                        )
                );

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
    }

    @Test
    void invalidLoginIsRejected() {

        AuthController controller =
                new AuthController(new BCryptPasswordEncoder());

        ResponseEntity<?> response =
                controller.login(
                        new AuthController.LoginRequest(
                                "admin",
                                "wrong"
                        )
                );

        assertEquals(401, response.getStatusCode().value());
    }
}