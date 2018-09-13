package com.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.model.Shipwreck;

public interface ShipwreckRepository extends MongoRepository<Shipwreck, String> {

	public Shipwreck findBy_id(Long _id);
    public Long deleteBy_id(Long _id);
}
