package kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//@Service
public class Receiver {

    @KafkaListener(topics = {"cameratopic1", "cameratopic2"})
    public void receive(@Payload SensorRecord SensorRecord,
                        @Headers MessageHeaders headers) {
        double speed = 0.5 / (SensorRecord.second * 3600);
        double fee = 0;
        if (speed > 71 && speed < 77) {
            fee = 25.00;
        }
        if (speed > 76 && speed < 83) {
            fee = 45.00;
        }
        if (speed > 82 && speed < 91) {
            fee = 85.00;
        }
        if (speed > 90) {
            fee = 125.00;
        }
        System.out.println("received message=" + SensorRecord.toString());
    }

}