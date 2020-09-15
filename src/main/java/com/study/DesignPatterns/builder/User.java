package com.study.DesignPatterns.builder;

import java.time.LocalDate;

/**
 *  Description:
 *      - Entity class used to construct the DTO
 *
 */
public class User {

  private String firstName;
  private String lastName;
  private LocalDate birth;
  private Address address;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
