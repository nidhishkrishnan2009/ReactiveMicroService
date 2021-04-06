package com.learning.reactive.serviceimpl;

import javax.inject.Named;

import org.springframework.web.reactive.function.server.ServerResponse;

import com.learning.reactive.dto.ReactiveTestDto;
import com.learning.reactive.service.ReactiveTestService;

import reactor.core.publisher.Mono;

@Named
public class ReactiveTestServiceImpl implements ReactiveTestService {

	@Override
	public Mono<ServerResponse> getResult() {
		final ReactiveTestDto r=new ReactiveTestDto();
		r.setId(1);
		r.setData("Hello");
		return ServerResponse.ok().body(Mono.just(r),ReactiveTestDto.class);
	}

}
