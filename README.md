# first-rabbit-mq

##How it start:
### Prepere Env to run

#### Link with docker image
    
    https://hub.docker.com/r/library/rabbitmq

##### run with webconsole
```
docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 4369:4369 -p 5671:5671 -p 5672:5672 -p 25672:25672 rabbitmq:3-management
```

##### goto RabbitMQ 

**create exchange:** myExchange

**create routingKey:** testRoute

**create queue:** myQueue
		
#### run Producer
#### run Receiver
		
	
	
