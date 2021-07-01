package com.example.DemoRESTful.Reactive.usecase;

import com.example.DemoRESTful.Reactive.dto.DatoDTO;
import com.example.DemoRESTful.Reactive.mapper.MapperUtils;
import com.example.DemoRESTful.Reactive.modelo.Dato;
import com.example.DemoRESTful.Reactive.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCrear implements GuardarDato {
    private final Repositorio repositorio;
    private final MapperUtils mapperUtils;
    @Autowired
    public UseCaseCrear(MapperUtils mapperUtils, Repositorio repositorio) {
        this.repositorio = repositorio;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(DatoDTO datoDTO) {
        return repositorio.save(mapperUtils.mapperToDato(null).apply(datoDTO)).map(Dato::getId);
    }
}