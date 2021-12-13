/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product.registration.rmi.view;

import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import product.registration.rmi.ProductService;
import product.registration.rmi.model.Product;
import product.registration.rmi.util.ProjectMap;

/**
 * @author roberlan-carvalho
 */
public class Home extends javax.swing.JFrame {

    ProductService service = null;
    DefaultTableModel model;
    private Label productQuantity;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        try {
            service = (ProductService) Naming.lookup("rmi://" + ProjectMap.RMI_PROPERTY_IP + ":" + ProjectMap.RMI_PROPERTY_PORT + "/" + ProjectMap.RMI_SERVICE_NAME);
            model = (DefaultTableModel) productsTable.getModel();
            
            reloadTable();
            
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "NotBoundException > "+ex.getMessage());
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "MalformedURLException > "+ex.getMessage());
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "RemoteException > "+ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        productRegistrationLabel = new javax.swing.JLabel();
        productNameLabel = new javax.swing.JLabel();
        productName = new javax.swing.JTextField();
        productDescriptionLabel = new javax.swing.JLabel();
        productPrice = new javax.swing.JTextField();
        productPriceLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDescription = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        alterButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        productRegistrationLabel.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        productRegistrationLabel.setText("Product Registration");
        productRegistrationLabel.setFocusable(false);
        productRegistrationLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        productNameLabel.setText("Name");

        productDescriptionLabel.setText("Description");

        productPriceLabel.setText("price");

        productDescription.setColumns(20);
        productDescription.setRows(5);
        jScrollPane1.setViewportView(productDescription);

        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        alterButton.setText("ALTER");
        alterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterButtonActionPerformed(evt);
            }
        });

        removeButton.setText("REMOVE");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(productsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(productNameLabel)
                                    .addComponent(productPriceLabel)
                                    .addComponent(productName)
                                    .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productDescriptionLabel)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(productRegistrationLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(productRegistrationLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productNameLabel)
                            .addComponent(productDescriptionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(productPriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(alterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String name = productName.getText().trim();
        String description = productDescription.getText().trim();
        int quantity = Integer.parseInt(productQuantity.getText().trim());
        String price = productPrice.getText().trim();
        
        if (name.isEmpty() || description.isEmpty()  || price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill in the fields.");
        } else {            
            try {
                double priceDouble = Double.parseDouble(price);
                try {
                    Product product = new Product(name, description, quantity, priceDouble);
                    product = service.add(product);

                    if (product != null) {
                        addToTable(product);
                    } else {
                        JOptionPane.showMessageDialog(null, "Add Product Err!");
                    }

                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "RMI Err > "+ex.getMessage());
                }   
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price invalid format!");
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void alterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterButtonActionPerformed
        if (productsTable.getSelectedRow() == -1){
            if (productsTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!");
            } else {
                JOptionPane.showMessageDialog(null, "You must select a product!");
            }
        } else {
            String name = productName.getText().trim();
            String description = productDescription.getText().trim();
            int quantity = Integer.parseInt(productQuantity.getText().trim());
            String price = productPrice.getText().trim();

            if (name.isEmpty() || description.isEmpty() || price.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in the fields.");
            } else {            
                try {
                    double priceDouble = Double.parseDouble(price);
                    try {
                        int id = Integer.parseInt(model.getValueAt(productsTable.getSelectedRow(), 0).toString());

                        Product product = new Product(id, name, description, quantity, priceDouble);

                        if (service.alter(product)) {
                            reloadTable();
                        } else {
                            JOptionPane.showMessageDialog(null, "Alter Product Err!");
                        }

                    } catch (RemoteException ex) {
                        JOptionPane.showMessageDialog(null, "RMI Err > "+ex.getMessage());
                    }   
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Price invalid format!");
                }
            }
        }
    }//GEN-LAST:event_alterButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if (productsTable.getSelectedRow() == -1){
            if (productsTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is empty!");
            } else {
                JOptionPane.showMessageDialog(null, "You must select a product!");
            }
        } else {            
            try {
                double priceDouble = Double.parseDouble(model.getValueAt(productsTable.getSelectedRow(), 0).toString());
                try {
                    int id = Integer.parseInt(model.getValueAt(productsTable.getSelectedRow(), 0).toString());

                    if (service.remmove(id)) {
                        model.removeRow(productsTable.getSelectedRow());
                    } else {
                        JOptionPane.showMessageDialog(null, "Remove Product Err!");
                    }

                } catch (RemoteException ex) {
                    JOptionPane.showMessageDialog(null, "RMI Err > "+ex.getMessage());
                }   
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price invalid format!");
            }
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        productName.setText(model.getValueAt(productsTable.getSelectedRow(), 1).toString());
        productDescription.setText(model.getValueAt(productsTable.getSelectedRow(), 2).toString());
        productPrice.setText(model.getValueAt(productsTable.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_productsTableMouseClicked

    private void reloadTable() throws RemoteException {
        model.getDataVector().removeAllElements();
        
        List<Product> products = service.selectAll();
            
        for (Product product : products){
            addToTable(product);
        }
    }
    
    private void addToTable(Product product){    
        model.addRow(new Object[]{product.getId(), product.getName(), product.getDescription(), product.getPrice()});
        clear();
    }
    
    private void clear(){
        productName.setText("");
        productDescription.setText("");
        productPrice.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton alterButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTextArea productDescription;
    private javax.swing.JLabel productDescriptionLabel;
    private static javax.swing.JTextField productName;
    private javax.swing.JLabel productNameLabel;
    private static javax.swing.JTextField productPrice;
    private javax.swing.JLabel productPriceLabel;
    private javax.swing.JLabel productRegistrationLabel;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

}
