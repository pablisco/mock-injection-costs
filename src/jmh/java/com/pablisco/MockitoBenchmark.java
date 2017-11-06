package com.pablisco;

import com.pablisco.domain.Service;
import org.assertj.core.api.Assertions;
import org.openjdk.jmh.annotations.Benchmark;

public class MockitoBenchmark {

    @Benchmark
    public void measureInjectionMockito() {
        Service service = new InjectedMockServiceFactory().build();
        Assertions.assertThat(service).isNotNull();
    }

    @Benchmark
    public void measureExplicitMockito() {
        Service service = new ExplicitMockServiceFactory().build();
        Assertions.assertThat(service).isNotNull();
    }
}
