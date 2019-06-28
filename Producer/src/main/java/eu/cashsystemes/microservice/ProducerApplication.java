package eu.cashsystemes.microservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class ProducerApplication {
	
	@Value("${queue.coucou.name}")
	private String coucouQueue;
	@Value("${queue.coucou2.name}")
	private String coucou2Queue;
	@Value("${queue.coucou3.name}")
	private String coucou3Queue;
	
	
	@Value("${queue.comment_cava.name}")
	private String commentCava;
	
	@Value("${queue.getName.name}")
	private String getNameQ;
	
	@Value("${queue.setName.name}")
	private String setNameQ;
	
	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}


	@Bean
	public FanoutExchange fanout()
	{
		return new FanoutExchange("test.fanout");
	}


	@Bean
	public Binding binding(FanoutExchange fanout, Queue coucou)
	{
	    return BindingBuilder.bind(coucou).to(fanout);
	}
	@Bean
	public Binding binding2(FanoutExchange fanout, Queue coucou2)
	{
	    return BindingBuilder.bind(coucou2).to(fanout);
	}
	@Bean
	public Binding binding3(FanoutExchange fanout, Queue coucou3)
	{
	    return BindingBuilder.bind(coucou3).to(fanout);
	}

	@Bean
	public Queue coucou()
	{
		return new Queue(coucouQueue, true);
	}
	@Bean
	public Queue coucou2()
	{
		return new Queue(coucou2Queue, true);
	}
	@Bean
	public Queue coucou3()
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
