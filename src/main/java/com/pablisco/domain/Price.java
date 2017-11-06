package com.pablisco.domain;

import java.math.BigDecimal;

public class Price {

    public enum Currency {
        UNKNOWN, DOLLAR, STERLING, EURO
    }

    private final Currency currency;
    private final BigDecimal amount;

    Price(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        return currency == price.currency
                && amount.equals(price.amount);
    }

    @Override
    public int hashCode() {
        int result = currency.hashCode();
        result = 31 * result + amount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Price{" +
                "currency=" + currency +
                ", amount=" + amount +
                '}';
    }
}
