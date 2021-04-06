package com.learning.reactive.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learning.reactive.service.QualifierTest;
import com.learning.reactive.service.ReactiveTestService;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import javax.inject.Inject;
import javax.inject.Named;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Configuration
public class MyRoutes {

	@Inject
	private ReactiveTestService reactiveTestService;

	@Inject
	private @Named("q1") QualifierTest qualifier1;

	@Inject
	private @Named("q2") QualifierTest qualifier2;

	@Bean
	RouterFunction<ServerResponse> getHome() {
		return route(GET("/"), request -> ok().body(fromValue("Home page")));
	}

	@Bean
	RouterFunction<ServerResponse> getObject() {
		return route(GET("/getObj"), resp -> reactiveTestService.getResult());
	}

	@Bean
	RouterFunction<ServerResponse> getQ1() {
		return route(GET("/getQ1"), resp -> qualifier1.getQulaifierData());
	}

	@Bean
	RouterFunction<ServerResponse> getQ2() {
		return route(GET("/getQ2"), resp -> qualifier2.getQulaifierData());
	}
}
