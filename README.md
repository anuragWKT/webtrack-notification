# webtrack-notification
Start ZooKeeper

cd kafka_2.13-3.6.2
bin/zookeeper-server-start.sh config/zookeeper.properties

Start Kafka broker
cd kafka_2.13-3.6.2
bin/kafka-server-start.sh config/server.properties

Create topics
cd kafka_2.13-3.6.2
bin/kafka-topics.sh --create --topic allocation-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
bin/kafka-topics.sh --create --topic leave-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
bin/kafka-topics.sh --create --topic timelog-events --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

/home/anurag-shetty/mailhog
MailHog UI at http://localhost:8025