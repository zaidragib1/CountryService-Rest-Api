//THIS IS BEAN/POJO CLASS
package comcountryservice.springbootcountryserviceproject.beans;

public class Country {
    int id;
    String countryName;
    String countryCapital;

    public Country(int id,String countryName, String countryCapital){
        this.id = id;
        this.countryName = countryName;
        this.countryCapital = countryCapital;
    }
    //above one constructor is written to diretly invoke the data.
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCountryCapital() {
        return countryCapital;
    }
    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
