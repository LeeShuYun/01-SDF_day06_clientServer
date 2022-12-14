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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import day06.IOUtils;

//this is TCP
//java -cp classes day06.ListServer <port>
//this is a threaded server

public class ChatServer {
    public static void main(String[] args) throws Exception{

        //get port number
        Integer port = Integer.parseInt(args[0]);
        
        //start server socket
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Listening on port %d\n", port);

        //executor service to juggle threads. the number of threads there will be is in the ()
        ExecutorService thrpool = Executors.newFixedThreadPool(2);

        // create the Runnable job for the thread to run
        Runnable run = () -> {
            
            try{
                //generate a random port between 1025 and 655535 nd check if it's available
                Random rnd = new SecureRandom();
                Integer rndPort = rnd.nextInt(64510) + 1025;

                //check if the port is occupied, if it isn't then we can use it
                Socket sockt = new Socket("localhost", rndPort);
                
            } catch (ConnectException e) {
                
            } catch (IOException e) {
                throw new IllegalStateException("Error while trying to check open port", e);
            }
            

        };

        
        //server listening loop on Main Thread
        while (true){
            //wait for a connection
            System.out.println("Waiting for connections....");
            Socket socket = server.accept();
            
            //create the Clienthandler class we made
            ClientHandler client = new ClientHandler(socket);
            //to make a thread we need to pass this Runnable client to the threadpool
            thrpool.submit(client);
            
            
        }
        socket.close();
        
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
        int attempts = 0;
        boolean scanning = true;
        while (scanning) {
            if (!available(8080)) {
                attempts++;
                if (attempts == 10) {
                    System.out.println("giving up!");
                    scanning = false;
                }
            } else {
                scanning = false;
            }
            try {
                Thread.sleep(2000);// 2 seconds
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

}

    private static boolean available(int port) {
        System.out.println("--------------Testing port " + port);
        Socket s = null;
        try {
            s = new Socket("localhost", port);
            // If the code makes it this far without an exception it means
            // something is using the port and has responded.
            System.out.println("--------------Port " + port + " is not available");
            return false;
        } catch (IOException e) {
            System.out.println("--------------Port " + port + " is available");
            return true;
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException("You should handle this error.", e);
                }
            }
        }
    }
}
