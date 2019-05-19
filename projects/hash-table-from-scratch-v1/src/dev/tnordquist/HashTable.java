package dev.tnordquist;


public class HashTable {

  public static void main(String[] args) {

    table = new HashTable(10);
    String key = "dog";
    String val = "animal";
    table.put(key, val);
    String key2 = "cat";
    String val2 = "barker";
    table.put(key2, val2);
    String key3 = "wat";
    String val3 = "feline";
    table.put(key3, val3);
    String key4 = "mat";
    String val4 = "whiskers";
    table.put(key4, val4);
    String key5 = "mat";
    String val5 = "purr";
    table.put(key5, val5);
    String key6 = "horse";
    String val6 = "gallops";
    table.put(key6, val6);
    String key7 = "rohse";
    String val7 = "gallops";
    table.put(key7, val7);
    String key8 = "rohse";
    String val8 = "gorse";
    table.put(key8, val8);

    System.out.println();
    System.out.print("The number of key / value associations in the hash"
        + " table is: " + table.size());
    System.out.println();
    printList(A);
    System.out.println();
    String getVal;
    String keyName;
    keyName = "mat";
    getVal = table.get(keyName);
    System.out.println();
    System.out.println("The value associated with the key " + keyName
        + " is:  \" " + getVal + "\".");
    keyName = "rork";
    getVal = table.get(keyName);

    System.out.println("The value associated with the key " + keyName
        + " is:  \" " + getVal + "\".");

    System.out.println();
    if (table.containsKey("ralf"))
      System.out.println("ralf is a key");
    else
      System.out.println("ralf is not a key");
    System.out.println();
    if (table.containsKey("dog"))
      System.out.println("dog is a key");
    else
      System.out.println("dog is not a key");
    System.out.println();
    if (table.containsKey("varg"))
      System.out.println("varg is a key");
    else
      System.out.println("varg is not a key");

    System.out.println();
    System.out.println();

    System.out.println();
    System.out.print("The number of key / value associations in the hash"
        + " table is: " + table.size());
    System.out.println();

    System.out.println();
    String remove;
    remove = "cat";
    System.out.println("The hash table before " +"\""+ remove + "\""+ " was removed"
        + " from the hash table:");
    printList(A);
    System.out.println();
    if (table.remove(remove))
      System.out.println(remove + "  was found and deleted.");
    else
      System.out.println(remove + " was not in the hash table.");
    System.out.println("The hash table after " + "\""+ remove + "\"" + " was removed"
        + " from the hash table:");
    printList(A);

    System.out.println();
    System.out.println();
    System.out.print("The number of key / value associations in the hash"
        + " table is: " + table.size());
    System.out.println();


    System.out.println();
    System.out.println();
    remove = "rork";
    System.out.println("The hash table before " + "\""+ remove + "\"" + " was removed"
        + " from the hash table:");
    printList(A);
    System.out.println();
    if (table.remove(remove))
      System.out.println(remove + "  was found and deleted.");
    else
      System.out.println(remove + " was not in the hash table.");
    System.out.println("The hash table after " + "\""+ remove + "\"" + " was removed"
        + " from the hash table:");
    printList(A);
    System.out.println();

    System.out.println();
    System.out.print("The number of key / value associations in the hash"
        + " table is: " + table.size());
    System.out.println();
  }

  // ------------------------------------------------------------------------

  class Node {
    String key;
    String value;
    Node next;

  }

  private static Node[] A;
  private static HashTable table;

  public HashTable(int ASize) {

    A = new Node[ASize];
  }

  /**
   * Associates the specified value with the specified key, where key must be
   * of type K and value must be of type V. If the map already associated some
   * other value with the key, then the new value replaces the old one.
   *
   * @param putKey
   *            the key that is to be put into the hash table
   * @param putVal
   *            the value associated with the key that was put into the hash
   *            table.
   */
  public void put(String putKey, String putVal) {
    Node newNode;

    newNode = table.new Node();
    newNode.key = putKey;
    newNode.value = putVal;
    Node head;
    int code = Math.abs(putKey.hashCode()) % A.length;

    if (A[code] == null) {
      head = table.new Node();
      head = newNode;
      A[code] = head;
    } else if (A[code] != null) {
      if (A[code].key.compareTo(putKey) == 0) {
        // if (A[code].value.compareTo(putVal) >= 0) {
        // newNode.next = A[code];
        // A[code] = newNode;

        A[code].value = putVal;

      } else if (A[code].key.compareTo(putKey) > 0) {
        newNode.next = A[code];
        A[code] = newNode;
      } else {

        Node runner; // A node for traversing the list.
        Node previous; // Always points to the node preceding runner.
        runner = A[code].next; // Start by looking at the SECOND
        // position.
        previous = A[code];
        while (runner != null && runner.key.compareTo(putKey) < 0) {
          // Move previous and runner along the list until runner
          // falls off the end or hits a list element that is
          // greater than or equal to putKey. When this loop ends,
          // previous indicates the position where putKey must be put.
          previous = runner;
          runner = runner.next;

        }
        // if (runner == null)
        // if(newNode.value.compareTo(anotherString))
        // if(runner.key.compareTo(putKey) == 0)
        // runner.value = putVal;
        // else {
        newNode.next = runner;
        previous.next = newNode;

        if (newNode.next != null
            && (previous.next.key.compareTo(newNode.next.key) == 0)) {
          previous.next.value = putVal;
          newNode.next = null;
        }
      }
    }
  }// end put()

  /**
   *
   * @param key
   *            the key for which its associated value is sought
   * @return value the object of type V that is associated by the hash table
   *         to the key. If the hash table does not associate any value with
   *         key, the the return value is null.
   */

  @SuppressWarnings("unused")
  private String get(String inKey) {
    Node runner = new Node();
    Node start = table.new Node();
    int code = Math.abs(inKey.hashCode()) % A.length;
    start = A[code];
    runner = start;

    while (runner != null && !((runner.key).equals(inKey))) {
      runner = runner.next;
    }
    if (runner != null && runner.key.equals(inKey))
      return runner.value;
    else
      return null;
  }

  /**
   * Delete a specified key association from the hash table, if that
   * association is present.
   *
   * @param removeKey
   *            the key to be remove (along with its associated value)
   * @return true if the key was found and deleted, or false if the key was
   *         not in the hash table.
   */
  @SuppressWarnings("unused")
  private boolean remove(String removeKey) {

    int code = Math.abs(removeKey.hashCode()) % A.length;
    if (A[code] == null) {
      // The list is empty, so it certainly doesn't contain removeKey
      return false;
    } else if (A[code].key.equals(removeKey)) {
      A[code] = A[code].next;
      return true;
    } else {
      // The key, if it exists, is somewhere beyond the first element
      // of the list. Search the list.
      Node runner; // A node for traversing the list.
      Node previous; // Always points to the node preceding runner.
      runner = A[code].next;
      previous = A[code];
      while (runner != null && runner.key.compareTo(removeKey) < 0) {
        // Move previous and runner along the list until runner
        // falls off the end or hits a list element that is greater than
        // or equal to removeKey. When this loop ends, runner indicates
        // the position where removeKey must be, it it is in the list.
        previous = runner;
        runner = runner.next;
      }
      if (runner != null && runner.key.equals(removeKey)) {
        // Runner points to the node that is to be deleted.
        // Remove it by changing the pointer in the previous node.
        previous.next = runner.next;
        return true;
      } else {
        // The item does not exist in the list.
        return false;
      }
    }

  } // end remove()

  /**
   *
   * @param containsKey the key for which its specified value is sought
   * @return returns a boolean value that is true if the map associates some
   * value to the specified key.
   */
  private boolean containsKey(String containsKey) {

    int code = Math.abs(containsKey.hashCode()) % A.length;
    if (A[code] == null) {
      // The list is empty, so it certainly doesn't contain removeKey
      return false;
    } else if (A[code].key.equals(containsKey)) {
      // The key is the first item of the list.
      return true;
    } else {
      // The key, if it exists, is somewhere beyond the first element
      // of the list. Search the list.
      Node runner; // A node for traversing the list.
      Node previous; // Always points to the node preceding runner.
      runner = A[code].next;
      previous = A[code];
      while (runner != null && runner.key.compareTo(containsKey) < 0) {
        // Move previous and runner along the list until runner
        // falls off the end or hits a list element that is greater than
        // or equal to removeKey. When this loop ends, runner indicates
        // the position where removeKey must be, it it is in the list.
        previous = runner;
        runner = runner.next;
      }
      if (runner != null && runner.key.equals(containsKey)) {
        // Runner points to the node.
        return true;
      } else {
        // The item does not exist in the list.
        return false;
      }
    }

  } // end containsKey()

  private int size() {

    int size = 0;
    for (int i = 0; i < A.length; i++) {
      Node start = table.new Node();
      start = A[i];
      Node runner; // For running along the list.
      runner = start;
      while (runner != null) {
        size++;
        runner = runner.next;
      }

    }
    return size;
  } // end size()

  /**
   * Prints the items in the list to which the parameter, start, points. They
   * are printed on one line, separated by spaces and enclosed in parentheses.
   */
  static void printList(Node[] A) {

    for (int i = 0; i < A.length; i++) {
      Node start = table.new Node();
      start = A[i];
      Node runner; // For running along the list.
      runner = start;
      System.out.print("[");
      while (runner != null) {
        System.out.print(" ( " + runner.key + ",");
        System.out.print(runner.value + ")");
        runner = runner.next;
      }
      System.out.print(" ]");
    }
  } // end printList()
} // end class HashTable
