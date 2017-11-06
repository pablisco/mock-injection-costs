package com.pablisco.data;

import java.util.List;
import java.util.Map;

public class ApiData {

    private List<Map<String, String>> items;

    public ApiData(List<Map<String, String>> items) {
        this.items = items;
    }

    public List<Map<String, String>> getItems() {
        return items;
    }
}
