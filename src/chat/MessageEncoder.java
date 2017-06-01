package chat;

import javax.websocket.Encoder;


import com.google.gson.Gson;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.util.logging.Logger;
/**
 * Created by Serug on 01.06.2017.
 */
public class MessageEncoder implements Encoder.Text<Message> {
    private final Logger log = Logger.getLogger(getClass().getName());

    @Override
    public String encode(Message message) throws EncodeException {
        log.info("converting message obj to json format");

        Gson gson = new Gson();
        String json = gson.toJson(message);
        return json;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // do nothing
    }

    @Override
    public void destroy() {
        // do nothing
    }
}
