package dev.tnordquist;

public class ReverseStringInPlace {

  public static void reverse(char[] charArr){

    for(int i = 0; i < charArr.length/2; ++i){

      char temp = charArr[i];
      charArr[i] = charArr[charArr.length-1-i];
      charArr[charArr.length-1-i] = temp;

    }

  }

  public static void main(String[] args) {
    char[] arr = {'A'};
    reverse(arr);
    char[] arrEmpty = {};
    reverse(arrEmpty);
    char[] arrLetters = {'a','b','c','d','e'};
    reverse(arrLetters);
    char[] arrLetters2 = {'a','b','c','d','e','f'};
    reverse(arrLetters2);
  }

}
