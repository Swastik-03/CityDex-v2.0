package Csv2DbInserter;

import java.io.*;
import java.sql.*;


public class HospitalInserter {
    public static void main() throws SQLException, IOException  {
        String jdbcURL = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "Sm.963258741m";

        String csvFilePath = "C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\hospitals.csv";

        try(Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            Statement stmt = conn.createStatement();
        ) {
            String sql1 = "DROP TABLE IF EXISTS hospitals";
            String sql = "CREATE TABLE IF NOT EXISTS hospitals " +
                    "( Name VARCHAR(100), " +
                    " Location VARCHAR(300), " +
                    " Address VARCHAR(300), " +
                    " Speciality VARCHAR(300), " +
                    " Website VARCHAR(300), " +
                    " Rating DOUBLE, "+
                    " City VARCHAR(100) )";
            System.out.println("Created Hospitals table in the database...");
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int batchSize = 100;

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO hospitals (Name,Location, Address, Speciality,Website,Rating,City ) VALUES (?, ?, ?, ?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

            int count = 0;

            lineReader.readLine();

            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String Name = data[0];
                String Location = data[1];
                String Address = data[2];
                String Speciality = data[3];
                String Website = data[4];
                String Rating = data[5];
                String City = data[6];



                statement.setString(1, Name);
                statement.setString(2, Location);
                statement.setString(3, Address);
                statement.setString(4, Speciality);
                statement.setString(5, Website);

                double hRating = Double.parseDouble(Rating);
                statement.setDouble(6, hRating);

                statement.setString(7, City);



                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }
            }

            lineReader.close();
            statement.executeBatch();

            connection.commit();
            connection.close();

        } catch (IOException ex) {
            System.err.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sm.963258741m");
//
//        Statement statement = conn.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from hospitals");
//        while(resultSet.next()){
//            System.out.println(resultSet.getString("Name"));
//        }

    }
}

