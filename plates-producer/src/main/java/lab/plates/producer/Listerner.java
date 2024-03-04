package lab.plates.producer;


import lab.plates.producer.proto.Plate;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Listerner {

    @KafkaListener(topics = "plates",
            properties = "specific.protobuf.value.type: lab.plates.producer.proto.Plate",
            concurrency = "1")
    public void consumeDfVehicleInfo(ConsumerRecord<String, Plate> message, Acknowledgment ack) {
        System.out.println("Received plate: " + message.value().getPlate());
    }
}
