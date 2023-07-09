package com.example.crudapi.repository;

import com.example.crudapi.model.Station;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StationRepository extends MongoRepository<Station, String> {
}
