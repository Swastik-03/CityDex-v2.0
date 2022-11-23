package CsvUpdater;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class HospitalUpdater {
    public static void load_into_hospitals_csv(String Name, String Location, String Address, String Speciality, String Website, int Rating, String City)
    {
        try {
            String csvFilePath = "C:\\Users\\Lenovo\\Downloads\\CityDex-main\\hospitals.csv";
            FileWriter fileWriter = new FileWriter(csvFilePath,true);
            fileWriter.write("\n%s,%s,%s,%s,%s,%s,%s,%s,%s,%s".formatted(Name,Location, Address, Speciality,Website,Rating,City ));
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void load_from_hospitals_csv(String nm, String add,String spl, String web) throws IOException
    {
        try {
            String csvFilePath = "C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\hospitals.csv";
            FileWriter Writer= new FileWriter("C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\temphospitals.csv");
            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;
            while ((lineText = lineReader.readLine()) != null) {
                String[] data = lineText.split(",");
                String Name = data[0];
                String Location = data[1];
                String Address = data[2];
                String Speciality = data[3];
                String Website = data[4];
                String Rating = data[5];
                String City = data[6];
                if (Name.compareTo(nm) == 0) {
                    Address=add;
                    Speciality=spl;
                    Website=web;
                }
                Writer.write(Name+","+Location+","+Address+","+Speciality+","+Website+","+Rating+","+City+"\n");

            }
            lineReader.close();
            Writer.close();
            FileWriter writer1=new FileWriter(csvFilePath);
            lineReader=new BufferedReader(new FileReader("C:\\Users\\swast\\Desktop\\Sem 3\\java projects\\CityDex-main\\tables\\temphospitals.csv"));
            while ((lineText = lineReader.readLine()) != null)
            {
                String[] data = lineText.split(",");
                String Name = data[0];
                String Location = data[1];
                String Address = data[2];
                String Speciality = data[3];
                String Website = data[4];
                String Rating = data[5];
                String City = data[6];

                writer1.write(Name+","+Location+","+Address+","+Speciality+","+Website+","+Rating+","+City+"\n");
            }
            writer1.close();
            lineReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}