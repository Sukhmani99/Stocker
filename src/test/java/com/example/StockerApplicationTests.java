package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StockerApplicationTests {

    /* Test case to check if the getMaxProfit() returns the right trade with maximum profit*/
    @Test
    public void testGetMaxProfit()
    {
        int[] input = {3, 28, 1880, 36, 1, 2, 56, 2142};
        assertEquals("buying at $1 and selling at $2142 for a maximum profit of 2141", StockerApplication.getMaxProfit(input));
    }

    /* Test case to check if the getMaxProfit() returns the right response on invalid input values for stock price*/
    @Test
    public void testGetMaxProfitWithOneStockPriceOnly()
    {
        int[] input = {3};
        assertEquals("You need at least 1 buying price and 1 selling price to calculate max profit", StockerApplication.getMaxProfit(input));
    }

    /* Test case to check if the getMaxProfit() returns the right response on null input for stock price*/
    @Test
    public void testGetMaxProfitWithNullException()
    {
        int[] input = null;
        assertEquals("Invalid input for stock price list", StockerApplication.getMaxProfit(input));
    }
}
