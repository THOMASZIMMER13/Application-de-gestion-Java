import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class View extends JFrame {
    private JTable table;

    public View() {
        setTitle("Liste des produits");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Connexion à la base de données
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MaterielsBD", "root", "root");
            // Création d'une requête pour récupérer les données de la table "product"
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");

            // Conversion des données de la table en un tableau bidimensionnel
            Object[][] data = new Object[37][16];
            int i = 0;
            while (rs.next()) {
                data[i][0] = rs.getInt("id");
                data[i][1] = rs.getInt("inventory");
                data[i][2] = rs.getString("brand");
                data[i][3] = rs.getString("model");
                data[i][4] = rs.getString("title");
                data[i][5] = rs.getString("description");
                data[i][6] = rs.getFloat("price");
                data[i][7] = rs.getString("serialnumber");
                data[i][8] = rs.getDate("releaseDate");
                data[i][9] = rs.getString("processor");
                data[i][10] = rs.getInt("ram");
                data[i][11] = rs.getInt("storage");
                data[i][12] = rs.getString("os");
                data[i][13] = rs.getFloat("screenSize");
                data[i][14] = rs.getString("computFormat");
                data[i][15] = rs.getString("productType");
                i++;
            }

            // Création de la JTable avec les données récupérées
            String[] columnNames = {"ID", "Stock", "Marque", "Modèle", "Title", "Description", "Prix", "Numéro de série", "Date de sortie", "Processeurr", "RAM", "Stockage", "OS", "ScreenSize", "Computer Format", "Product Type"};
            table = new JTable(data, columnNames);

            // Ajout de la JTable dans un JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane);

            // Ajout des boutons "Delete" et "Close"
            JButton deleteButton = new JButton("Supprimer");
            deleteButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // TODO: Ajouter la fonctionnalité du bouton "Delete"
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MaterielsBD", "root", "root");
                String query = "DELETE FROM product WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, (int) table.getValueAt(selectedRow, 0));
                stmt.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(null, "Le produit à bien était supprimé");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à supprimer.");
        }

                }
            });
            getContentPane().add(deleteButton, "South");

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
//            getContentPane().add(closeButton, "South");

            // Affichage de la fenêtre
            setVisible(true);

            // Fermeture de la connexion
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
