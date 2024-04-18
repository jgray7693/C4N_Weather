package com.c4n.c4n_weather.Locations;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record All_Locations (
    String city,
    String state_id,
    String state_name,
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    double lat,
    @Id
    double lon
){
    public All_Locations{
        if (lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        if (lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
    }
    public String getCityStateID() {
        return String.format("%s, %s", city, state_id);
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
