package com.study.DesignPatterns.creational.factoryMethod;

import com.study.DesignPatterns.creational.factoryMethod.creator.JsonMessageCreator;
import com.study.DesignPatterns.creational.factoryMethod.creator.MessageCreator;
import com.study.DesignPatterns.creational.factoryMethod.creator.TextMessageCreator;
import com.study.DesignPatterns.creational.factoryMethod.message.Message;

public class Client {

  public static void main(String[] args) {
    printMessage(new JsonMessageCreator());
    printMessage(new TextMessageCreator());
  }

  public static void printMessage(MessageCreator creator) {
    Message msg = creator.getMessage();
    System.out.println(msg);
  }
}
