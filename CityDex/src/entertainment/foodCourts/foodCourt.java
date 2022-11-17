package entertainment.foodCourts;
import entertainment.*;

public class foodCourt extends entertainment {
    private int id;

    public foodCourt(String name, String location, String address, double rating,String city) {
        super(name, location,address, rating,city);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public foodCourt()
    {
        super();
    }


}
