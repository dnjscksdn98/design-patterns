## 🚀 Factory Method

- We want to move the object creation logic from our code to a separate class.

- We use this pattern when we do not know in advance which class we may need to instantiate beforehand & also to allow new classes to be added to system and handle their creation without affecting client code.
- We let sub classes decide which object to instantiate by overriding the factory method.

### ✓ Implement a Factory Method

- We start by creating a class for our creator
  - Creator itself can be concrete if it can provide a default object or it can be abstract.
  - Implementations will override the method and return an object.
  
![](https://images.velog.io/images/dnjscksdn98/post/d8381a17-fb46-449f-b0bf-759edfdb8ce1/Untitled%20Diagram.png)
  
### ✓ Implementation Considerations

- The creator can be a concrete class & provide a default implementation for the factory method. In such cases you'll create some **default** object in base creator.
- You can also use the simple factory way of accepting additional arguments to choose between different object types. Sub classes can then override factory method to selectively create different objects for some criteria.

### ✓ Design Considerations

- Creator hierarchy in factory method pattern reflects the product hierarchy. We typically end up with a concrete creator per object type.
- Template Method design patterns often makes use of Factory Methods.
- Another Creational Design Pattern called **Abstract Factory** makes use of factory method pattern.

### 🚫 Pitfalls

- More complex to implement. More classes involved and need unit testing.
- You have to start with Factory Method design patterns from the beginning. It's not easy to refactor existing code into factory method patterns.
- Sometimes this pattern forces you to subclass just to create appropriate instance.

### 🎯 Summary

- Use Factory Method pattern when you want to delegate object instantiation to sub classes, you'd want to do this when you have **product** inheritance hierarchy and possibility of future additions to that.

### ✓ Code Example

```java
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
```

```java
public class JsonMessage extends Message {

  @Override
  public String getContent() {
    return "{\"Json\":[]}";
  }
}
```

```java
public class TextMessage extends Message {

  @Override
  public String getContent() {
    return "Text";
  }
}
```

```java
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
```

```java
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
```

```java
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
```

```java
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
```
