package com.grepiu.sample.webflux;

import com.grepiu.sample.webflux.process.dao.SampleRepository;
import com.grepiu.sample.webflux.process.entity.Sample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

		GreetingWebClient gwc = new GreetingWebClient();
		System.out.println(gwc.getResult());
	}

	CommandLineRunner execute(SampleRepository sampleRepository) {
		return args -> {
			Flux<Sample> samples = Flux.just(
					new Sample("테스트1", "아무개", "내용"),
					new Sample("테스트2", "아무개2", "내용2")
			).flatMap(sampleRepository::save);

			samples
					.thenMany(sampleRepository.findAll())
					.subscribe(System.out::println);
		};
	}
}
