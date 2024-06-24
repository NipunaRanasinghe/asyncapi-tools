package io.ballerina.asyncapi.cmd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AsyncAPIConstants {
    public static final Set<String> VALID_HTTP_NAMES = new HashSet<>(Arrays.asList("http", "https"));
    public static final Set<String> VALID_WS_NAMES = new HashSet<>(Arrays.asList("ws", "wss", "websocket"));

}
