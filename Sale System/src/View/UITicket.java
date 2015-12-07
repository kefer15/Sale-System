package View;

import Interface.ITicket;

import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class UITicket extends javax.swing.JFrame {
    private ITicket iTicket;
    
    /** Between this method starts the UI
     * @param iTicket
     * @param strCode
     * @param iOption */
    public UITicket(ITicket iTicket, String strCode, int iOption) {
        initComponents();
        this.setVisible(true);
        this.setTitle("Detalle de Compra");
        setLocationRelativeTo(null);        
        this.iTicket = iTicket;
        
        switch(iOption){
            case 0: this.lblMessage.setText("Comprobante Guardado");
                    break;
            
            case 1: this.lblMessage.setText("Venta Exitosa. Comprobante Generado");
                    break;
            
            default:    JOptionPane.showMessageDialog(null, "Default Option");
                        break;
        }
        StringBuilder strValue = new StringBuilder(500);
        strValue.append("Boletas");
        strValue.append(File.separator);
        strValue.append(strCode);
        strValue.append(".png");
        
        ImageIcon cIcono = new ImageIcon(String.valueOf(strValue));  
        this.lblTicket.setIcon(cIcono);
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAcept = new javax.swing.JButton();
        lblTicket = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Sources/icon.png")));

        btnAcept.setText("Aceptar");
        btnAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptActionPerformed(evt);
            }
        });

        lblMessage.setText("Mensaje:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 418, Short.MAX_VALUE)
                        .addComponent(btnAcept))
                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAcept)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptActionPerformed
        this.iTicket.close();
    }//GEN-LAST:event_btnAceptActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcept;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTicket;
    // End of variables declaration//GEN-END:variables
}
