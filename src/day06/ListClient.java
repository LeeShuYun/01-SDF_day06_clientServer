package day06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListClient {
    public static void main(String[] args) throws Exception{
        // java -cp classes day06 <numof numbers> <top limit>
        //grab CLI terminal commands for the range of number, host, and port 
        Integer range = Integer.parseInt(args[0]);
        String host = args[1];
        Integer port = Integer.parseInt(args[2]);

        //creates socket to server
        Socket socket = new Socket(host, port);
        
        System.out.printf("connected to %s: %d on port %d", host, port, socket.getPort());
        
       

        socket.close();

    }
}
