import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class View extends JFrame {

    private JPanel contentPane;
    private JTable productTable;
    private DefaultTableModel productTableModel;

    private Connection conn;

    /**
     * Create the frame.
     */
    public View() {
        setVisible(true);
        setTitle("Affichage des produits");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Connect to the database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MaterielsBD", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the table model
        productTableModel = new DefaultTableModel();
        productTableModel.addColumn("ID");
        productTableModel.addColumn("Inventory");
        productTableModel.addColumn("Brand");
        productTableModel.addColumn("Model");
        productTableModel.addColumn("Title");
        productTableModel.addColumn("Description");
        productTableModel.addColumn("Price");
        productTableModel.addColumn("Serial Number");
        productTableModel.addColumn("Release Date");
        productTableModel.addColumn("Processor");
        productTableModel.addColumn("RAM");
        productTableModel.addColumn("Storage");
        productTableModel.addColumn("OS");
        productTableModel.addColumn("Screen Size");
        productTableModel.addColumn("Computer Format");
        productTableModel.addColumn("Product Type");

        // Populate the table with data from the database
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] rowData = new Object[16];
                rowData[0] = rs.getInt("id");
                rowData[1] = rs.getInt("inventory");
                rowData[2] = rs.getString("brand");
                rowData[3] = rs.getString("model");
                rowData[4] = rs.getString("title");
                rowData[5] = rs.getString("description");
                rowData[6] = rs.getFloat("price");
                rowData[7] = rs.getString("serialnumber");
                rowData[8] = rs.getDate("releaseDate");
                rowData[9] = rs.getString("processor");
                rowData[10] = rs.getInt("ram");
                rowData[11] = rs.getInt("storage");
                rowData[12] = rs.getString("os");
                rowData[13] = rs.getFloat("screenSize");
                rowData[14] = rs.getString("computFormat");
                rowData[15] = rs.getString("productType");
                productTableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create the table and add it to the
        productTable = new JTable(productTableModel);
        productTable.getColumnModel().getColumn(0).setPreferredWidth(30);
        productTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(2).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        productTable.getColumnModel().getColumn(5).setPreferredWidth(250);
        productTable.getColumnModel().getColumn(6).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(7).setPreferredWidth(120);
        productTable.getColumnModel().getColumn(8).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(9).setPreferredWidth(120);
        productTable.getColumnModel().getColumn(10).setPreferredWidth(40);
        productTable.getColumnModel().getColumn(11).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(12).setPreferredWidth(60);
        productTable.getColumnModel().getColumn(13).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(14).setPreferredWidth(80);
        productTable.getColumnModel().getColumn(15).setPreferredWidth(80);
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        JScrollPane scrollPane = new JScrollPane(productTable);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Add a listener for the table selection
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    int id = (int) productTableModel.getValueAt(selectedRow, 0);
                    showProductDetailsWindow(id);
                }
            }
        });
    }

    /**
     * Show the window for editing a product.
     */
    private void showProductDetailsWindow(int productId) {
        // TODO: Implement the product details window
        // You can use the productId to retrieve the details of the product from the database
        // and show them in a form that allows the user to edit them
    }
}