package com.study.DesignPatterns.creational.builder;

import java.time.LocalDate;

/**
 *  Description:
 *      - Abstract builder
 *
 */
public interface UserDtoBuilder {

  /**
   *  Description:
   *      - Methods to build parts of product at a time
   *
   */
  UserDtoBuilder withFirstName(String fname);

  UserDtoBuilder withLastName(String lname);

  UserDtoBuilder withBirth(LocalDate birth);

  UserDtoBuilder withAddress(Address address);

  /**
   *  Description:
   *      - Method to assemble final product
   *
   */
  UserDto build();

  /**
   *  Description:
   *      - (Optional) method to fetch already built object
   *
   */
  UserDto getUserDto();
}
