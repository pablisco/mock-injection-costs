package com.pablisco;

import com.pablisco.data.ApiClient;
import com.pablisco.domain.Service;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.mock;

class ExplicitMockServiceFactory {

    Service build() {
        ApiClient client = mock(ApiClient.class);
        return new Service(client);
    }

}
