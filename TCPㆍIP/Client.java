import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * 클라이언트는 접속할 소켓 하나만 있으면 된다.
 * */
public class Client {
	private Socket clientSocket;
	private DataInputStream dataInputStream; // 데이터가 들어오는 통로
	private DataOutputStream dataOutputStream;

	// 1. 데이터를 계속 전송하는 쓰레드
	// 2. 데이터를 계속 수신하는 쓰레드

	public void connect() {
		try {
			System.out.println("접속 시도");
			clientSocket = new Socket("192.168.56.1", 8080);
			System.out.println("접속 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 수신
	public String dataRecv() {
		try {
			return dataInputStream.readUTF();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 데이터 송신
	public void dataSend(String sendData) {
		try {
			dataOutputStream.writeUTF(sendData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터 스트림 세팅
	public void streamSetting() {
		try {
			dataInputStream = new DataInputStream(clientSocket.getInputStream());
			dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
		}
	}

	public Client() {
		connect();
		streamSetting();
		dataSend("안녕하세요 클라이언트 입니다.");
		System.out.println(dataRecv());
	}

	public static void main(String[] args) {
		new Client();
	}
}
