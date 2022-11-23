
package person.admin;
import facilities.hospitals.Hospital;
import facilities.hotels.Hotel;
import person.user.User;
import requestr.Requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.System.exit;

public class AdminRunner {
    static ArrayList<Admin> arr = new ArrayList<>();
    static ArrayList<Hospital> hospitals = new ArrayList<>();
    static ArrayList<Hotel> hotels = new ArrayList<>();
    static  ArrayList<User> ussr = new ArrayList<>();
   public static ArrayList<Requester> req=new ArrayList<>();
    public static ArrayList<Requester> requn = new ArrayList<>();
    public static ArrayList<Requester> req_ap = new ArrayList<>();
    static BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));


    static void displayAdmins() {
        for (Admin i : arr
        ) {

            System.out.println(i);

        }
    }

    static void requestAcceptor() throws SQLException, IOException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();


        ResultSet resultSet1 = statement.executeQuery("select * from requests");

        int ii = 1;
        int jj = req_ap.size()+1;
        int idd=1;
        req.clear();
        requn.clear();
        req_ap.clear();
        while (resultSet1.next()) {
            Requester r = new Requester();
            r.setId(idd);
            r.setUsername(resultSet1.getString("username"));
            r.setField(resultSet1.getString("Field"));
            r.setStatus(resultSet1.getString("status"));
            r.setFieldname(resultSet1.getString("name"));
            r.setFieldAddress(resultSet1.getString("address"));
            r.setFieldContact(resultSet1.getString("contact"));
            r.setFieldCity(resultSet1.getString("city"));
            r.setFieldRating(resultSet1.getByte("rating"));
            r.setFieldLocation(resultSet1.getString("location"));
            r.setFiledCost(resultSet1.getInt("cost"));
            r.setFieldFee(resultSet1.getInt("fee"));
            r.setFieldPrincipal(resultSet1.getString("principal"));
            idd++;
            req.add(r);

        }
    }

    public static void showRequests() throws IOException,SQLException {
        requestAcceptor();
        for(Requester i:req){
            {
                System.out.println(i+"\n");
            }
        }
    }

    public static void acceptRequests() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();

        boolean ko=true;

        do {
            System.out.println("Press the id of the request you want to accept or press 0 to exit this..");
            int kl = Integer.parseInt(brr.readLine());
            if (kl == 0) {
                ko = false;
                break;
            }
            String uname = "";
            String addr = "";

            for (Requester i : req) {
                if (i.getId() == kl) {

                    if (i.getStatus().equalsIgnoreCase("not approved")) {
                        i.setStatus("Approved");

                        req_ap.add(i);
                        uname = i.getUsername();
                        addr = i.getFieldAddress();
                        System.out.println(i.getField());
                        if (i.getField().equalsIgnoreCase("hotel")) {
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String contact = i.getFieldContact();
                            int  cost = i.getFiledCost();
                            String location = i.getFieldLocation();
                            String queryx = "insert into hotels(city,hotel_name,rating,address,contact_info,cost_to_stay,location) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating + ",'" + address + "'" + ",'" + contact + "'" + "," + cost + ",'" + location + "'"+");";
                            System.out.println(queryx);
                            statement.executeUpdate(queryx);

                        }
                        else if(i.getField().equalsIgnoreCase("school")){
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String contact = i.getFieldContact();
                            int  cost = i.getFieldFee();
                            String location = i.getFieldLocation();
                            String princ=i.getFieldPrincipal();
                            String queryx = "insert into schools(city,name,Rating,website,Monthly_fee,Address,Name_of_Principle,location) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating  + ",'" + contact + "'" + "," + cost + ",'" + address + "'"+",'"+ princ+"'" +","+"'"+location+"'"+");";
                            System.out.println(queryx);
                            statement.executeUpdate(queryx);
                        }
                        else if(i.getField().equalsIgnoreCase("college")){
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String contact = i.getFieldContact();
                            int  cost = i.getFieldFee();
                            String location = i.getFieldLocation();
                            String direc=i.getFieldPrincipal();
                            String queryx = "insert into colleges(city,name,Rating,website,Semester_fee,location,Name_of_Director,address) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating  + ",'" + contact + "'" + "," + i.getFieldFee() + ",'" + location + "'"+ ",'"+ direc+"'" +","+ "'" +address+ "'" + ");";

                            System.out.println(queryx);

                            statement.executeUpdate(queryx);
                        }
                        else if(i.getField().equalsIgnoreCase("hospital")){
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String contact = i.getFieldContact();
                            String location = i.getFieldLocation();
                            String spec=i.getFieldPrincipal();
                            String queryx = "insert into hospitals(city,name,Rating,Contact,location,Specialty,address) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating  + ",'" + contact + "'" + ",'" + location + "'"+ ",'"+ spec+"'" +","+ "'" +address+ "'" + ");";

                            System.out.println(queryx);

                            statement.executeUpdate(queryx);
                        }
                        else if(i.getField().equalsIgnoreCase("food Court")){
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String location = i.getFieldLocation();
                            String queryx = "insert into fastfood(city,name,Rating,location,address) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating  + ",'" + location + "'"+","+ "'" +address+ "'" + ");";

                            System.out.println(queryx);

                            statement.executeUpdate(queryx);
                        }
                        else if(i.getField().equalsIgnoreCase("mallandtheatre")){
                            String  city = i.getFieldCity();
                            String  name = i.getFieldname();
                            int  rating = i.getFieldRating();
                            String address = i.getFieldAddress();
                            String location = i.getFieldLocation();
                            String type=i.getFieldPrincipal();
                            String queryx = "insert into mall_theatre(city,name,Rating,location,Type,address) values(" + "'" + city + "'" + ",'" + name + "'" + "," + rating  + ",'" + location + "'"+ ",'"+ type+"'" +","+ "'" +address+ "'" + ");";

                            System.out.println(queryx);
                            statement.executeUpdate(queryx);
                        }
                        break;
                    }
                }
            }
            Iterator it = req.iterator();
//            while (it.hasNext()) {
//                Requester ss = (Requester) it.next();
//                System.out.println(ss);
//                if (ss.getId() == kl) {
//                    it.remove();
//                    break;
//                }
//            }
            String queryy = "update requests set status='Approved' where username = " + "'" + uname + "'" + "and address = " + "'" + addr + "'" + ";";
            statement.executeUpdate(queryy);
        }while (ko);
    }

    public static boolean login(String uname,String admin_password) throws IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from adminprofiles");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean ffl=true;
        boolean flag = false;

        main();
        do{ //System.out.println("Enter the Username: ");
        flag=false;
       // String uname = br.readLine();
        for (Admin i : arr) {
            if (i.getUsername().equals(uname)) {
                flag = true;
            }
        }
        if (flag) {
            //System.out.println("Enter the password : ");
            //String admin_password = br.readLine();
            boolean bbl=true;

                for (Admin i : arr) {
                    if (i.getUsername().equals(uname)) {
                        if (i.getPassword().equals(admin_password)) {
                            System.out.println("You have logged in successfully!!");
                            boolean Istrue = true;
                            ffl = false;
                            bbl=false;
                        }
                    }

                }

        } else {
            System.out.println("Enter valid Username or Password");
            exit(0);

        }
    }while (ffl);
        return flag;
    }

    public static void deleteRequests() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();

        boolean ko=true;

        do {
            System.out.println("Enter id of the request you want to delete \n  0 to exit this..");
            int dlno = Integer.parseInt(brr.readLine());
            if (dlno == 0){
                ko = false;break;
            }
            String dlname= "" ;
            String addr = "";
            for ( Requester i : req){
                if(i.getId()==dlno){
                    dlname = i.getUsername();
                    addr = i.getFieldAddress();
                    String query ="delete from requests where address ="+"'"+addr+"';" ;
                    statement.executeUpdate(query);
                    ko=false;break;
                }
            }
          requestAcceptor();
        }while(ko);



    }


   public static void requestManager() throws IOException, SQLException {
       req.clear();
       requn.clear();
       req_ap.clear();
       requestAcceptor();

       boolean ki=true;
       do{
           System.out.println("Press 1.To display requests 2.To accept_requests 3.Delete_requests  4.Exit  " );
           int kkk = Integer.parseInt(brr.readLine());

           switch (kkk) {
               case 1: {

                   showRequests();
                   break;
               }
               case 2: {
                   acceptRequests();
                   break;
               }
               case 3:{
                   deleteRequests();
                   break;
               }
               case 4:{ki=false;
               req.clear();
               }
           }
   }while (ki);

    }

    public void acceptusers() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from userprofiles");
        int usid =1;
        while (resultSet1.next()) {
            User u = new User();u.setId(usid);
            u.setCity(resultSet1.getString("City"));
            u.setContact(Long.parseLong(resultSet1.getString("Contact")));
            u.setPassword(resultSet1.getString("Password"));
            u.setUsername(resultSet1.getString("UserName"));
            u.setName(resultSet1.getString("Name"));
            u.setMail(resultSet1.getString("Email"));
            ussr.add(u);usid++;
        }

    }

    public void displayUsers() throws SQLException {
        ussr.clear();
        acceptusers();
        for(User i: ussr ){
            System.out.println(i);
        }

    }
    public void deleteUser() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from userprofiles");
        System.out.println("Enter ID of user to delete ");
        int usno= Integer.parseInt(brr.readLine());
        for (User i : ussr){
            if(i.getId()==usno){
                String usname= i.getName();
                String userquery = "delete from userprofiles where name ="+"'"+usname+"';";
                statement.executeUpdate(userquery)
                ;break;
            }
        }
    }

    public void usermanager() throws IOException, SQLException {
        ussr.clear();

        boolean usrq = true ;
        do{
            System.out.println("1.To display User Profiles 2.Delete User Profiles 3.Exit ");
            int sss = Integer.parseInt(brr.readLine());

            switch (sss){
                case 1 :{
                    displayUsers();
                    break;
                }
                case 2 :{
                    deleteUser();
                    break;
                }
                case 3 :{
                    usrq = false;break;
                }
            }
        }while(usrq);
    }

    public static void accepthotels() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from hotels");
        int hotid =1;
        while(resultSet1.next()){
            Hotel h = new Hotel();h.setId(hotid);
            h.setAddress(resultSet1.getString("ADDRESS"));
            h.setLocation(resultSet1.getString("Location"));
            h.setCity(resultSet1.getString("CITY"));
            h.setRating(resultSet1.getInt("RATING"));
            h.setCost_per_day(resultSet1.getInt("Cost_To_Stay"));
            h.setContact(resultSet1.getString("CONTACT_INFO"));
            h.setName(resultSet1.getString("HOTEL_NAME"));
            hotels.add(h);hotid++;
        }
    }

    public static void displayhotels() throws SQLException {
        hotels.clear();
        accepthotels();
        for (Hotel i: hotels){
            System.out.println(i);
        }
    }

    public static void deletehotels() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from hotels");
        System.out.println("Enter ID of Hotel to delete ");
        int hono = Integer.parseInt(brr.readLine());
        for(Hotel i: hotels){
            if(i.getId()==hono){
                String hoadd = i.getAddress();String hoquery = "delete from hotels where ADDRESS ="+"'"+hoadd+"';";
             //   System.out.println(hoquery);
                statement.executeUpdate(hoquery);break;
            }
        }
    }

    public static boolean hotelmanager() throws IOException, SQLException {
        hotels.clear();
        boolean hotl =true;
        do{
            System.out.println("1.To display Hotel data 2.Delete Hotel 3.Exit ");
            int hhh = Integer.parseInt(brr.readLine());
            switch (hhh){
                case 3 ->{
                    hotl =false;break;
                }
                case 1 ->{
                    displayhotels();break;
                }
                case 2 -> {
                    deletehotels();
                    break;
                }
            }
        }while (hotl);
        return hotl;
    }

    public static void displayhospitals() throws SQLException {
        hospitals.clear();
        accepthospitals();
        for (Hospital i: hospitals){
            System.out.println(i);
        }
    }
    public static void accepthospitals() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from hospitals");
        int hosid =1;
        while(resultSet1.next()){
            Hospital hos = new Hospital();hos.setId(hosid);
            hos.setAddress(resultSet1.getString("Address"));
            hos.setLocation(resultSet1.getString("Location"));
            hos.setCity(resultSet1.getString("CITY"));
            hos.setRating(resultSet1.getInt("RATING"));
            hos.getSpeciality(resultSet1.getString("Specialty"));
            hos.setContact(resultSet1.getString("CONTACT"));
            hos.setName(resultSet1.getString("NAME"));
            hospitals.add(hos);hosid++;
        }

    }

    public static void deletehospitals() throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
        Statement statement = connection.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select * from hospitals");
        System.out.println("Enter ID of Hospital to delete ");
        int hosno = Integer.parseInt(brr.readLine());
        for(Hospital i: hospitals){
            if(i.getId()==hosno){
                String hosadd = i.getAddress();String hosquery = "delete from hospitals where ADDRESS ="+"'"+hosadd+"';";
               // System.out.println(hosquery);
                statement.executeUpdate(hosquery);break;
            }
        }
    }

    public static boolean hospitalmanager() throws IOException, SQLException {
        hospitals.clear();
        boolean hosbrk = true;
        do{
            System.out.println("1.To display Hospital data 2.Delete Hospital 3.Exit");
            int hoho = Integer.parseInt(brr.readLine());
            switch (hoho)
            {
                case 3->{hosbrk=false;break;}
                case 2->{deletehospitals();break;}
                case 1->{displayhospitals();break;}
            }
        }
        while(hosbrk);
        return hosbrk;

    }

    public static void main() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Sm.963258741m");

        Statement statement=connection.createStatement();


        arr.clear();
//        String query1 = "UPDATE people SET name = 'Lord' WHERE name='Alfred Schmidt';";
//        statement.executeUpdate(query1);

        ResultSet resultSet= statement.executeQuery("select * from adminprofiles");
        int i=1;

        while (resultSet.next()) {
            Admin u =new Admin();

            String k = resultSet.getString("Name");
            u.setId(i);
            u.setName(resultSet.getString("Name"));
            u.setPassword(resultSet.getString("Password"));
            u.setUsername(resultSet.getString("Username"));
            u.setMail(resultSet.getString("Email"));
            i++;
            arr.add(u);


        }


    }

}
