package com.github.search.repository;

import com.github.search.document.Airfare;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirfareRepository extends MongoRepository<Airfare,String> {
}
