package entertainment;

public abstract class entertainment {

    private String name;
    private String address;
    private String city;
    private double rating;
    private String location;
    public entertainment(String name, String address, String city, double rating,String location) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.rating = rating;
        this.location=location;
    }

    public entertainment() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
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
                        ", address='" + address +
                        ", address='" + address +
                        ", city='" + city +
                        ", rating=" + rating;
    }
}
