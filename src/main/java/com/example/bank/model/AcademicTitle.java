package com.example.bank.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.Set;
import java.util.Objects;


@Entity
@Table(name = "academic_title")
public class AcademicTitle {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "code")
  private Integer code;
  @Column(name = "name")
  private String name;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
  @JoinTable(
      name = "employee_academic_title",
      joinColumns = @JoinColumn(name = "academicTitle", referencedColumnName = "code"),
      inverseJoinColumns = @JoinColumn(name = "employee", referencedColumnName = "employeeCode")
      )
  private Set<Employee> employees;

  public AcademicTitle() {
  }

  public AcademicTitle(String name, Set<Employee> employees) {
    this.name = name;
    this.employees = employees;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(Set<Employee> employees) {
    this.employees = employees;
  }

  public void addEmployee(Employee employee) {
    employees.add(employee);
    employee.getAcademicTitles().add(this);
  }

  public void removeEmployee(Employee employee) {
    employees.remove(employee);
    employee.getAcademicTitles().remove(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AcademicTitle)) return false;
    AcademicTitle that = (AcademicTitle) o;
    return Objects.equals(getCode(), that.getCode()) &&
        Objects.equals(getName(), that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCode(), getName());
  }
}
