package com.study.DesignPatterns.creational.singleton;

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
