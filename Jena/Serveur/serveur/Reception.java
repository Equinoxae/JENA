package serveur;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Receptionne et renvoie les messages des utilisateurs
 * @author esteban et Adrien
 *
 */
public class Reception implements Runnable {

    private String message = null;	// Message du client
    private ArrayList<Client> user;
    private int i;
    
    /**
     * Constructeur d'un receveur
     * @param user (ArrayList<Client>) Tableau des utilisateurs connect�s
     * @param i (int) Num�ro de l'utilisateur dans le tableau
     */
    public Reception(ArrayList<Client> user,int i){
    	this.user=user;
    	this.i=i;
    }

	/**
	 * Transforme un String en Message, les parties doivent �tre s�par�es par un �
	 * @param in
	 * @return
	 */
	public Message fromString(String in)
	{
	 	String[] tmp = in.split("�");
	 	return new Message(tmp);
	}
    
    /**
     * Lancement de la thread qui re�oit et renvoie les messages client
     */
    public void run()
    {
        while(true)
        {
        	try
        	{
        		while(true)
        		{
	                message = user.get(i).getBuffer().readLine();	// Receptionne la saisi du client
	                Message msg=fromString(message);
	                System.out.println(msg.getType());
	                switch(msg.getType())
	                {
		                case "quit":
		                	user.get(i).getWriter().println("quit");
	            			user.get(i).getWriter().flush();
		                	ChatServeur.getInstance().deleteUser(user.get(i));
		                	break;
		                	
		                case "message":
		                	msg.setContent(msg.getSender()+" : "+msg.getContent());
	                    	for(int j=0;j<user.size();j++)
	                    	{
	                			user.get(j).getWriter().println(msg.getContent());
	                			user.get(j).getWriter().flush();
	                    	}
		                    break;
		                    
		                case "kick":
		                	for(int k=0;k<user.size();k++)
		                	{
		                		String kTest=msg.getRecipient();
		                		String uTest=(String) user.get(k).getLogin();
		                		if(kTest.equalsIgnoreCase(uTest))
		                		{
		                			user.get(k).getWriter().println("quit");
		                			user.get(k).getWriter().flush();
			            			new Emission(user,uTest+" a �t� kick�").messageServ();
				                	ChatServeur.getInstance().deleteUser(user.get(k));
		                		}
		                	}
		                	break;
		                	
		                case "pm":
		                	for(int k=0;k<user.size();k++)
		                	{
		                		String kTest=msg.getRecipient();
		                		String uTest=(String) user.get(k).getLogin();
		                		if(kTest.equalsIgnoreCase(uTest))
		                		{
		                			user.get(k).getWriter().println("PM from "+msg.getSender()+" : "+msg.getContent());
		                			user.get(k).getWriter().flush();
		                			user.get(i).getWriter().println("To "+msg.getRecipient()+" : "+msg.getContent());
		                			user.get(i).getWriter().flush();
		                		}
		                	}
		                	break;
		                	
		                case "ban":
		                	for(int k=0;k<user.size();k++)
		                	{
		                		String kTest=msg.getRecipient();
		                		String uTest=(String) user.get(k).getLogin();
		                		if(kTest.equalsIgnoreCase(uTest))
		                		{
		                			user.get(k).getWriter().println("quit");
		                			user.get(k).getWriter().flush();
			            			new Emission(user,uTest+" a �t� kick�").messageServ();
				                	ChatServeur.getInstance().deleteUser(user.get(k));
		                		}
		                	}
		                	break;
	                }
	                
	             
        		}
            }
        	catch (IOException e)
            {
        		// Affichage de l'erreur 
        		e.printStackTrace();
        	}
        }
    }

}