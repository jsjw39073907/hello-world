import java.net.Socket;

public class MainClient {
	
	public static void main(String[] args) {
		
		try {
			Socket c_socket = new Socket("180.83.0.224", 8888);
			
			ReceiverThread rec_thread = new ReceiverThread();
			rec_thread.setSocket(c_socket);
			
			SendThread send_thread = new SendThread();
			send_thread.setSocket(c_socket);
			
			send_thread.start();
			rec_thread.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // end of main
	
} // end of class
