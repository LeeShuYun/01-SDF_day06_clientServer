package chattwoway;

import java.io.BufferedInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.lang.Runnable;

//creates a thread
public class ConnectionHandler implements Runnable{
    private final Socket socket;

    public ConnectionHandler(Socket socket){ 
        this.socket = socket;
    }
        
    @Override
    public void run(){
        
        try{
            InputStream is = this.socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);

            // System.out.println(Thread.currentThread().getName()+ ", executing run() method!");

            //while the thread is in use, we read messages from socket constantly
            while(true){
                String msg = dis.readUTF();
                System.out.println("received>>>" + msg);
            }
            
        }catch(IOException e){
            socket.close();
            System.err.println("IO Error. Socket now closed.");
        }catch(EOFException e){
            //this is for when socket is closed on other side, 
            //it will throw a EOFException and we clean up by closing socket here too
            socket.close(); 
            System.err.println("EOF Error. Socket now closed.");

        }
    
    }
    
}
