package com.example.crudapi.service;

import com.example.crudapi.model.Station;
import com.example.crudapi.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StationService {

    @Autowired
    StationRepository stationRepository;


    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Optional<Station> getStationById(String id) {
        return stationRepository.findById(id);
    }

    public Station createStation(Station station) {
        return stationRepository.save(station);
    }

    public Station updateStation(String id, Station station) {
        Optional<Station> stationData = stationRepository.findById(id);

        if(stationData.isPresent()) {
            Station _station = stationData.get();

            if (station.getStationName() != null) {
                _station.setStationName(station.getStationName());
            }

            if (station.getStationAddress() != null) {
                _station.setStationAddress(station.getStationAddress());
            }

            if (station.getStationCity() != null) {
                _station.setStationCity(station.getStationCity());
            }

            if (station.getStationImage() != null) {
                _station.setStationImage(station.getStationImage());
            }

            if (station.getStationPricing() != null) {
                _station.setStationPricing(station.getStationPricing());
            }

            return stationRepository.save(_station);
        }
        else{
            return null;
        }
    }

    public void deleteById(String id) {
        stationRepository.deleteById(id);
    }

    public void deleteAllStations() {
        stationRepository.deleteAll();
    }
}