package com.example.crudapi.controller;

import com.example.crudapi.model.Station;
import com.example.crudapi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ev-battery-api")
public class StationController {

    @Autowired
    StationService stationService;

    @GetMapping("/stations")
    public ResponseEntity<List<Station>> getAllStations(){
        try{
            List<Station> stations = stationService.getAllStations();
            if(stations.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(stations, HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stations/{id}")
    public ResponseEntity<Station> getStationById(@PathVariable("id") String id){
        try{
            Optional<Station> stationData = stationService.getStationById(id);

            if(stationData.isPresent()){
                return new ResponseEntity<>(stationData.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/stations")
    public ResponseEntity<Station> createStation(@RequestBody Station station){
        try{
            Station _station = stationService.createStation(station);
            return new ResponseEntity<>(_station, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stations/{id}")
    public ResponseEntity<Station> updateStation(@PathVariable("id") String id, @RequestBody Station station){
        try{
            Station _station = stationService.updateStation(id,station);
            if(_station == null){
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(_station, HttpStatus.OK);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/stations/{id}")
    public ResponseEntity<HttpStatus> deleteStation(@PathVariable("id") String id){
        try{
            stationService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/stations")
    public ResponseEntity<HttpStatus> deleteAllStations(){
        try{
            stationService.deleteAllStations();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
