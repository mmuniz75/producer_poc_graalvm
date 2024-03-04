package lab.plates.producer.config;


import com.google.protobuf.DescriptorProtos;
import io.confluent.kafka.schemaregistry.client.rest.entities.Schema;
import io.confluent.kafka.schemaregistry.client.rest.entities.SchemaReference;
import io.confluent.kafka.schemaregistry.client.rest.entities.SchemaString;
import io.confluent.kafka.schemaregistry.client.rest.entities.requests.RegisterSchemaRequest;
import io.confluent.kafka.schemaregistry.client.rest.entities.requests.RegisterSchemaResponse;
import io.confluent.kafka.serializers.context.NullContextNameStrategy;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufDeserializer;
import io.confluent.kafka.serializers.protobuf.KafkaProtobufSerializer;
import io.confluent.kafka.serializers.subject.DefaultReferenceSubjectNameStrategy;
import io.confluent.kafka.serializers.subject.TopicNameStrategy;
import lab.plates.producer.proto.Plate;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@Configuration
@ImportRuntimeHints(GraalVMConfig.class)
@RegisterReflectionForBinding({
        RegisterSchemaRequest.class,
        RegisterSchemaResponse.class,
        Plate.class
})
public class GraalVMConfig implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {

        kafkaHints(hints);
        kafkaProtoBuf(hints);
        protoBufBusinessHints(hints);
    }

    private void kafkaHints(RuntimeHints hints) {
        hints.reflection().registerType(NullContextNameStrategy.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(NullContextNameStrategy.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(TopicNameStrategy.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(TopicNameStrategy.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(Schema.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(Schema.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(SchemaString.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(SchemaString.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(SchemaReference.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(SchemaReference.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DefaultReferenceSubjectNameStrategy.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DefaultReferenceSubjectNameStrategy.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(io.confluent.kafka.schemaregistry.client.rest.entities.ErrorMessage.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(io.confluent.kafka.schemaregistry.client.rest.entities.ErrorMessage.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(RegisterSchemaRequest.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(RegisterSchemaRequest.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(RegisterSchemaResponse.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(RegisterSchemaResponse.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);



    }

    private void kafkaProtoBuf(RuntimeHints hints){

        //Serializers
        hints.reflection().registerType(KafkaProtobufDeserializer.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(KafkaProtobufDeserializer.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(KafkaProtobufSerializer.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(KafkaProtobufSerializer.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        //To create Protobuf
        hints.reflection().registerType(DescriptorProtos.FieldOptions.Builder.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FieldOptions.Builder.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.FieldOptions.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FieldOptions.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.FieldOptions.newBuilder().getCtype().getClass(), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FieldOptions.newBuilder().getCtype().getClass(), MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.FieldOptions.newBuilder().getJstype().getClass(), MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FieldOptions.newBuilder().getJstype().getClass(), MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.UninterpretedOption.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.UninterpretedOption.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.MessageOptions.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.MessageOptions.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.MessageOptions.Builder.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.MessageOptions.Builder.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.FileOptions.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FileOptions.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.FileOptions.Builder.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FileOptions.Builder.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.FileOptions.OptimizeMode.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.FileOptions.OptimizeMode.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.EnumValueOptions.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.EnumValueOptions.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.EnumValueOptions.Builder.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.EnumValueOptions.Builder.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.EnumOptions.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.EnumOptions.class, MemberCategory.INVOKE_DECLARED_METHODS);

        hints.reflection().registerType(DescriptorProtos.EnumOptions.Builder.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
        hints.reflection().registerType(DescriptorProtos.EnumOptions.Builder.class, MemberCategory.INVOKE_DECLARED_METHODS);
    }

    private void protoBufBusinessHints(RuntimeHints hints){

        hints.reflection().registerType(Plate.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(Plate.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

        hints.reflection().registerType(Plate.Builder.class, MemberCategory.INVOKE_DECLARED_METHODS);
        hints.reflection().registerType(Plate.Builder.class, MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);

    }

}
