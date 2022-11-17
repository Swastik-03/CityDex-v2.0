
package edu;

public abstract class EducationalInstitutions {

    private String name;
    private String city;
    private String website;
    private int fee;
    private String address;

    private double Rating;

    private String location;
    private int id;

    public EducationalInstitutions(int id,String name, String city, String website, int fee, String address,double rating ,String location) {
        this.id=id;
        this.name = name;
        this.city = city;
        this.website = website;
        this.fee = fee;
        this.address = address;
        this.Rating=rating;
        this.location=location;
    }

    public EducationalInstitutions() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return
                "name='" + name +
                ", city='" + city +
                ", website='" + website +
                ", fee='" + fee +
                ", address='" + address + " Rating "+Rating ;

    }


}
