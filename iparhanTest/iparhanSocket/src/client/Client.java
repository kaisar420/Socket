package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  throws IOException{
        //1.create Socket and appoint and address and port
        Socket socket = new Socket("localhost",8887);
        //2.use OutputStream send message to Server
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("User:admin , Password:123");

        printWriter.flush();
                //close socketOutputStream
        socket.shutdownOutput();
        //3.use InputStream receive the message from server.
        InputStream inputStream =  socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info  = null;
        while ((info = bufferedReader.readLine()) != null){
            System.out.println("Im Client and wanna send message to server" + info);
        }

        //4.close
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        printWriter.close();
        outputStream.close();
    }

}
