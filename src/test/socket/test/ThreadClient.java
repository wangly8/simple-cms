package test.socket.test;

import java.io.IOException;
import java.net.InetAddress;

public class ThreadClient {

	public static void main(String[] args)throws IOException, InterruptedException 
		  {
		    int threadNo = 0;
		    InetAddress addr = InetAddress.getByName("localhost");
		    for(threadNo = 0;threadNo<3;threadNo++)
		    {
		       new ClientThreadCode(addr);
		    }
		  }
}
