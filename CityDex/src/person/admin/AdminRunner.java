
package person.admin;
import java.sql.*;
import java.util.ArrayList;

public class AdminRunner {

    static ArrayList<Admin> arr= new ArrayList<>();
    static void displayAdmins(){
        for (Admin i: arr
        ) {

            System.out.println(i);

        }
    }
    public static void main() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","Sm.963258741m");

        Statement statement=connection.createStatement();


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
