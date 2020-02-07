package Server;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class IOCommandesServeur extends Thread {

	private BufferedReader lectureEcran;
	private BufferedReader lectureReseau;
	private PrintStream ecritureEcran;
	private PrintStream ecritureReseau;
	private Socket maChaussette;

	public Socket getMaChaussette() {
		return maChaussette;
	}

	@Override
	public void run() {
		PrincipaleServeur.threadCounter++;
		discussion();
	}

	public IOCommandesServeur(Socket uneChaussette) {

		// Partie en local
		InputStreamReader monInputStream = new InputStreamReader(System.in);
		lectureEcran = new BufferedReader(monInputStream);
		ecritureEcran = new PrintStream(System.out);

		// Partie réseau
		maChaussette = uneChaussette;
		InputStreamReader monInputStreamReseau = null;

		try {
			monInputStreamReseau = new InputStreamReader(maChaussette.getInputStream());
			lectureReseau = new BufferedReader(monInputStreamReseau);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			ecritureReseau = new PrintStream(maChaussette.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ecrireEcran(String texte) {
		ecritureEcran.println(texte);
	}

	public String lireEcran() {
		String texte = "";
		try {
			texte = lectureEcran.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return texte;
	}

	public void ecrireReseau(String texte) {
		if (maChaussette != null)
			ecritureReseau.println(texte);
	}

	public String lireReseau() {
		if (maChaussette != null) {
			String texte = "";
			try {
				texte = lectureReseau.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return texte;
		}
		return null;

	}

	public void discussion() {

		try {
			String message = "";
			ecrireEcran("Connexion avec le client : " + maChaussette.getInetAddress());
			while (!message.equals("quit")) {
				message = lireReseau();
				String messageLog = maChaussette.getInetAddress() + " dit : " + message + " à : " + new Date();
				ecrireLog("fichiers/logs.txt", messageLog);
				ecrireEcran("Le client dit : " + message);
				ecrireReseau("echo>" + message);
			}
			maChaussette.close();
			ecrireEcran("Déconnexion de : " + maChaussette.getInetAddress());
			PrincipaleServeur.threadCounter--;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ecrireLog(String path, String message) {

		try {
			PrintWriter fichier = new PrintWriter(new FileWriter(path, true));
			fichier.println(message);
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
