package com.study.DesignPatterns.builder;

import java.time.LocalDate;
import java.time.Period;

/**
 *  Description:
 *      - The concrete builder for UserWebDto
 *
 */
public class UserWebDtoBuilder implements UserDtoBuilder {

  private String firstName;
  private String lastName;
  private String address;
  private String age;
  private UserWebDto dto;

  @Override
  public UserDtoBuilder withFirstName(String fname) {
    firstName = fname;
    return this;
  }

  @Override
  public UserDtoBuilder withLastName(String lname) {
    lastName = lname;
    return this;
  }

  @Override
  public UserDtoBuilder withBirth(LocalDate birth) {
    Period ageInYears = Period.between(birth, LocalDate.now());
    age = Integer.toString(ageInYears.getYears());
    return this;
  }

  @Override
  public UserDtoBuilder withAddress(Address address) {
    this.address = address.getHouseNumber() + ", " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + ", " + address.getZipCode();
    return this;
  }

  @Override
  public UserDto build() {
    dto = new UserWebDto(firstName + " " + lastName, address, age);
    return dto;
  }

  @Override
  public UserDto getUserDto() {
    return dto;
  }
}
