package com.example.crudapi.controller;

import com.example.crudapi.model.Station;
import com.example.crudapi.repository.StationRepository;
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
    StationRepository stationRepository;

    @GetMapping("/stations")
    public ResponseEntity<List<Station>> getAllStations(){
        try{
            List<Station> stations = stationRepository.findAll();

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
            Optional<Station> stationData = stationRepository.findById(id);

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
            Station _station = stationRepository.save(station);
            return new ResponseEntity<>(_station, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stations/{id}")
    public ResponseEntity<Station> updateStation(@PathVariable("id") String id, @RequestBody Station station){
        try{
            Optional<Station> stationData = stationRepository.findById(id);

            if(stationData.isPresent()){
                Station _station = stationData.get();

                if(station.getStationName() != null){
                    _station.setStationName(station.getStationName());
                }

                if(station.getStationAddress() != null){
                    _station.setStationAddress(station.getStationAddress());
                }

                if(station.getStationCity() != null){
                    _station.setStationCity(station.getStationCity());
                }

                if(station.getStationImage() != null){
                    _station.setStationImage(station.getStationImage());
                }

                if(station.getStationPricing() != null){
                    _station.setStationPricing(station.getStationPricing());
                }

                return new ResponseEntity<>(stationRepository.save(_station), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/stations/{id}")
    public ResponseEntity<HttpStatus> deleteStation(@PathVariable("id") String id){
        try{
            stationRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/stations")
    public ResponseEntity<HttpStatus> deleteAllStations(){
        try{
            stationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
