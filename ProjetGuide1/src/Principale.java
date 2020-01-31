
public class Principale {

	public static void main(String[] args) {
		IOCommandes ioc = new IOCommandes();
		String entree;
		do {
			entree = ioc.lireEcran();
			ioc.ecrireEcran(entree);
		}while(!entree.contentEquals("quit"));
	}
}
