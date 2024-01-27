package com.cenk.FlightSearch.controller;

import com.cenk.FlightSearch.dto.RegistrationMember;
import com.cenk.FlightSearch.entity.Member;
import com.cenk.FlightSearch.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Auth", description = "the Auth Api")

@RestController
@RequestMapping("/auth")

public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @Operation(
            summary = "To register a user We should use the post method.",
            description = "The Post service creates a new user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember){
        return authenticationService.register(registrationMember.email(), registrationMember.password());
    }
}
