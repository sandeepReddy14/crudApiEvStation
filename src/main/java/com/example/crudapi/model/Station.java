package com.example.crudapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "evBatteryStationsCollection")
public class Station {

    @Id
    private String id;

    private String stationName;
    private String stationCity;
    private Double stationPricing;
    private String stationAddress;
    private byte[] stationImage;

    public Station() {
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCity() {
        return stationCity;
    }

    public void setStationCity(String stationCity) {
        this.stationCity = stationCity;
    }

    public Double getStationPricing() {
        return stationPricing;
    }

    public void setStationPricing(Double stationPricing) {
        this.stationPricing = stationPricing;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public byte[] getStationImage() {
        return stationImage;
    }

    public void setStationImage(byte[] stationImage) {
        this.stationImage = stationImage;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", stationName='" + stationName + '\'' +
                ", stationCity='" + stationCity + '\'' +
                ", stationPricing=" + stationPricing +
                ", stationAddress='" + stationAddress + '\'' +
                ", stationImage=" + Arrays.toString(stationImage) +
                '}';
    }
}
