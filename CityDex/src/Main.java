import Csv2DbInserter.HospitalInserter;
import city.City;
import coderunner.startswitch;
import edu.Institutions.College.CollegeRunner;
import edu.Institutions.school.SchoolRunner;
import entertainment.foodCourts.foodCourtRunner;
import entertainment.mallsAndTheatres.mallTheatreRunner;
import entertainment.tourism.tourismRunner;
import facilities.hospitals.HospitalRunner;
import facilities.hotels.HotelRunner;
import facilities.transports.TransportRunner;
import person.admin.AdminRunner;
import person.user.User;
import person.user.UserRunner;
import requestr.Requester;

import Csv2DbInserter.CollegeInserter;
import Csv2DbInserter.HospitalInserter;
import Csv2DbInserter.SchoolInserter;
import CsvUpdater.HospitalUpdater;
import CsvUpdater.SchoolUpdater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Main {


    public static void CommandLine(String[] args) throws SQLException,IOException,URISyntaxException
    {
        boolean flag=false;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        if (args[0].equals("-h") && args.length==1)
    {
        flag=true;
        System.out.println("-search [faciclities] -city [city] -------> To search list of facilities in city");
        System.out.println("-search [faciclities] -city [city] -rating gt [number] -------> To search list of facilities in city with rating greater than given number");
        System.out.println("-search [faciclities] -city [city] -rating lt [number] -------> To search list of facilities in city with rating less than given number");
        System.out.println("-search [faciclities] -city [city] -rating eq [number] -------> To search list of facilities in city with rating equal to given number");
        System.out.println("-search [faciclities] -city [city] -name [\"String\"] -------> To search list of facilities in city with name containing the given string");
        System.out.println("-search [faciclities] -city [city] -ID [Id] -------> To search facility in city with Id of required facility");
        System.out.println("-search [faciclities] -city [city] -ID [Id] Web -------> To go to Webpage of facility in city with Id of required facility");
        System.out.println("-search [faciclities] -city [city] -ID [Id] location -------> To search list of facilities in city with Id of required facilities\n");
        System.out.println("-request -------> To request to include your facility in our app");
        System.out.println("-update_profile -------> To update your profile");
        System.out.println("-display requests -------> To show all requests");
        System.out.println("-Accept requests -------> To accept requests");
        System.out.println("-Delete requests -------> To delete requests");
        System.out.println("-sign_up -------> To Create an account");
        System.out.println("-CSV [facilities] -------> To insert CSV file in database for given facility");
        System.out.println("-Update -CSV [facilities] -------> To update CSV for given facility\n");
        System.out.println("-----------------------------------------------------NOTE------------------------------------------------------------------------------------------------");
        System.out.println("Availabe facilities are-> colleges , schools ,fastfood , mall_theatre ,hospitals , hotels , tourism ,transport");
        System.out.println("Availabe cities are-> Delhi, Kolkata, Mumbai, Chennai");
        System.out.println("Facilities whose Webpage is not available are -> fastfood ,mall_theatre,tourism");
        System.out.println("Facilities available for CSV are hospitals,colleges,schools");
        System.out.println("Facilities available for -Update -CSV are hospitals,schools");
        exit(0);

    }
        else if (args[0].equals("-v") && args.length==1)
        {
            flag=true;
            System.out.println("CityDex -a smart and simple multi city guide version 4.2");
            System.out.println("Co-Created by -> Swastik Mukati,Choragudi V S Datta Sandeep,Kanishaka Pranjal,Divyanshu Jha ,Kondaka Pranav");
            exit(0);

        }
        else if(args[0].equals("-display") && args[1].equals("-requests"))
        { flag=true;
            String uname,pass;
            System.out.println("Enter Admin Username : ");
            uname=br.readLine();
            System.out.println("Enter Admin Password : ");
            pass=br.readLine();
            boolean W=false;
            W=AdminRunner.login(uname,pass);
            if(W)
            {
                AdminRunner.showRequests();
                exit(0);
            }
        }
        else if(args[0].equals("-Accept") && args[1].equals("-requests"))
        {
            flag=true;
            String uname,pass;
            System.out.println("Enter Admin Username : ");
            uname=br.readLine();
            System.out.println("Enter Admin Password : ");
            pass=br.readLine();
            boolean W=false;
            W=AdminRunner.login(uname,pass);
            if(W)
            {
                AdminRunner.acceptRequests();
                exit(0);
            }
        }

        else if(args[0].equals("-Delete") && args[1].equals("-requests"))
        {
            flag=true;
            String uname,pass;
            System.out.println("Enter Admin Username : ");
            uname=br.readLine();
            System.out.println("Enter Admin Password : ");
            pass=br.readLine();
            boolean W=false;
            W=AdminRunner.login(uname,pass);
            if(W)
            {
                AdminRunner.deleteRequests();
                exit(0);
            }
        }
        else if(args[0].equals("-CSV") && args[1]!=null)
        {
            if(args[1].equals("hospitals"))
            {
                flag=true;
                String uname,pass;
                System.out.println("Enter Admin Username : ");
                uname=br.readLine();
                System.out.println("Enter Admin Password : ");
                pass=br.readLine();
                boolean W=false;
                W=AdminRunner.login(uname,pass);
                if(W)
                {
                    HospitalInserter hs=new HospitalInserter();
                    hs.main();
                    exit(0);
                }
            }
            else if(args[1].equals("schools"))
            {
                flag=true;
                String uname,pass;
                System.out.println("Enter Admin Username : ");
                uname=br.readLine();
                System.out.println("Enter Admin Password : ");
                pass=br.readLine();
                boolean W=false;
                W=AdminRunner.login(uname,pass);
                if(W)
                {
                    SchoolInserter sc=new SchoolInserter();
                    sc.main();
                    exit(0);
                }
            }
            else if(args[1].equals("colleges"))
            {
                flag=true;
                String uname,pass;
                System.out.println("Enter Admin Username : ");
                uname=br.readLine();
                System.out.println("Enter Admin Password : ");
                pass=br.readLine();
                boolean W=false;
                W=AdminRunner.login(uname,pass);
                if(W)
                {
                    CollegeInserter cl=new CollegeInserter();
                    cl.main();
                    exit(0);
                }
            }
        }
        else if (args[0].equals("-Update") && args[1].equals("-CSV") && args[2]!=null)
        {
            if(args[2].equals("hospitals"))
            {
                flag=true;
                String uname,pass;
                System.out.println("Enter Admin Username : ");
                uname=br.readLine();
                System.out.println("Enter Admin Password : ");
                pass=br.readLine();
                boolean W=false;
                W=AdminRunner.login(uname,pass);
                if(W) {
                    System.out.println("Enter the name of hospital: ");
                    String nm = br.readLine();
                    System.out.println("Enter the address: ");
                    String add = br.readLine();
                    System.out.println("Enter the speciality: ");
                    String spl = br.readLine();
                    System.out.println("Enter the website: ");
                    String web = br.readLine();
                    HospitalUpdater.load_from_hospitals_csv(nm, add, spl, web);
                }
                exit(0);
            }
            if(args[2].equals("schools"))
            { flag=true;
                String uname,pass;
                System.out.println("Enter Admin Username : ");
                uname=br.readLine();
                System.out.println("Enter Admin Password : ");
                pass=br.readLine();
                boolean W=false;
                W=AdminRunner.login(uname,pass);
                if(W) {
                    System.out.println("Enter the name of school: ");
                    String nm2 = br.readLine();
                    System.out.println("Enter the address: ");
                    String add2 = br.readLine();
                    System.out.println("Enter the name of principal: ");
                    String prncpl = br.readLine();
                    System.out.println("Enter the website: ");
                    String web2 = br.readLine();
                    SchoolUpdater.load_from_schools_csv(nm2, add2, prncpl, web2);
                }
                exit(0);
            }
        }
        else if(args[0].equals("-sign_up") && args.length==1)
        {
            flag=true;
            UserRunner.signup();
            exit(0);
        }
        else
        {
            flag=false;
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * from userprofiles");

        System.out.println("Enter the Username: ");
        String uname=br.readLine();
        System.out.println("Enter the password: ");
        String pass=br.readLine();
        User user = null;
        ArrayList<User> userarray=new ArrayList<>();
        int i=1;

        while (resultSet.next()) {
            User u =new User();

            String k = resultSet.getString("Name");
            u.setId(i);
            u.setName(resultSet.getString("Name"));
            u.setCity(resultSet.getString("City"));
            u.setPassword(resultSet.getString("Password"));
            u.setUsername(resultSet.getString("Username"));
            u.setMail(resultSet.getString("Email"));
            u.setContact(resultSet.getLong("Contact"));
            i++;
            userarray.add(u);
        }


        Boolean T=false;
        for(User j:userarray) {
            if (j.getUsername().equals(uname)) {
                for (User p : userarray) {
                    if (p.getUsername().equals(uname)) {
                        if (p.getPassword().equals(pass))
                        {
                            T = true;
                            user=j;
                        }
                    }
                }
            }
        }


            if (T)
            {
                System.out.println("\nLogged in\n");
                if (args[0].equals("-search") && args[2].equals("-city") && args[1] != null && args[3] != null)
                {
                    City n = new City(args[3]);

                    if (args.length > 4)
                    {
                        if (args[4].equals("-rating"))
                        {
                            if (args[5].equals("gt") && args[6] != null)
                            {
                                flag=true;
                                double r = Double.parseDouble(args[6]);
                                switch (args[1])
                                {
                                    case "colleges" -> {CollegeRunner.gtRating(n, r);}
                                    case "schools" -> SchoolRunner.gtRating(n, r);
                                    case "fastfood" -> foodCourtRunner.gtRating(n, r);
                                    case "mall_theatre" -> mallTheatreRunner.gtRating(n, r);
                                    case "hospitals" -> HospitalRunner.gtRating(n, r);
                                    case "hotels" -> HotelRunner.gtRating(n, r);
                                    case "tourism" -> tourismRunner.gtRating(n, r);
                                    case "transport" -> TransportRunner.gtRating(n, r);
                                    default -> {
                                        System.out.println("Incorrect command!!!!");
                                        flag=false;
                                    }
                                }

                                exit(0);
                            } else if (args[5].equals("lt") && args[6] != null)
                            {
                                flag=true;
                                double r = Double.parseDouble(args[6]);
                                switch (args[1])
                                {
                                    case "colleges" -> CollegeRunner.ltRating(n, r);
                                    case "schools" -> SchoolRunner.ltRating(n, r);
                                    case "fastfood" -> foodCourtRunner.ltRating(n, r);
                                    case "mall_theatre" -> mallTheatreRunner.ltRating(n, r);
                                    case "hospitals" -> HospitalRunner.ltRating(n, r);
                                    case "hotels" -> HotelRunner.ltRating(n, r);
                                    case "tourism" -> tourismRunner.ltRating(n, r);
                                    case "transport" -> TransportRunner.ltRating(n, r);
                                    default -> {
                                        System.out.println("Incorrect command!!!!");
                                        flag=false;
                                    }
                                }
                                exit(0);
                            }
                            else if (args[5].equals("eq") && args[6] != null)
                            {
                                flag=true;
                                double r = Double.parseDouble(args[6]);
                                switch (args[1])
                                {
                                    case "colleges" -> CollegeRunner.eqRating(n, r);
                                    case "schools" -> SchoolRunner.eqRating(n, r);
                                    case "fastfood" -> foodCourtRunner.eqRating(n, r);
                                    case "mall_theatre" -> mallTheatreRunner.eqRating(n, r);
                                    case "hospitals" -> HospitalRunner.eqRating(n, r);
                                    case "hotels" -> HotelRunner.eqRating(n, r);
                                    case "tourism" -> tourismRunner.eqRating(n, r);
                                    case "transport" -> TransportRunner.eqRating(n, r);
                                    default -> {
                                        System.out.println("Incorrect command!!!!");
                                        flag=false;
                                    }
                                }

                                exit(0);
                            }
                        }
                        else if (args[4].equals("-name"))
                        {
                            if (args[5] != null)
                            {
                                flag=true;
                                switch (args[1])
                                {
                                    case "colleges" -> CollegeRunner.Searchname(n,args[5]);
                                    case "schools" -> SchoolRunner.Searchname(n,args[5]);
                                    case "fastfood" -> foodCourtRunner.Searchname(n,args[5]);
                                    case "mall_theatre" -> mallTheatreRunner.Searchname(n,args[5]);
                                    case "hospitals" -> HospitalRunner.Searchname(n,args[5]);
                                    case "hotels" -> HotelRunner.Searchname(n,args[5]);
                                    case "tourism" -> tourismRunner.Searchname(n,args[5]);
                                    case "transport" -> TransportRunner.Searchname(n,args[5]);
                                    default -> {
                                        System.out.println("Incorrect command!!!!");
                                        flag=false;
                                    }
                                }

                                exit(0);
                            }
                        }
                        else if(args[4].equals("-ID") && args[5]!=null && args[6].equals("Web"))
                        {
                            flag=true;
                            int id=Integer.parseInt(args[5]);
                            switch (args[1])
                            {
                                case "colleges" -> CollegeRunner.getWeb(n, id);
                                case "schools" -> SchoolRunner.getWeb(n, id);
                                case "hospitals" -> HospitalRunner.getWeb(n, id);
                                case "hotels" -> HotelRunner.getWeb(n, id);
                                case "transport" -> TransportRunner.getWeb(n,id);
                                default -> {
                                    System.out.println("Incorrect command!!!!");
                                    flag=false;
                                }                            }

                            if(args[1].equals("fastfood")|| args[1].equals("mall_theatre") || args[1].equals("tourism"))
                            {
                                System.out.println("There is'n a WebPage for these facilities!!! Try again");
                                flag=false;
                            }
                            exit(0);
                        }

                        else if(args[4].equals("-ID") && args[5]!=null && args[6].equals("location"))
                        {
                            flag=true;
                            int id=Integer.parseInt(args[5]);
                            switch (args[1])
                            {
                                case "colleges" -> CollegeRunner.getloc(n, id);
                                case "schools" -> SchoolRunner.getloc(n, id);
                                case "fastfood" -> foodCourtRunner.getloc(n,id);
                                case "mall_theatre" -> mallTheatreRunner.getloc(n, id);
                                case "hospitals" -> HospitalRunner.getloc(n, id);
                                case "hotels" -> HotelRunner.getloc(n, id);
                                case "tourism" -> tourismRunner.getloc(n, id);
                                case "transport" -> TransportRunner.getloc(n,id);
                                default -> {
                                    System.out.println("Incorrect command!!!!");
                                    flag=false;
                                }
                            }
                            exit(0);
                        }

                        else if(args[4].equals("-ID") && args[5]!=null && args.length==6)
                        {
                            flag=true;
                            int id = Integer.parseInt(args[5]);
                            switch (args[1])
                                {
                                    case "colleges" -> CollegeRunner.SearchID(n, id);
                                    case "schools" -> SchoolRunner.SearchID(n, id);
                                    case "fastfood" -> foodCourtRunner.SearchID(n, id);
                                    case "mall_theatre" -> mallTheatreRunner.SearchID(n, id);
                                    case "hospitals" -> HospitalRunner.SearchID(n, id);
                                    case "hotels" -> HotelRunner.SearchID(n, id);
                                    case "tourism" -> tourismRunner.SearchID(n, id);
                                    case "transport" -> TransportRunner.SearchID(n, id);
                                    default -> {
                                        System.out.println("Incorrect command!!!!");
                                        flag=false;
                                    }
                                }
                                exit(0);
                        }
                    }
                    else
                        {
                            flag=true;
                            switch (args[1])
                            {

                                case "colleges" -> CollegeRunner.display(n);
                                case "schools" -> SchoolRunner.display(n);
                                case "fastfood" -> foodCourtRunner.display(n);
                                case "mall_theatre" -> mallTheatreRunner.display(n);
                                case "hospitals" -> HospitalRunner.display(n);
                                case "hotels" -> HotelRunner.display(n);
                                case "tourism" -> tourismRunner.display(n);
                                case "transport" -> TransportRunner.display(n);
                                default -> {
                                    System.out.println("Incorrect command!!!!");
                                    flag=false;
                                }
                            }

                            exit(0);
                        }

                }

                else if (args[0].equals("-request") && args.length==1)
                {
                    flag=true;
                    Requester r=new Requester();
                    r.request(user);
                    exit(0);
                }
                else if(args[0].equals("-update_profile") && args.length==1)
                {
                    flag=true;
                    UserRunner.updateprofile(user);
                    exit(0);
                }

                else if(!flag)
                {
                    System.out.println("\nIncorrect Command!!!!\n");
                    System.out.println("Command for help is -h ");
                    exit(0);
                }
            }
       // }
        else if(!T && !flag){
                System.out.println("Incorrect Username or Password");
                exit(0);
            }
        else if (T && !flag) {
                System.out.println("Incorrect command");
                exit(0);
            }


    }

    public static void main(String[] args) throws SQLException, IOException , URISyntaxException {

        System.out.println("\nWelcome to CityDex:\n");
        if(args.length!=0)
        {
            CommandLine(args);
        }

        startswitch s= new startswitch();
        s.main();
    }

}

