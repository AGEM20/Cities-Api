package com.github.AGEM20.CitiesApi.countries;
import java.util.List;
import java.util.Optional;

import com.github.AGEM20.CitiesApi.countries.Country;
import com.github.AGEM20.CitiesApi.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryResource {

    private final CountryRepository repository;

    public CountryResource(final CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/countries")
    public Page<Country> cities(Pageable page) {

        return repository.findAll(page);



    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);

        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());

    }else{
            return ResponseEntity.notFound().build();
        }

    }

}