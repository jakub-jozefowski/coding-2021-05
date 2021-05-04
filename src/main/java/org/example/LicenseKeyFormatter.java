package org.example;

import com.google.common.base.Splitter;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class LicenseKeyFormatter {

  private static final char SPECIAL_CHAR = '-';

  public String formatStream(String input, int groupSize) {
    String combined = input.replace("" + SPECIAL_CHAR, "");
    String reversed = reverse(combined);

    return reverse(
        StreamSupport.stream(Splitter.fixedLength(groupSize).split(reversed).spliterator(), false)
            .map(String::toUpperCase)
            .collect(Collectors.joining("" + SPECIAL_CHAR)));
  }

  public String formatSimple(String input, int groupSize) {
    LinkedList<String> groups = new LinkedList<>();

    int lastIndex = groupSize - 1;
    char[] buffer = new char[groupSize];
    int bufferSize = 0;

    for (int index = input.length() - 1; index >= 0; index--) {
      char currentChar = input.charAt(index);

      if (currentChar == SPECIAL_CHAR) {
        continue;
      }

      if (bufferSize >= groupSize) {
        groups.addFirst(new String(buffer));

        buffer = new char[groupSize];
        lastIndex = groupSize - 1;
        bufferSize = 0;
      }

      buffer[lastIndex] = Character.toUpperCase(currentChar);
      lastIndex--;
      bufferSize++;
    }

    if (bufferSize > 0) {
      groups.addFirst(new String(buffer).trim());
    }

    return String.join("" + SPECIAL_CHAR, groups);
  }

  private static String reverse(String input) {
    return new StringBuffer(input).reverse().toString();
  }
}
