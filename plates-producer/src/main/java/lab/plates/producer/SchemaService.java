package lab.plates.producer;


import io.confluent.kafka.schemaregistry.client.rest.RestService;
import org.springframework.stereotype.Service;

@Service
public class SchemaService {

    public void register(){
        RestService restService = new RestService("cfc_graalvm_poc-value");
    }
}
