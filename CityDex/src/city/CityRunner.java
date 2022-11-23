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
import java.net.URISyntaxException;
import java.sql.*;
interface intro{
    void printIntro(City city) ;
}
public class CityRunner implements intro {
    City city;

    public CityRunner(City city) {
        this.city = city;
    }



    public void runner() throws SQLException, IOException, URISyntaxException {

        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        //Statement statement = connection.createStatement();

       // String query = "select * from hotels where city =" + "'" + this.city.getCity() + "'";
       // ResultSet resultSet = statement.executeQuery(query);

        printIntro(city);
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

    @Override
    public void printIntro(City city) {
        if(city.getCity().equalsIgnoreCase("kolkata"))
        {
            System.out.println("\n About Kolkata : \n\t\t\t Kolkata, formerly known as Calcutta, is the capital of the Indian state of West Bengal.\n Located on the east bank of the Hooghly River, it is the principal commercial, cultural, and educational centre of East India, while the Port of Kolkata is India's oldest operating port and its sole major riverine port. \n As of 2011, the city had 4.5 million residents; the urban agglomeration, which comprises the city and its suburbs, was home to approximately 14.1 million, making it the third-most populous metropolitan area in India. \n As of 2016, the GDP of Kolkata was estimated to be US$60 billion. \n\n");
        }
        if(city.getCity().equalsIgnoreCase("delhi"))
        {
            System.out.println("\n About Delhi : \n\t\t\t Delhi, the capital of India, is a large metropolis with a population of over 16 million people. \n It is the second most populous city in India after Mumbai and is the eighth most populous city in the world. \n Delhi is the historical and present day capital of India. \n It is also the political hub of the country with the Parliament, President's House and Supreme Court all located here. \n Delhi is a major commercial center and is home to many large businesses and industries. \n It is also a major tourist destination, with many historical and cultural sites to see. \n\n");
        }
        if(city.getCity().equalsIgnoreCase("mumbai"))
        {
            System.out.println("\n About Mumbai : \n\t\t\t Mumbai, formerly known as Bombay, is the capital of the Indian state of Maharashtra.\n It is the most populous city in India with an estimated population of 12.4 million.\n Mumbai is also the wealthiest city in India, and has the highest GDP of any city in South, West, or Central Asia. Mumbai has a long history, dating back to the mid-17th century.\n It was originally a small fishing village named after the goddess Mumbadevi.\n However, it soon became a major trading port, and was eventually made the capital of the British Raj in 1858.\n Mumbai remained the capital of the Raj until India gained independence in 1947.\n Today, Mumbai is a major financial, commercial, and entertainment hub of India.\n It is home to the Bombay Stock Exchange, the National Stock Exchange of India, and the headquarters of several major Indian banks and financial institutions.\n Mumbai is also home to Bollywood, the largest film industry in the world. \n\n");
        }
        if(city.getCity().equalsIgnoreCase("chennai"))
        {
            System.out.println("\n About Chennai : \n\t\t\t Chennai is one of the most populous cities in India.\n It is the capital of Tamil Nadu and is located on the Coromandel Coast of the Bay of Bengal.\n Chennai is a major cultural, economic and educational hub in India.\n It is one of the world's most populous cities and has a diverse population.\n Chennai is also home to a large number of IT and manufacturing companies.\n The city has a tropical climate and experiences hot and humid weather for most of the year.\n Chennai is also a major center for Carnatic music and dance. \n\n");
        }



    }
}
