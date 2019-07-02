package docker.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId countryLanguageId;

    @NotNull
    @Column(name = "percentage", nullable = false)
    private Double percentage;

    public CountryLanguageId getCountryLanguageId() {
        return countryLanguageId;
    }

    public void setCountryLanguageId(CountryLanguageId countryLanguageId) {
        this.countryLanguageId = countryLanguageId;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}
