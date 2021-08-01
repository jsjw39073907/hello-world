import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread{
	
	private Socket m_Socket;
	
	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
			
			String receiveString;
			
			while (true) {
				receiveString = tmpbuf.readLine();
				
				System.out.println("상대방 : " + receiveString);
			}
		} catch (Exception e) {}
		
	} // end of run
		
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}

} // end of class
