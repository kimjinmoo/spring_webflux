package com.grepiu.sample.webflux.process.dao;

import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 *
 * ReactiveMongoRepository 생성한다.
 *
 */
public interface SampleRepository extends ReactiveMongoRepository<Sample, Integer> {
}
