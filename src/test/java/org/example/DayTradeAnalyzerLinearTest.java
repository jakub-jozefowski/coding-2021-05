package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DayTradeAnalyzerLinearTest {

  @Test
  void example() {
    double[] prices = {13.0, 14.0, 12.0, 9.0, 9.5, 11.0, 8.0, 9.0};

    int[] result = new DayTradeAnalyzer().getBiggestBenefitLinear(prices);
    assertEquals(3, result[0]);
    assertEquals(5, result[1]);
  }

  @Test
  void exampleAndBigger() {
    double[] prices = {13.0, 14.0, 12.0, 9.0, 9.5, 11.0, 8.0, 9.0, 15.0};

    int[] result = new DayTradeAnalyzer().getBiggestBenefitLinear(prices);
    assertEquals(6, result[0]);
    assertEquals(8, result[1]);
  }

  @Test
  void emptyPrices() {
    double[] prices = {};

    int[] result = new DayTradeAnalyzer().getBiggestBenefitLinear(prices);
    assertEquals(0, result[0]);
    assertEquals(0, result[1]);
  }
}