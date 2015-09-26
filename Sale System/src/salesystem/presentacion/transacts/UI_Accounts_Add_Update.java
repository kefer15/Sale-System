package salesystem.presentacion.transacts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UI_Accounts_Add_Update extends javax.swing.JFrame {

    private IAccounts_Add_Update interfaceAccounts;
    public UI_Accounts_Add_Update(IAccounts_Add_Update interfaceAccounts, String Customer_id, String Account_id) {
        this.interfaceAccounts = interfaceAccounts;
        
        initComponents();
        this.setVisible(true);
        this.setTitle("Add / Update Accounts");
        setLocationRelativeTo(null);
        
        this.txId.setText(Account_id);
        this.dcDateOpened.setDate(new Date());
    }
    
    public UI_Accounts_Add_Update(IAccounts_Add_Update interfaceAccounts, String Account_id, String Customer_id, String Date_account_opened, String Account_name, String Other_account_details) throws ParseException {
        this.interfaceAccounts = interfaceAccounts;
        
        initComponents();
        this.setVisible(true);
        this.setTitle("Add / Update Accounts");
        setLocationRelativeTo(null);
        
        
        final String OLD_FORMAT = "yyyy-MM-dd";
        final String NEW_FORMAT = "dd/MM/yyyy";

        
        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = sdf.parse(Date_account_opened);
        sdf.applyPattern(NEW_FORMAT);
        String newDateString = sdf.format(d);
               
        this.txId.setText(Account_id);
        this.dcDateOpened.setDate(new Date(newDateString));
        this.txName.setText(Account_name);
        this.taOher.setText(Other_account_details);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txId = new javax.swing.JTextField();
        dcDateOpened = new com.toedter.calendar.JDateChooser();
        txName = new javax.swing.JTextField();
        tlAccounts = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taOher = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btbDone = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txId.setEditable(false);

        tlAccounts.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tlAccounts.setText("Accounts");

        jLabel2.setText("Id");

        jLabel3.setText("Date Opened");

        taOher.setColumns(20);
        taOher.setRows(5);
        jScrollPane1.setViewportView(taOher);

        jLabel4.setText("Name");

        btbDone.setText("Done");
        btbDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbDoneActionPerformed(evt);
            }
        });

        jLabel5.setText("Other");

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
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(246, 246, 246))
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tlAccounts)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txId)
                                    .addComponent(txName)
                                    .addComponent(dcDateOpened, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btbDone)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)
                        .addGap(72, 72, 72)))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tlAccounts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcDateOpened, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btbDone)
                    .addComponent(btnCancel))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btbDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbDoneActionPerformed
        interfaceAccounts.addUpdateAccounts(txId.getText(), dcDateOpened.getDate(), txName.getText(), taOher.getText());
    }//GEN-LAST:event_btbDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        interfaceAccounts.close();
    }//GEN-LAST:event_btnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbDone;
    private javax.swing.JButton btnCancel;
    private com.toedter.calendar.JDateChooser dcDateOpened;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taOher;
    private javax.swing.JLabel tlAccounts;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txName;
    // End of variables declaration//GEN-END:variables
}
