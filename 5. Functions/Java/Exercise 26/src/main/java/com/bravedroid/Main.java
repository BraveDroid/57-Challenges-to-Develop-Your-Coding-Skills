package com.bravedroid;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

  private static final int I = 12;
  private static final int B = 5000;
  private static final int P = 100;

  public static void main(String[] args) {
    //v = b/p
    final BigDecimal v = BigDecimal.valueOf((long) B / (long) P);

    // z =1-(1+I)^30
    final BigDecimal z = Z(I).multiply(BigDecimal.valueOf(-1)).add(BigDecimal.ONE);

    //v1 = b/p(1-(1+I)^30)
    final BigDecimal v1 = z.multiply(v);

    // a = (1+(b/p(1-(1+I)^30)))
    final BigDecimal a = v1.add(BigDecimal.ONE);

    // val = log(1+(b/p(1-(1+I)^30)))
    final double val = Math.log(a.doubleValue());

    // val = log(1+(b/p(1-(1+I)^30))) en BigDecimal
    final BigDecimal h = BigDecimal.valueOf(val);

    //multiplicand =-1/30
    final BigDecimal multiplicand = BigDecimal.valueOf(-1 / 30d);

    // multiply = -1/30 * log(1+(b/p(1-(1+I)^30)))
    final BigDecimal multiply = h.multiply(multiplicand);

    // n = -1/30 * log(1+(b/p(1-(1+I)^30)))/log(1+I)
    BigDecimal n = multiply.divide(F(I), new MathContext(5, RoundingMode.HALF_UP));
    System.out.println(n);
  }

  //F=log(1+I)
  private static BigDecimal F(double I) {
    return BigDecimal.valueOf(Math.log10(1 + I));
  }

  //Z=(1+I)^30
  private static BigDecimal Z(double I) {
    return BigDecimal.valueOf(1 + I).pow(30);
  }
}
