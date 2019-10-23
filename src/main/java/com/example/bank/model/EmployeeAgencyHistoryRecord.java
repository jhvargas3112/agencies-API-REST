package com.example.bank.model;

import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "employee_agency_history")
public class EmployeeAgencyHistoryRecord {
  @EmbeddedId
  private EmployeeAgencyHistoryRecordId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("employee")
  private Employee employee;
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("agency")
  private Agency agency;

  public EmployeeAgencyHistoryRecord() {
  }

  public EmployeeAgencyHistoryRecord(Employee employee, Agency agency) {
    this.employee = employee;
    this.agency = agency;
  }

  public EmployeeAgencyHistoryRecordId getId() {
    return id;
  }

  public void setId(EmployeeAgencyHistoryRecordId id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Agency getAgency() {
    return agency;
  }

  public void setAgency(Agency agency) {
    this.agency = agency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof EmployeeAgencyHistoryRecord)) return false;
    EmployeeAgencyHistoryRecord that = (EmployeeAgencyHistoryRecord) o;
    return Objects.equals(getEmployee(), that.getEmployee()) &&
        Objects.equals(getAgency(), that.getAgency());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmployee(), getAgency());
  }
}
