package lab.plates.producer.producer;



import lab.plates.producer.proto.Plate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;


@Configuration
@RequiredArgsConstructor
@Slf4j
public class PlatesCheckerProducer {

    @Autowired
    private KafkaTemplate<String, Plate> kafkaTemplate;

    @Scheduled(fixedRate = 10000)
    public void platesToCheck() {
        getPlates().forEach(plate -> kafkaTemplate.send("plates", plate.getPlate(), plate));
    }

    private List<Plate> getPlates(){
        log.info("Sending 5 plates to topic");
        return List.of(
                Plate.newBuilder().setPlate("SIE7D3K").build(),
                Plate.newBuilder().setPlate("SIE7D4K").build(),
                Plate.newBuilder().setPlate("SIE7D5K").build(),
                Plate.newBuilder().setPlate("SIE7D6K").build(),
                Plate.newBuilder().setPlate("SIE7D7K").build()
        );
    }
}
