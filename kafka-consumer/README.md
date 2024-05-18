## Kafka Docker Setting
1. docker-compose.yml 파일 생성
```bash
vi docker-compose.yml
```
```yml
version: '2'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    container_name: zookeeper
    ports:
      - "2181:2181"
  kafka:
    image: wurstmeister/kafka
    container_name: kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_HOST_NAME: 127.0.0.1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    volumes:
      - /var/run/docker.sock:/var/run/docker.sock
```
2. docker-compose 실행
```bash
docker-compose up -d
```

## Kafka Simple Test
1. kafka-consumer 모듈 KafkaConsumerApplication 실행
2. kafka-producer 모듈 KafkaProducerTest 실행
3. kafka-consumer 모듈에서 메시지 확인

## Kafka 3.0 Producer Default Setting
- enable.idempotent=true
- acks = all

[카프카 프로듀서의 acks=all 옵션은 사실(?) 느리지 않다!](https://blog.voidmainvoid.net/507)

## Spring Boot 3.0 Migration
- Spring Framework 6부터 ListenableFuture가 Deprecated 되었음
- ListenableFuture -> CompletableFuture로 변경

https://multifrontgarden.tistory.com/302

## Reference
- [신뢰성 있는 카프카 애플리케이션을 만드는 3가지 방법 (최원영 Cory)](https://youtu.be/7_VdIFH6M6Q?si=Sfm4yPhjkdswNYaK)
- [kafka 조금 아는 척하기 1 (개발자용)](https://youtu.be/0Ssx7jJJADI?si=pBBCatkY9IOhR0rs)