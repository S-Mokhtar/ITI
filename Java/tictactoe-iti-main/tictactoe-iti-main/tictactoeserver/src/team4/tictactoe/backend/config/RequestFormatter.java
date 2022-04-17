package team4.tictactoe.backend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RequestFormatter {
    public static String formatMessage(Object object, String type, boolean success) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode newObjectNode = objectMapper.createObjectNode();
        newObjectNode.putPOJO(success ? "data" : "errors", object);
        newObjectNode.put("type", type);
        newObjectNode.put("success", success);
        return newObjectNode.toString();
    }
}
