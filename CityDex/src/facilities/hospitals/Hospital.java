package facilities.hospitals;
import facilities.*;

public class Hospital extends facilities{


    private String speciality;
    public Hospital(String name, String location, String address, String speciality, String contact, int rating, String city) {
        super(name, address, city, contact, rating,location);
        this.speciality = speciality;
    }

    public String getSpeciality(String specialty) {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public Hospital() {
        super();
    }
}

