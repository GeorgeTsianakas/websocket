package websocket;

import java.io.IOException;
import java.util.Set;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class ServerEndpointClass {

    private SessionRegistry registry = SessionRegistry.getInstance();

    @OnOpen
    public void onOpen(Session session, EndpointConfig conf) throws IOException {

        registry.add(session);
        session.getBasicRemote().sendText("People chatting " + registry.getAll().size());

    }

    @OnMessage
    public void onMessage(Session sender, String message) throws IOException {

        Set<Session> sessions = registry.getAll();
        for (Session s : sessions) {
            try {
                s.getBasicRemote().sendText("User said: " + message);
            } catch (IOException iOException) {
            }
        }

    }

}
