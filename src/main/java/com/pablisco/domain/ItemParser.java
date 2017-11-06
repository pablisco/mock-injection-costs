package com.pablisco.domain;

import java.util.Map;

class ItemParser {

    private PriceParser priceParser = new PriceParser();

    Item parse(Map<String, String> data) {
        return new Item(data.get("id"), data.get("name"), priceParser.parse(data.get("price")));
    }

}
