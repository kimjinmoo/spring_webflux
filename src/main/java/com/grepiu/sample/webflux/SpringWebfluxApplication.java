package com.grepiu.sample.webflux;

import com.grepiu.sample.webflux.config.GreetingWebClient;
import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

/**
 *
 * Spring Webflux Sample
 *
 */
@SpringBootApplication
public class SpringWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxApplication.class, args);
	}

	@Bean
	CommandLineRunner execute(SampleRepository sampleRepository) {
		// sample 데이터를 저장한다.
		return args -> {
			if (sampleRepository.findAll().toStream().count() == 0) {
				Flux<Sample> samples = Flux.just(
						new Sample("테스트1", "아무개", "내용")
				).flatMap(sampleRepository::save);

				samples
						.thenMany(sampleRepository.findAll())
						.subscribe(
								sample -> System.out.println("insert Data : " + sample.toString())
						);
			}
		};
	}
}
