package com.example.object;

class Animal {

  private String name;
  private String type;

  public Animal(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Animal other = (Animal) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }



  @Override
  public String toString() {
    return "Animal [name=" + name + ", type=" + type + "]";
  }
}


public class EqualsHashCodeToStringExample {
  public static void main(String[] args) {
    Animal animal1 = new Animal("Tommy", "Dog");
    System.out.println(animal1);// Animal [name=Tommy, type=Dog]

    // == comparison operator checks if the object references are pointing
    // to the same object. It does NOT look at the content of the object.
    Animal animal2 = new Animal("Tommy", "Dog");
    Animal animal3 = animal2;
    System.out.println(animal1.equals(animal2));// true
    System.out.println(animal2.equals(animal3));// true
  }
}
