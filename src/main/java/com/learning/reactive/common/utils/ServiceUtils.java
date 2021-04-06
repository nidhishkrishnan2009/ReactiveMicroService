package com.learning.reactive.common.utils;

import javax.inject.Named;

import com.learning.reactive.dto.ReactiveTestDto;

@Named
public class ServiceUtils {

	public ReactiveTestDto setData(String data) {
		final ReactiveTestDto r = new ReactiveTestDto();
		r.setData(data);
		r.setId(1);
		return r;
	}
}
