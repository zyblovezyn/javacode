package com.java12.spring.spring_in_action.chp3;


public class BlankDisc {

  private final String title;
  private final String artist;
private Integer connectionCount;

  public Integer getConnectionCount() {
    return connectionCount;
  }

  public BlankDisc(String title, String artist, Integer connectionCount) {
    this.title = title;
    this.artist = artist;
    this.connectionCount = connectionCount;
  }

  public BlankDisc(String title, String artist) {
    this.title = title;
    this.artist = artist;
  }
  
  public String getTitle() {
    return title;
  }
  
  public String getArtist() {
    return artist;
  }
  
}
