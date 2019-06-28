package eu.cashsystemes.microservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer
{
	@RabbitListener(queues = {"${queue.coucou2.name}"})
	public void receive(@Payload String msg)
	{	
		System.out.println("Reçu(2) -> " + msg);
	}
	
	@RabbitListener(queues = {"${queue.comment_cava.name}"})
	@SendTo("queue.comment_cava.name")
	public String receive_comment_cava()
	{	
		System.out.println("Consumer(2) -> [Queue : comment_cava]");
		
		return ("Consumer [ 2 ] : Impec' !");
	}
}