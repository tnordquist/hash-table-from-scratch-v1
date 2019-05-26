package dev.tnordquist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ReverseStringTest {

  private static Object[][] reverseString() {
    return new Object[][]{

        {"abcd", "dcba"},
        {"ohio", "oiho"},
        {"123456789", "987654321"}
    };
  }

  @ParameterizedTest
  @MethodSource
  void reverseString(String input, String expected) {

  String actual = ReverseString.reverseString(input);
  assertEquals(expected,actual);
  }
}