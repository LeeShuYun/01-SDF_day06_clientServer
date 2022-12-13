package chattwoway;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



public class ChatIOUtils implements Runnable{
    public ChatIOUtils(InputStream is){
    }
    @Override
    public void run(){
        try{
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
        }
    }
    public static void 

    public static void write(Socket socket, String payload) throws IOException {
        //get output stream
        //
        OutputStream os = socket.getOutputStream();
        //knows the best size to write, the NTU
        BufferedOutputStream bos = new BufferedOutputStream(os);
        DataOutputStream dos = new DataOutputStream(bos);

        System.out.println(">>>> payload" + payload);
        dos.writeUTF(payload);
        dos.flush();

        // dos.close();
        // bos.close(); 
        // os.close(); //this is the one with the only stream

    }

    //send in a socket, receive the packets from the socket
    public static String read(Socket socket) throws IOException{
        //get the input stream 
        InputStream is = socket.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        DataInputStream dis = new DataInputStream(bis);

        //grabs the data
        String payload = dis.readUTF();
        System.out.printf("<<< %s\n", payload);

        // dis.close();
        // bis.close();
        // is.close();

        return payload;
    }
}
