package main.java.app;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

public class SendingThread {

    private final Socket socket;

    public SendingThread(Socket socket) {
        this.socket = socket;
    }

    public void sendMessage(String message) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            outputStreamWriter.write(message);
            if (!message.isEmpty() && !message.equals("00214")){
                System.out.println("Send to server: " + message);
            }
            outputStreamWriter.flush();
        } catch (SocketException f){
            //System.out.println("ERROR: Socket is closed");
        } catch (IOException e) {
            System.out.println("ERROR: Sender");
        }
    }
}
