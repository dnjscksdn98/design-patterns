package com.study.DesignPatterns.creational.builder2;

import com.study.DesignPatterns.creational.builder.Address;

import java.time.LocalDate;
import java.time.Period;

public class UserDto {

  private String name;
  private String address;
  private String age;

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  private void setAddress(String address) {
    this.address = address;
  }

  public String getAge() {
    return age;
  }

  private void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return String.format("Name: %s\nAge: %s\nAddress: %s", name, age, address);
  }

  public static UserDtoBuilder getBuilder() {
    return new UserDtoBuilder();
  }

  public static class UserDtoBuilder {
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserDto userDto;

    public UserDtoBuilder withFirstName(String fname) {
      firstName = fname;
      return this;
    }

    public UserDtoBuilder withLastName(String lname) {
      lastName = lname;
      return this;
    }

    public UserDtoBuilder withBirth(LocalDate birth) {
      Period ageInYears = Period.between(birth, LocalDate.now());
      age = Integer.toString(ageInYears.getYears());
      return this;
    }

    public UserDtoBuilder withAddress(Address address) {
      this.address = address.getHouseNumber() + ", " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + ", " + address.getZipCode();
      return this;
    }

    public UserDto build() {
      this.userDto = new UserDto();
      userDto.setName(firstName + " " + lastName);
      userDto.setAddress(address);
      userDto.setAge(age);
      return this.userDto;
    }

    public UserDto getUserDto() {
      return this.userDto;
    }
  }
}
