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
	
	public IOCommandes(Socket socket){
		this.lectureEcran = new BufferedReader(new InputStreamReader(System.in));
		this.ecritureEcran = new PrintStream(System.out);
		
		this.socket = socket;
		
		try {
			this.lectureReseau = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.ecritureReseau = new PrintStream(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void ecrireEcran(String text) {
		this.ecritureEcran.print(text);
	}
	
	public String lireEcran() {
		String entree = "";
		
		try {
			entree = this.lectureEcran.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entree;
	}
	
	public void ecrireReseau(String text) {
		this.ecritureReseau.println(text);
	}
	
	public String lireReseau() {
		String entry = "";
		
		try {
			entry = this.lectureReseau.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entry;
	}
}	
