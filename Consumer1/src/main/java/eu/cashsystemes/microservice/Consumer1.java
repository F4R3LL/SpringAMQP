package eu.cashsystemes.microservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer1
{
	@RabbitListener(queues = {"${queue.coucou.name}"})
	public void receive(@Payload String msg)
	{	
		System.out.println("Reçu(1) -> " + msg);
	}
	
	@RabbitListener(queues = {"${queue.comment_cava.name}"})
	@SendTo("queue.comment_cava.name")
	public String receive_comment_cava()
	{	
		System.out.println("Consumer(1) -> comment_cava?");
		
		return ("Consumer [ 1 ] : Oh caralho !");
	}
}