package com.grepiu.sample.webflux.process.controller;

import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.domain.DefaultSearch;
import com.grepiu.sample.webflux.process.entity.Sample;
import com.grepiu.sample.webflux.process.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

  private Logger log = LoggerFactory.getLogger(SampleController.class);

  private SampleService sampleService;

  public SampleController(SampleService sampleService) {
    this.sampleService = sampleService;
  }

  public void saveSample() {

  }

  /**
   * Sample 데이터를 가져온다.
   *
   * @return Flux<Sample>
   */
  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<Sample> getSamples(DefaultSearch search) {
    return sampleService.getFindAll(search);
  }

  @GetMapping(path = "/{no}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Mono<ResponseEntity<Sample>> getSampleByNo(@PathVariable("no") String id) {
    return sampleService.findById(id)
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**
   *
   * 샘플 데이터를 가져온다.
   *
   * @return Flux<String>
   * @throws Exception
   */
  @GetMapping("/list")
  public Flux<String> getSampleList() throws Exception {
    return sampleService.getSample();
  }
}
