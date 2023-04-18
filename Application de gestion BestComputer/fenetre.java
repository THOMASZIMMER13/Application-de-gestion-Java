import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
public class fenetre extends JFrame implements ActionListener {


private JButton b1, b2;
private JLabel l1, lien;
private String str = "www.waytolearnx.com";


public fenetre () {

setTitle("BIENVENUE !");
setSize(400, 600);
setLocation(200,50 );
setResizable(false); //empêche l'utilisateur toute modification
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null); //empécher le positionnement automatique des fenetres

b1 = new JButton ("Progiciel");
b1.addActionListener(this); //etape 4 pour préciser le bouton 
b1.setBackground(Color.cyan);
b1.setForeground(Color.black);
b1.setBounds (15, 450, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
b1.requestFocusInWindow();

b2 = new JButton ("Fermer la fenêtre!");
b2.addActionListener(this); //etape 4 pour préciser le bouton 
b2.setBackground(Color.red);
b2.setForeground(Color.black);
b2.setBounds(185, 450, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
b2.requestFocusInWindow();

JLabel l1=new JLabel ("Accueil");
Font police = new Font("Arial", Font.BOLD, 18);
l1.setFont(police);
l1.setBounds(140, 5, 150, 20); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
l1.requestFocusInWindow(); 

//méthode pour afficher une image
JLabel image = new JLabel();
image.setIcon(new ImageIcon("logo.png"));
image.setBounds(0, 30, 400, 400); //2e nombre position du label dans la fenetre, 2 dernier nombre taille//image.requestFocusInWindow(); 
image.requestFocusInWindow(); 


//conteneur qui contien les boutons, text, et label
JPanel contener = new JPanel ();
contener.setLayout(null);
contener.add(b1);
contener.add(b2);
contener.add(l1);
contener.add(image);
contener.setBounds(10, 10, 600, 500);
contener.requestFocusInWindow();
add(contener); //ajout du conteneur à la fenetre
setVisible(true);

}


//etape 3 méthode contient traitement de l'évènement action suite au clique du bouton.
public void actionPerformed (ActionEvent e) {
//test si l'utilisateur clique sur le premier bouton afin d'effectuer l'affichage.
if (e.getSource() == b1)  {
fenetreChoix fc1 = new fenetreChoix (); 
}

if (e.getSource() == b2) {
System.exit(0);
}
}


}