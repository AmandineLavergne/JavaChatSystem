import java.net.InetAddress;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class ChatServer extends UnicastRemoteObject implements Chat {
	LinkedList<Client> listeClients;
	LinkedList<String> historiqueMessages;
	
	// Impl�mentation du constructeur
	public ChatServer() throws java.rmi.RemoteException {
		LinkedList<Client> liste = new LinkedList<Client>();
		LinkedList<String> historique = new LinkedList<String>();
		listeClients = liste;
		historiqueMessages = historique;
	}
	
	// Impl�mentation de la m�thode distante
	public void afficherHistoriqueMessage() throws java.rmi.RemoteException {
		for(String s:historiqueMessages)
			System.out.println(s);
	}
	
	public void send(String message){
		
	}
	
	public void connect(int id){
		
	}
	
	public void bye(){
		
	}
	
	public LinkedList<Client> who() {
		
		return listeClients;
	}
	
	public static void main(String args[]) {
		int port; String URL;
		try { // transformation d �une cha�ne de caract�res en entier
			Integer I = new Integer(args[0]); port = I.intValue();
		} catch (Exception ex) {
			System.out.println(" Please enter: Server <port>"); return;
		}
		try {
			// Cr�ation du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);
			// Cr�ation d �une instance de l�objet serveur
			Chat obj = new ChatServer();
			// Calcul de l�URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/ChatServer";
			Naming.rebind(URL, obj);
		} catch (Exception exc) { }
	}
}
