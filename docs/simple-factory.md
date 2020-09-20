## 🚀 Simple Factory Patterns

- Simpley move the instantiation logic to a separate class and most commonly to a static method of this class.
- Some do not consider simple factory to be a "design pattern", as it's simply a method that encapsulates object instantiation. Nothing complex goes on in that method.
- Typlically we want to do this if we have more than one option when instantiating object and a simple logic is used to choose correct class.

### ✓ Implement a Simple Factory

- Start by creating a separate class for our simple factory
  - Add a method which returns desired object instance.
  - This method is typically static and will accept some argument to decide which class to instantiate.
  - You can also provide additional arguments which will be used to instantiate objects.
  
```java
/**
 *  Description:
 *    - Abstract post class.
 *    - Represents a generic post on a web site.
 *
 */
public abstract class Post {

  private Long id;
  private String title;
  private String content;
  private LocalDateTime createdAt;
  private LocalDateTime publishedAt;

  ...
}
```

```java
/**
 *  Description:
 *    - Represents a news post.
 *
 */
public class NewsPost extends Post {

  private String headline;
  private LocalDate newsTime;
  
  ...
}
```

```java
/**
 *  Description:
 *    - Represents a blog post.
 *
 */
public class BlogPost extends Post {

  private String author;
  private String[] tags;
  
  ...
  
}
```

```java
/**
 *  Description:
 *    - Represents a product information post.
 *
 */
public class ProductPost extends Post {

  private String imageUrl;
  private String name;
  
  ...
}
```

```java
/**
 *  Description:
 *    - This class acts as a Simple Factory for creation of different posts
 *
 */
public class PostFactory {

  /**
   *  Description:
   *    - Instantiate subclass of Post
   *    - Give type as the criteria for which subclass to instantiate
   *
   */
  public static Post createPost(String type) {
    switch(type) {
      case "blog":
        return new BlogPost();

      case "news":
        return new NewsPost();

      case "product":
        return new ProductPost();

      default:
        throw new IllegalArgumentException("Post type is unknown.");
    }
  }
}
```

```java
public class Client {

  public static void main(String[] args) {

    Post post = PostFactory.createPost("blog");
    System.out.println(post);
  }
}
```

### ✓ Implementation & Design Considerations

- Simple Factory can be just a method in existing class. Adding a separate class however allows other parts of your code to use simple factory more easily.
- Simple Factory itself doesn't need any state tracking so it's best to keep this as a static method.

- Simple Factory will in turn may use other design pattern like Builder to construct objects.
- In case you want to specialize your Simple Factory in sub classes, you need Factory method design pattern instead.

### ✓ Comparison with Factory Method

- Simple Factory
  - We simply move our instantiation logic away from client code. Typically in a static method.
  - Simple Factory knows about all classes whose objects it can create.

- Factory Method
  - Factory method is more useful when you want to delegate object creation to subclasses.
  - In Factory Method we don't know in advance about all product subclasses.
  
### 🚫 Pitfalls

- The criteria used by Simple Factory to decide which object to instantiate can get more convoluted/complex over time. If you find yourself in such situation then use Factory Method instead.
