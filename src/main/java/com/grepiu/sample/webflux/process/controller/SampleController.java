package com.grepiu.sample.webflux.process.controller;

import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sample")
public class SampleController {

  @Autowired
  private SampleRepository sampleRepository;

  /**
   * Sample 데이터를 가져온다.
   *
   * @return Flux<Sample>
   */
  @GetMapping
  public Flux<Sample> getSamples() {
    return sampleRepository.findAll();
  }

  @GetMapping("{no}")
  public Mono<ResponseEntity<Sample>> getSampleByNo(@PathVariable("no") Integer no) {
    return sampleRepository.findById(no)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }
}
