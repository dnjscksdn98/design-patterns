package com.study.DesignPatterns.creational.factoryMethod.message;

/**
 *  Description:
 *    - This class Represents interface for our "product" which is a message
 *    - Implementations will be specific to content type
 *
 */
public abstract class Message {

  public abstract String getContent();

  public void addDefaultHeaders() {

  }

  public void encrypt() {

  }
}
