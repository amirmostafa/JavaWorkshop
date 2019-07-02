package docker.controllers;

import docker.models.CountryModel;
import docker.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @RequestMapping(value = "/{countryCode}", method = RequestMethod.GET)
    public ResponseEntity<CountryModel> home(@PathVariable("countryCode") String countryCode) {
        CountryModel result = countryService.getCountryByCode(countryCode);
        return ResponseEntity.status(result.getReplyCode()).body(result);
    }
}
