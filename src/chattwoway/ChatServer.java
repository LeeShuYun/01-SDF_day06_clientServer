package chattwoway;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import day06.IOUtils;

//this is TCP
//java -cp classes day06.ListServer <port>

public class ChatServer {
    public static void main(String[] args) throws Exception{

        //get port number
        Integer port = Integer.parseInt(args[0]);
        
        //start server socket
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Listening on port %d\n", port);
        
        //server listening loop
        while (true){
            //wait for a connection
            System.out.println("Waiting for connections....");
            Socket socket = server.accept();
            System.out.printf("New connection on port %d\n", socket.getLocalPort());

             // open output
            String payload = IOUtils.read(socket);

            // parsing the received data
            String[] values = payload.split(" ");
            Integer noOfNum = Integer.parseInt(values[0]);
            Integer numLimit = Integer.parseInt(values[1]);

            Random rand = new SecureRandom();
            List<Integer> randNums = new LinkedList<>();
            for (Integer i = 0; i < noOfNum; i++) {
                randNums.add(rand.nextInt(numLimit));
            }

            //we read the response
            String response = randNums.stream()
            .map(v -> v.toString())
            .collect(Collectors.joining(":"));

            IOUtils.write(socket, response);
            
            socket.close();


        }
        
        //on linux we can type 
        //netstat -tulpn
        //in order to see the tcp6 port connection
        /* 

        while (true) {
            String fromClient = dis.readUTF();

            if (fromClient.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("LOG => client: " + fromClient);

            //checks if the client sends an int
            if (Integer.parseInt(fromClient) > 1) {
                //create the list
                Random rand = ran
                Integer[] intList;
                //send list to client
                for (int i = 0; i < intList.size(); i++) {
                    dos.writeUTF(intList[i]);
                }

                dos.flush();
            } else {
                // Send a msg, "Invalid command from server"
                dos.writeUTF("From server: Invalid Command");
                dos.flush();
            }
        }
        socket.close();*/
    
        //connect to client

    //receives a number from client of 100^(n)
    //randomly generates a list of n numbers
    //sends back to client as a comma separated list of strings
    //client will calc avg of numbers and print out on their side
}
}
