package com.study.DesignPatterns.creational.singleton;

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
