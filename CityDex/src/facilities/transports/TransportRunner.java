package facilities.transports;
import city.City;
import facilities.hotels.Hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;


public class TransportRunner {
    static ArrayList<Transport> transportArray=new ArrayList<>();


    public static void main(City city) throws SQLException, IOException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();


        String query = "select * from transport where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            Transport h = new Transport();
            h.setId(id);
            h.setName(resultSet.getString("name"));
            h.setCity(resultSet.getString("city"));
            h.setAddress(resultSet.getString("ADDRESS"));
            h.setContact(resultSet.getString("CONTACT"));
            h.setRating(Double.parseDouble(resultSet.getString("Rating")));
            h.setTransportType(resultSet.getString("transport_type"));
            h.setLocation(resultSet.getString("Location"));
            transportArray.add(h);
            id++;
        }
        for (Transport i : transportArray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() +"  Transport Type: "+i.getTransportType()+ " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }

        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display Transport stations 2.Contact Transport 3.To go to google maps 4.Exit Transport");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1 -> {

                    System.out.println("The details of different transport modes and stations in " + city.getCity() + " are:");
                    for (Transport i : transportArray) {
                        System.out.println("[ID: " + i.getId() + "]" + " Name: " + i.getName() +"  Transport Type: "+i.getTransportType() + " Address: " + i.getAddress() + " [Rating: " + i.getRating() + "]");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the id of the Transport station");
                    int idd = Integer.parseInt(br.readLine());
                    for (Transport j : transportArray) {
                        if (j.getId() == idd) {
                            try {

                                URI uri = new URI(j.getContact());
                                System.out.println(uri);

                                java.awt.Desktop.getDesktop().browse(uri);
                                System.out.println("Web page opened in browser");

                            } catch (Exception e) {

                                e.printStackTrace();
                            }
                        }

                    }
                }
                case 3 -> {
                    System.out.println("Enter the id of the transport station");
                    int idf = Integer.parseInt(br.readLine());
                    for (Transport j : transportArray) {
                        if (j.getId() == idf) {
                            try {

                                URI uri = new URI(j.getLocation());
                                System.out.println(uri);

                                java.awt.Desktop.getDesktop().browse(uri);
                                System.out.println("Web page opened in browser");

                            } catch (Exception e) {

                                e.printStackTrace();
                            }
                        }

                    }
                }
                case 4 -> {
                    isTrue = false;
                    transportArray.clear();
                }
            }

        }
        while (isTrue);

    }
}
