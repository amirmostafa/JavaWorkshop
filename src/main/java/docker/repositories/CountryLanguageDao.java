package docker.repositories;

import docker.entities.CountryLanguage;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CountryLanguageDao extends PagingAndSortingRepository<CountryLanguage, String> {
    List<CountryLanguage> findByCountryLanguageId_CountryCode(String countryCode);
}
