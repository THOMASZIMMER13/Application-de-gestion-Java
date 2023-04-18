import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
public class fenetreChoix extends JFrame implements ActionListener {

private JButton btStock;
private JButton btEmploye;
private JButton btReturn; 
private JButton btClose;
private JLabel l1;

public fenetreChoix () {
setTitle(" Choisir la catégorie à afficher ");
setSize(400, 600);
setLocation(200,50);
setResizable(false); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null); //empécher le positionnement automatique des fenetres


l1 = new JLabel ("Selection Catégorie");
Font police = new Font("Arial", Font.BOLD, 18);
l1.setFont(police);
l1.setBackground(Color.green);
l1.setBounds(100, 10, 300, 100); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
l1.requestFocusInWindow();


btStock = new JButton ("Gestion stock");
btStock.addActionListener(this); //etape 4 pour préciser le bouton 
btStock.setBackground(Color.cyan);
btStock.setBounds(110, 120, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btStock.requestFocusInWindow();

btEmploye = new JButton ("Gestion employés ");
btEmploye.addActionListener(this); //etape 4 pour préciser le bouton 
btEmploye.setBackground(Color.cyan);
btEmploye.setBounds(110, 250, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btEmploye.requestFocusInWindow();


btReturn = new JButton ("Retour");
btReturn.addActionListener(this); //etape 4 pour préciser le bouton 
btReturn.setBackground(Color.green);
btReturn.setBounds(15, 400, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btReturn.requestFocusInWindow();


btClose = new JButton ("Fermer");
btClose.addActionListener(this); //etape 4 pour préciser le bouton 
btClose.setBackground(Color.red);
btClose.setBounds(195, 400, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btClose.requestFocusInWindow();


//conteneur qui contien les boutons, text, et label
JPanel contener = new JPanel ();
contener.setLayout(null);
contener.add(btStock);
contener.add(btEmploye);
contener.add(btReturn);
contener.add(btClose);
contener.add(l1);
contener.setBounds(10, 10, 400, 500);
contener.requestFocusInWindow();
add(contener); //ajout du conteneur à la fenetre
setVisible(true);
}


//etape 3 méthode contient traitement de l'évènement action suite au clique du bouton.
public void actionPerformed (ActionEvent e) {
//test si l'utilisateur clique sur le premier bouton afin d'effectuer l'affichage.
if (e.getSource() == btStock)  {
fenetreStock fs1 = new fenetreStock (); }
if (e.getSource() == btEmploye)  {
fenetreEmployes fe1 = new fenetreEmployes (); }
if (e.getSource() == btReturn) {
fenetre f1 = new fenetre ();
}
if (e.getSource() == btClose) {
System.exit(0);
}
}
}