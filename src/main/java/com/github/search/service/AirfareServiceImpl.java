package com.github.search.service;

import com.github.search.document.Airfare;
import com.github.search.repository.AirfareRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static org.springframework.data.crossstore.ChangeSetPersister.*;


@Service
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

    @SneakyThrows
    @Override
    public Optional<Airfare> findById(String id) {
        Optional<Airfare> search = repository.findById(id);
        if (search.isPresent()){
            return search;
        }else {
            throw new NotFoundException();
        }
    }

    @Override
    public Optional<Airfare> saveAirfare(Airfare airfare) {
        if (airfare.equals(null)){
            throw new NullPointerException();
        }
        repository.save(airfare);
        return Optional.of(airfare);

    }

    @Override
    public Airfare update(String id, Airfare airfare) {
        return null;
    }

    @SneakyThrows
    @Override
    public void delete(String id) {
        Optional<Airfare> search = findById(id);
        repository.delete(search.orElseThrow(()
                -> new NotFoundException()));
    }
}
