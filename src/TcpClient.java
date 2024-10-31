import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        String message = "Hello, server!";
        byte[] buffer = message.getBytes();

        outputStream.write(buffer);

        buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        message = new String(buffer, 0, bytesRead);

        System.out.println("Received message from server: " + message);

        socket.close();
    }
}