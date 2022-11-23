package requestr;

import person.user.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Requester {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String username;
    private String field;
    private String status;
    private String fieldname;
    private String fieldAddress;
    private String fieldCity;
    private String fieldContact;
    private int fieldRating;
    private int filedCost;
    private String fieldLocation;
    private int fieldFee;
    private String fieldPrincipal;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress;
    }

    public String getFieldCity() {
        return fieldCity;
    }

    public void setFieldCity(String fieldCity) {
        this.fieldCity = fieldCity;
    }

    public String getFieldContact() {
        return fieldContact;
    }

    public void setFieldContact(String fieldContact) {
        this.fieldContact = fieldContact;
    }

    public int getFieldRating() {
        return fieldRating;
    }

    public void setFieldRating(int fieldRating) {
        this.fieldRating = fieldRating;
    }

    public int getFiledCost() {
        return filedCost;
    }

    public void setFiledCost(int filedCost) {
        this.filedCost = filedCost;
    }

    public String getFieldLocation() {
        return fieldLocation;
    }

    public void setFieldLocation(String fieldLocation) {
        this.fieldLocation = fieldLocation;
    }

    public int getFieldFee() {
        return fieldFee;
    }

    public void setFieldFee(int fieldFee) {
        this.fieldFee = fieldFee;
    }

    public String getFieldPrincipal() {
        return fieldPrincipal;
    }

    public void setFieldPrincipal(String fieldPrincipal) {
        this.fieldPrincipal = fieldPrincipal;
    }

    public void request(User u) throws SQLException, IOException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Sm.963258741m");

        Statement statement=connection.createStatement();

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Enter the city: ");

        this.setUsername(u.getUsername());
        this.setFieldCity(br.readLine());
        System.out.println("Enter the facility you wanna request to host in our app: ");
        this.setField(br.readLine());
        if(this.getField().toLowerCase().contains("hotel")){
            System.out.println("Enter the name of the hotel: ");
            this.setFieldname(br.readLine());
            System.out.println("Give the Address of your hotel: ");
            this.setFieldAddress(br.readLine());
            System.out.println("Give the location of your hotel(google mao link)");
            this.setFieldLocation(br.readLine());
            System.out.println("Enter the Rating of your hotel: ");
            this.setFieldRating(Integer.parseInt(br.readLine()));
            System.out.println("Enter the cost of room per night in :");
            this.setFiledCost(Integer.parseInt(br.readLine()));
            System.out.println("Enter the link to the website of your hotel: ");
            this.setFieldContact(br.readLine());
            this.setStatus("Not Approved");
            String queryx="Insert into requests(field,status,city,name,Address,Contact,Rating,Cost,Location,username) values("+"\'"+this.getField()+"\',"+"\'"+this.getStatus()+"\',"+"\'"+this.getFieldCity()+"\',"+"\'"+this.getFieldname()+"\',"+"\'"+this.getFieldAddress()+"\',"+"\'"+this.getFieldContact()+"\',"+this.getFieldRating()+","+this.getFiledCost()+","+"\'"+this.getFieldLocation()+"\'"+",'"+this.getUsername()+"'"+");";
            System.out.println(queryx);
           statement.executeUpdate(queryx);
           
           
        }
        else if (this.getField().toLowerCase().contains("school")){
            System.out.println("Enter the name of the school: ");
            this.setFieldname(br.readLine());
            System.out.println("Give the Address of your school: ");
            this.setFieldAddress(br.readLine());
            System.out.println("Give the location of your school(google mao link)");
            this.setFieldLocation(br.readLine());
            System.out.println("Enter the Rating of your hotel: ");
            this.setFieldRating(Integer.parseInt(br.readLine()));
            System.out.println("Enter the fee :");
            this.setFieldFee(Integer.parseInt(br.readLine()));
            System.out.println("Enter the link to the website of your school: ");
            this.setFieldContact(br.readLine());
            System.out.println("Enter the name of Principal");
            this.setFieldPrincipal(br.readLine());
            this.setStatus("Not Approved");
            String queryx = "Insert into requests(field,status,city,name,address,contact,rating,Fee,location,username,Principal) values(" + "\'" + this.getField() + "\'," + "\'" + this.getStatus() + "\'," + "\'" + this.getFieldCity() + "\'," + "\'" + this.getFieldname() + "\'," + "\'" + this.getFieldAddress() + "\'," + "\'" + this.getFieldContact() + "\'," + this.getFieldRating() + "," + this.getFieldFee() + "," + "\'" + this.getFieldLocation() + "\'" + ",'" + this.getUsername() + "'"+","+"'"+this.getFieldPrincipal() +"'"+ ");";
            statement.executeUpdate(queryx);
        }
        else if (this.getField().toLowerCase().contains("college")) {
            System.out.println("Enter the name of the college: ");
            this.setFieldname(br.readLine());
            System.out.println("Give the Address of your college: ");
            this.setFieldAddress(br.readLine());
            System.out.println("Give the location of your college(google map link)");
            this.setFieldLocation(br.readLine());
            System.out.println("Enter the Rating of your college: ");
            this.setFieldRating(Integer.parseInt(br.readLine()));
            System.out.println("Enter the semester fee :");
            this.setFieldFee(Integer.parseInt(br.readLine()));
            System.out.println("Enter the link to the website of your college: ");
            this.setFieldContact(br.readLine());
            System.out.println("Enter the name of Director");
            this.setFieldPrincipal(br.readLine());
            this.setStatus("Not Approved");
            String queryx = "Insert into requests(field,status,city,name,address,contact,rating,Fee,location,username,Principal) values(" + "\'" + this.getField() + "\'," + "\'" + this.getStatus() + "\'," + "\'" + this.getFieldCity() + "\'," + "\'" + this.getFieldname() + "\'," + "\'" + this.getFieldAddress() + "\'," + "\'" + this.getFieldContact() + "\'," + this.getFieldRating() + "," + this.getFieldFee() + "," + "\'" + this.getFieldLocation() + "\'" + ",'" + this.getUsername() + "'"+","+"'"+this.getFieldPrincipal() +"'"+ ");";
            statement.executeUpdate(queryx);
        }
        else if (this.getField().toLowerCase().contains("hospital")) {
            System.out.println("Enter the name of the Hospital: ");
            this.setFieldname(br.readLine());
            System.out.println("Give the Address of your Hospital: ");
            this.setFieldAddress(br.readLine());
            System.out.println("Give the location of your Hospital(google map link)");
            this.setFieldLocation(br.readLine());
            System.out.println("Enter the Rating of your Hospital: ");
            this.setFieldRating(Integer.parseInt(br.readLine()));
            System.out.println("Enter the link to the website of your Hospital: ");
            this.setFieldContact(br.readLine());
            System.out.println("Enter the Specialty of Hospital : ");
            this.setFieldPrincipal(br.readLine());
            this.setStatus("Not Approved");
            String queryx = "Insert into requests(field,status,city,name,address,contact,rating,location,username,Principal) values(" + "\'" + this.getField() + "\'," + "\'" + this.getStatus() + "\'," + "\'" + this.getFieldCity() + "\'," + "\'" + this.getFieldname() + "\'," + "\'" + this.getFieldAddress() + "\'," + "\'" + this.getFieldContact() + "\'," + this.getFieldRating() + "," + "\'" + this.getFieldLocation() + "\'" + ",'" + this.getUsername() + "'"+","+"'"+this.getFieldPrincipal() +"'"+ ");";
            statement.executeUpdate(queryx);
        }
        else if (this.getField().equalsIgnoreCase("food court")) {
            System.out.println("Enter the name of the Food Court: ");
            this.setFieldname(br.readLine());
            System.out.println("Give the Address of your food Court: ");
            this.setFieldAddress(br.readLine());
            System.out.println("Give the location of your Food Court(google map link)");
            this.setFieldLocation(br.readLine());
            System.out.println("Enter the Rating of your Food Court: ");
            this.setFieldRating(Integer.parseInt(br.readLine()));
            this.setStatus("Not Approved");
            String queryx = "Insert into requests(field,status,city,name,address,rating,location,username) values(" + "\'" + this.getField() + "\'," + "\'" + this.getStatus() + "\'," + "\'" + this.getFieldCity() + "\'," + "\'" + this.getFieldname() + "\'," + "\'" + this.getFieldAddress() + "\'," + this.getFieldRating() + "," + "\'" + this.getFieldLocation() + "\'" + ",'" + this.getUsername() + "'" +");";
            System.out.println(queryx);
            statement.executeUpdate(queryx);
        }
        else if (this.getField().toLowerCase().contains("mallandtheatre")) {
            System.out.println("Enter the name of the Mall or Theatre: ");
            this.setFieldname(br.readLine());
            System.out.println("Give the Address of your Mall/Theatre: ");
            this.setFieldAddress(br.readLine());
            System.out.println("Give the location of your Mall/Theatre(google map link)");
            this.setFieldLocation(br.readLine());
            System.out.println("Enter the Rating of your Mall/Theatre: ");
            this.setFieldRating(Integer.parseInt(br.readLine()));
            System.out.println("Enter the Type whether it is Mall or Cinema Hall: ");
            this.setFieldPrincipal(br.readLine());
            this.setStatus("Not Approved");
            String queryx = "Insert into requests(field,status,city,name,address,rating,location,username,Principal) values(" + "\'" + this.getField() + "\'," + "\'" + this.getStatus() + "\'," + "\'" + this.getFieldCity() + "\'," + "\'" + this.getFieldname() + "\'," + "\'" + this.getFieldAddress() + "\',"  + this.getFieldRating() + "," + "\'" + this.getFieldLocation() + "\'" + ",'" + this.getUsername() + "'"+","+"'"+this.getFieldPrincipal() +"'"+ ");";
            statement.executeUpdate(queryx);
        }
    }

    @Override
    public String toString() {
        return "Request[" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", field='" + field + '\'' +
                ", status='" + status + '\'' +
                ", fieldname='" + fieldname + '\'' +
                ", fieldAddress='" + fieldAddress + '\'' +
                ", fieldCity='" + fieldCity + '\'' +
                ", fieldContact='" + fieldContact + '\'' +
                ", fieldRating=" + fieldRating +
                ", filedCost=" + filedCost +
                ", fieldLocation='" + fieldLocation + '\'' +
                ", fieldFee='" + fieldFee + '\'' +
                ", fieldPrincipal='" + fieldPrincipal + '\'' +
                ']';
    }
}
