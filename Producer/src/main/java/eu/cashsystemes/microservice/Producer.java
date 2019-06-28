package eu.cashsystemes.microservice;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class Producer
{
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private FanoutExchange fanoutMsg;


	@Autowired
	private Queue comment_cava;
	@Autowired
	private Queue get_Name;
	@Autowired
	private Queue set_Name;


	@RequestMapping("/coucou")
	public void ola(@RequestParam(value="name", defaultValue="Default") String msg)
	{
		rabbitTemplate.convertAndSend(fanoutMsg.getName(), "", msg);
		System.out.println("Fanout -> " + msg);
	}
	
	@RequestMapping("/comment_cava")
	public void olala()
	{
		System.out.println("sender : ");
	
		String response = (String) rabbitTemplate.convertSendAndReceive(this.comment_cava.getName(), " ");
		
		System.out.println("Received from : " + response);
	}
	
	@RequestMapping("/getName")
	public void get_Name()
	{
		System.out.println("Send -> Name Request...");
	
		String response = (String) rabbitTemplate.convertSendAndReceive (this.get_Name.getName(), " ");
		
		System.out.println("GetName : [ " + response + " ]");
	}
	
	@RequestMapping("/setName")
	public void set_Name(@RequestParam(value="name", defaultValue="bob") String msg)
	{
		System.out.println("setName : " + msg);
		rabbitTemplate.convertAndSend(this.set_Name.getName(), msg);
	}
}
