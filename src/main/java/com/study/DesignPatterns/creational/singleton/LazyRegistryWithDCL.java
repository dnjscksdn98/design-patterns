package com.study.DesignPatterns.creational.singleton;

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
