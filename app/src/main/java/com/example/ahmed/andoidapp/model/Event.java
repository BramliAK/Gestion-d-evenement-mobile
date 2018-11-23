package com.example.ahmed.andoidapp.model;

import java.util.List;

/**
 * Created by ahmed on 22/11/2018.
 */

public class Event {

    private Long id;
    private String nom;
    private String description;
    private String typeevnet;
    private String image;
    private String imageContentType;
    private String prix;
    private List<Dateevents> dateevents;
    private List<Localisations> localisations;

    public Event() {
    }

    public Event(Long id, String nom, String description, String typeevnet, String image, String imageContentType, String prix, List<Dateevents> dateevents, List<Localisations> localisations) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.typeevnet = typeevnet;
        this.image = image;
        this.imageContentType = imageContentType;
        this.prix = prix;
        this.dateevents = dateevents;
        this.localisations = localisations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeevnet() {
        return typeevnet;
    }

    public void setTypeevnet(String typeevnet) {
        this.typeevnet = typeevnet;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public List<Dateevents> getDateevents() {
        return dateevents;
    }

    public void setDateevents(List<Dateevents> dateevents) {
        this.dateevents = dateevents;
    }

    public List<Localisations> getLocalisations() {
        return localisations;
    }

    public void setLocalisations(List<Localisations> localisations) {
        this.localisations = localisations;
    }
}