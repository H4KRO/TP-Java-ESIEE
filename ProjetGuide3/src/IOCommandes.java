import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class IOCommandes {
	
	private BufferedReader lectureEcran;
	private PrintStream ecritureEcran;
	
	private Socket socket;
	private BufferedReader lectureReseau;
	private PrintStream ecritureReseau;
	
	private File file;
	private BufferedReader lectureFichier;
	private PrintStream ecritureFichier;
	
	public IOCommandes(File file) throws FileNotFoundException {
		this.lectureEcran = new BufferedReader(new InputStreamReader(System.in));
		this.ecritureEcran = new PrintStream(System.out);
		
		this.file = file;
		this.lectureFichier = new BufferedReader(new FileReader(this.file));
		this.ecritureFichier = new PrintStream(this.file);
	}
	
	public IOCommandes(Socket socket){
		this.lectureEcran = new BufferedReader(new InputStreamReader(System.in));
		this.ecritureEcran = new PrintStream(System.out);
		
		this.socket = socket;
		
		try {
			this.lectureReseau = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			this.ecritureReseau = new PrintStream(this.socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public void ecrireFichier(String test) {
		this.ecritureFichier.println(test);
	}
	
	public String lireFichier() throws IOException {
		return this.lectureFichier.readLine();
	}
}	
