package com.cenk.FlightSearch.controller;

import com.cenk.FlightSearch.entity.entityFlights;
import com.cenk.FlightSearch.service.FlightsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Tag(name = "Flights", description = "the Flights Api")

@RestController
@RequestMapping("/flights")
public class FlightsController {

    private FlightsService flightsService;

@Autowired
    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }


    @Operation(
            summary = "To save a new flight. We should use the post method.",
            description = "The Post service creates a new flight.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping("/")
    public entityFlights save(@RequestBody entityFlights EntityFlights){
    return flightsService.save(EntityFlights);
    }



    @Operation(
            summary = "To fetch the all flights, We use this get method.",
            description = "The Get service fetches the all flights in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/")
    public List<entityFlights> findAll(){
        return flightsService.findAll();
    }



    @Operation(
            summary = "To fetch a specific flight, We use this get method.",
            description = "The Get service fetches the specific flights in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/{id}")
    public entityFlights findById(@PathVariable int id) {
        return flightsService.findById(id);
    }



    @Operation(
            summary = "To fetch a specific airport with some parameters.",
            description = "The Get service fetches the specific airport with some parameters.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/findFlights")
    public List<entityFlights> findFlights(@RequestParam("departureAirport") String departureAirport,
                                           @RequestParam("arrivalAirport") String arrivalAirport,
                                           @RequestParam("departureDate") LocalDate departureDate,
                                           @RequestParam(name= "returnDate",required = false)  LocalDate returnDate) {
        return flightsService.findFlights(departureAirport,arrivalAirport,departureDate,returnDate);
    }



    @Operation(
            summary = "To update specific flight, We use this put method.",
            description = "The Put service updates the specific flight in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/{id}")
    public entityFlights update( @PathVariable int id ,@RequestBody entityFlights EntityFlights) {
        EntityFlights.setId(id);
        return flightsService.update(EntityFlights);
    }



    @Operation(
            summary = "To delete the given flight, We use this delete method.",
            description = "The Delete service deletes the given flight in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("/{id}")
    public entityFlights remove( @PathVariable int id) {
        return flightsService.remove(id);
    }

}
