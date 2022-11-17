package edu.Institutions.College;

import city.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;

public class CollegeRunner {
    static ArrayList<College> Collegearray=new ArrayList<>();

    static double average;
    public static void main(City city) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();

        String query = "select * from colleges where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        int id = 1;
        while (resultSet.next()) {
            College h = new College();
            h.setId(id);
            h.setName(resultSet.getString("Name"));
            h.setCity(resultSet.getString("City"));
            h.setAddress(resultSet.getString("Address"));
            h.setWebsite(resultSet.getString("Website"));
            h.setRating(Double.parseDouble(resultSet.getString("Rating")));
            h.setFee(Integer.parseInt(resultSet.getString("Semester_Fee")));
            h.setLocation(resultSet.getString("Location"));
            Collegearray.add(h);
            id++;
        }
        for (College i : Collegearray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }
        String query2 = "select avg(Semester_Fee) as Average from colleges where city =" + "'" + city.getCity() + "'";
        ResultSet resultSet2 = statement.executeQuery(query2);

        while(resultSet2.next()) {
            average= Double.parseDouble(resultSet2.getString(1));
            System.out.println("The average fee per semester for a college in this city is :" + average);
        }
        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the colleges 2.To go to college's Webpage 3.To go to google maps 4.Exit College");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1 -> {

                    System.out.println("The details of all the Collges in " + city.getCity() + " are:");
                    for (College i : Collegearray) {
                        System.out.println("[ID: " + i.getId() + "]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating() + "]");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the id of the College");
                    int idd = Integer.parseInt(br.readLine());
                    for (College j : Collegearray) {
                        if (j.getId() == idd) {
                            try {

                                URI uri = new URI(j.getWebsite());
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
                    System.out.println("Enter the id of the College");
                    int idf = Integer.parseInt(br.readLine());
                    for (College j : Collegearray) {
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
                    Collegearray.clear();
                }
            }

        }
        while (isTrue);

    }
}

