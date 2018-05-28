package offer1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class socketCode {
   public static void main(String[] args){
	   ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
	   try {
		ServerSocket serverSocket=new ServerSocket(10011);
		System.out.println("server started");
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("A client is connected...");
			newCachedThreadPool.execute(()->{
				handlers(socket);
			});
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public static void handlers(Socket socket){
	   try {
		InputStream inputStream = socket.getInputStream();
		byte[] bytes=new byte[1024];
		while(true){
			int read = inputStream.read(bytes);
			if (read!=-1) {
				System.out.println(new String(bytes));
				
			}
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   }
}
