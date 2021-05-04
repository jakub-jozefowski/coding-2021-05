# Day Trading

[Wikipedia](https://en.wikipedia.org/wiki/Day_trading):

>Buying and selling financial instruments within the same trading day, such that all positions are closed before the market closes for the trading day

Given a time series representing the successive prices reached by a security during a day, what is the best benefit that a day trader could have obtained? **_(without shorting: Buy before Sell)_**

**Example:**
```
double prices[] = {13.0D, 14.0D, 12.0D, 9.0D, 9.5D, 11.0D, 8.0D, 9.0D};
```
Here the best benefit is obtained between 3 (`9.0D`) and 5 (`11.0D`): benefit = prices[5] - prices[3] = `11.0D` - `9.0D` = `2.0D`

**Exercise:** write a function that accepts a time series and returns a best trade (achieving the best benefit), as described by its Buy and Sell times.

1) Present a simple, brute-force solution.
2) Discuss whether the solution is optimal and why.
3) If applicable, try and come up with a better solution.
