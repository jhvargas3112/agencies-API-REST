package com.example.bank.repository;

import com.example.bank.model.Agency;
import com.example.bank.model.AgencyId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, AgencyId>{

}
