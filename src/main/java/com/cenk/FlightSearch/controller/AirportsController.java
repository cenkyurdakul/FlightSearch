package com.cenk.FlightSearch.controller;

import com.cenk.FlightSearch.entity.entityAirports;
import com.cenk.FlightSearch.service.AirportsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Airport", description = "the Airport Api")

@RestController
@RequestMapping("airports")
public class AirportsController {

    private AirportsService airportsService;

    @Autowired
    public AirportsController(AirportsService airportsService) {
        this.airportsService = airportsService;
    }

    @Operation(
            summary = "To save a new airport We should use the post method.",
            description = "The Post service creates a new airport.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/")
    public entityAirports save(@RequestBody entityAirports EntityAirports) {
        return airportsService.save(EntityAirports);
    }


    @Operation(
            summary = "To fetch the all airports, We use this get method.",
            description = "The Get service fetches the all airports in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })

    @GetMapping("/")
    public List<entityAirports> findAll() {
        return airportsService.findAll();
    }



    @Operation(
            summary = "To fetch a specific airport, We use this get method.",
            description = "The Get service fetches the specific airport in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/{id}")
    public entityAirports findById(@RequestBody int id) {
        return airportsService.findById(id);
    }



    @Operation(
            summary = "To update specific airports, We use this put method.",
            description = "The Put service updates the specific airport in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })

    @PutMapping("/")
    public entityAirports update(entityAirports EntityAirports) {
        return airportsService.update(EntityAirports);
    }



    @Operation(
            summary = "To delete the given airport, We use this delete method.",
            description = "The Delete service deletes the given airport in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("/{id}")
    public entityAirports remove(@RequestBody int id) {
        return airportsService.remove(id);
    }
}
