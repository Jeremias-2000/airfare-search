package com.github.search.service;

import com.github.search.document.Airfare;
import com.github.search.repository.AirfareRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class AirfareServiceImpl implements AirfareService<Airfare>{

    @Autowired
    private AirfareRepository repository;

    public AirfareServiceImpl(AirfareRepository repository) {
        this.repository = repository;
    }

    @Override
    public Collection<Airfare> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Airfare> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Airfare saveAirfare(Airfare airfare) {
        return repository.save(airfare);
    }

    @Override
    public Airfare update(String id, Airfare airfare) {
        return null;
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
