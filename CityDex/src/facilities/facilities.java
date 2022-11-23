
package facilities;
public abstract class facilities {

   private String name;
   private String address;
   private String city;
   private String contact;
   private double rating;

   private String location;
   private int id;

    public facilities(String name, String address, String city, String contact, double rating,String location) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.contact = contact;
        this.rating = rating;
        this.location=location;
    }

    public facilities() {

    }

    public facilities(String name, String location, String address, int rating, String city) {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "ID="+id+
                "name='" + name +
                ", address='" + address +
                ", city='" + city +
                ", contact='" + contact +
                ", rating=" + rating;

    }
}
