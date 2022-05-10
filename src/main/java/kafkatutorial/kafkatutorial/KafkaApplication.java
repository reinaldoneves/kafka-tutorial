package kafkatutorial.kafkatutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	/***
	 * This is a command line runner which will be executed after the application is started.
	 * @param kafkaTemplate - The template to send the message to the kafka topic.
	 * You need to tell to the template what topic you want to send the message to, and what message you want to send.
	 *                      Here I'm sending a message to the topic "naldosTopic" with the message "Hello Kafka - Fora Bolsonaro".
	 * @return
	 */
	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {

			for (int i = 0; i < 10000; i++) {
				kafkaTemplate.send("naldosTopic", "Hello Kafka - Bolsonaro, o genocida miliciano disse até hoje um total de " + i + " MERDAS." +
						"\n" +"Seu recorde é de " + i + " MERDAS ABSURDAS.");
			}
		};
//		TODO: run this cmd at kafka partition to consume this topic:
//		$ bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
	}
}
