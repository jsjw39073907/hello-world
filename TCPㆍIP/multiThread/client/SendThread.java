import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SendThread extends Thread {
	
	private Socket m_Socket;
	
	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			
			String sendString;
			
			while (true) {
				sendString = tmpbuf.readLine();
				
				if (sendString.equals("exit")) {
					break;
				}
				
				sendWriter.println(sendString);
				sendWriter.flush();
				
			}
			
			sendWriter.close();
			tmpbuf.close();
			m_Socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // end of run
	
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
	
} // end of class
