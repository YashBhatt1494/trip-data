package com.tripData.entity;


import java.util.Objects;


public class Place {


    private Long placeId;
    private String placeName;
    private String state;
    private String address;


    public Place(Long placeid, String placeName, String state, String address) {
        this.placeId = placeid;
        this.placeName = placeName;
        this.state = state;
        this.address = address;
    }

    public Place(String placeName, String state, String address) {
        this.placeName = placeName;
        this.state = state;
        this.address = address;
    }
    public Place(){

    }


    public Long getPlaceid() {
        return placeId;
    }

    public void setPlaceid(Long placeid) {
        this.placeId = placeid;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeid=" + placeId +
                ", placeName='" + placeName + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return Objects.equals(placeId, place.placeId) &&
                Objects.equals(placeName, place.placeName) &&
                Objects.equals(state, place.state) &&
                Objects.equals(address, place.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, placeName, state, address);
    }
}
