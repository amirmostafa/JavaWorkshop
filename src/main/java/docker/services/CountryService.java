package docker.services;

import docker.entities.Country;
import docker.entities.CountryLanguage;
import docker.models.CountryModel;
import docker.repositories.CountryDao;
import docker.repositories.CountryLanguageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryDao countryDao;

    @Autowired
    CountryLanguageDao countryLanguageDao;

    public CountryModel getCountryByCode(String code) {
        CountryModel countryModel = new CountryModel();
        try {
            Country country = countryDao.findByCode(code);
            if (country == null) {
                countryModel.setReplyMessage("INVALID_COUNTRY_CODE");
                countryModel.setReplyCode(500);
                return countryModel;
            }
            countryModel = constructCountryModel(country);
        } catch (Exception e) {
            countryModel.setReplyMessage("INTERNAL_ERROR");
            countryModel.setReplyCode(500);
        }
        return countryModel;
    }

    private CountryModel constructCountryModel(Country country) {
        CountryModel countryModel = new CountryModel();
        countryModel.setName(country.getName());
        countryModel.setContinent(country.getContinent());
        countryModel.setPopulation(country.getPopulation());
        countryModel.setLifeExpectancy(country.getLifeExpectancy());
        countryModel.setCountryLanguage(getCountryLanguage(country));
        return countryModel;
    }

    private String getCountryLanguage(Country country) {
        List<CountryLanguage> countryLanguages = countryLanguageDao.findByCountryLanguageId_CountryCode(country.getCode());
        CountryLanguage countryLanguage = countryLanguages.stream()
                .max(Comparator.comparing(CountryLanguage::getPercentage))
                .orElse(null);
        return countryLanguage == null ? null : countryLanguage.getCountryLanguageId().getLanguage();
    }
}
