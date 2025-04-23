package builderTests;

import bednarek.patterns.builder.Company;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static bednarek.patterns.builder.Company.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BuilderTests {
    @Test
    void builderTest() {
        Company company = Company.builder()
                .name("TechNova")
                .industry("Software")
                .country("Ukraine")
                .city("Lviv")
                .foundedYear(2015)
                .numberOfEmployees(150)
                .revenueInMillions(12.5)
                .isPublic(false)
                .ceo("Nadia Bednarek")
                .registrationDate(LocalDate.of(2015, 6, 1))
                .techStack(Arrays.asList("Java", "Spring", "React", "Docker"))
                .build();

        assertNotNull(company);
        assertEquals("TechNova", company.getName());
    }

    @Test
    void builderUpdateTest() {
        Company initialCompany = Company.builder()
                .name("TechNova")
                .industry("Software")
                .country("Poland")
                .city("Wroclaw")
                .foundedYear(2015)
                .numberOfEmployees(150)
                .revenueInMillions(12.5)
                .isPublic(false)
                .ceo("Nadia Bednarek")
                .registrationDate(LocalDate.of(2015, 6, 1))
                .techStack(Arrays.asList("Java", "Spring", "React", "Docker"))
                .build();
        Company newCompany = initialCompany.toBuilder()
                .name("NovaSoft")
                .country("Germany")
                .city("Berlin")
                .build();

        assertNotNull(newCompany);
        assertEquals("NovaSoft", newCompany.getName());
        assertEquals("Software", newCompany.getIndustry());
        assertEquals("Germany", newCompany.getCountry());
    }
}