package com.study.DesignPatterns.creational.simpleFactory;

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
