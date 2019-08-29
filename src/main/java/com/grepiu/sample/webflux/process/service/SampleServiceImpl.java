package com.grepiu.sample.webflux.process.service;

import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.domain.DefaultSearch;
import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SampleServiceImpl implements SampleService {

  private SampleRepository sampleRepository;

  public SampleServiceImpl(SampleRepository sampleRepository) {
    this.sampleRepository = sampleRepository;
  }

  @Override
  public Flux<Sample> getFindAll(DefaultSearch search) {
    return sampleRepository.findAll();
  }

  @Override
  public Mono<Sample> findById(String id) {
    return sampleRepository.findById(id);
  }
}
