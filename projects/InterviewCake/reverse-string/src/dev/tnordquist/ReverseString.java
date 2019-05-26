package dev.tnordquist;

/**
 * Interview Cake coding practice problem: reverse a string in place.
 */
class ReverseString {

  static String reverseString(String str) {

    char[] charStr = str.toCharArray();

    for (int i = 0; i < charStr.length / 2; ++i) {

      int max = charStr.length - 1 - i;

      char temp = charStr[i];
      charStr[i] = charStr[max];
      charStr[max] = temp;
    }

    return new String(charStr);
  }

}
