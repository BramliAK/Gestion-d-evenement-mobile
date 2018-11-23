package com.example.ahmed.andoidapp.model;

/**
 * Created by ahmed on 22/11/2018.
 */

public class Localisations {
    private Long id;
    private String nomemplacement;
    private String emplacement;
    private String longitude;
    private String latitude;

    public Localisations() {
    }

    public Localisations(Long id, String nomemplacement, String emplacement, String longitude, String latitude) {
        this.id = id;
        this.nomemplacement = nomemplacement;
        this.emplacement = emplacement;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomemplacement() {
        return nomemplacement;
    }

    public void setNomemplacement(String nomemplacement) {
        this.nomemplacement = nomemplacement;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
