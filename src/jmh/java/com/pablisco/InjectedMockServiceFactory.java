package com.pablisco;

import com.pablisco.data.ApiClient;
import com.pablisco.domain.Service;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class InjectedMockServiceFactory {

    @Mock
    private ApiClient apiClient;

    InjectedMockServiceFactory() {
        MockitoAnnotations.initMocks(this);
    }

    Service build() {
        return new Service(apiClient);
    }

}
