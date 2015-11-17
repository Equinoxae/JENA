/**
 * Login.java
 * @date 06/11/2015
 * @author Julien
 */

package iGraphique;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	/**
	 * Boutton d'inscription et d'invitation
	 */
	private JButton b_inscription,b_invite;
	/**
	 * Champ de texte : Login / Password
	 */
	private JTextField tfLogin, tfPassword;
	/**
	 * Panel : Principale contenant : Bouton(panel ou sont plac� les boutons) / Log(Contenant les informations de connexion)
	 */
	private JPanel principale,bouton,log;
	/**
	 *  Label : Login/Password/Mot de passe perdu
	 */
	private JLabel lLogin,lPassword,lPsLoose;
	/**
	 * CheckBox : Se souvenir de moi;
	 */
	private JCheckBox rememberMe;
	/**
	 * Layout : Choix du GridLayout a 7 lignes et 0 collones
	 */
	private GridLayout gL = new GridLayout(7,1);
	/**
	 * Constructeur de fenetre : Impl�mentation des �l�ments utiles
	 * @param x : Taille en x
	 * @param y : Taille en y
	 */
	Login(int x, int y){
		super("Conexion : ");
		setPreferredSize(new Dimension(x,y));
		b_inscription = new JButton("Inscription");
		b_inscription.addActionListener(this);
		b_invite = new JButton("Invit�");
		lLogin = new JLabel("Login(*)");
		lPassword = new JLabel("Password(*)");
		tfLogin = new JTextField("Obligatoire",20);
		tfPassword = new JTextField("Obligatoire",20);
		rememberMe = new JCheckBox("Se souvenir de moi");
		lPsLoose = new JLabel("Mot de passe oubli� ?");
		principale = new JPanel(new FlowLayout());
		bouton = new JPanel();
		log = new JPanel();
		log.setLayout(gL);
		construireFenetre();
	}
	/**
	 * Ajout des diff�rents �l�ments dans la fen�tre
	 */
	private void construireFenetre(){
		
		log.add(lLogin);
		log.add(tfLogin);
		log.add(lPassword);
		log.add(tfPassword);
		log.add(lPsLoose);
		log.add(rememberMe);
		bouton.add(b_inscription);
		bouton.add(b_invite);
		log.add(bouton);
		principale.add(log);
			
		
		this.pack();
		this.add(principale);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	/**
	 * Action li�es aux cliques boutons
	 */
	 public  void    actionPerformed(ActionEvent e)
	    {
		 	/**
		 	 * On recup�re la source de l'event
		 	 */
	        Object source = e.getSource();
	        /**
	         * Si la source est le bouton d'inscription, on va sur la fenetre de chat principale
	         */
	        if (source == b_inscription){
	        	Principale p = new Principale(500,500);
	        	p.setVisible(true);
	        	this.setVisible(false);
	        }
	    }
}
