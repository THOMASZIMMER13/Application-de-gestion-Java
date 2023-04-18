import java.io.*;
import java.util.*; 
import java.awt.event.*; 
import java.sql.*;
import java.awt.*;
import javax.swing.*;
public class formAddDesktop extends JFrame implements ActionListener {


    private Connection conn;    //attribut qui memorise la connexion a la base

private JLabel labInventory, labBrand, labModel, labTitle, labDescription, labPrice, labSerialnumber, labReleaseDate, labProcessor, labRam, labStorage, labOs, labComputFormat;

private JTextField jtfInventory, jtfBrand, jtfModel, jtfTitle, jtfPrice, jtfSerialnumber, jtfReleaseDate, jtfProcessor, jtfRam, jtfStorage, jtfOs, jtfComputFormat;

private JPanel Conteneur1, Conteneur2;

private JButton btAdd, btClose, btReset;
private JTextArea jtaDescription;
private String[] options = {"4", "8", "16", "32", "64", "128"};
private String[] format = {"MT (Mini Tower)", "DT (Desktop)", "MFF (Micro Form Factor)", "SFF (Small Form Factor)", "USFF (Ultra Small Form Factor)"};
private JComboBox ram;
private JComboBox jcbComputFormat;

public formAddDesktop (){

setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Ajout d'un nouveau PC Fixe");
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		JPanel pan=new JPanel();
		pan.setLayout(null);
		pan.setBackground(Color.blue);
		pan.requestFocusInWindow();
		add(pan);
		
		
		labInventory=new JLabel("Nombre de pièce disponible :");
		labInventory.setBounds(20,30,200,30);
		labInventory.setFont(new Font("Arial",Font.BOLD,12));
		labInventory.setForeground(Color.white);
		pan.add(labInventory);
		
		jtfInventory=new JTextField();
		jtfInventory.setBounds(250,30,200,30);
		jtfInventory.setToolTipText("nombre de pièce disponible");
		jtfInventory.requestFocusInWindow();
		pan.add(jtfInventory);
		
		labBrand=new JLabel("Marque :");
		labBrand.setBounds(20,70,200,30);
		labBrand.setFont(new Font("Arial",Font.BOLD,12));
		labBrand.setForeground(Color.white);
		pan.add(labBrand);
		
		jtfBrand=new JTextField();
		jtfBrand.setBounds(250,70,200,30);
		jtfBrand.requestFocusInWindow();
		jtfBrand.setToolTipText("Marque");
		pan.add(jtfBrand);
		
		labModel=new JLabel("Modèle :");
		labModel.setBounds(20,110,200,30);
		labModel.setFont(new Font("Arial",Font.BOLD,12));
		labModel.setForeground(Color.white);
		pan.add(labModel);

		jtfModel=new JTextField();
		jtfModel.setBounds(250,110,200,30);
		jtfModel.requestFocusInWindow();
		jtfModel.setToolTipText("Modèle");
		pan.add(jtfModel);
		
		labTitle=new JLabel("Titre du produit :");
		labTitle.setBounds(20,150,200,30);
		labTitle.setFont(new Font("Arial",Font.BOLD,12));
		labTitle.setForeground(Color.white);
		pan.add(labTitle);

		jtfTitle=new JTextField();
		jtfTitle.setBounds(250,150,200,30);
		jtfTitle.setToolTipText("Titre du produit");
		jtfTitle.requestFocusInWindow();		pan.add(jtfTitle);

		labDescription=new JLabel("Description du produit :");
		labDescription.setBounds(20,190,200,30);
		labDescription.setFont(new Font("Arial",Font.BOLD,12));
		labDescription.setForeground(Color.white);
		pan.add(labDescription);

		jtaDescription=new JTextArea ();
		jtaDescription.setBounds(250,190,200,30);
//		jtaDescription.requestFocusInWindow();
		jtaDescription.setToolTipText("Description du produit");
		pan.add(jtaDescription);
		
		labPrice=new JLabel("Prix du produit :");
		labPrice.setBounds(20,230,200,30);
		labPrice.setFont(new Font("Arial",Font.BOLD,12));
		labPrice.setForeground(Color.white);
		pan.add(labPrice);

		jtfPrice=new JTextField();
		jtfPrice.setBounds(250,230,200,30);
		jtfPrice.setToolTipText("Prix");
		jtfPrice.requestFocusInWindow();
		pan.add(jtfPrice);
		
		
		labSerialnumber=new JLabel("Numéro de série :");
		labSerialnumber.setBounds(20,270,200,30);
		labSerialnumber.setFont(new Font("Arial",Font.BOLD,12));
		labSerialnumber.setForeground(Color.white);
		pan.add(labSerialnumber);

		jtfSerialnumber=new JTextField();
		jtfSerialnumber.setBounds(250,270,200,30);
		jtfSerialnumber.setToolTipText("Numéro de série");
		jtfSerialnumber.requestFocusInWindow();
		pan.add(jtfSerialnumber);
		
		labReleaseDate=new JLabel("Date de sortie du produit (yyyy-mm-dd) :");
		labReleaseDate.setBounds(20,310,200,30);
		labReleaseDate.setFont(new Font("Arial",Font.BOLD,12));
		labReleaseDate.setForeground(Color.white);
		pan.add(labReleaseDate);

		jtfReleaseDate=new JTextField();
		jtfReleaseDate.setBounds(250,310,200,30);
		jtfReleaseDate.setToolTipText("Date de sortie du produit");
jtfReleaseDate.requestFocusInWindow();
		pan.add(jtfReleaseDate);
		
		labProcessor=new JLabel("Nom du processeur :");
		labProcessor.setBounds(20,350,200,30);
		labProcessor.setFont(new Font("Arial",Font.BOLD,12));
		labProcessor.setForeground(Color.white);
		pan.add(labProcessor);

		jtfProcessor=new JTextField();
		jtfProcessor.setBounds(250,350,200,30);
		jtfProcessor.setToolTipText("Processeur");
		jtfProcessor.requestFocusInWindow();
		pan.add(jtfProcessor);
		
		labRam=new JLabel("Taille de la ram :");
		labRam.setBounds(20,390,200,30);
		labRam.setFont(new Font("Arial",Font.BOLD,12));
		labRam.setForeground(Color.white);
		pan.add(labRam);

    ram = new JComboBox<String>(options);
ram.setBounds(250,390,200,30);
ram.setToolTipText("RAM");
ram.requestFocusInWindow();
pan.add(ram);

		labStorage=new JLabel("Taille du stockage :");
		labStorage.setBounds(20,430,200,30);
		labStorage.setFont(new Font("Arial",Font.BOLD,12));
		labStorage.setForeground(Color.white);
		pan.add(labStorage);

		jtfStorage=new JTextField();
		jtfStorage.setBounds(250,430,200,30);
		jtfStorage.setToolTipText("Taille du stockage");
		jtfStorage.requestFocusInWindow();
		pan.add(jtfStorage);
		
		labOs=new JLabel("Système d'exploitation :");
		labOs.setBounds(20,470,200,30);
		labOs.setFont(new Font("Arial",Font.BOLD,12));
		labOs.setForeground(Color.white);
		pan.add(labOs);

		jtfOs=new JTextField();
		jtfOs.setBounds(250,470,200,30);
jtfOs.setToolTipText("Système d'exploitation");
		jtfOs.requestFocusInWindow();
		pan.add(jtfOs);

		labComputFormat=new JLabel("Taille de l'écran (exemple 13.3) :");
		labComputFormat.setBounds(20,510,200,30);
		labComputFormat.setFont(new Font("Arial",Font.BOLD,12));
		labComputFormat.setForeground(Color.white);
		pan.add(labComputFormat);

		jcbComputFormat = new JComboBox<String>(format);
		jcbComputFormat.setBounds(250,510,200,30);
		jcbComputFormat.setToolTipText("Format");
		jcbComputFormat.requestFocusInWindow();
		pan.add(jcbComputFormat);
		

		btAdd=new JButton("Ajouter");
		btAdd.setBounds(150,550,150,30);
		btAdd.setBackground(Color.green);
		btAdd.setFont(new Font("Arial",Font.BOLD,18));
		btAdd.setForeground(Color.green);
btAdd.addActionListener(this);
		btAdd.requestFocusInWindow();
		pan.add(btAdd);


		btClose=new JButton("Fermer");
		btClose.setBounds(150,590,150,30);
		btClose.setBackground(Color.red);
		btClose.setFont(new Font("Arial",Font.BOLD,18));
		btClose.setForeground(Color.red);
btClose.addActionListener(this);
		btClose.requestFocusInWindow();
		pan.add(btClose);

		btReset=new JButton("Effacer les champs de text");
		btReset.setBounds(150,630,150,30);
		btReset.setBackground(new Color(173, 216, 230)); // Couleur bleu clair
		btReset.setFont(new Font("Arial",Font.BOLD,18));
		btReset.setForeground(Color.blue);
btReset.addActionListener(this);
		btReset.requestFocusInWindow();
		pan.add(btReset);

setVisible(true);
	}


  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btAdd) {
      try {
        // Récupération des données du formulaire
        int inventory = Integer.parseInt(jtfInventory.getText());
        String brand = jtfBrand.getText();
        String model = jtfModel.getText();
        String title = jtfTitle.getText();
        String description = jtaDescription.getText();
        float price = Float.parseFloat(jtfPrice.getText());
        String serialNumber = jtfSerialnumber.getText();
java.sql.Date releaseDate = java.sql.Date.valueOf(jtfReleaseDate.getText());
        String processor = jtfProcessor.getText(); 
String value = (String)ram.getSelectedItem();
int ram  = Integer.parseInt(value);
        int storage = Integer.parseInt(jtfStorage.getText());
        String os = jtfOs.getText();
String computFormat = (String) jcbComputFormat.getSelectedItem();
        String productType ="desktop";

        // Connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/MaterielsBD";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, user, password);

        // Préparation de la requête SQL
        String sql = "INSERT INTO product(inventory, brand, model, title, description, price, serialnumber, releasedate, processor, ram, storage, os, computFormat, producttype) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, inventory);
        stmt.setString(2, brand);
        stmt.setString(3, model);
        stmt.setString(4, title);
        stmt.setString(5, description);
        stmt.setFloat(6, price);
        stmt.setString(7, serialNumber);
        stmt.setDate(8, new java.sql.Date(releaseDate.getTime()));
        stmt.setString(9, processor);
        stmt.setInt(10, ram);
        stmt.setInt(11, storage);
        stmt.setString(12, os);
        stmt.setString(13, computFormat);
        stmt.setString(14, productType);

        // Exécution de la requête SQL
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
          JOptionPane.showMessageDialog(this, "Le produit a été ajouté à la base de données");
          // Effacer les champs de saisie
          jtfInventory.setText("");
          jtfBrand.setText("");
          jtfModel.setText("");
          jtfTitle.setText("");
          jtaDescription.setText("");
          jtfPrice.setText("");
          jtfSerialnumber.setText("");
          jtfReleaseDate.setText("");
          jtfProcessor.setText("");
          jtfRam.setText("");
          jtfStorage.setText("");
          jtfOs.setText("");
          jtfComputFormat.setText("");
        }

        // Fermeture de la connexion
        conn.close();

      } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Une erreur s'est produite : " + ex.getMessage());
      }
    }
    if (e.getSource() == btClose) {
setVisible(false);
  }
    if (e.getSource() == btReset) {
          // Effacer les champs de saisie
          jtfInventory.setText("");
          jtfBrand.setText("");
          jtfModel.setText("");
          jtfTitle.setText("");
          jtaDescription.setText("");
          jtfPrice.setText("");
          jtfSerialnumber.setText("");
          jtfReleaseDate.setText("");
          jtfProcessor.setText("");
          jtfRam.setText("");
          jtfStorage.setText("");
          jtfOs.setText("");
          jtfComputFormat.setText("");
        }
}
}