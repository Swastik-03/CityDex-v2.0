package entertainment.tourism;
import city.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;


public class tourismRunner {
    static ArrayList<tourism> tourismArray =new ArrayList<>();

    public static void main(City city) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();


        String query = "select * from tourism where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            tourism h = new tourism();
            h.setId(id);
            h.setName(resultSet.getString("Name"));
            h.setCity(resultSet.getString("City"));
            h.setType(resultSet.getString("Type"));
            h.setAddress(resultSet.getString("Address"));
            h.setRating(Double.parseDouble(resultSet.getString("Rating")));
            h.setLocation(resultSet.getString("Location"));
            tourismArray.add(h);
            id++;
        }
        for (tourism i : tourismArray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Type: "+ i.getType()+ " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }

        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the Toursism  2.To go to google maps 3.Exit Tourism");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1 -> {

                    System.out.println("The details of all the tourism places in " + city.getCity() + " are:");
                    for (tourism i : tourismArray) {
                        System.out.println("[ID: " + i.getId() + "]" + " Name: " + i.getName() + " Type: " + i.getType() + " Address: " + i.getAddress() + " [Rating: " + i.getRating() + "]");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the id of the tourism place");
                    int idf = Integer.parseInt(br.readLine());
                    for (tourism j : tourismArray) {
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
                case 3 -> {
                    isTrue = false;
                    tourismArray.clear();
                }
            }

        }
        while (isTrue);

    }
}


