package com.study.DesignPatterns.creational.factoryMethod.message;

public class JsonMessage extends Message {

  @Override
  public String getContent() {
    return "{\"Json\":[]}";
  }
}
