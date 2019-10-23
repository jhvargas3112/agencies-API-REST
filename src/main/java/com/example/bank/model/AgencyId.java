package com.example.bank.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import javax.persistence.Column;
import java.util.Objects;

@SuppressWarnings("serial")
@Embeddable
public class AgencyId implements Serializable {
  @Column(name = "name")
  private String name;
  @Column(name = "city")
  private Integer city;

  public AgencyId() {
  }

  public AgencyId(String name, Integer city) {
    this.name = name;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public Integer getCity() {
    return city;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AgencyId)) return false;
    AgencyId that = (AgencyId) o;
    return Objects.equals(getName(), that.getName()) &&
        Objects.equals(getCity(), that.getCity());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getCity());
  }
}
