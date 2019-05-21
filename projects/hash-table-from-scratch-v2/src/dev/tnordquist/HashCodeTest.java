package dev.tnordquist;

public class HashCodeTest {

  public static void main(String[] args) {

    String cat = "cat";
    String fat = "fat";
    String dog = "dog";
    String tac = "tac";
    String zero = "0";
    String catcat = "catcat";
    String rumple = "9";

    System.out.println(Math.abs(cat.hashCode())%19);
    System.out.println(Math.abs(fat.hashCode())%19);
    System.out.println(Math.abs(dog.hashCode())%19);
    System.out.println(Math.abs(tac.hashCode())%19);
    System.out.println(Math.abs(zero.hashCode())%19);
    System.out.println(Math.abs(catcat.hashCode())%19);
    System.out.println(Math.abs(rumple.hashCode())%19);
  }

}
