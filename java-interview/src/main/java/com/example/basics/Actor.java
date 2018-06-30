package com.example.basics;

public class Actor {

  // member variable
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    // bradPitt & tomCruise are objects or instances of Class Actor
    // Each instance has separate value for the member variable name
    Actor bradPitt = new Actor();
    bradPitt.setName("Brad Pitt");

    Actor tomCruise = new Actor();
    tomCruise.setName("Tom Cruise");
  }
}
