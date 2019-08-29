package com.grepiu.sample.webflux.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 *
 * WebFlux를 적용 한다.
 *
 */
@Configuration
@EnableWebFlux
public class WebfluxConfiguration implements WebFluxConfigurer {
}
