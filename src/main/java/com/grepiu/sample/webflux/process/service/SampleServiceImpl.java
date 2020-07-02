package com.grepiu.sample.webflux.process.service;

import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.domain.DefaultSearch;
import com.grepiu.sample.webflux.process.entity.Sample;
import com.grepiu.sample.webflux.process.utils.SampleWorkers;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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
  public Flux<Sample> getFindAll() {
    return sampleRepository.findAll();
  }

  @Override
  public Mono<Sample> findById(String id) {
    return sampleRepository.findById(id);
  }

  @Override
  public Flux<String> getSample() throws Exception {
    Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
    Flux<String> flux = Flux.fromStream(Stream.generate(()->{
      return SampleWorkers.randomWorker();
    }));
    return Flux.zip(flux, interval, (key, value) -> key);
  }
}
