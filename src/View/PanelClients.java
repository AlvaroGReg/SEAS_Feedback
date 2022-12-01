package View;

import Controller.ClientsController;
import Main.FrameMain;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author alvar
 */
public class PanelClients extends javax.swing.JPanel {

    
    private FrameMain frame;
    private ClientsController controller;
    /**
     * Creates new form EditClientes
     */
    public PanelClients(FrameMain frame) {
        this.frame=frame;
        initComponents();
        controller=new ClientsController(this);
        controller.refreshTable();
    }

    public JTable getTable(){
        return ListCli;
    }
    
    public JScrollPane getScrPanel(){
        return jScrollPane2;
    }
    
    public JTextField getTextView_clientName(){
        return txtName;
    }
    
    public JTextField getTextView_prename1(){
        return txtPrename1;
    }
    
    public JTextField getTextView_prename2(){
        return txtPrename2;
    }

    public JTextField getTxtField_telephone() {
        return txtField_telephone;
    }
    
    public JCheckBox getCheckBox_vip() {
        return checkBox_vip;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        txtPrename1 = new javax.swing.JTextField();
        txtPrename2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListCli = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        checkBox_vip = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        txtField_telephone = new javax.swing.JTextField();

        jLabel1.setText("Nombre");

        jLabel2.setText("Primer Apellido");

        jLabel3.setText("Segundo Apellido");

        Modificar.setText("Editar cliente");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClientAction(evt);
            }
        });

        ListCli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Apellido 2", "Telephone", "VIP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ListCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListCliMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ListCli);

        jButton1.setText("Nuevo cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newClientAction(evt);
            }
        });

        jButton2.setText("Borrar cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseClientAction(evt);
            }
        });

        checkBox_vip.setText("VIP");

        jLabel4.setText("Teléfono");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrename2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkBox_vip))
                            .addComponent(txtPrename1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtField_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBox_vip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrename1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrename2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtField_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Modificar)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editClientAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClientAction
        
        if(getTable().getSelectedRowCount()!=1){   
            JOptionPane.showMessageDialog(this,
                "Seleccione el cliente que quiere editar.");              
        }else if(controller.checkValidString(txtName) &&
                controller.checkValidString(txtPrename1) &&
                controller.checkValidString(txtPrename2) &&
                controller.checkValidPhoneNumber(txtField_telephone)){
            controller.editClient();
            JOptionPane.showMessageDialog(this, "Cliente editado.");
        }
    }//GEN-LAST:event_editClientAction

    private void ListCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListCliMouseClicked
       controller.writeSelectedRow();
    }//GEN-LAST:event_ListCliMouseClicked

    private void newClientAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newClientAction
        if(controller.checkValidString(txtName) &&
                controller.checkValidString(txtPrename1) &&
                controller.checkValidString(txtPrename2) &&
                controller.checkValidPhoneNumber(txtField_telephone)){
            controller.addProduct();
            JOptionPane.showMessageDialog(this, "Cliente añadido.");
        } 
    }//GEN-LAST:event_newClientAction

    private void eraseClientAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseClientAction
        if(getTable().getSelectedRowCount()!=1){   
            JOptionPane.showMessageDialog(this,
                "Seleccione el cliente que quiere editar.");     
        }else{
            controller.deleteClient();
            JOptionPane.showMessageDialog(this, "Cliente borrado.");
        }
    }//GEN-LAST:event_eraseClientAction


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListCli;
    private javax.swing.JButton Modificar;
    private javax.swing.JCheckBox checkBox_vip;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtField_telephone;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrename1;
    private javax.swing.JTextField txtPrename2;
    // End of variables declaration//GEN-END:variables
}