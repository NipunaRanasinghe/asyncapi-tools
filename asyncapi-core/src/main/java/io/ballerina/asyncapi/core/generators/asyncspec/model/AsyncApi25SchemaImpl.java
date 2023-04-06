package io.ballerina.asyncapi.core.generators.asyncspec.model;


/**
 * In Apicurio data model they are using JsonNodes for bindings
 * therefore we have to convert Java object to a Jackson ObjectNode we have to use new ObjectMapper()
 * <p>
 * This {@code AsyncApi25SchemaImpl} contains details related to AsyncApi25SchemaImpl. It has overrided the original
 * Apicurio isEntity method and set it into false, then it will not be printed. Reason because this is in the
 * original, entity attribute has become true by default and it is also printing in the asyncapi definition when using
 * jackson's objectmapper
 *
 * @since 2.0.0
 */

public class AsyncApi25SchemaImpl extends io.apicurio.datamodels.models.asyncapi.v25.AsyncApi25SchemaImpl {

    @Override
    public boolean isEntity() {
        return false;
    }
}
