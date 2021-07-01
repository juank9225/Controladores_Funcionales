package com.example.DemoRESTful.Reactive.usecase;

import com.example.DemoRESTful.Reactive.dto.DatoDTO;
import com.example.DemoRESTful.Reactive.mapper.MapperUtils;
import com.example.DemoRESTful.Reactive.modelo.Dato;
import com.example.DemoRESTful.Reactive.repositorio.Repositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class UseCaseListar implements Supplier<Flux<DatoDTO>> {
    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;
    public UseCaseListar(MapperUtils mapperUtils, Repositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<DatoDTO> get() {
        return repositorio.findAll().map(mapperUtils.mapDatoToDTO());
    }
}