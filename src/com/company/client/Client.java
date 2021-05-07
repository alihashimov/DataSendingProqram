package com.company.client;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("Please enter name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("please enter surname:");
        String surname = new Scanner(System.in).nextLine();
        System.out.println(name + " " + surname + " proqrama xosh geldiniz:");
        System.out.println("Zəhmət olmasa göndərmək istədiyiniz sheklin yerləşdiyi keçidi qeyd edin");
        String fileTransition = new Scanner(System.in).nextLine();
        System.out.println("bu shekli göndərmək istədiyiniz şəxsin(serverin) ip və portunu daxil edin:");
        String ipAndPort = new Scanner(System.in).nextLine();
        String[] arr = ipAndPort.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);
        Socket socket = new Socket(ip, port);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] bytes = Files.readAllBytes(Paths.get(fileTransition));
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
        System.out.println("Uğurla göndərildi.");
    }
}
