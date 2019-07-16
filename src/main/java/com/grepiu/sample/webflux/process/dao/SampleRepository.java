package com.grepiu.sample.webflux.process.dao;

import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * ReactiveMongoRepository 생성한다.
 *
 */
@Repository
public interface SampleRepository extends ReactiveMongoRepository<Sample, Integer> {
}
