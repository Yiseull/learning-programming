package com.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webflux.dto.CheckNicknameResponse;

import reactor.core.publisher.Mono;

@RestController
public class WebfluxController {

	private final WebClientComponent webClientComponent;

	public WebfluxController(final WebClientComponent webClientComponent) {
		this.webClientComponent = webClientComponent;
	}

	@GetMapping
	public Mono<String> get() {
		return Mono.just("Hello World");
	}

	@PostMapping("/check/nickname")
	public Mono<CheckNicknameResponse> checkNickname(@RequestParam String nickname) throws JsonProcessingException {
		return webClientComponent.checkNickname(nickname);
	}
}
