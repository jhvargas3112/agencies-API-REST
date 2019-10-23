package com.example.bank.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Entity
@Table(name = "Agency")
public class Agency {
  @EmbeddedId
  private AgencyId id;
  @Column(name = "address")
  private String address;
  @Column(name = "telephone")
  private String telephone;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id")
  private City city;

  @OneToMany(
      mappedBy = "agency",
      cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, // Por defecto es fetch = FetchType.EAGER.
      orphanRemoval = true
      )
  private List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords = new ArrayList<>();

  public Agency() {
  }

  public Agency(String address, String telephone, City city,
      List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords) {
    this.address = address;
    this.telephone = telephone;
    this.city = city;
    this.employeeAgencyHistoryRecords = employeeAgencyHistoryRecords;
  }

  public AgencyId getId() {
    return id;
  }

  public void setId(AgencyId id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public List<EmployeeAgencyHistoryRecord> getEmployeeAgencyHistoryRecords() {
    return employeeAgencyHistoryRecords;
  }

  public void setEmployeeAgencyHistoryRecords(
      List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords) {
    this.employeeAgencyHistoryRecords = employeeAgencyHistoryRecords;
  }

  public void addEmployee(Employee employee) {
    EmployeeAgencyHistoryRecord employeeAgencyHistoryRecord = new EmployeeAgencyHistoryRecord(employee, this);
    employeeAgencyHistoryRecords.add(employeeAgencyHistoryRecord);
    employee.getEmployeeAgencyHistoryRecords().add(employeeAgencyHistoryRecord);
  }

  public void removeEmployee(Employee employee) {
    for (Iterator<EmployeeAgencyHistoryRecord> iterator = employeeAgencyHistoryRecords.iterator(); iterator.hasNext();) {
      EmployeeAgencyHistoryRecord employeeAgencyHistoryRecord = iterator.next();

      if (employeeAgencyHistoryRecord.getAgency().equals(this) &&
          employeeAgencyHistoryRecord.getEmployee().equals(employee)) {
        iterator.remove();
        employeeAgencyHistoryRecord.getEmployee().getEmployeeAgencyHistoryRecords().remove(employeeAgencyHistoryRecord);
        employeeAgencyHistoryRecord.setAgency(null);
        employeeAgencyHistoryRecord.setEmployee(null);
      }
    }
  }
}
