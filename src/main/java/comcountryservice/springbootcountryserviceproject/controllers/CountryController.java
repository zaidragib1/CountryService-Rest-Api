package comcountryservice.springbootcountryserviceproject.controllers;

import comcountryservice.springbootcountryserviceproject.beans.Country;
import comcountryservice.springbootcountryserviceproject.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
    // autowired is used to connect the countryservice class here,
    // it is a way in sping boot to avoid making the object again and again
    //as in other frameworks we usually ,ake object first then call them by
    //by adding (.) in it,
    //AS CountryService countryService = new Countryservice(),
    //and now to use country service we we do, we put countryService.function name

    @Autowired
    CountryService countryService;

    @GetMapping("/getcountries")
    public List getAllCountries()
    {
        return countryService.getAllCountries();
    }

    @GetMapping("/getcountries/{id}")
    public Country getCountrybyId(@PathVariable(value="id") int id)
    {
        return countryService.getCountrybyId(id);
    }

    @GetMapping("/getcountries/countryname")
    public Country getCountrybyName(@RequestParam(value="name") String countryName)
    {
        return countryService.getCountrybyName(countryName);
    }
    @PostMapping("/addcountry")
    public Country addNewCountry(@RequestBody Country country)
    {
        return countryService.addNewCountry(country);
    }

    @PutMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country)
    {
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value="id") int id)
    {
        return countryService.deleteCountry(id);
    }


}
