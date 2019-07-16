package com.grepiu.sample.webflux;

import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

//@Component
public class Runner implements CommandLineRunner {

  @Autowired
  private SampleRepository sampleRepository;

  @Override
  public void run(String... args) throws Exception {

  }
}
