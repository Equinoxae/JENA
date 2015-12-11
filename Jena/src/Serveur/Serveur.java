package Serveur;

import java.io.*;
import java.net.*;

public class Serveur 
{
    public static ServerSocket socketserver = null;     // Socket du serveur (flux entrant)
    public static Thread t;     // Thread lanc�e à chaque demande de connexion client

    public static void main(String[] args)
    {
        try
        {
            // Application du Socket sur le port 2000 à l'adresse localhost
            socketserver = new ServerSocket(2000);
            System.out.println("Le serveur est à l'�coute du port " + socketserver.getLocalPort());

            // Lancement de la Thread de d�tection des demandes client
            t = new Thread(new Accepter_connexion(socketserver));
            t.start();
            
        }catch (IOException e)
        // Erreur en cas de surcharge du port demand� 
        {System.err.println("Le port n'est pas disponible !");}
    }
}
