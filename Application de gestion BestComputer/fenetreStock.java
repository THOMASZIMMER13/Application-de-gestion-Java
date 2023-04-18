import java.sql.*;
import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
import java.util.*; 
import java.io.*;
public class fenetreStock extends JFrame implements ActionListener {
private JLabel title;
private JButton btAddLaptop, btAddDesktop, btAddAccessory;
private JButton btStock, btDelete, btModif;
private JButton btReturn, btHome, btClose;




public fenetreStock () {

setTitle("Gestion du stock de l'entreprise ");
setSize(800, 900);
setLocation(400,400 );
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setLayout(null); //empécher le positionnement automatique des fenetres


JLabel title=new JLabel ("Gestion de stock");
Font police = new Font("Arial", Font.BOLD, 18);
title.setFont(police);
title.setBounds(240, 5, 300, 20); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
title.requestFocusInWindow(); 

btDelete = new JButton ("Supprimer un produit");
btDelete.addActionListener(this); //etape 4 pour préciser le bouton 
btDelete.setBackground(new Color(150,0,0)); // Définit la couleur d'arrière-plan du bouton
btDelete.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btDelete.setBounds(535, 300, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btDelete.requestFocusInWindow();

btModif = new JButton ("Actualiser les informations des produit");
btModif.addActionListener(this); //etape 4 pour préciser le bouton 
btModif.setBackground(Color.orange);
btModif.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btModif.setBounds(269, 300, 260, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btModif.requestFocusInWindow();

btStock = new JButton ("Affichage du stock");
btStock.addActionListener(this); //etape 4 pour préciser le bouton 
btStock.setBackground(Color.blue);
btStock.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btStock.setBounds(15, 300, 250, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btStock.requestFocusInWindow();

btAddDesktop = new JButton ("Ajouter un pc fixe");
btAddDesktop.addActionListener(this); //etape 4 pour préciser le bouton 
btAddDesktop.setBackground(new Color(0, 100, 0)); // couleur vert foncé
btAddDesktop.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btAddDesktop.setBounds(15,40, 200, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btAddDesktop.requestFocusInWindow();

btAddLaptop = new JButton ("Ajouter un pc portable");
btAddLaptop.addActionListener(this); //etape 4 pour préciser le bouton 
btAddLaptop.setBackground(new Color(0, 100, 0)); // couleur vert foncé
btAddLaptop.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btAddLaptop.setBounds(221,40, 225, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btAddLaptop.requestFocusInWindow();

btAddAccessory= new JButton ("Ajouter un accessoire");
btAddAccessory.addActionListener(this); //etape 4 pour préciser le bouton 
btAddAccessory.setBackground(new Color(0, 100, 0)); // couleur vert foncé
btAddAccessory.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btAddAccessory.setBounds(451, 40, 215, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btAddAccessory.requestFocusInWindow();

btReturn = new JButton ("Retour");
btReturn.addActionListener(this); //etape 4 pour préciser le bouton 
btReturn.setBackground(Color.red);
btReturn.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btReturn.setBounds(15, 500, 100, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btReturn.requestFocusInWindow();

btHome = new JButton ("Accueil");
btHome.addActionListener(this); //etape 4 pour préciser le bouton 
btHome.setBackground(Color.black);
btHome.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btHome.setBounds(120, 500, 100, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btHome.requestFocusInWindow();

btClose = new JButton ("fermer");
btClose.addActionListener(this); //etape 4 pour préciser le bouton 
btClose.setBackground(Color.red);
btClose.setForeground(Color.white); // Définit la couleur du texte du bouton en blanc
btClose.setBounds(225, 500, 100, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btClose.requestFocusInWindow();

//conteneur qui contien les boutons, jtaLst, et label
JPanel contener = new JPanel ();
contener.setLayout(null);
contener.add(btReturn);
contener.add(btHome);
contener.add(btDelete);
contener.add(title);
contener.add(btModif);
contener.add(btClose);
contener.add(btStock);
contener.add(btAddLaptop);
contener.add(btAddDesktop);
contener.add(btAddAccessory);
contener.setBounds(0, 0, 700, 800);
contener.setBackground(new Color(240,240,240)); //Définit la couleur de fond du conteneur en gris clair
contener.requestFocusInWindow();

add(contener); //ajout du conteneur à la fenetre


setVisible(true);
}


//etape 3 méthode contient traitement de l'évènement action suite au clique du bouton.
public void actionPerformed (ActionEvent e) {
//test si l'utilisateur clique sur le premier bouton afin d'effectuer l'affichage.
if (e.getSource() == btStock) {
//affichage de tous le stoque
//view v1 = new view();
new View ();
}
if (e.getSource() == btAddLaptop) {
     formAddLaptop form=new formAddLaptop();
}
if (e.getSource() == btAddDesktop) {
     formAddDesktop formDesktop=new formAddDesktop();
}
if (e.getSource() == btAddAccessory) {
     formAddAccessory formAccessory=new formAddAccessory();
}
if (e.getSource() == btDelete) {
deleteProduct delete = new deleteProduct();
}
if (e.getSource() == btModif) {
modifProduct modif = new modifProduct(); 
}
if (e.getSource() == btReturn) {
fenetreChoix fc1 = new fenetreChoix ();  
}
if (e.getSource() == btHome) {
fenetre f1 = new fenetre (); }
if (e.getSource() == btClose) {
setVisible(false);
      System.exit(0);
}
}


}