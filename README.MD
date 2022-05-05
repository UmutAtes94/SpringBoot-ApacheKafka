
#Apache Kafka - Spring Boot 

#### <ins>Dependency:
add the apache kafka dependency to pom.xml

```sh
<dependency>
	<groupId>org.springframework.kafka</groupId>
	<artifactId>spring-kafka</artifactId>
</dependency>  
```


#### <ins> KAFKA-ZOOKEEPER DOCKER COMPOSE:

```sh
version: '3.1'
services:
  fd-kafka:
    image: spotify/kafka
    ports:
      - "2181:2181" #zookeeper
      - "9092:9092" #kafka
    hostname: localhost
    container_name: kafka
    environment:
      - "ADVERTISED_HOST=localhost"
      - "ADVERTISED_PORT=9092"
      - "AUTO_CREATE_TOPICS=true"
    command: >
      bash -c
      "(sleep 15s &&
      /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh
      --create
      --zookeeper
      localhost:2181 --replication-factor 1 --partitions 1
      --topic kafkademo-topic &) && (supervisord -n)"
```


run the following command in your project path to run kafka-zookeeper container
```sh
docker-compose -f {projectPath}\src\main\resources\docker-compose.yml up -d
```

#### <ins>application.properties:
 add the following properties in your application.properties file.
 we will use these values in configuration and service class.
```sh
kafkademo.kafka.address = 127.0.0.1:9092
kafkademo.kafka.topic =kafkademo-topic
kafkademo.kafka.group.id=kafkademo-group
```

#### <ins>Configuration and Service Classes

We have 2 configuration classes under the config package.
- KafkaProducerConfig has configuration for Producer
- KafkaConsumerConfig has configuration for Consumer

We have KafkaListenerService to listen messages in kafka topic.
- We are using @KafkaListener annotation to listen topic. 

To send message to Kafka we use send() method in KafkaTemplate. (KafkaMessageSenderService)

####Sample Request:
endpoint: http://localhost:8080/kafkaDemo
method: POST
request: { "message": "first test messagea" }
