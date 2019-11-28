package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The StockerApplication program implements an algorithm to find the
 * best trading window to maximise the profit for a stock observed over
 * it's varying sock prices throughout a day. The interval for stock price
 * capture is 1 minute from the time trade window stock market opens till
 * the time it closes for the day.
 *
 * @author  Sukhmani
 * @version 1.0
 * @since   27-11-2019
 */

@SpringBootApplication
public class StockerApplication {

    /**
     * Main function to execute the getMaxProfit in bootRun mode.
     */
    public static void main(final String[] args) {

        SpringApplication.run(StockerApplication.class, args);
        /* Sample input for stock prices */
        int[] input = {3, 28, 1880, 36, 1, 2, 56, 2142};
        System.out.println(getMaxProfit(input));
    }

    /**
     * Function to extract best trade and determine maximum profit for a stock.
     */
    public static String getMaxProfit(final int[] stockPrices) {
        try {

            /* Variable initialisations starts */
            int stockPriceLength = stockPrices.length;
            int buyingPrice = stockPrices[0];
            int profit = 0;
            int sellingPrice = stockPrices[1];
            int[] maxProfitForEachStockPrice = new int[stockPriceLength];
            int maxProfitIndex = 0;
            /* Variable initialisations starts */

            //First loop to iterate over the list of stock prices
            for (int i = 0; i < stockPriceLength; i++) {
                //
                //    Initialise a new array with next possible
                //    profit for stock bought at every stock price
                //
                if (i < stockPriceLength - 1) {
                    maxProfitForEachStockPrice[i] = stockPrices[i + 1] - stockPrices[i];
                }

                //
                //    Second loop to iterate over rest of the stock prices
                //    other than the current one and find their
                //    difference with the current one
                //
                for (int j = i + 1; j < stockPriceLength; j++) {
                    if (stockPrices[j] - stockPrices[i]
                            > maxProfitForEachStockPrice[i]) {
                        maxProfitForEachStockPrice[i] = stockPrices[j]
                                                            - stockPrices[i];
                    }
                    maxProfitForEachStockPrice[i]
                            = Math.max(maxProfitForEachStockPrice[i], stockPrices[j] - stockPrices[i]);
                }

                //
                //    Use the outer loop to find out the index of
                //    the stock price at which the trader makes
                //    maximum profit by selling it later
                //    This is the buying time inde
                //
                if (maxProfitForEachStockPrice[i]
                        > maxProfitForEachStockPrice[maxProfitIndex]) {
                    maxProfitIndex = i;
                }
            }
            /*
                Now using the array and the index of max profit
                we will get the max profit amount
            */
            profit = maxProfitForEachStockPrice[maxProfitIndex];
            //
            //    Since the maxProfitIndex corresponds to the
            //    price at which stock was bought we can
            //    initialise the buyingPrice
            //
            buyingPrice = stockPrices[maxProfitIndex];
            //
            //    Adding the buying price and profit will give
            //    us the selling price
            //
            sellingPrice = buyingPrice + profit;

            /* Returning the output of the algorithm */
            return "buying at $" + buyingPrice + " and selling at $"
                    + sellingPrice + " for a maximum profit of " + profit;
        } catch (Exception e) {
            // Exception clauses
            if (stockPrices == null) {
                return "Invalid input for stock price list";
            } else {
                return "You need at least 1 buying price "
                        + "and 1 selling price to calculate max profit";
            }
        }
    }
}
