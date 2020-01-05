# SpringBootKafka

1. git clone https://github.com/lorenzolince/docker.git
2. cd docker/kafka
3. docker-compose pull
4. docker-compose up -d 
5. cd SpringBootKafka/modules/KafKaBootConsumer 
6. mvn clean install spring-boot:run
7. cd SpringBootKafka/modules/KafKaBootProducer
8. mvn clean install spring-boot:run 
9. localhost:8088/api/producer/mytext
