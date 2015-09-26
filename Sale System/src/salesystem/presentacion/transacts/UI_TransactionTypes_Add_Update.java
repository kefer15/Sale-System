package salesystem.presentacion.transacts;

public class UI_TransactionTypes_Add_Update extends javax.swing.JFrame {

    private ITransactionTypes_Add_Update interfaceTransactionTypes;
    public UI_TransactionTypes_Add_Update(ITransactionTypes_Add_Update interfaceTransactionTypes, String code) {
        this.interfaceTransactionTypes = interfaceTransactionTypes;
        initComponents();
        this.setVisible(true);
        this.setTitle("Add / Update Transactions Types");
        setLocationRelativeTo(null);
        
        this.txCode.setText(code);
    }
    
    public UI_TransactionTypes_Add_Update(ITransactionTypes_Add_Update interfaceTransactionTypes, String code, String description) {
        this.interfaceTransactionTypes = interfaceTransactionTypes;
        initComponents();
        this.setVisible(true);
        this.setTitle("Add / Update Transactions Types");
        setLocationRelativeTo(null);
        
        this.txCode.setText(code);
        this.txDescription.setText(description);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tlTransactionTypes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txDescription = new javax.swing.JTextField();
        btbDone = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tlTransactionTypes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tlTransactionTypes.setText("Transaction Types");

        jLabel2.setText("Code");

        txCode.setEditable(false);

        jLabel4.setText("Description");

        btbDone.setText("Done");
        btbDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbDoneActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btbDone)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCode, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(tlTransactionTypes)
                            .addComponent(txDescription))))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tlTransactionTypes)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbDone)
                    .addComponent(btnCancel))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btbDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbDoneActionPerformed
        interfaceTransactionTypes.addUpdateTransactionTypes(txCode.getText(), txDescription.getText());
    }//GEN-LAST:event_btbDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        interfaceTransactionTypes.close();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbDone;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel tlTransactionTypes;
    private javax.swing.JTextField txCode;
    private javax.swing.JTextField txDescription;
    // End of variables declaration//GEN-END:variables
}
