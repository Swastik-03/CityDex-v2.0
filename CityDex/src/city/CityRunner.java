package city;

import edu.Institutions.College.CollegeRunner;
import edu.Institutions.school.SchoolRunner;
import entertainment.foodCourts.foodCourtRunner;
import entertainment.mallsAndTheatres.mallTheatreRunner;
import entertainment.tourism.tourismRunner;
import facilities.hospitals.HospitalRunner;
import facilities.hotels.HotelRunner;
import facilities.transports.TransportRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class CityRunner {
    City city;

    public CityRunner(City city) {
        this.city = city;
    }


    public void runner() throws SQLException, IOException {

        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        //Statement statement = connection.createStatement();

       // String query = "select * from hotels where city =" + "'" + this.city.getCity() + "'";
       // ResultSet resultSet = statement.executeQuery(query);

        boolean isTrue=true;
        do{
            System.out.println("Enter 1.Hotels  2.Hospitals  3.Educational Institutions  4.Entertainment 5.Transports 6.Exit");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());


            switch (c) {
                case 1 -> HotelRunner.main(city);
                case 2 -> HospitalRunner.main(city);

                case 3 -> {
                    boolean sst = true;
                    do {
                        System.out.println("Enter 1.Schools 2.Colleges 3.Exit Educational Institutions");
                        int cc = Integer.parseInt(br.readLine());
                        switch (cc) {
                            case 1 -> SchoolRunner.main(city);
                            case 2 -> CollegeRunner.main(city);
                            case 3 -> sst = false;
                        }

                    } while (sst);
                }

                case 4 -> {
                    boolean sst = true;
                    do {
                        System.out.println("Enter 1.Malls and Theatres  2.Food Courts  3.Tourism   4.Exit Entertainment");
                        int cc = Integer.parseInt(br.readLine());
                        switch (cc) {
                            case 1 -> mallTheatreRunner.main(city);
                            case 2 -> foodCourtRunner.main(city);
                            case 3 -> tourismRunner.main(city);
                            case 4 -> sst = false;
                        }

                    } while (sst);
                }
                case 5->TransportRunner.main(city);

                default -> isTrue = false;
            }
    }while (isTrue);
    }

}
