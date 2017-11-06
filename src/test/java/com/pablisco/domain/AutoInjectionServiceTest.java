package com.pablisco.domain;

import com.pablisco.data.ApiClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static com.pablisco.domain.ServiceFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class AutoInjectionServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private ApiClient apiClient;

    private Service service;

    @Before
    public void setUp() {
        service = new Service(apiClient);
    }

    @Test
    public void shouldProvideName() {
        String name = service.getName();

        assertThat(name).isEqualTo("Service");
    }

    @Test
    public void shouldFetchData_fromApiClient() {
        given(apiClient.fetchAll()).willReturn(API_DATA);

        List<Item> items = service.fetchAllItems();

        assertThat(items).containsOnly(ITEM_1, ITEM_2);
    }

    @Test
    public void shouldReturnNothing_whenApiClientFails() throws Exception {
        given(apiClient.fetchAll()).willThrow(RuntimeException.class);

        List<Item> items = service.fetchAllItems();

        assertThat(items).isEmpty();
    }
}