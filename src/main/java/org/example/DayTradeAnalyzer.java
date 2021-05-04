package org.example;

public class DayTradeAnalyzer {

  int[] getBiggestBenefitLinear(double[] prices) {
    int bestBuyIndex = 0;
    int bestSellIndex = 0;

    double benefit = 0;

    int lowestBuyIndex = 0;

    for (int i = 0; i < prices.length; i++) {
      double currentPrice = prices[i];

      double lowestPrice = prices[lowestBuyIndex];
      if (currentPrice < lowestPrice) {
        lowestBuyIndex = i;
        lowestPrice = prices[i];
      }

      double currentBenefit = currentPrice - lowestPrice;
      if (currentBenefit > benefit) {
        benefit = currentBenefit;

        bestBuyIndex = lowestBuyIndex;
        bestSellIndex = i;
      }
    }

    return new int[]{bestBuyIndex, bestSellIndex};
  }

  int[] getBiggestBenefitBrute(double[] prices) {
    int bestBuyIndex = 0;
    int bestSellIndex = 0;

    double highestBenefit = 0;

    double buy;
    double sell;

    for (int i = 0; i < prices.length; i++) {
      buy = prices[i];

      for (int j = i + 1; j < prices.length; j++) {
        sell = prices[j];

        double benefit = sell - buy;
        if (benefit > highestBenefit) {
          bestBuyIndex = i;
          bestSellIndex = j;

          highestBenefit = benefit;
        }
      }
    }

    return new int[]{bestBuyIndex, bestSellIndex};
  }
}
