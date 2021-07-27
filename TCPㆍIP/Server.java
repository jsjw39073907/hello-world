import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// 서버 소켓을 만들기
	private ServerSocket serverSocket;
	// 어셉트를 할 때 들어오는 정보를 저장할 소켓
	private Socket clientSocket;
	private DataInputStream dataInputStream; // 데이터가 들어오는 통로
	private DataOutputStream dataOutputStream;

	// 1. 데이터를 계속 전송하는 쓰레드
	// 2. 데이터를 계속 수신하는 쓰레드


	public void serverSetting() {
		try {
			// localhost, 8080
			serverSocket = new ServerSocket(8080); // 바인드
			clientSocket = serverSocket.accept(); // 어셉트
			// 소켓이 접속 완료된 부분
			System.out.println("클라이언트 소켓 연결");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeAll() {
		try {
			serverSocket.close();
			clientSocket.close();
			dataInputStream.close();
			dataOutputStream.close();
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

	public Server() {
		serverSetting();
		streamSetting();
		System.out.println(dataRecv());
		dataSend("잘 받았어요");
		closeAll();
	}

	public static void main(String[] args) {
		new Server();
	}


}
