package com.example.DemoRESTful.Reactive.usecase;

import com.example.DemoRESTful.Reactive.dto.DatoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarDato {
    public Mono<String> apply(DatoDTO datoDTO);
}