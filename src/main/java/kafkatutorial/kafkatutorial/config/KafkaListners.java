package kafkatutorial.kafkatutorial.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListners {

    @KafkaListener(
            topics = "naldosTopic",
            groupId = "groupId")
    void listener(String data) {
        System.out.println("Listner received: " + data + "8========D ((_");
    }

}
