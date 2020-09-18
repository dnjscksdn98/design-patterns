package com.study.DesignPatterns.creational.simpleFactory;

import java.time.LocalDate;

/**
 *  Description:
 *    - Represents a news post.
 *
 */
public class NewsPost extends Post {

  private String headline;
  private LocalDate newsTime;

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public LocalDate getNewsTime() {
    return newsTime;
  }

  public void setNewsTime(LocalDate newsTime) {
    this.newsTime = newsTime;
  }
}
