package com.example.bank.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "City")
public class City {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "population")
  private Integer population;

  @OneToMany(
      mappedBy = "city", // Este city no sé si es City (nombre de la tabla en BD o de la Clase City) o city (nombre del atributo de la clase Agency).
      cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, // Por defecto es fetch = FetchType.LAZY.
      fetch = FetchType.LAZY,
      orphanRemoval = true
      )
  private List<Agency> agencies = new ArrayList<>();

  // @JsonManagedReference
  @OneToMany(
      mappedBy = "city", // Este city no sé si es City (nombre de la tabla en BD o de la Clase City) o city (nombre del atributo de la clase Agency).
      cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, // Por defecto es fetch = FetchType.LAZY.
      fetch = FetchType.LAZY,
      orphanRemoval = true
      )
  private List<Employee> employees = new ArrayList<>();

  public City(String name, Integer population, List<Agency> agencies, List<Employee> employees) {
    this.name = name;
    this.population = population;
    this.agencies = agencies;
    this.employees = employees;
  }

  public City() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPopulation() {
    return population;
  }

  public void setPopulation(Integer population) {
    this.population = population;
  }

  public List<Agency> getAgencies() {
    return agencies;
  }

  public void setAgencies(List<Agency> agencies) {
    this.agencies = agencies;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
    employee.setCity(this);
  }

  public void removeComment(Employee employee) {
    employees.remove(employee);
    employee.setCity(null);
  }
}
