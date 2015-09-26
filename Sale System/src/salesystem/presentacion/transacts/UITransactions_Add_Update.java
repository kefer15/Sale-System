package salesystem.presentacion.transacts;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class UITransactions_Add_Update extends javax.swing.JFrame {

    private ITransactions_Add_Update interfaceTransacts;
    public UITransactions_Add_Update(ITransactions_Add_Update interfaceTransacts,boolean type) {
        
        initComponents();
        this.setVisible(true);
        this.setTitle("Add / Update Transactions");
        setLocationRelativeTo(null);
        
        this.interfaceTransacts = interfaceTransacts;
        this.lblCode.setVisible(type);
        this.txtCode.setVisible(type);
        if(type)
        {
            interfaceTransacts.cargar(txtCode, txtAccount,txtInvoice,txtTypeTrans, dcDateOpened, txtAmount, txtOther);
        } 
        interfaceTransacts.autoComplete(txtAccount, 1);
        interfaceTransacts.autoComplete(txtInvoice, 2);
        interfaceTransacts.autoComplete(txtTypeTrans, 3);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDateOpened = new javax.swing.JLabel();
        lblAmount = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        lblInvoice = new javax.swing.JLabel();
        lblOther = new javax.swing.JLabel();
        txtTypeTrans = new javax.swing.JTextField();
        dcDateOpened = new com.toedter.calendar.JDateChooser();
        lblTypeTransaction = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblTransactions = new javax.swing.JLabel();
        btnDone = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtInvoice = new javax.swing.JTextField();
        txtAccount = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtOther = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblDateOpened.setText("Date Opened");

        lblAmount.setText("Amount");

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        lblInvoice.setText("Invoice");

        lblOther.setText("Other");

        txtTypeTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTypeTransActionPerformed(evt);
            }
        });

        dcDateOpened.setDateFormatString("yyyy-MM-dd");

        lblTypeTransaction.setText("Type Transaction");

        lblCode.setText("Id");

        lblTransactions.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTransactions.setText("TRANSACTIONS");

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("Account");

        txtOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOther)
                            .addComponent(txtOther, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCode)
                                        .addGap(115, 115, 115)
                                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblTypeTransaction)
                                            .addComponent(lblInvoice)
                                            .addComponent(jLabel1)
                                            .addComponent(lblDateOpened))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dcDateOpened, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtAccount)
                                            .addComponent(txtTypeTrans, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                            .addComponent(txtInvoice))))
                                .addGap(70, 70, 70)
                                .addComponent(lblAmount)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addComponent(btnDone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblTransactions)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTransactions)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInvoice)
                    .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTypeTransaction)
                    .addComponent(txtTypeTrans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDateOpened)
                        .addComponent(lblAmount)
                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcDateOpened, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblOther)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDone)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtOther)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        try
        {
            String formato = dcDateOpened.getDateFormatString();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            String date = String.valueOf(sdf.format(dcDateOpened.getDate()));
            
            interfaceTransacts.agregarModificarTransacts(txtCode.getText(),txtAccount.getText(), txtInvoice.getText(), txtTypeTrans.getText(), date, txtAmount.getText(),txtOther.getText());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You must choose a date", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        interfaceTransacts.cerrar();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void txtTypeTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTypeTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTypeTransActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void txtOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtherActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private com.toedter.calendar.JDateChooser dcDateOpened;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDateOpened;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblOther;
    private javax.swing.JLabel lblTransactions;
    private javax.swing.JLabel lblTypeTransaction;
    private javax.swing.JTextField txtAccount;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtOther;
    private javax.swing.JTextField txtTypeTrans;
    // End of variables declaration//GEN-END:variables
}
