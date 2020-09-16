package com.study.DesignPatterns.creational.builder;

import java.time.LocalDate;

/**
 *  Description:
 *    - This class is our client which also works as director
 *
 */
public class Client {

  public static void main(String[] args) {
    User user = createUser();
    UserDtoBuilder builder = new UserWebDtoBuilder();

    UserDto dto = directBuild(builder, user);
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
