package salesystem.presentacion.products;

import javax.swing.DefaultListModel;

public class UIProducts_Add_Update extends javax.swing.JFrame {

    private IProducts_Add_Update IProducts;
    private String productId;
    
    public UIProducts_Add_Update(IProducts_Add_Update IProducts) {
        this.IProducts = IProducts;        
        initComponents();
        this.setVisible(true);
        this.setTitle("Add New Product");
        this.productId = "";
        setLocationRelativeTo(null);        
    }
    
    public UIProducts_Add_Update(IProducts_Add_Update IProducts, String productId) {
        this.IProducts = IProducts;
        initComponents();
        this.setVisible(true);
        this.setTitle("Update Product");
        this.productId = productId;
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducts = new javax.swing.JLabel();
        pnlPanel1 = new javax.swing.JPanel();
        txtParent = new javax.swing.JTextField();
        lblParents = new javax.swing.JLabel();
        lblSize = new javax.swing.JLabel();
        txtParents = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        slpParents = new javax.swing.JScrollPane();
        lisParents = new javax.swing.JList();
        txtSize = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        btnParents = new javax.swing.JButton();
        lblParent = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        cbxSize = new javax.swing.JComboBox();
        pnlPanel2 = new javax.swing.JPanel();
        txtCategories = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        slpCategories = new javax.swing.JScrollPane();
        lisCategories = new javax.swing.JList();
        lblCategories = new javax.swing.JLabel();
        txtCategory = new javax.swing.JTextField();
        btnCategories = new javax.swing.JButton();
        lblCategory = new javax.swing.JLabel();
        slpDescription = new javax.swing.JScrollPane();
        txaDescription = new javax.swing.JTextArea();
        pnlPanel3 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        slpOther = new javax.swing.JScrollPane();
        txaOther = new javax.swing.JTextArea();
        lblOther = new javax.swing.JLabel();
        btnDone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblProducts.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProducts.setText("PRODUCTS");
        lblProducts.setToolTipText("");

        lblParents.setText("Products:");

        lblSize.setText("Size");

        lisParents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lisParentsMouseClicked(evt);
            }
        });
        slpParents.setViewportView(lisParents);

        btnParents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnParents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParentsActionPerformed(evt);
            }
        });

        lblParent.setText("Parent Product");

        lblPrice.setText("Price");

        lblName.setText("Name");

        lblColor.setText("Color");

        javax.swing.GroupLayout pnlPanel1Layout = new javax.swing.GroupLayout(pnlPanel1);
        pnlPanel1.setLayout(pnlPanel1Layout);
        pnlPanel1Layout.setHorizontalGroup(
            pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slpParents)
                    .addGroup(pnlPanel1Layout.createSequentialGroup()
                        .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPanel1Layout.createSequentialGroup()
                                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                                    .addComponent(lblPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPanel1Layout.createSequentialGroup()
                                        .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPanel1Layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPanel1Layout.createSequentialGroup()
                                .addComponent(lblParents)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtParents, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnParents, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPanel1Layout.createSequentialGroup()
                                .addComponent(lblParent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtParent, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPanel1Layout.setVerticalGroup(
            pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblParents)
                    .addComponent(txtParents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParents, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slpParents, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblParent, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtParent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSize, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSize, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblDescription.setText("Description");

        lisCategories.setMaximumSize(new java.awt.Dimension(312, 0));
        lisCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lisCategoriesMouseClicked(evt);
            }
        });
        slpCategories.setViewportView(lisCategories);

        lblCategories.setText("Categories:");

        btnCategories.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriesActionPerformed(evt);
            }
        });

        lblCategory.setText("Category");

        txaDescription.setColumns(20);
        txaDescription.setRows(5);
        slpDescription.setViewportView(txaDescription);

        javax.swing.GroupLayout pnlPanel2Layout = new javax.swing.GroupLayout(pnlPanel2);
        pnlPanel2.setLayout(pnlPanel2Layout);
        pnlPanel2Layout.setHorizontalGroup(
            pnlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPanel2Layout.createSequentialGroup()
                        .addComponent(lblCategory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCategory))
                    .addGroup(pnlPanel2Layout.createSequentialGroup()
                        .addComponent(lblDescription)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(slpCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(pnlPanel2Layout.createSequentialGroup()
                        .addComponent(lblCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCategories)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(slpDescription))
                .addContainerGap())
        );
        pnlPanel2Layout.setVerticalGroup(
            pnlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCategories))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(slpCategories, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategory)
                    .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slpDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        txaOther.setColumns(20);
        txaOther.setRows(5);
        slpOther.setViewportView(txaOther);

        lblOther.setText("Other");

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPanel3Layout = new javax.swing.GroupLayout(pnlPanel3);
        pnlPanel3.setLayout(pnlPanel3Layout);
        pnlPanel3Layout.setHorizontalGroup(
            pnlPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPanel3Layout.createSequentialGroup()
                        .addComponent(lblOther)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPanel3Layout.createSequentialGroup()
                        .addComponent(slpOther)
                        .addGap(18, 18, 18)
                        .addGroup(pnlPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancel))))
                .addContainerGap())
        );
        pnlPanel3Layout.setVerticalGroup(
            pnlPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPanel3Layout.createSequentialGroup()
                        .addGap(0, 26, Short.MAX_VALUE)
                        .addComponent(btnDone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(pnlPanel3Layout.createSequentialGroup()
                        .addComponent(lblOther)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slpOther, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        IProducts.done(productId, this.lisParents.getSelectedIndex(), this.lisCategories.getSelectedIndex(), txtName, txtPrice, txtColor, txtSize, this.cbxSize.getSelectedIndex(), txaDescription, txaOther);
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        IProducts.cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void lisParentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lisParentsMouseClicked
        this.txtParent.setText(String.valueOf(this.lisParents.getSelectedValue()));
    }//GEN-LAST:event_lisParentsMouseClicked

    private void btnParentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParentsActionPerformed
        this.lisParents.setModel(new DefaultListModel());
        if(this.txtParents.getText().isEmpty())
            IProducts.searchParent(this.lisParents);
        else
            IProducts.searchParent(this.txtParents, this.lisParents);
    }//GEN-LAST:event_btnParentsActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(productId.isEmpty())
            this.IProducts.inicializateMeasures(this.cbxSize);
        else
            this.IProducts.fill(this.productId, this.lisParents, this.txtParent, this.lisCategories, this.txtCategory, this.txtName, this.txtPrice, this.txtColor, this.txtSize, this.cbxSize, this.txaDescription, this.txaOther);
    }//GEN-LAST:event_formWindowActivated

    private void btnCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriesActionPerformed
        this.lisCategories.setModel(new DefaultListModel());
        if(this.txtCategories.getText().isEmpty())
        IProducts.searchCategory(this.lisCategories);
        else
        IProducts.searchCategory(this.txtCategories, this.lisCategories);
    }//GEN-LAST:event_btnCategoriesActionPerformed

    private void lisCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lisCategoriesMouseClicked
        this.txtCategory.setText(String.valueOf(this.lisCategories.getSelectedValue()));
    }//GEN-LAST:event_lisCategoriesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCategories;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnParents;
    private javax.swing.JComboBox cbxSize;
    private javax.swing.JLabel lblCategories;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOther;
    private javax.swing.JLabel lblParent;
    private javax.swing.JLabel lblParents;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JLabel lblSize;
    private javax.swing.JList lisCategories;
    private javax.swing.JList lisParents;
    private javax.swing.JPanel pnlPanel1;
    private javax.swing.JPanel pnlPanel2;
    private javax.swing.JPanel pnlPanel3;
    private javax.swing.JScrollPane slpCategories;
    private javax.swing.JScrollPane slpDescription;
    private javax.swing.JScrollPane slpOther;
    private javax.swing.JScrollPane slpParents;
    private javax.swing.JTextArea txaDescription;
    private javax.swing.JTextArea txaOther;
    private javax.swing.JTextField txtCategories;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtParent;
    private javax.swing.JTextField txtParents;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSize;
    // End of variables declaration//GEN-END:variables
}
