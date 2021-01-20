package com.github.search.service;

import java.util.Collection;
import java.util.Optional;

public interface AirfareService<A> {
    Collection<A> findAll();
    Optional<A> findById(String id);
    Optional<A> saveAirfare(A a);
    A update(String id,A a);
    void delete(String id);
}
