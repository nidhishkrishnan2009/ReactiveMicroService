package com.learning.reactive.serviceimpl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.reactive.function.server.ServerResponse;

import com.learning.reactive.common.utils.ServiceUtils;
import com.learning.reactive.dto.ReactiveTestDto;
import com.learning.reactive.service.QualifierTest;

import reactor.core.publisher.Mono;

@Named("q1")
public class Qualifier1 implements QualifierTest {

	@Inject
	private ServiceUtils utils;

	@Override
	public Mono<ServerResponse> getQulaifierData() {		
		Mono<ReactiveTestDto> m = Mono.just(utils.setData("qualifier1"));
		return ServerResponse.ok().body(m, ReactiveTestDto.class);
	}

}
