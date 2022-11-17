package entertainment.mallsAndTheatres;
import entertainment.*;

public class mallTheatre extends entertainment{


    private String type;
    private int id;

    public mallTheatre(String name, String location, String address, int rating, String type, String city) {
        super(name, location,address, rating,city);
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public mallTheatre() {
        super();
    }
}

