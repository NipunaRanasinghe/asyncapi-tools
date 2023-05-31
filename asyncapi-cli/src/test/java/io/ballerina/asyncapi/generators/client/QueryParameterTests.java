/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.ballerina.asyncapi.generators.client;

import io.apicurio.datamodels.models.asyncapi.v25.AsyncApi25DocumentImpl;
import io.ballerina.asyncapi.core.GeneratorUtils;
import io.ballerina.asyncapi.core.exception.BallerinaAsyncApiException;
import io.ballerina.asyncapi.core.generators.client.IntermediateClientGenerator;
import io.ballerina.asyncapi.core.generators.client.model.AASClientConfig;
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static io.ballerina.asyncapi.generators.common.TestUtils.compareGeneratedSyntaxTreeWithExpectedSyntaxTree;


/**
 * This tests class for the tests Query parameters in swagger file.
 */
public class QueryParameterTests {
    private static final Path RES_DIR = Paths.get("src/test/resources/generators/client").toAbsolutePath();
    List<String> list1 = new ArrayList<>();
    List<String> list2 = new ArrayList<>();
    SyntaxTree syntaxTree;

    @Test(description = "Generate Client for query parameter has default value")
    public void generateQueryParamWithDefault() throws IOException, BallerinaAsyncApiException {
        Path definitionPath = RES_DIR.resolve("swagger/query_param_with_default_value.yaml");
        Path expectedPath = RES_DIR.resolve("ballerina/query_param_with_default_value.bal");

        AsyncApi25DocumentImpl openAPI = GeneratorUtils.normalizeAsyncAPI(definitionPath);
        AASClientConfig.Builder clientMetaDataBuilder = new AASClientConfig.Builder();
        AASClientConfig oasClientConfig = clientMetaDataBuilder
                .withAsyncAPI(openAPI).build();
        IntermediateClientGenerator intermediateClientGenerator = new IntermediateClientGenerator(oasClientConfig);
        syntaxTree = intermediateClientGenerator.generateSyntaxTree();
        compareGeneratedSyntaxTreeWithExpectedSyntaxTree(expectedPath, syntaxTree);
    }

    @Test(description = "Generate Client for query parameter without default value")
    public void generateQueryParamWithOutDefault() throws IOException, BallerinaAsyncApiException {
        Path definitionPath = RES_DIR.resolve("swagger/query_param_without_default_value.yaml");
        Path expectedPath = RES_DIR.resolve("ballerina/query_param_without_default_value.bal");

        AsyncApi25DocumentImpl openAPI = GeneratorUtils.normalizeAsyncAPI(definitionPath);
        AASClientConfig.Builder clientMetaDataBuilder = new AASClientConfig.Builder();
        AASClientConfig oasClientConfig = clientMetaDataBuilder
                .withAsyncAPI(openAPI).build();
        IntermediateClientGenerator intermediateClientGenerator = new IntermediateClientGenerator(oasClientConfig);
        syntaxTree = intermediateClientGenerator.generateSyntaxTree();
        compareGeneratedSyntaxTreeWithExpectedSyntaxTree(expectedPath, syntaxTree);
    }

    @Test(description = "Generate Client for query parameter with referenced schema")
    public void generateQueryParamWithReferencedSchema() throws IOException, BallerinaAsyncApiException {
        Path definitionPath = RES_DIR.resolve("swagger/query_param_with_ref_schema.yaml");
        Path expectedPath = RES_DIR.resolve("ballerina/query_param_with_ref_schema.bal");

        AsyncApi25DocumentImpl openAPI = GeneratorUtils.normalizeAsyncAPI(definitionPath);
        AASClientConfig.Builder clientMetaDataBuilder = new AASClientConfig.Builder();
        AASClientConfig oasClientConfig = clientMetaDataBuilder
                .withAsyncAPI(openAPI).build();
        IntermediateClientGenerator intermediateClientGenerator = new IntermediateClientGenerator(oasClientConfig);
        syntaxTree = intermediateClientGenerator.generateSyntaxTree();
        compareGeneratedSyntaxTreeWithExpectedSyntaxTree(expectedPath, syntaxTree);
    }

    @Test(description = "Generate query parameters when both apikeys and http/OAuth is supported")
    public void genQueryParamsForCombinationOfApiKeyAndHTTPOrOAuth() throws IOException, BallerinaAsyncApiException {
        Path definitionPath = RES_DIR.resolve("swagger/combination_of_apikey_and_http_oauth.yaml");
        Path expectedPath = RES_DIR.resolve("ballerina/combination_of_apikey_and_http_oauth.bal");

        AsyncApi25DocumentImpl openAPI = GeneratorUtils.normalizeAsyncAPI(definitionPath);
        AASClientConfig.Builder clientMetaDataBuilder = new AASClientConfig.Builder();
        AASClientConfig oasClientConfig = clientMetaDataBuilder
                .withAsyncAPI(openAPI).build();
        IntermediateClientGenerator intermediateClientGenerator = new IntermediateClientGenerator(oasClientConfig);
        syntaxTree = intermediateClientGenerator.generateSyntaxTree();
        compareGeneratedSyntaxTreeWithExpectedSyntaxTree(expectedPath, syntaxTree);
    }

    @Test(description = "Generate encoding map for query parameters")
    public void genQueryParamEncodingMap() throws IOException, BallerinaAsyncApiException {
        Path definitionPath = RES_DIR.resolve("swagger/queryparam_encoding_map_gen.yaml");
        Path expectedPath = RES_DIR.resolve("ballerina/queryparam_encoding_map_gen.bal");

        AsyncApi25DocumentImpl openAPI = GeneratorUtils.normalizeAsyncAPI(definitionPath);
        AASClientConfig.Builder clientMetaDataBuilder = new AASClientConfig.Builder();
        AASClientConfig oasClientConfig = clientMetaDataBuilder
                .withAsyncAPI(openAPI).build();
        IntermediateClientGenerator intermediateClientGenerator = new IntermediateClientGenerator(oasClientConfig);
        syntaxTree = intermediateClientGenerator.generateSyntaxTree();
        compareGeneratedSyntaxTreeWithExpectedSyntaxTree(expectedPath, syntaxTree);
    }

}
