package com.pablisco.domain;

import com.pablisco.data.ApiClient;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;

import static com.pablisco.domain.ServiceFixtures.*;
import static com.pablisco.tests.MockitoExtensions.stub;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class ExplicitServiceTest {

    @Test
    public void shouldProvideName() {
        Service service = givenAService_withClient(apiClientStub(c -> { }));

        String name = service.getName();

        assertThat(name).isEqualTo("Service");
    }

    @Test
    public void shouldFetchData_fromApiClient() {
        Service service = givenAService_withClient(
                apiClientStub(c -> given(c.fetchAll()).willReturn(API_DATA))
        );

        List<Item> items = service.fetchAllItems();

        assertThat(items).containsOnly(ITEM_1, ITEM_2);
    }

    @Test
    public void shouldReturnNothing_whenApiClientFails() {
        Service service = givenAService_withClient(
                apiClientStub(c -> given(c.fetchAll()).willThrow(RuntimeException.class))
        );

        List<Item> items = service.fetchAllItems();

        assertThat(items).isEmpty();
    }

    private ApiClient apiClientStub(Consumer<ApiClient> f) {
        ApiClient client = stub(ApiClient.class);
        f.accept(client);
        return client;
    }

    private Service givenAService_withClient(ApiClient client) {
        return new Service(client);
    }

}