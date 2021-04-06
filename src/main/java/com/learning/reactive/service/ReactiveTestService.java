package com.learning.reactive.service;

import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface ReactiveTestService {

	Mono<ServerResponse> getResult();
}
