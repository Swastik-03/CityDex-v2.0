package CsvUpdater;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class SchoolUpdater {
    public static void load_into_schools_csv(String Name, String Address, String Monthly_Fee, String Name_of_Principle, String Website, int Rating, String Location,String City)
    {
        try {
            String csvFilePath = "C:\\Users\\Lenovo\\Downloads\\CityDex-main\\schools.csv";
            FileWriter fileWriter = new FileWriter(csvFilePath,true);
            fileWriter.write("\n%s,%s,%s,%s,%s,%s,%s,%s,%s,%s".formatted(Name, Address, Monthly_Fee,Name_of_Principle,Website,Rating,Location,City  ));
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void load_from_schools_csv(String nm, String add,String prncpl, String web) throws IOException
    {
        try {
            String csvFilePath = "C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\schools.csv";
            FileWriter Writer= new FileWriter("C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\tempschools.csv");
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String Name = data[0];
                String Address = data[1];
                String Monthly_Fee = data[2];
                String Name_of_Principle = data[3];
                String Website = data[4];
                String Rating = data[5];
                String Location = data[6];
                String City = data[7];
                if (Name.compareTo(nm) == 0) {
                    Address=add;
                    Name_of_Principle=prncpl;
                    Website=web;
                }
                Writer.write(Name+","+Address+","+Monthly_Fee+","+Name_of_Principle+","+Website+","+Rating+","+Location+","+City+"\n");

            }
            lineReader.close();
            Writer.close();
            FileWriter writer1=new FileWriter(csvFilePath);
            lineReader=new BufferedReader(new FileReader("C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\tempschools.csv"));
            while ((lineText = lineReader.readLine()) != null)
            {
                String[] data = lineText.split(",");
                String Name = data[0];
                String Address = data[1];
                String Monthly_Fee = data[2];
                String Name_of_Principle = data[3];
                String Website = data[4];
                String Rating = data[5];
                String Location = data[6];
                String City = data[7];

                writer1.write(Name+","+Address+","+Monthly_Fee+","+Name_of_Principle+","+Website+","+Rating+","+Location+","+City+"\n");
            }
            writer1.close();
            lineReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}