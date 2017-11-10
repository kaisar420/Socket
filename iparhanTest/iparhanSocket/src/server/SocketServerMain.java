package server;

import org.apache.log4j.net.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket
 */
public class SocketServerMain {
    public static void main(String[] args) throws IOException {
        //1.create ServerSocket and Server
        ServerSocket serverSocket =  new ServerSocket(8887);
        //2.use accept() listen request of Client
        System.out.println("Server will be start and wait for client.....");
        Socket socket = serverSocket.accept();
        //3.use InputStream receive message from Client
        InputStream inputStream = socket.getInputStream();
                 //convert the Stream to reader
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 //create buffer for reader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info  =null;
                 //if the data from client is not empty
        while ((info = bufferedReader.readLine()) != null){
            System.out.println("Im server and i can read data from Client" + info);
        }
        socket.shutdownInput();
        //4.use OutputStream send message to Client to PrintWriter
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("Server reply  data to Client");
        printWriter.flush();
        //5.close IO and Server.
        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }

}
