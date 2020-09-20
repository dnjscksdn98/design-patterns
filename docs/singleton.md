## 🚀 Singleton

- A singleton class has only one instance, accessible globally through a single point(via a method/field)
- The main problem this pattern solves is to ensure that only a single instance of this class exists.
- Any state you add in your singleton becomes part of "global state" of your application.

### ✓ Implement a Singleton

- Controlling instance creation
  - Class constructor(s) must not be accessible globally
  - Subclassing/Inheritance must not be allowed
- Keeping track of instance
  - Class itself is a good place to track the instance
- Giving access to the singleton instance
  - A public static method is a good choice
  - Can expose instance as final public static field but it won't work for all singleton implementations
  
### ✓ Two options for implementing a singleton

- Early initialization - Eager Singleton
  - Create singleton as soon as class is loaded
- Lazy initialization - Lazy Singleton
  - Singleton is created when it is first requested
  
### ✓ Implementation Considerations

- Early/Eager initialization is the simplest & preferred way. Always try to use this approach first.
- The "classic" singleton pattern implementation uses double check locking and volatile field.
- The lazy initialization holder idiom provides best of both world, you don't deal with synchronization issues directly and is easy to implement.
- You can also implement singletons using enums. However due to pre-conceptions about what an enum is, it may be a hard sell during code review especially if singleton has mutable fields.

### ✓ Design Considerations

- Singleton creation does not need any parameters. If you find yourself in need of support for constructor arguments, you need a simple factory or factory method pattern instead.
- Make sure that your singletons are not carrying a lot of mutable global state.

### ✓ Comparison with Factory Method

- Singleton
  - Primary purpose or intent of singleton pattern is to ensure that only one instance of a class is ever created.
  - Singleton instance is created without any need of arguments from client code.

- Factory Method
  - Factory method is primarily used to isolate client code from object creation & delegate object creation to subclasses.
  - Factory method allows to parameterize the object creation.
  
### 🚫 Pitfalls

- Singleton pattern can deceive you about true dependencies. Since they are globally accessible it's easy to miss dependencies.
- They are hard to unit test. You cannot easily mock the instance that is returned.
- Most common way to implement singleton in Java is through static variables and they are held per class loader and not per JVM. So they may not be truly singleton is an OSGI or web application.
- A singleton carrying around a large **mutable** global state is a good indication of an abused singleton pattern.

### 🎯 Summary

- Singleton pattern is used when you want to ensure that only one instance of a class exists in application.
- In Java we achieve this by making constructor **private**, this also prevents inheritance & providing a public static method which returns the singleton instance.
- Implementation wise we have two broad choices
  1. In eager loading singleton, we create instance as soon as class is loaded by classloader
  2. In lazy loading singleton, we defer creation until some code actually requests the instance.
- Always prefer the eager loading instance unless creation cost is high and start-up time impact is noticeable.

### ✓ Eager Singleton

```java
/**
 *  Description:
 *    - This class uses eager initialization of singleton instance.
 *
 */
public class EagerRegistry {

  /**
   *  Description:
   *    - By making constructor private, we prevent object instantiation outside of this class
   *    - this will also prevent inheritance
   *
   */
  private EagerRegistry() {

  }

  /**
   *  Description:
   *    - The singleton instance
   *    - Eagerly initialized singleton
   *
   */
  private static final EagerRegistry INSTANCE = new EagerRegistry();

  /**
   *  Description:
   *    - This method returns the singleton instance to outside world
   *    @return Instance of EagerRegistry
   *
   */
  public static EagerRegistry getInstance() {
    return INSTANCE;
  }
}
```

### ✓ Lazy Singleton with Double check Locking

```java
/**
 *  Description:
 *    - This class demonstrates singleton pattern using Double Checked Locking or "classic" singleton
 *    - This is also a lazy initializing singleton
 *    - Although this implementation solves the multi-threading issue with lazy initialization using volatile
 *      and double check locking, the volatile keyword is guaranteed to work only after JVMs starting with
 *      version 1.5 and later.
 *
 */
public class LazyRegistryWithDCL {

  /**
   *  Description:
   *    - Private constructor to prevent instantiation outside this class and prevent subclassing
   */
  private LazyRegistryWithDCL() {

  }

  /**
   *  Description:
   *    - The lazy singleton instance
   *    - Note the use of volatile
   */
  private static volatile LazyRegistryWithDCL INSTANCE;

  /**
   *  Description:
   *    - This method implements the double check locking
   *    @return Instance of {@link LazyRegistryWithDCL}
   */
  public static LazyRegistryWithDCL getInstance() {
    if (INSTANCE == null) {
      synchronized (LazyRegistryWithDCL.class) {
        if (INSTANCE == null) {
          INSTANCE = new LazyRegistryWithDCL();
        }
      }
    }
    return INSTANCE;
  }
}
```

### ✓ Lazy Singleton with Initialization Holder

```java
/**
 *  Description:
 *    - Singleton pattern using lazy initialization holder class
 *    - This ensures that we have a lazy initialization without worrying about synchronization
 *
 */
public class LazyRegistryIODH {

  /**
   *  Description:
   *    - Private constructor to prevent instantiation outside of this class
   *    - This also prevents inheritance
   */
  private LazyRegistryIODH() {
    System.out.println("In LazyRegistryIODH singleton");
  }

  /**
   *  Description:
   *    - This class provides with the Initialization on demand holder pattern
   */
  private static class RegistryHolder {
    static LazyRegistryIODH INSTANCE = new LazyRegistryIODH();
  }

  /**
   *  Description:
   *    - This method provides the singleton instance. Note the use of {@link RegistryHolder}
   *    @return Instance of {@link LazyRegistryIODH}
   */
  public static LazyRegistryIODH getInstance() {
    return RegistryHolder.INSTANCE;
  }
}
```
