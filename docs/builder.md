## 🚀 Builder Patterns

- We have a complex process to construct an object involving multiple steps, then builder design pattern can help us.

- In Builder we remove the logic related to object contruction from code & abstract it in separate classes.

### ✓ How to implement a Builder

- We start by creating a builder
  - Identify the parts of the product & provide methods to create those parts.
  - It should provide a method to assemble or build the object.
  - It must provide a way/method to get fully built object out. Optionally builder can keep reference to an object it has built so the same can be returned again in future.
  
- A Director can be a separate class or client that can play the role of director.

### ✓ Compare & Contrast with Prototype Patterns

**Builder**

- When we have complex constructor and builder allows us to work with that.
- We can create a builder as a separate class and so it can work with legacy code.

**Prototype**

- Prototype allows to altogether skip using contructor.
- In Java this pattern works using ```clone``` method, and needs to modify existing code so may not work with legacy code.

### 🚫 Pitfalls

- Possibility of partially initialized objects
  - An object can be set with only a few or none of the properties using ```withXXX``` methods and call ```build()```. If required properties are missing, build method should provide suitable defaults or throw an exception.

### 🎯 Example Code

```java
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
```

### ✓ Summary

- Think of builder pattern when you have a complex constructor or an object is built in multiple steps.
