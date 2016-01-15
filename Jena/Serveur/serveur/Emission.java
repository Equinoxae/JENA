package serveur;

import java.util.ArrayList;
/** 
 * Classe permettant l'envoie de certains message (D�co, Kick , Connexion ...)
 * @author esteb
 *
 */
public class Emission
{    
    private ArrayList<Client> user;		// Envoyeur
    private String message = null;	// Message a transmettre
    
    /**
     * Constructeur de l'envoyeur 
     * @param user : Tableau de client
     * @param message : Message � envoyer (String)
     */
    public Emission(ArrayList<Client> user,String message)
    {
    	this.user=user;
    	this.message=message;
    }
    /**
     * Envoie � chaque personne connect�e du message par le serveur
     */
    public void messageServ()
    {
    	 while(message!=null){
         	for(int i=0;i<user.size();i++)
         	{
         			user.get(i).getWriter().println(message);
         			user.get(i).getWriter().flush();
         	}
         	message=null;
    	 }
    }
}