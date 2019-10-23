package com.example.bank.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "laboral_category")
public class LaboralCategory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "baseSalary")
  private Double baseSalary;
  @Column(name = "extraHourPrice")
  private Double extraHourPrice;

  @JsonManagedReference
  @OneToMany(
      mappedBy = "laboralCategory", // Este city no sé si es City (nombre de la tabla en BD o de la Clase City) o city (nombre del atributo de la clase Agency).
      cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, // Por defecto es fetch = FetchType.EAGER.
      orphanRemoval = true
      )
  private List<Employee> employees = new ArrayList<>();

  public LaboralCategory() {
  }

  public LaboralCategory(String name, Double baseSalary, Double extraHourPrice,
      List<Employee> employees) {
    this.name = name;
    this.baseSalary = baseSalary;
    this.extraHourPrice = extraHourPrice;
    this.employees = employees;
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

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public Double getExtraHourPrice() {
    return extraHourPrice;
  }

  public void setExtraHourPrice(Double extraHourPrice) {
    this.extraHourPrice = extraHourPrice;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }
}
