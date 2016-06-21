package test.socket.guessnum;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.commons.lang3.StringUtils;

public class SocketClient {

	static String clientName = "Mike";
    //端口号
	public static int portNo = 3333;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 // 设置连接地址类,连接本地

        InetAddress addr = InetAddress.getByName("localhost");        

        //要对应服务器端的3333端口号
        Socket socket = new Socket(addr, portNo);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
        try{
        		System.out.println("socket = " + socket);
               // 设置IO句柄
        		while(true){
        			int msg = (int) (Math.random()*50);
        			out.writeUTF(String.valueOf(msg));
        			String sendData = in.readUTF();
	             	if(StringUtils.equals("true", sendData)){
	             		System.out.println("--right answer--");
	             		break;
	             	}
        		}
        }finally {
               System.out.println("close the Client socket and the io.");
               socket.close();
		}
	}

}
