package View;

import Controller.AccionesAltaClientes;
import Main.FrameMain;
import javax.swing.JTextField;



/**
 *
 * @author alvar
 */
public class AltaClientes extends javax.swing.JPanel {

    /**
     * Creates new form AltaClientes
     */
    
    private FrameMain frame;
    private AccionesAltaClientes acciones;
    
    public AltaClientes(FrameMain frame) {
        this.frame=frame;
        initComponents();
        acciones=new AccionesAltaClientes(this);
    }    
    
    public FrameMain getFrame(){
        return frame;
    }    
    
    public void setFrame(FrameMain frame){
        this.frame=frame;
    }
    
    public JTextField getTxtNombre(){
        return TxtNombre;
    }
    
    public JTextField getTxtApellido(){
        return TxtApellido;
    }
    
    public JTextField getTxtApellido2(){
        return TxtApellido2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GuardarCliente = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Apellido2 = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        TxtApellido = new javax.swing.JTextField();
        TxtApellido2 = new javax.swing.JTextField();

        setLayout(null);

        GuardarCliente.setText("Guardar");
        GuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarClienteActionPerformed(evt);
            }
        });
        add(GuardarCliente);
        GuardarCliente.setBounds(170, 160, 90, 25);

        Nombre.setText("Nombre");
        add(Nombre);
        Nombre.setBounds(50, 30, 50, 15);

        Apellido.setText("Primer Apellido");
        add(Apellido);
        Apellido.setBounds(50, 70, 120, 15);

        Apellido2.setText("Segundo Apellido");
        add(Apellido2);
        Apellido2.setBounds(50, 110, 120, 15);
        add(TxtNombre);
        TxtNombre.setBounds(180, 30, 140, 19);
        add(TxtApellido);
        TxtApellido.setBounds(180, 70, 140, 19);
        add(TxtApellido2);
        TxtApellido2.setBounds(180, 110, 140, 19);
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarClienteActionPerformed
     acciones.newClient(TxtNombre.getText(), TxtApellido.getText(), TxtApellido2.getText());
    }//GEN-LAST:event_GuardarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Apellido;
    private javax.swing.JLabel Apellido2;
    private javax.swing.JButton GuardarCliente;
    private javax.swing.JLabel Nombre;
    private javax.swing.JTextField TxtApellido;
    private javax.swing.JTextField TxtApellido2;
    private javax.swing.JTextField TxtNombre;
    // End of variables declaration//GEN-END:variables
}