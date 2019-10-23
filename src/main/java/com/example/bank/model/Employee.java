package com.example.bank.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import org.hibernate.annotations.NaturalId;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.ManyToMany;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;


@Entity
@Table(name = "Employee")
@Inheritance(
		strategy = InheritanceType.JOINED
		)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeCode")
	private Integer employeeCode;
	@NaturalId
	@Column(name = "dni")
	private String dni;
	@Column(name = "nss")
	private String nss;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;

	// @JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city")
	private City city;

	// @JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laboralCategory")
	private LaboralCategory laboralCategory;

	@OneToMany(
			mappedBy = "employee",
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, // No existe fetch por defecto. Hay siempre que especificar si es Perezoso(LAZY) o ágil (EAGER)
			fetch = FetchType.LAZY,
			orphanRemoval = true
			)
	private List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords = new ArrayList<>();

	@ManyToMany(mappedBy = "employees")
	private Set<Syndicate> syndicates;

	@ManyToMany(mappedBy = "employees")
	private Set<AcademicTitle> AcademicTitles;

	public Employee() {
	}

	public Employee(String dni, String nss, String name, String surname, City city,
			LaboralCategory laboralCategory,
			List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords, Set<Syndicate> syndicates,
			Set<AcademicTitle> academicTitles) {
		this.dni = dni;
		this.nss = nss;
		this.name = name;
		this.surname = surname;
		this.city = city;
		this.laboralCategory = laboralCategory;
		this.employeeAgencyHistoryRecords = employeeAgencyHistoryRecords;
		this.syndicates = syndicates;
		AcademicTitles = academicTitles;
	}

	public Integer getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(Integer employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@JsonIgnore
	public City getCity() {
		return city;
	}

	@JsonIgnore
	public void setCity(City city) {
		this.city = city;
	}

	public String getCityName() {
		return city.getName();
	}

	@JsonIgnore
	public LaboralCategory getLaboralCategory() {
		return laboralCategory;
	}

	@JsonIgnore
	public void setLaboralCategory(LaboralCategory laboralCategory) {
		this.laboralCategory = laboralCategory;
	}

	public String getLaboralCategoryName() {
		return laboralCategory.getName();
	}

	public List<EmployeeAgencyHistoryRecord> getEmployeeAgencyHistoryRecords() {
		return employeeAgencyHistoryRecords;
	}

	public void setEmployeeAgencyHistoryRecords(
			List<EmployeeAgencyHistoryRecord> employeeAgencyHistoryRecords) {
		this.employeeAgencyHistoryRecords = employeeAgencyHistoryRecords;
	}

	public Set<Syndicate> getSyndicates() {
		return syndicates;
	}

	public void setSyndicates(Set<Syndicate> syndicates) {
		this.syndicates = syndicates;
	}

	public Set<AcademicTitle> getAcademicTitles() {
		return AcademicTitles;
	}

	public void setAcademicTitles(Set<AcademicTitle> academicTitles) {
		AcademicTitles = academicTitles;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Employee)) return false;
		Employee that = (Employee) o;
		return Objects.equals(getDni(), that.getDni()) &&
				Objects.equals(getNss(), that.getNss()) &&
				Objects.equals(getName(), that.getName()) &&
				Objects.equals(getSurname(), that.getSurname());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDni(), getNss(), getName(), getSurname());
	}
}
