import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket s_socket = new ServerSocket(8888);
			
			Socket c_socket = s_socket.accept();
			
			// 수신 스레드 생성하고 소켓 전달
			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);
			
			// 송신 스레드 생성하고 소켓 전달
			SendThread send_thread = new SendThread();
			send_thread.setSocket(c_socket);
			
			rec_thread.start();
			send_thread.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // end of main
	
} // end of calss
