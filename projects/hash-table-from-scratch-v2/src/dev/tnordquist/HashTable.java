package dev.tnordquist;

public class HashTable {

  private class Node {

    String key; // key for hash table
    String val; // value for the key
    Node next; // new node to be pointed to
  }


  private static Node[] headArr = new Node[3]; // Array that holds linked lists for hash table
  private static final int N = headArr.length;

  /**
   * This method puts a key / value pair into appropriate place in a linked list which itself is
   * placed in an appropriate value of the array who's index corresponds to the key's hashcode.
   *
   * @param k key value to be inserted into node of linked list of appropriate array index
   * @param v value corresponding to the key
   */
  public void put(String k, String v) {

    Node newNode;
    newNode = new Node();
    newNode.key = k;
    newNode.val = v;
    Node head;

    int hashcode = Math.abs(k.hashCode()) % N;
    head = headArr[hashcode];

    if (head == null) {
      headArr[hashcode] = newNode;
    } else if (head.val.compareTo(v) >= 0) {
      newNode.next = head;
      headArr[hashcode] = newNode;
    } else {
      Node runner;
      Node previous;
      runner = head.next;
      previous = head;
      while (runner != null && runner.val.compareTo(v) < 0) {
        previous = runner;
        runner = runner.next;
      }
      newNode.next = runner;
      previous.next = newNode;

    }
  }

  public static void main(String[] args) {
    HashTable hashTable = new HashTable();
    hashTable.put("cat", "meow");
    hashTable.put("cat", "purr");
    hashTable.put("cat", "cuddle");
  }
}