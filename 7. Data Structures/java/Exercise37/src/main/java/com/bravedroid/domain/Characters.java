package com.bravedroid.domain;

public final class Characters {
  public static char[] punct;
  public static char[] alpha;
  public static short[] digit;

  static {
    alpha = new char[]{'a', 'A', 'b', 'B', 'c', 'C', 'd', 'e', 'f', 'g', 'h', 'l', 'm', 'n', 'o', 'p', 'P', 'q', 'R', 'S', 'T', 'u', 'V', 'W', 'Z'};
    digit = new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    punct = new char[]{'!', '#', '$', '%', '&', '(', ')', '*', '+', '-', ':', ';', '<', '=', '>', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~'};
  }

  private Characters() {
  }
}
