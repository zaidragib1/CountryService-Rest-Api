package comcountryservice.springbootcountryserviceproject.services;

import comcountryservice.springbootcountryserviceproject.beans.Country;
import comcountryservice.springbootcountryserviceproject.controllers.AddResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CountryService {

    static HashMap<Integer,Country>countryIdMap;

    public CountryService()
    {
        countryIdMap = new HashMap<Integer, Country>();

        Country indiaCountry = new Country(1,"India","Delhi");
        Country USACountry = new Country(2,"USA","Washington");
        Country UKCountry = new Country(3,"UK","London");

        countryIdMap.put(1,indiaCountry);
        countryIdMap.put(2,USACountry);
        countryIdMap.put(3,UKCountry);

    }


    public List getAllCountries()
    {
        List countries = new ArrayList(countryIdMap.values());

        return countries;

    }

    public Country getCountrybyId(int id){

        Country country = countryIdMap.get(id);
        return country;
    }

    public Country getCountrybyName(String countryName)
    {
        Country country = null;

        for(int x: countryIdMap.keySet())
        {
            if(countryIdMap.get(x).getCountryName().equals(countryName))
            {
                country = countryIdMap.get(x);
            }
        }
        return country;
    }

    public Country addNewCountry(Country country)
    {
       country.setId(getMaxId());
       countryIdMap.put(country.getId(),country);
       return country;

    }

    //for getting max from a hashmap so that in addNewCountry , id will be automatically kept as te maxi +1
    public static int getMaxId()
    {
        int maxi = Integer.MIN_VALUE;
        for(int id:countryIdMap.keySet()){
            if(id > maxi){
                maxi = id;
            }
        }
        return maxi +1;
    }

    public Country updateCountry(Country country)
    {
        if(country.getId() > 0){
            countryIdMap.put(country.getId(), country);

        }
        return country;
    }

    public AddResponse deleteCountry(int id)
    {
        countryIdMap.remove(id);
        AddResponse res = new AddResponse();
        res.setMsg("Country Deleted..");
        res.setId((id));
        return res;

    }


}
