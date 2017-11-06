package com.pablisco.domain;

import com.pablisco.data.ApiClient;
import com.pablisco.data.ApiData;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class Service {

    private static final String NAME = "Service";

    private final ApiClient client;
    private final ItemParser itemParser;

    public Service(ApiClient client) {
        this.client = client;
        this.itemParser = new ItemParser();
    }

    public String getName() {
        return NAME;
    }

    public List<Item> fetchAllItems() {
        try {
            return client.fetchAll()
                    .getItems()
                    .stream()
                    .map(itemParser::parse)
                    .collect(toList());
        } catch (Exception e) {
            return emptyList();
        }
    }

}
