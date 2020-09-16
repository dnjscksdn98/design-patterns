package com.study.DesignPatterns.creational.builder2;

import com.study.DesignPatterns.creational.builder.Address;
import com.study.DesignPatterns.creational.builder.User;
import com.study.DesignPatterns.creational.builder2.UserDto.UserDtoBuilder;

import java.time.LocalDate;

public class Client {

  public static void main(String[] args) {
    User user = createUser();
    UserDto dto = directBuild(UserDto.getBuilder(), user);
    System.out.println(dto);
  }

  private static UserDto directBuild(UserDtoBuilder builder, User user) {
    return builder
            .withFirstName(user.getFirstName())
            .withLastName(user.getLastName())
            .withBirth(user.getBirth())
            .withAddress(user.getAddress())
            .build();
  }

  /**
   *  Description:
   *      - Returns a sample user
   *
   */
  public static User createUser() {
    User user = new User();
    user.setBirth(LocalDate.of(1998, 11, 18));
    user.setFirstName("Alex");
    user.setLastName("Won");
    Address address = new Address();
    address.setHouseNumber("100");
    address.setStreet("Non-Hyundong");
    address.setCity("Apgojung");
    address.setState("Gangnam");
    address.setZipCode("12957");
    user.setAddress(address);
    return user;
  }
}
