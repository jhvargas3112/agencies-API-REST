package com.example.bank.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "temporal_contract_employee")
public class TemporalContractEmployee extends Employee {
  @Column(name = "startDate",
      nullable = false
      )
  private Date startDate = new Date();

  @Column(name = "finishDate",
      nullable = false
      )
  private Date finishDate = new Date();

  public TemporalContractEmployee() {
  }

  public TemporalContractEmployee(String dni, String nss, String name, String surname, City city,
      LaboralCategory laboralCategory,
      List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords, Set<Syndicate> syndicates,
      Set<AcademicTitle> academicTitles) {
    super(dni, nss, name, surname, city, laboralCategory, employeeAgencyHistoryRecords, syndicates,
        academicTitles);
  }

  public TemporalContractEmployee(Date startDate, Date finishDate) {
    super();
    this.startDate = startDate;
    this.finishDate = finishDate;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(Date finishDate) {
    this.finishDate = finishDate;
  }
}
