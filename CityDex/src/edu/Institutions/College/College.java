package edu.Institutions.College;
import edu.EducationalInstitutions;


public class College extends EducationalInstitutions {

    private String director;

    public College(int id,String name, String city, String website, int fee, String address,double rating,String director,String location) {
        super(id,name, city, website, fee, address,rating,location);
        this.director=director;
    }

    public College() {
        super();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return
                super.toString()+ "director='" + director;

    }
}
