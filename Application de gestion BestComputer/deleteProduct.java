import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
 
public class deleteProduct extends JFrame {
 
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
 
    public deleteProduct() {
setTitle("Supression de produit");
        setSize(800, 600);
        setLocationRelativeTo(null);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 setResizable(false); //empêche l'utilisateur toute modification

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Stock");
        model.addColumn("Marque");
        model.addColumn("Modèle");
        model.addColumn("Titre");
        model.addColumn("Description");
        model.addColumn("Prix");
        model.addColumn("Numéro de série");
        model.addColumn("Date de sorti");
        model.addColumn("Processeur");
        model.addColumn("RAM");
        model.addColumn("Stockage");
        model.addColumn("Systhème d'exploitation");
        model.addColumn("Taille d'écran");
        model.addColumn("Taille d'écran");
        model.addColumn("type de produit");
        model.addColumn("Supprimer!");
 
        table = new JTable(model);
 
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    int id = (int) model.getValueAt(row, 0);
                    deleteProduct(id);
                    model.removeRow(row);
                }
            }
        });


            JButton closeButton = new JButton("Fermer");
            closeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });


        JPanel buttonPanel = new JPanel();
         buttonPanel.add(deleteButton);
         buttonPanel.add(closeButton);
        JScrollPane scrollPane = new JScrollPane(table);
 
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
 
        loadProducts();
    }
 
    private void loadProducts() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaterielsBD", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM product");
            while (rs.next()) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = rs.getInt("id");
                row[1] = rs.getInt("inventory");
                row[2] = rs.getString("brand");
                row[3] = rs.getString("model");
                row[4] = rs.getString("title");
                row[5] = rs.getString("description");
                row[6] = rs.getFloat("price");
                row[7] = rs.getString("serialnumber");
                row[8] = rs.getDate("releaseDate");
                row[9] = rs.getString("processor");
                row[10] = rs.getInt("ram");
                row[11] = rs.getInt("storage");
                row[12] = rs.getString("os");
                row[13] = rs.getFloat("screenSize");
                row[14] = rs.getString("computFormat");
                row[15] = rs.getString("productType");
                row[16] = "Supprimer";
                model.addRow(row);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 

    private void deleteProduct(int id) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaterielsBD", "root", "root");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM product WHERE id=" + id);
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}