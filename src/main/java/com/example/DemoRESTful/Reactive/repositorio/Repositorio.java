package com.example.DemoRESTful.Reactive.repositorio;

import com.example.DemoRESTful.Reactive.modelo.Dato;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Repositorio extends ReactiveMongoRepository<Dato, String> {
}