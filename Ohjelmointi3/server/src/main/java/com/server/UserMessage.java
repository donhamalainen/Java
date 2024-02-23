package com.server;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class UserMessage {

    // Attributes
    private String locationName;
    private String locationDescription;
    private String locationCity;
    private String locationCountry;
    private String locationStreetAddress;
    private String originalPoster;
    private ZonedDateTime originalPostingTime;
    private ZonedDateTime sent;
    private String latitude;
    private String longitude;

    // Constructor
    public UserMessage(String locationName, String locationDescription, String locationCity, String locationCountry,
            String locationStreetAddress, String originalPoster, String postingTime, String latitude,
            String longitude) {

        this.locationName = locationName;
        this.locationDescription = locationDescription;
        this.locationCity = locationCity;
        this.locationCountry = locationCountry;
        this.locationStreetAddress = locationStreetAddress;
        this.originalPoster = originalPoster;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        this.originalPostingTime = ZonedDateTime.parse(postingTime, formatter);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter and setters
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public ZonedDateTime getSent() {
        return sent;
    }

    public ZonedDateTime getOriginalPostingTime() {
        return originalPostingTime;
    }

    public void setOriginalPostingTime(ZonedDateTime originalPostingTime) {
        this.originalPostingTime = originalPostingTime;
    }

    public void setSent(ZonedDateTime sent) {
        this.sent = sent;
    }

    public long dateAsInt() {
        return originalPostingTime.toInstant().toEpochMilli();

    }

    public void setSent(long epoch) {
        originalPostingTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(epoch), ZoneOffset.UTC);
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationStreetAddress() {
        return locationStreetAddress;
    }

    public void setLocationStreetAddress(String locationStreetAddress) {
        this.locationStreetAddress = locationStreetAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOriginalPoster() {
        return originalPoster;
    }

    public void setOriginalPoster(String originalPoster) {
        this.originalPoster = originalPoster;
    }

}
