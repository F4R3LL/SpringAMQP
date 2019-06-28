package eu.cashsystemes.microservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer
{
	private	String	name = "NoName";

	public	String	get_Name()
	{
		return (this.name);
	}
	public	void	set_Name(String value)
	{
		this.name = value;
	}
 
	@RabbitListener(queues = {"${queue.coucou3.name}"})
	public void receive(@Payload String msg)
	{	
		System.out.println("Reçu(3) -> " + msg);
	}

//    
//	@RabbitListener(queues = {"${queue.coucou.name}"})
//	public void receive(@Payload String msg)
//	{	
//		System.out.println("Reçu(3) -> : " + msg);
//	}
	
	@RabbitListener(queues = {"${queue.comment_cava.name}"})
	@SendTo("queue.comment_cava.name")
	public String receive_comment_cava()
	{	
		System.out.println("Consumer(3) -> [Queue : comment_cava]");
		
		return ("Consumer [ 3 ] : I'm good.");
	}
	
	@RabbitListener(queues = {"${queue.getName.name}"})
	@SendTo("queue.getName.name")
	public String getNameRequest()
	{	
		System.out.println("Consumer3 -> [getName Request]");
		
		return ("Consumer3 : " + get_Name());
	}
	
	@RabbitListener(queues = {"${queue.setName.name}"})
	public void setNameRequest(@Payload String value)
	{	
		System.out.println("Reçu 3 - " + value + " name = " + get_Name());
		set_Name(value);
		System.out.println("Reçu 3 - name = " + get_Name());
	}
}