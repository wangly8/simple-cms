package test.socket.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

             //设置IO句柄
             BufferedReader in = new BufferedReader(new InputStreamReader(socket
                           .getInputStream()));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);                    
             while (true){
                String str = in.readLine();
                if (str.equals("byebye"))
                {
                       break;
                }
                System.out.println("In Server reveived the info: " + str);
                out.println(str);
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
