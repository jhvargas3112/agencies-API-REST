package com.example.bank.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class EmployeeAgencyHistoryRecordId implements Serializable {
  @Column(name = "employee")
  private Integer employee;
  @Column(name = "agency")
  private AgencyId agency;
  @Column(name = "timeStamp")
  private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

  public EmployeeAgencyHistoryRecordId() {
  }

  public EmployeeAgencyHistoryRecordId(Integer employee, AgencyId agency, Timestamp timestamp) {
    this.employee = employee;
    this.agency = agency;
    this.timestamp = timestamp;
  }

  public Integer getEmployee() {
    return employee;
  }

  public void setEmployee(Integer employee) {
    this.employee = employee;
  }

  public AgencyId getAgency() {
    return agency;
  }

  public void setAgency(AgencyId agency) {
    this.agency = agency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AgencyId)) return false;
    EmployeeAgencyHistoryRecordId that = (EmployeeAgencyHistoryRecordId) o;
    return Objects.equals(getEmployee(), that.getEmployee()) &&
        Objects.equals(getAgency(), that.getAgency());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getEmployee(), getAgency());
  }
}
