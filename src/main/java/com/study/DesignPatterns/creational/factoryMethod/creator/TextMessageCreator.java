package com.study.DesignPatterns.creational.factoryMethod.creator;

import com.study.DesignPatterns.creational.factoryMethod.message.Message;
import com.study.DesignPatterns.creational.factoryMethod.message.TextMessage;

/**
 *  Description:
 *    - Provides implementation for creating Text Messages
 *
 */
public class TextMessageCreator extends MessageCreator {

  @Override
  public Message createMessage() {
    return new TextMessage();
  }
}
