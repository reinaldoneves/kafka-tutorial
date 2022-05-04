package kafkatutorial.kafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    /**
     * AmigosCode Kafka Study
    * https://youtu.be/SqVfCyfCJqw?t=1241
     */
    @Bean
    public NewTopic naldosTopic() {
        return TopicBuilder.name("naldosTopic").build();
    }

}
