package com.webflux;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webflux.dto.CheckNicknameResponse;

import reactor.core.publisher.Mono;

@Component
public class WebClientComponent {

	private final ObjectMapper objectMapper;

	public WebClientComponent(final ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public Mono<CheckNicknameResponse> checkNickname(final String nickname) throws JsonProcessingException {
		return WebClient.create("https://api.uju-lime.shop").post()
			.uri("/api/members/check/nickname")
			.contentType(MediaType.APPLICATION_JSON)
			.bodyValue(objectMapper.writeValueAsString(Map.of("nickname", nickname)))
			.retrieve()
			.bodyToMono(CheckNicknameResponse.class);
	}
}
