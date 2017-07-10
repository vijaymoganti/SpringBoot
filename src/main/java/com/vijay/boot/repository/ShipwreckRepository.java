package com.vijay.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.boot.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
