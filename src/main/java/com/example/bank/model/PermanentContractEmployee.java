package com.example.bank.model;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permanent_contract_employee")
public class PermanentContractEmployee extends Employee {
  @Column(name = "seniotirty",
      nullable = false
      )
  private Integer seniority;
  
  public PermanentContractEmployee() {
  }

  public PermanentContractEmployee(String dni, String nss, String name, String surname, City city,
      LaboralCategory laboralCategory,
      List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords, Set<Syndicate> syndicates,
      Set<AcademicTitle> academicTitles) {
    super(dni, nss, name, surname, city, laboralCategory, employeeAgencyHistoryRecords, syndicates,
        academicTitles);
  }
  
  public PermanentContractEmployee(Integer seniority) {
    this.seniority = seniority;
  }

  public Integer getSeniority() {
    return seniority;
  }

  public void setSeniority(Integer seniority) {
    this.seniority = seniority;
  }
}
