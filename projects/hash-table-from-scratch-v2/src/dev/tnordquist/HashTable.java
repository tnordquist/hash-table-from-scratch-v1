package dev.tnordquist;

public class HashTable {

  private class Node {

    String key; // key for hash table
    String val; // value for the key
    Node next; // new node to be pointed to
  }


  private static Node[] headArr = new Node[19]; // Array that holds linked lists for hash table
  private static final int N = headArr.length;

  /**
   * This method uses a key argument to determine the array value which is the head of the linked
   * list containing the sought after key / value pair.  A runner node runs along the linked nodes
   * until the specific key is found and then returns the corresponding value.  If the key does not
   * exist then null is returned.
   *
   * @param k key used to find its corresponding value
   * @return value corresponding to the given key
   */
  public String get(String k) {

    int hashcode = Math.abs(k.hashCode()) % N;
    Node head = headArr[hashcode];
    Node runner = head;

    while (runner != null) {
      if (runner.key.equals(k)) {
        return runner.val;
      }
      runner = runner.next;
    }

    return null;
  }

  /**
   * This method puts a key / value pair into appropriate place in a linked list which itself is
   * placed in an appropriate value of the array who's index corresponds to the key's hashcode.
   *
   * @param k key value to be inserted into node of linked list of appropriate array index
   * @param v value corresponding to the key
   */
  private void put(String k, String v) {

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

  private void remove(String k) {

    int hC = Math.abs(k.hashCode()) % N;
    Node head = headArr[hC];

    if (headArr[hC] == null) {
      return;
    }

    if (headArr[hC].key.equals(k)) {
      headArr[hC] = headArr[hC].next;
      return;
    }

    Node prev = head;
    Node runner = head.next;
    while (runner != null) {
      if(runner.key.equals(k)){
        if(runner.next==null){
          prev.next = null;
          return;
        } else {
          prev.next = runner.next;
          runner = null;
          return;
        }
      } else {
        prev = runner;
        runner = runner.next;
      }
    }
  }

  public static void main(String[] args) {
    HashTable hashTable = new HashTable();
    hashTable.put("fat", "cellulite");
    hashTable.put("dog", "bark");
    hashTable.put("cat", "grease");
    hashTable.put("9", "meow");

    System.out.println(hashTable.get("9"));

    hashTable.remove("fat");


    System.out.println(hashTable.get("cat"));
  }
}