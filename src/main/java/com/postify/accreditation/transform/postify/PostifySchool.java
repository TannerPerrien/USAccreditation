package com.postify.accreditation.transform.postify;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class PostifySchool implements Serializable {

    private static final long serialVersionUID = -5257848755647159521L;

    public static class Coordinates implements Serializable {

        private static final long serialVersionUID = -5637493279319204299L;

        @SerializedName("x")
        private double lon;

        @SerializedName("y")
        private double lat;

        public double getLon() {
            return lon;
        }

        public void setLon(final double lon) {
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(final double lat) {
            this.lat = lat;
        }

        @Override
        public String toString() {
            return "lat: " + lat + ", lon: " + lon;
        }

    }

    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String url;
    private Coordinates loc;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(final String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Coordinates getLoc() {
        return loc;
    }

    public void setLoc(final Coordinates loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "name: " + name + ", address: " + address + ", city: " + city
                + ", state: " + state + ", zip: " + zip + ", phone: " + phone
                + ", url: " + url + ", loc: [" + loc + "]";
    }

}
