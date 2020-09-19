package com.study.DesignPatterns.creational.factoryMethod.creator;

import com.study.DesignPatterns.creational.factoryMethod.message.JsonMessage;
import com.study.DesignPatterns.creational.factoryMethod.message.Message;

/**
 *  Description:
 *    - Provides implementation for creating JSON Messages
 *
 */
public class JsonMessageCreator extends MessageCreator {

  @Override
  public Message createMessage() {
    return new JsonMessage();
  }
}
