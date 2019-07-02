package docker.repositories;

import docker.entities.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryDao extends PagingAndSortingRepository<Country, String> {
    Country findByCode(String code);
}
