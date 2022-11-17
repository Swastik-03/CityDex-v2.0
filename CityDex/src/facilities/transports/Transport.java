package facilities.transports;
import facilities.*;

public class Transport extends facilities {
    private String transportType;

    public Transport(String name, String location, String address, String transportType, String contact, int rating, String city) {
        super(name, address, city, contact, rating,location);
        this.transportType =transportType;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public Transport()
    {
        super();
    }

    @Override
    public String toString() {
        return super.toString()+
                "Transport Type = " + transportType;
    }

}
