package spring.kafka.broker.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.kafka.broker.producer.KafkaProducer;


@RestController
@RequestMapping("/api/v1")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostMapping(value = "/send")
    public String sendMessage(@RequestParam("message") String message) {
        kafkaProducer.sendMessageToTopic(message);
        return "Message sent Successfully to the your learning-station-topic ";
    }

}