/*
 * ClientTest.java
 * Simple client-server socket app (CLIENT PART)
 * @author Gabor Jaszfalvi
 * 2016
 */
package Pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) throws Exception {
        // creating a socket for the server        
        Socket requestSocket = new Socket("localhost",2004);
        System.out.println("Connected to Server on localhost, 2004");

        // creating I/O streams        
        PrintWriter out = new PrintWriter(requestSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
        
        // reading from and writing to the streams using a loop
        while (true) {
        String s = in.readLine();
        System.out.println("Server: " + s);
        System.out.print("Client: ");
        String k = new Scanner(System.in).nextLine();
        out.println(k);
        if (k.equalsIgnoreCase("exit")) {break;}
        }

        // closing the streams and the socket        
        out.close();
        in.close();
        requestSocket.close();
    }
}
