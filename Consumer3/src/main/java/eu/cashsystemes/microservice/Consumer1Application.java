package eu.cashsystemes.microservice;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Consumer1Application {

	@Value("${queue.coucou3.name}")
	private String coucou3Queue;
	
	@Value("${queue.comment_cava.name}")
	private String commentCava;
	
	@Value("${queue.getName.name}")
	private String getNameQ;

	@Value("${queue.setName.name}")
	private String setNameQ;

	public static void main(String[] args) {
		SpringApplication.run(Consumer1Application.class, args);
	}

	@Bean
	public Queue coucou()
	{
		return new Queue(coucou3Queue, true);
	}

	@Bean
	public Queue comment_cava()
	{
		return new Queue(commentCava, true);
	}

	@Bean
	public Queue get_Name()
	{
		return new Queue(getNameQ, true);
	}

	@Bean
	public Queue set_Name()
	{
		return new Queue(setNameQ, true);
	}
}
