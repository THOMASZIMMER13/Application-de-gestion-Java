import java.awt.event.*; 
import java.awt.*;
import javax.swing.*;
public class fenetreEmployes extends JFrame implements ActionListener {

private JLabel title;
private JButton viewButton, effectifButton;
private JButton btReturn, btHome, btClose;
private JTextField jtfEffectif; 
private JTextField tx2; 
private JTextArea text;
private JTextArea text2;
private JComboBox liste;
private JScrollPane js;
private JScrollPane js2;
//création des employés de l'entreprise.
employe ce = new chefEntreprise ("benk", "Guillaume", 40, "12/12/2017");
employe ri1 = new responsableInformatique ("mil", "Tom", 33, "09/01/2018");
employe rc1 = new responsableCommercial ("sing", "Marine", 29, "10/01/2018");
employe c1 = new commercial  ("Dupond", "Jacque", 39, "20/01/2020");
employe c2 = new commercial  ("Charm", "Marie", 34, "15/11/2018");
employe tec1 = new technicien  ("Marl", "Bruno", 45, "18/05/2019");
employe t2 = new technicien  ("Ben", "Sam", 26, "02/11/2022");
employe t3 = new technicien  ("Const", "Lucie", 30, "12/02/2023");
employe m1 = new manutentionnaire  ("Brown", "James", 30, "03/09/2018");
employe m2 = new manutentionnaire  ("harn", "Carim", 28, "19/02/2028");
employe m3 = new manutentionnaire  ("Cork", "Borice", 29, "10/01/2019");
private employe [] monTabEmployes = {ce, ri1, rc1, c1, c2, tec1, t2, t3, m1, m2, m3};


public fenetreEmployes () {
setTitle("Gestion des prims et salaires des employés.");
setSize(400, 600);
setLocation(200,50);
setResizable(false); 
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setLayout(null); //empécher le positionnement automatique des fenetres
this.setLocationRelativeTo(null);

JLabel title=new JLabel ("Gestion des employés");
Font police = new Font("Arial", Font.BOLD, 18);
title.setFont(police);
title.setBounds(110, 5, 300, 20); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
title.requestFocusInWindow(); 


effectifButton = new JButton ("Effectif employé");
effectifButton.addActionListener(this); //etape 4 pour préciser le bouton 
effectifButton.setBackground(Color.cyan);
effectifButton.setBounds(15, 40, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
effectifButton.requestFocusInWindow();

viewButton = new JButton ("Affichage employés");
viewButton.addActionListener(this); //etape 4 pour préciser le bouton 
viewButton.setBackground(Color.cyan);
viewButton.setBounds(15, 300, 160, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
viewButton.requestFocusInWindow();



btReturn = new JButton ("Retour");
btReturn.addActionListener(this); //etape 4 pour préciser le bouton 
btReturn.setBackground(Color.green);
btReturn.setBounds(15, 500, 100, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btReturn.requestFocusInWindow();

btHome = new JButton ("Accueil");
btHome.addActionListener(this); //etape 4 pour préciser le bouton 
btHome.setBackground(Color.green);
btHome.setBounds(120, 500, 100, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btHome.requestFocusInWindow();

btClose = new JButton ("Fermer");
btClose.addActionListener(this); //etape 4 pour préciser le bouton 
btClose.setBackground(Color.red);
btClose.setBounds(225, 500, 100, 50); //2e nombre position du label dans la fenetre, 2 dernier nombre taille
btClose.requestFocusInWindow();

jtfEffectif=new JTextField ("");
jtfEffectif.setEditable(false);
jtfEffectif.setVisible(false);
jtfEffectif.setBounds(200, 40, 160, 50); 
jtfEffectif.requestFocusInWindow();


text2=new JTextArea ();
text2.setLineWrap(true);
text2.setEditable(false);
text2.requestFocusInWindow();

js2 = new JScrollPane(text2,
JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
add(js2);
js2.setBounds(200, 130, 160, 100); 
js2.setVisible(true);


text=new JTextArea ();  
text.setLineWrap(true);
text.setEditable(false);
text.requestFocusInWindow();

js = new JScrollPane(text,
JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
add(js);
js.setBounds(200, 300, 160, 150); 
js.setVisible(false);

Object [] elements = new Object []{"chef d'entreprise", "responsable informatique", "responsable commercial", "commercial 1", "commercial 2", "technicien 1", "technicien 2", "technicien 3", "manutensionnaire 1", "manutensionnaire 2", "manutensionnaire 3"};
JComboBox<String> liste = new JComboBox(elements);
liste.setBounds(15, 130, 160, 23); 
liste.requestFocusInWindow();


//conteneur qui contien les boutons, text, et label
JPanel contener = new JPanel ();
contener.setLayout(null);
contener.add(viewButton);
contener.add(effectifButton);
contener.add(btReturn);
contener.add(btHome);
contener.add(btClose);
contener.add(jtfEffectif);
contener.add(text2);
contener.add(liste);
contener.add(js);
contener.add(js2);
contener.add(title);
contener.setBounds(0, 0, 400, 600);
contener.requestFocusInWindow();
add(contener); //ajout du conteneur à la fenetre


//- 5) --- appliquer une action listener à la liste  JComboBox
liste.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
e.getSource();
text2.setText("Vous avez sélectionné : "+monTabEmployes[liste.getSelectedIndex()]);
js2.setViewportView(text2);
}
});

setVisible(true);
}



public void actionPerformed (ActionEvent e) {


//test si l'utilisateur clique sur le premier bouton afin d'effectuer l'affichage.
if (e.getSource() == viewButton) {
//affichage de tous les employés
js.setVisible(!js.isVisible());

for (int i=0; i<monTabEmployes.length; i++) {
text.append(monTabEmployes[i].toString()+'\n'+'\r');
}
}
if (e.getSource() == effectifButton) {
//affichage du nombre d'employés
jtfEffectif.setVisible(!jtfEffectif.isVisible());
for (int i=0; i<=monTabEmployes.length; i++) {
jtfEffectif.setText(i+""); }
}
if (e.getSource() == btReturn) {
//revien à la fenêtre de choix
fenetreChoix fc1 = new fenetreChoix (); 
}
if (e.getSource() == btHome) {
//réouvre la fenêtre principale
fenetre f1 = new fenetre (); }
if (e.getSource() == btClose) {
//quiter
        System.exit(0);
}
}
}