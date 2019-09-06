package com.grepiu.sample.webflux.process.service;

import com.grepiu.sample.webflux.process.domain.DefaultSearch;
import com.grepiu.sample.webflux.process.entity.Sample;
import java.util.HashMap;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SampleService {

  public Flux<Sample> getFindAll(DefaultSearch search);

  public Mono<Sample> findById(String id);

  public Flux<String> getSample() throws Exception;
}

