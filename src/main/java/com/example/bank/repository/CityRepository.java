package com.example.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bank.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{

}
