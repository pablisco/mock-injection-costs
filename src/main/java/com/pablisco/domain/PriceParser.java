package com.pablisco.domain;

import java.math.BigDecimal;

class PriceParser {

    private static Price.Currency parseCurrency(String currencyString) {
        switch (currencyString) {
            case "USD":
                return Price.Currency.DOLLAR;
            case "GBP":
                return Price.Currency.STERLING;
            case "EUR":
                return Price.Currency.EURO;
            default:
                return Price.Currency.UNKNOWN;
        }
    }

    Price parse(String data) {
        String currencyString = data.substring(data.length() - 3, data.length());
        String amountValue = data.substring(0, data.length() - 3);
        return new Price(
                parseCurrency(currencyString),
                new BigDecimal(amountValue)
        );
    }

}
