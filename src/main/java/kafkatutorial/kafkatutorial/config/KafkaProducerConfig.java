package kafkatutorial.kafkatutorial.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> producerConfigs() {
        HashMap<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return props;
    }

    /***
     * If you want to send a custom class to Kafka, you need to specify here in this method the class name
     * at the value in the map. For now, it will be simply a String. (Maybe some day could be a Json?)
     * @return a ProducerFactory
     */
    public ProducerFactory<String, String> producerFactory() {
        return new org.springframework.kafka.core.DefaultKafkaProducerFactory<>(producerConfigs());
    }

}
