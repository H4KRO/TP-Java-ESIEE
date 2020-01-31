import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class IOCommandes {
	
	private BufferedReader lectureEcran;
	private PrintStream ecritureEcran;
	
	public IOCommandes(){
		this.lectureEcran = new BufferedReader(new InputStreamReader(System.in));
		this.ecritureEcran = new PrintStream(System.out);
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
}	
