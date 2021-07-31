import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


// 송신 스레드
public class SendThread extends Thread{ // Thread 클래스 상속
	private Socket m_Socket;
	
	@Override
	public void run() { // 상속으로 run() 오버라이딩 할 수 있게 됨 여기에 머소드가 할 일을 프로그램
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in)); // 입력 스트림
			PrintWriter sendWrite = new PrintWriter(m_Socket.getOutputStream()); // 출력 스트림
			String sendString;
		
			while (true) { // 실제 데이터 전송하는 부분
				sendString = tmpbuf.readLine(); // 키보드 입력을 대기하고 키보드로부터 데이터를 받으면 해당 버퍼에 전달
				
				sendWrite.println(sendString); // 소켓으로 해당 문자열 전송
				sendWrite.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of run
	
	public void setSocket(Socket _socket) { // 메인으로부터 "Socket" 객체를 받기 위한 메소드
		m_Socket = _socket;
	}

} // end of class
