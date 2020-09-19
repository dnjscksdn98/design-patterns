package com.study.DesignPatterns.creational.factoryMethod.creator;

import com.study.DesignPatterns.creational.factoryMethod.message.Message;

/**
 *  Description:
 *    - This is our abstract "creator"
 *    - The abstract method createMessage() has to be implemented by its sub classes
 *
 */
public abstract class MessageCreator {

  public Message getMessage() {
    Message msg = createMessage();

    msg.addDefaultHeaders();
    msg.encrypt();

    return msg;
  }

  /**
   *  Description:
   *    - Factory Method
   *
   */
  public abstract Message createMessage();
}
