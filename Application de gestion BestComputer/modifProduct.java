import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class modifProduct extends JFrame implements ActionListener {

    private JTextField idField, inventoryField, brandField, modelField, titleField, priceField, serialField;
    private JTextArea descriptionArea;
    private JComboBox<String> productTypeBox;
    private JSpinner ramSpinner, storageSpinner, screenSizeSpinner;
    private JTextField processorField, osField, computFormatField;
    private JButton saveButton, resetButton, closeButton;
    private Connection con;

    public modifProduct () {

setTitle("Actualisation des informations produits");
    setSize(400, 600);
    setLocationRelativeTo(null);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setLayout(null); //empécher le positionnement automatique des fenetres

        // Create GUI components
        idField = new JTextField(10);
        inventoryField = new JTextField(10);
        brandField = new JTextField(10);
        modelField = new JTextField(10);
        titleField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        priceField = new JTextField(10);
        serialField = new JTextField(10);
        productTypeBox = new JComboBox<String>(new String[]{"laptop", "desktop", "accessory"});
        ramSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 64, 1));
        storageSpinner = new JSpinner(new SpinnerNumberModel(128, 128, 4096, 1));
        screenSizeSpinner = new JSpinner(new SpinnerNumberModel(15.6, 10.1, 34, 0.1));
        processorField = new JTextField(20);
        osField = new JTextField(10);
        computFormatField = new JTextField(10);
        saveButton = new JButton("Enregistrer");
        resetButton = new JButton("Actualiser");
        closeButton = new JButton("Fermer");

        // Add action listeners to buttons
        saveButton.addActionListener(this);
        resetButton.addActionListener(this);
        closeButton.addActionListener(this);

        // Set layout of the window
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("ID:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(idField, c);
        c.gridy++;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Stock:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(inventoryField, c);
        c.gridy++;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Marque:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(brandField, c);
        c.gridy++;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Modèle:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(modelField, c);
        c.gridy++;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Titre:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(titleField, c);
        c.gridy++;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Description:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(new JScrollPane(descriptionArea), c);
        c.gridy++;
        c.gridx = 0;
        c.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Prix:"), c);
        c.gridx++;
        c.anchor = GridBagConstraints.LINE_START;
        add(priceField, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Numéro de série:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(serialField, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Type de produit:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(productTypeBox, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("RAM:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(ramSpinner, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Stockage:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(storageSpinner, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Taille d'écran:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(screenSizeSpinner, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Processeur:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(processorField, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Système d'exploitation:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(osField, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.LINE_END;
    add(new JLabel("Format d'ordinateur:"), c);
    c.gridx++;
    c.anchor = GridBagConstraints.LINE_START;
    add(computFormatField, c);
    c.gridy++;
    c.gridx = 0;
    c.anchor = GridBagConstraints.CENTER;
    c.gridwidth = 2;
    add(saveButton, c);
    c.gridy++;
    add(resetButton, c);
    c.gridy++;
    add(closeButton, c);

    // Connect to the database
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/MaterielsBD", "root", "root");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Load data from the database
    loadData();
setVisible(true);
}

private void loadData() {
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");
        if (rs.next()) {
            idField.setText(rs.getString("id"));
            inventoryField.setText(rs.getString("inventory"));
            brandField.setText(rs.getString("brand"));
            modelField.setText(rs.getString("model"));
            titleField.setText(rs.getString("title"));
            descriptionArea.setText(rs.getString("description"));
            priceField.setText(rs.getString("price"));
            serialField.setText(rs.getString("serialnumber"));
            productTypeBox.setSelectedItem(rs.getString("productType"));
            ramSpinner.setValue(rs.getInt("ram"));
            storageSpinner.setValue(rs.getInt("storage"));
            screenSizeSpinner.setValue(rs.getFloat("screenSize"));
            processorField.setText(rs.getString("processor"));
            osField.setText(rs.getString("os"));
            computFormatField.setText(rs.getString("computFormat"));
        }
        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void actionPerformed(ActionEvent e) {
    if (e.getSource() == closeButton) {
setVisible(false);
}    
// Save button clicked
if (e.getSource() == saveButton) {
try {
// Update the database
PreparedStatement pstmt = con.prepareStatement("UPDATE product SET inventory=?, brand=?, model=?, title=?, description=?, price=?, serialnumber=?, releaseDate=?, processor=?, ram=?, storage=?, os=?, screenSize=?, computFormat=?, productType=? WHERE id=?");
pstmt.setInt(1, Integer.parseInt(inventoryField.getText()));
pstmt.setString(2, brandField.getText());
pstmt.setString(3, modelField.getText());
pstmt.setString(4, titleField.getText());
pstmt.setString(5, descriptionArea.getText());
pstmt.setFloat(6, Float.parseFloat(priceField.getText()));
pstmt.setString(7, serialField.getText());
pstmt.setDate(8, new java.sql.Date(new java.util.Date().getTime()));
pstmt.setString(9, processorField.getText());
pstmt.setInt(10, (Integer) ramSpinner.getValue());
pstmt.setInt(11, (Integer) storageSpinner.getValue());
pstmt.setString(12, osField.getText());
pstmt.setFloat(13, (Float) screenSizeSpinner.getValue());
pstmt.setString(14, computFormatField.getText());
pstmt.setString(15, (String) productTypeBox.getSelectedItem());
pstmt.setInt(16, Integer.parseInt(idField.getText()));
pstmt.executeUpdate();
pstmt.close();

            // Display success message
            JOptionPane.showMessageDialog(this, "Modification réussi");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de la modification, veuillez réessayer. ");
        }
    }

    // Reset button clicked
    if (e.getSource() == resetButton) {
        loadData();
    }
}

}
