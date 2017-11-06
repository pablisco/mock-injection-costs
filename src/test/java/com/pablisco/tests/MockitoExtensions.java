package com.pablisco.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

public class MockitoExtensions {

    public static <T> T stub(Class<T> type) {
        return mock(type, withSettings().stubOnly());
    }

}
