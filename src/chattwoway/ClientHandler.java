package chattwoway;

import java.io.IOException;
import java.net.Socket;

//runnable is the job you want to give to a thread
public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        
        System.out.printf("New connection on port %d\n", socket.getLocalPort());

        try{
        // open output
        String payload = ChatIOUtils.read(socket);
        
        //
        if (payload.equalsIgnoreCase("exit")){
            socket.close();
        }
        // parsing the received data, which comes in String[]. we can use regular string funcs on it
        // String[] values = payload.split(" ");
        // Integer noOfNum = Integer.parseInt(values[0]);
        // Integer numLimit = Integer.parseInt(values[1]);

        //we send the response as string
        String response = mylist.stream()
                                .map(v -> v.toString())
                                .collect(Collectors.joining(":"));
        
        //delay for 2 sec to make the movement visible
        Thread.sleep(2000);

        IOUtils.write(socket, response);
        }catch(IOException e){
        }finally{
            //finally means guaranteed to execute before we exit this method
            try{socket.close();} catch (IOException e){}
        }
    }    
}
