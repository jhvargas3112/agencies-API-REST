package com.example.bank.model;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Syndicate")
public class Syndicate {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "fee")
  private Double fee;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
  @JoinTable(
      name = "employee_syndicate",
      joinColumns = @JoinColumn(name = "syndicate", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "employee", referencedColumnName = "employeeCode")
      )
  private Set<Employee> employees;

  public Syndicate() {
  }

  public Syndicate(String name, Double fee, Set<Employee> employees) {
    this.name = name;
    this.fee = fee;
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

  public Double getFee() {
    return fee;
  }

  public void setFee(Double fee) {
    this.fee = fee;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
    employee.getSyndicates().add(this);
  }

  public void removeEmployee(Employee employee) {
    employees.remove(employee);
    employee.getSyndicates().remove(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Syndicate)) return false;
    Syndicate that = (Syndicate) o;
    return Objects.equals(getId(), that.getId()) &&
        Objects.equals(getName(), that.getName()) &&
        Objects.equals(getFee(), that.getFee());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getFee());
  }
}
