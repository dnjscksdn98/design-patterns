package com.study.DesignPatterns.creational.singleton;

public class Client {

  public static void main(String[] args) {

    EagerRegistry registry = EagerRegistry.getInstance();
    EagerRegistry registry2 = EagerRegistry.getInstance();

    System.out.println(registry == registry2);

    LazyRegistryWithDCL registry3 = LazyRegistryWithDCL.getInstance();
    LazyRegistryWithDCL registry4 = LazyRegistryWithDCL.getInstance();

    System.out.println(registry3 == registry4);
  }
}
