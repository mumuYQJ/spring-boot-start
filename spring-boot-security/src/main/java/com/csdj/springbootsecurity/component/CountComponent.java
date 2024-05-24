package com.csdj.springbootsecurity.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CountComponent {

    private Counter counter;


    public CountComponent(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("yqj.hh");
    }

    public void count() {
        counter.increment();
    }
}
