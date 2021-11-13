package com.github.AGEM20.CitiesApi.repository;

import com.github.AGEM20.CitiesApi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}