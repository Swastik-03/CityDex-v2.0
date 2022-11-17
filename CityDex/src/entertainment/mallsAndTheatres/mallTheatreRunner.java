package entertainment.mallsAndTheatres;
import city.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;


public class mallTheatreRunner {
    static ArrayList<mallTheatre> mallTheatreArray=new ArrayList<>();

    public static void main(City city) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();


        String query = "select * from mall_theatre where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            mallTheatre h = new mallTheatre();
            h.setId(id);
            h.setName(resultSet.getString("Name"));
            h.setCity(resultSet.getString("City"));
            h.setType(resultSet.getString("Type"));
            h.setAddress(resultSet.getString("Address"));
            h.setRating(Double.parseDouble(resultSet.getString("Rating")));
            h.setLocation(resultSet.getString("Location"));
            mallTheatreArray.add(h);
            id++;
        }
        for (mallTheatre i : mallTheatreArray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Type: "+ i.getType()+ " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }

        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the Malls and Theatres  2.To go to google maps 3.Exit Malls and Theatres");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1 -> {

                    System.out.println("The details of the Malls and Theatre in " + city.getCity() + " are:");
                    for (mallTheatre i : mallTheatreArray) {
                        System.out.println("[ID: " + i.getId() + "]" + " Name: " + i.getName() + " Type: " + i.getType() + " Address: " + i.getAddress() + " [Rating: " + i.getRating() + "]");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the id of the mall or theatre");
                    int idf = Integer.parseInt(br.readLine());
                    for (mallTheatre j : mallTheatreArray) {
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
                    mallTheatreArray.clear();
                }
            }

        }
        while (isTrue);

    }
}


