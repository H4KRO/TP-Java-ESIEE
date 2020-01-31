import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Principale {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("192.168.100.25", 5999);
		IOCommandes ioc = new IOCommandes(socket);
		String msg = "";
		do {
			msg = ioc.lireEcran();
			ioc.ecrireReseau(msg);
			ioc.ecrireEcran(ioc.lireReseau());
		}while(!msg.contentEquals("quit"));
		socket.close();
		
	}
}
