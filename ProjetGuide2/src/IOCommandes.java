import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class IOCommandes {
	
	private BufferedReader lectureEcran;
	private PrintStream ecritureEcran;
	private BufferedReader lectureReseau;
	private PrintStream ecritureReseau;
	private Socket socket;
	
	public IOCommandes(Socket socket) throws IOException{
		this.lectureEcran = new BufferedReader(new InputStreamReader(System.in));
		this.ecritureEcran = new PrintStream(System.out);
		
		this.socket = socket;
		this.lectureReseau = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		this.ecritureReseau = new PrintStream(this.socket.getOutputStream());
		
	}
	
	public void ecrireEcran(String text) {
		this.ecritureEcran.print(text);
	}
	
	public String lireEcran() throws IOException {
		return this.lectureEcran.readLine();
	}
	
	public void ecrireReseau(String text) {
		this.ecritureReseau.println(text);
	}
	
	public String lireReseau() throws IOException {
		return this.lectureReseau.readLine();
	}
}	
