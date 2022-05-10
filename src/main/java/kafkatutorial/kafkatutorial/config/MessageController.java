package kafkatutorial.kafkatutorial.config;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author Reinaldo Neves
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private KafkaTemplate<String,String> kafkaTemplate;

    /***
     * This is where the magik happens.
     * Your API can be consumed By any other API and send messages to any topic!
     * TODO: Maybe you can receive your topic by parameter too, as well as the message.
     */
    @PostMapping
    public void publish(@RequestBody MessageRequest request){
        kafkaTemplate.send("naldosTopic", request.message());
    }

}
