package entertainment.foodCourts;

import city.City;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.sql.*;
import java.util.ArrayList;

public class foodCourtRunner {
    static ArrayList<foodCourt>foodCourtArray=new ArrayList<>();
    public static void main(City city) throws SQLException, IOException{
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Sm.963258741m");

        Statement statement= connection.createStatement();
        String query="select * from fastfood where city ="+"'" + city.getCity() + "'";
        ResultSet resultSet=statement.executeQuery(query);
        int id=1;
        while(resultSet.next()) {
            foodCourt h = new foodCourt();
            h.setId(id);
            h.setName(resultSet.getString("Name"));
            h.setCity(resultSet.getString("City"));
            h.setAddress(resultSet.getString("address"));
            h.setLocation(resultSet.getString("location"));
            h.setRating(Double.parseDouble(resultSet.getString("rating")));
            foodCourtArray.add(h);
            id++;
        }

        for (foodCourt i : foodCourtArray) {
            System.out.println("[ID: " + i.getId() +"]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating()+"]");
        }


        boolean isTrue=true;
        do{
            System.out.println("Enter 1.To Re-Display all the Food Courts  2.To go to google maps 3.Exit Food Courts");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int c = Integer.parseInt(br.readLine());
            switch (c) {
                case 1 -> {

                    System.out.println("The details of the Food Courts in " + city.getCity() + " are:");
                    for (foodCourt i : foodCourtArray) {
                        System.out.println("[ID: " + i.getId() + "]" + " Name: " + i.getName() + " Address: " + i.getAddress() + " [Rating: " + i.getRating() + "]");
                    }
                }
                case 2 -> {
                    System.out.println("Enter the id of Food Court");
                    int idf = Integer.parseInt(br.readLine());
                    for (foodCourt j : foodCourtArray) {
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
                    foodCourtArray.clear();
                }
            }

        }
        while (isTrue);

    }
}
