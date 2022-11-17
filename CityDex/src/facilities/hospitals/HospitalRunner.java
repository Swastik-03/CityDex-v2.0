package facilities.hospitals;
import city.City;
import facilities.hotels.Hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;

public class HospitalRunner {
    static ArrayList<Hospital> hospitalarray=new ArrayList<>();

    public static void main(City city) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();


        String query = "select * from hospitals where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            Hospital h = new Hospital();
            h.setId(id);
            h.setName(resultSet.getString("Name"));
            h.setCity(resultSet.getString("City"));
            h.setSpeciality(resultSet.getString("Specialty"));
            h.setAddress(resultSet.getString("Address"));
            h.setContact(resultSet.getString("Contact"));
            h.setRating(Double.parseDouble(resultSet.getString("Rating")));
            h.setLocation(resultSet.getString("Location"));
            hospitalarray.add(h);
            id++;
        }
        for (Hospital i : hospitalarray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }

        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the hospital 2.To go to hospital's Webpage 3.To go to google maps 4.Exit hospital");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1 -> {

                    System.out.println("The details of all the hospital in " + city.getCity() + " are:");
                    for (Hospital i : hospitalarray) {
                        System.out.println("[ID: " + i.getId() + "]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating() + "]");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the id of the hospital");
                    int idd = Integer.parseInt(br.readLine());
                    for (Hospital j : hospitalarray) {
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
                    System.out.println("Enter the id of the hospital");
                    int idf = Integer.parseInt(br.readLine());
                    for (Hospital j : hospitalarray) {
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
                    hospitalarray.clear();
                }
            }

        }
        while (isTrue);

    }
}


