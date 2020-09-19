package com.study.DesignPatterns.creational.factoryMethod.message;

public class TextMessage extends Message {

  @Override
  public String getContent() {
    return "Text";
  }
}
