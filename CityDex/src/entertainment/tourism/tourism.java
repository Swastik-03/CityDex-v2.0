package entertainment.tourism;
import entertainment.*;

public class tourism extends entertainment{


    private String type;
    private int id;

    public tourism (String name, String location, String address, double rating, String type, String city) {
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


    public tourism () {
        super();
    }
}

