import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;

public class Principale {

	public static void main(String[] args) throws UnknownHostException, IOException {
		File file = new File("C:/Users/Eddie/Documents/GitHub/TP-Java-ESIEE/ProjetGuide3/bin/test.txt");
		IOCommandes ioc = new IOCommandes(file);
		String msg = "";
		do {
			msg = ioc.lireEcran();
			ioc.ecrireFichier(msg);
			ioc.ecrireEcran(ioc.lireFichier());
		}while(!msg.contentEquals("quit"));
		
	}
}
