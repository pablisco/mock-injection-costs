package com.pablisco.domain;

import com.pablisco.data.ApiData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pablisco.domain.Price.Currency.DOLLAR;
import static com.pablisco.domain.Price.Currency.STERLING;

class ServiceFixtures {

    static final Item ITEM_1 = new Item("id_one", "One", new Price(STERLING, new BigDecimal(10.5)));
    static final Item ITEM_2 = new Item("id_two", "Two", new Price(DOLLAR, new BigDecimal(12.5)));
    static final ApiData API_DATA = new ApiData(createApiDataItems());

    private static List<Map<String, String>> createApiDataItems() {
        List<Map<String, String>> items = new ArrayList<>();
        HashMap<String, String> item1 = new HashMap<>();
        item1.put("id", "id_one");
        item1.put("name", "One");
        item1.put("price", "10.5GBP");
        items.add(item1);
        HashMap<String, String> item2 = new HashMap<>();
        item2.put("id", "id_two");
        item2.put("name", "Two");
        item2.put("price", "12.5USD");
        items.add(item2);
        return items;
    }

}
