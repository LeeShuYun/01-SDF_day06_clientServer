package chattwoway;

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

public class ChatClient {
    public static void main(String[] args) throws Exception{
          // java -cp classes day06.ListClient <num of numbers to output> <num range limit> <host> <port>
        // grab CLI terminal commands for the range of number, host, and port 
        Integer numToReturn = Integer.parseInt(args[0]);
        Integer numRange = Integer.parseInt(args[1]);
        String host = args[2];
        Integer port = Integer.parseInt(args[3]);

        //creates socket to server
        Socket socket = new Socket(host, port);
        
        System.out.printf("connected to %s: %d on port %d", host, port, socket.getPort());

        //send a message with number of numbers and range as confirmation
        ChatIOUtils.write(socket, "%d %d".formatted(numToReturn, numRange));

        //write something
        String message = args[0];
        ChatIOUtils.write(socket, message);
        
        //receive the finished list of numbers from server according to spec
        String response = ChatIOUtils.read(socket);
        System.out.println("Server response >>> " + response);

        socket.close();

    }
}
