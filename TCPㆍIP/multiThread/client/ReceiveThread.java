import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

// 수신 스레드
public class ReceiveThread extends Thread{ // Thread 클래스 상속
	
	private Socket m_Socket;
	
	@Override
	public void run() {
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream())); // 입력 스트림
			
			String receiveString;
			
			while (true) { // 데이터 처리
				// 전송 받은 소켓의 데이터는 inputStream에 쌓이게 되고 readLine을 통해 가져온다
				receiveString = tmpbuf.readLine(); 
				
				if (receiveString == null) {
					System.out.println("상대방 연결이 끊겼습니다.");
					break;
				} else {
					System.out.println("상대방 : " + receiveString);
				}
			}
			tmpbuf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // end of run
	
	public void setSocket(Socket _socket) { // 메인으로부터 "Socket" 객체를 받기 위한 메소드
		m_Socket = _socket;
	}
	
} // end of calss
