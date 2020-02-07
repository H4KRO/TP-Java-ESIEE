package Server;

import java.net.ServerSocket;
import java.net.Socket;

public class PrincipaleServeur {
	public static int port = 4501;
	public static int threadCounter = 0 ;
	public static int maxThreads = 2;
	
	public static void main(String[] args) {
	    try {
	      ServerSocket socketServeur = new ServerSocket(port);
	      System.out.println("Lancement du serveur");
	      while(true) {
	    	  if(threadCounter < maxThreads) {
	  	        Socket socketClient = socketServeur.accept();
	  	        IOCommandesServeur t = new IOCommandesServeur(socketClient); 
	  	        t.start();
	  	        System.out.println("Nb de connexions : " + threadCounter);
	  	      }
	      }
	     
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	  }

}
