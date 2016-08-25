/*
 * ServerTest.java
 * Simple client-server socket app (Server PART)
 * @author Gabor Jaszfalvi
 * 2016
 */
package Pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTest {
    public static void main(String[] args) throws Exception {
        // creating a socket for the server
        ServerSocket serverSocket = new ServerSocket(2004,10);        
        System.out.println("Waiting for connection...");
        
        // the clientsocket is actually the accepted serversocket
        Socket clientSocket = serverSocket.accept();        
        System.out.println("Connection recieved from " + clientSocket.getInetAddress().getHostName());
        
        // creating I/O streams
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        out.println("Welcome to my planet!" );
        
        // reading from and writing to the streams using a loop
        while (true) {
        String s = in.readLine();
        System.out.println("Client: " + s);
        System.out.print("Server: ");
        String k = new Scanner(System.in).nextLine();
        out.println(k);
        if (k.equalsIgnoreCase("exit")) {break;}
        }
        
        // closing the streams and the socket
        out.close();
        in.close();
        serverSocket.close();
    }
}