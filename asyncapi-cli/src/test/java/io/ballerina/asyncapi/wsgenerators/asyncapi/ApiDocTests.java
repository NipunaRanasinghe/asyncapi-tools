/*
 *  Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
 *
 *  WSO2 LLC. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package io.ballerina.asyncapi.wsgenerators.asyncapi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This test class for the covering the unit tests for return type scenarios.
 */
public class ApiDocTests {
    private static final Path RES_DIR = Paths.get("src/test/resources/websockets" +
            "/ballerina-to-asyncapi").toAbsolutePath();
    private Path tempDir;

    @BeforeMethod
    public void setup() throws IOException {
        this.tempDir = Files.createTempDirectory("bal-to-asyncapi-test-out-" + System.nanoTime());
    }

    @Test(description = "Resource function api doc mapped to AAS operation summary")
    public void testsForResourceFunction() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/resource_function_scenario.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/resource_function.yaml");
    }

    @Test(description = "Resource function api doc mapped to AAS operation summary")
    public void testsForPathParameter() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/resource_function_with_pathparam_scenario.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/path_param.yaml");
    }

    @Test(description = "Query parameter api doc mapped to AAS parameter description")
    public void testsForQueryParameter() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/resource_function_with_queryparam_scenario.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/query_param.yaml");
    }

    @Test(description = "Request payload api doc mapped to AAS requestBody description")
    public void testsForRequestPayload() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/resource_function_with_request_scenario.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/request.yaml");
    }

    @Test(description = "Record api doc mapped to AAS record description")
    public void testsForRecord() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/record.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/record.yaml");
    }

    @Test(description = "TypeInclusion record api doc mapped to AAS description")
    public void testsForRecordHasTypeInclusion() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/typeInclusion.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/typeInclusion.yaml");
    }

    @Test(description = "Reference scenarios")
    public void testsForReferenceScenario() throws IOException {
        Path ballerinaFilePath = RES_DIR.resolve("apidoc/reference_scenario.bal");
        TestUtils.compareWithGeneratedFile(ballerinaFilePath, "apidoc/reference_scenario.yaml");
    }

    @AfterMethod
    public void cleanUp() {
        TestUtils.deleteDirectory(this.tempDir);
    }

    @AfterTest
    public void clean() {
        System.setErr(null);
        System.setOut(null);
    }
}
