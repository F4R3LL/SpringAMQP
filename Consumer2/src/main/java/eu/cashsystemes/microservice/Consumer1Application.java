package eu.cashsystemes.microservice;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Consumer1Application {
	
	@Value("${queue.coucou2.name}")
	private String coucou2Queue;
	
	@Value("${queue.comment_cava.name}")
	private String commentCava;

	public static void main(String[] args) {
		SpringApplication.run(Consumer1Application.class, args);
	}
	
	@Bean
	public Queue coucou()
	{
		return new Queue(coucou2Queue, true);
	}

	@Bean
	public Queue comment_cava()
	{
		return new Queue(commentCava, true);
	}
}
