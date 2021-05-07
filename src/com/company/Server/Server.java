package com.company.Server;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(1111);
        Socket socket = ourFirstServerSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataStream = new DataInputStream(inputStream);
        int msgLen = dataStream.readInt();
        byte[] arr = new byte[msgLen];
        dataStream.readFully(arr);
        Files.write(Paths.get("Ali.jpg"), arr);
    }
}
