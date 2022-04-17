package team4.tictactoe.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RequestFormatter {
    public static String formatMessage(Object object, String type) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode newObjectNode = objectMapper.createObjectNode();
        newObjectNode.putPOJO("data", object);
        newObjectNode.put("type", type);
        return newObjectNode.toString();
    }
}
