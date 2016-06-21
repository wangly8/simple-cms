package test.socket.guessnum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static int portNo = 3333;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket s = null;
		 Socket socket = null;
		 
	  
		try {
			s = new ServerSocket(portNo);
			 System.out.println("The Server is start: " + s);
			 socket = s.accept();
			 System.out.println("Accept the Client: " + socket);  
			 
			 int num = (int) (Math.random()*50);
			                  
            //设置IO句柄
			 DataInputStream in = new DataInputStream(socket.getInputStream());
			 DataOutputStream out = new DataOutputStream(socket.getOutputStream());     
            while (true){
               String str = in.readUTF();
               if(num == Integer.parseInt(str)){
            	   System.out.println("right answer: " + str);
            	   out.writeUTF("true");
            	   break;
               }
               out.writeUTF("false");
               System.out.println("In Server reveived the info: " + str);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
                System.out.println("close the Server socket and the io.");
                socket.close();
                s.close();
        }
	}

}
