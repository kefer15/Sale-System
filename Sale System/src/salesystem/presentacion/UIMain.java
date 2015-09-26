package salesystem.presentacion;

import salesystem.presentacion.invoices.CInvoices;
import salesystem.presentacion.transacts.CTransacts;
import salesystem.presentacion.orders.COrders;
import salesystem.presentacion.transacts.CType_Account;
import salesystem.presentacion.products.CCategory_Measure;
import salesystem.presentacion.products.CProducts;
import salesystem.presentacion.customers.CCustomers;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class UIMain extends javax.swing.JFrame
{
    private IMain interfaz;
    private CHome home;
    private CCustomers customers;
    private CProducts products;
    private CTransacts transacts;
    private COrders orders;
    private CInvoices invoices;
    private CHelp help;
    private CCategory_Measure catMeasures;
    private CType_Account typeAccounts;
    private ArrayList<JButton> menuBtn;
    private ListSelectionModel cellSelectionModel;
    
    public UIMain(IMain interfaz, int num_ventana)
    {
        initComponents();
        this.setVisible(true);
        this.setTitle("Sale System");
        setLocationRelativeTo(null);
        
        menuBtn = new ArrayList<JButton>();
        menuBtn.add(btnHome);
        menuBtn.add(btnCustomers);
        menuBtn.add(btnProducts);
        menuBtn.add(btnTransacts);
        menuBtn.add(btnOrders);
        menuBtn.add(btnInvoices);
        menuBtn.add(btnHelp);
        
        switch(num_ventana)
        {
            case 0:
                interfaz.cambiarHome((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(0, menuBtn);
            break;
                
            case 1:
                interfaz.cambiarCustomers((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(1, menuBtn);
            break;
            
            case 2:
                interfaz.cambiarProducts((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(2, menuBtn);
            break;
            
            case 3:
                interfaz.cambiarTransacts((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(3, menuBtn);
            break;
            
            case 4:
                interfaz.cambiarOrders((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(4, menuBtn);
            break;
            
            case 5:
                interfaz.cambiarInvoices((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(5, menuBtn);
            break;
            
            case 6:
                interfaz.cambiarHelp((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(6, menuBtn);
            break;
                
            case 7:
                interfaz.cambiarTypeAccount((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(3, menuBtn);
                
            break;
                
            case 8:
                interfaz.cambiarCatMeasure((CardLayout)pnlContenido.getLayout(), pnlContenido);
                interfaz.colorear(2, menuBtn);
            break;
        }
        
        this.interfaz = interfaz;
        this.home = new CHome();
        this.customers = new CCustomers(jTableCust);
        this.products = new CProducts();
        this.transacts = new CTransacts(tblTransacts, lisCustomers);
        this.orders = new COrders(tblOrders, tblOrderDetails, txaCustomer);
        this.invoices = new CInvoices(tblInvoices , tblOrders, tblOrderDetails,txaCusInv);
        this.help = new CHelp();
        this.catMeasures = new CCategory_Measure(tblCategorias, tblUnidades);
        this.typeAccounts = new CType_Account();
        
        typeAccounts.updateTableTrasactionTypes(tbTrasactionTypes);
        typeAccounts.updateTableAccounts(tbAccounts);
        
        //SEARCHING ...
        customers.autoComplete(jTableCust, txtCustomer);
        
        transacts.autoComplete(lisCustomers, txtCustomers);
        transacts.autoComplete(tblTransacts, txtTransacts);
        
        orders.autoComplete(txaCustomer, txtSearch);
        orders.autoComplete(tblOrders, txtSearchOrders);
        orders.autoComplete(tblOrderDetails, txtOrdenId);
        
        invoices.autoComplete(txaCusInv, txtSeaCusInv);
        invoices.autoComplete(tblInvoices, txtSeaInv);
        
        // Invoice_Details
        cellSelectionModel = tblInvoices.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        cellSelectionModel.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                invoices.displayDetails(tblInvoices, tblInvoicesDetails);
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        pnlMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnTransacts = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnInvoices = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();
        pnlContenido = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        pnlCustomers = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCust = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        btnRemoveCust = new javax.swing.JButton();
        btnUpdCust = new javax.swing.JButton();
        btnAddCust = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblSearchCust = new javax.swing.JLabel();
        txtCustomer = new javax.swing.JTextField();
        btnSearchCust = new javax.swing.JButton();
        pnlProducts = new javax.swing.JPanel();
        btnCatMeasure = new javax.swing.JButton();
        slpCategories = new javax.swing.JScrollPane();
        lisCategories = new javax.swing.JList();
        slpProducts = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        lblCategories = new javax.swing.JLabel();
        txtCategories = new javax.swing.JTextField();
        lblSearchCat = new javax.swing.JLabel();
        btnSearchCat = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        lblProducts = new javax.swing.JLabel();
        lblSearchPro = new javax.swing.JLabel();
        txtProducts = new javax.swing.JTextField();
        btnSearchPro = new javax.swing.JButton();
        pnlTransacts = new javax.swing.JPanel();
        btnTypeAccount = new javax.swing.JButton();
        slpCustomers = new javax.swing.JScrollPane();
        lisCustomers = new javax.swing.JList();
        btnAddTransact = new javax.swing.JButton();
        btnUpdateTransact = new javax.swing.JButton();
        btnRemoveTransact = new javax.swing.JButton();
        slpTransacts = new javax.swing.JScrollPane();
        tblTransacts = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtCustomers = new javax.swing.JTextField();
        btnSearchCustomer = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        lblTransacts = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtTransacts = new javax.swing.JTextField();
        btnSearchTransacts = new javax.swing.JButton();
        pnlInvoices = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblCustomers = new javax.swing.JLabel();
        lblSearchCus = new javax.swing.JLabel();
        txtSeaCusInv = new javax.swing.JTextField();
        btnSeaCusInv = new javax.swing.JButton();
        slpCusInv = new javax.swing.JScrollPane();
        txaCusInv = new javax.swing.JList();
        jPanel8 = new javax.swing.JPanel();
        lblInvoices = new javax.swing.JLabel();
        lblSearchInv = new javax.swing.JLabel();
        txtSeaInv = new javax.swing.JTextField();
        btnSearchInv = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        lblProductsInv = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblInvoicesDetails = new javax.swing.JTable();
        btnAddInv = new javax.swing.JButton();
        btnUpdInv = new javax.swing.JButton();
        btnRmvInv = new javax.swing.JButton();
        pnlOrders = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        txtOrdenId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblOrderDetails = new javax.swing.JTable();
        btnAdd1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnRemove1 = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        txaCustomer = new javax.swing.JList();
        jPanel16 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSearchOrders = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnVerIteOrd = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnlHelp = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlTypeAccount = new javax.swing.JPanel();
        btnReturnTransacts = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        lblCustomers1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbTrasactionTypes = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        btnAddTransactionTypes = new javax.swing.JButton();
        btnUpdateTransactionTypes = new javax.swing.JButton();
        btnRemoveTransactionTypes = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        lblCustomers2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbAccounts = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        btnAddAccounts = new javax.swing.JButton();
        btnUpdateAccounts = new javax.swing.JButton();
        btnRemoveAccounts = new javax.swing.JButton();
        pnlCatMeasure = new javax.swing.JPanel();
        btnReturnProducts = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUnidades = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false;
            }
        }
        ;
        jPanel4 = new javax.swing.JPanel();
        btnAddMea = new javax.swing.JButton();
        btnUpdMea = new javax.swing.JButton();
        btnRemMea = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnAddCat = new javax.swing.JButton();
        btnUpdCat = new javax.swing.JButton();
        btnRemCat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/icon.png")));

        btnHome.setBackground(new java.awt.Color(224, 224, 224));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Home2.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setIconTextGap(-3);
        btnHome.setOpaque(true);
        btnHome.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Home3.png"))); // NOI18N
        btnHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Home1.png"))); // NOI18N
        btnHome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHomeActionPerformed(evt);
            }
        });

        btnCustomers.setBackground(new java.awt.Color(224, 224, 224));
        btnCustomers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Customer2.png"))); // NOI18N
        btnCustomers.setText("Customers");
        btnCustomers.setBorder(null);
        btnCustomers.setBorderPainted(false);
        btnCustomers.setContentAreaFilled(false);
        btnCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomers.setIconTextGap(-3);
        btnCustomers.setOpaque(true);
        btnCustomers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Customer3.png"))); // NOI18N
        btnCustomers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Customer1.png"))); // NOI18N
        btnCustomers.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomers.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCustomersActionPerformed(evt);
            }
        });

        btnTransacts.setBackground(new java.awt.Color(224, 224, 224));
        btnTransacts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTransacts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Transaction2.png"))); // NOI18N
        btnTransacts.setText("Transacts");
        btnTransacts.setBorder(null);
        btnTransacts.setBorderPainted(false);
        btnTransacts.setContentAreaFilled(false);
        btnTransacts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTransacts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTransacts.setIconTextGap(-3);
        btnTransacts.setOpaque(true);
        btnTransacts.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Transaction3.png"))); // NOI18N
        btnTransacts.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Transaction1.png"))); // NOI18N
        btnTransacts.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnTransacts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTransacts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTransactsActionPerformed(evt);
            }
        });

        btnProducts.setBackground(new java.awt.Color(224, 224, 224));
        btnProducts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Product2.png"))); // NOI18N
        btnProducts.setText("Products");
        btnProducts.setBorder(null);
        btnProducts.setBorderPainted(false);
        btnProducts.setContentAreaFilled(false);
        btnProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducts.setIconTextGap(-3);
        btnProducts.setOpaque(true);
        btnProducts.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Product3.png"))); // NOI18N
        btnProducts.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Product1.png"))); // NOI18N
        btnProducts.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProducts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProducts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnProductsActionPerformed(evt);
            }
        });

        btnInvoices.setBackground(new java.awt.Color(224, 224, 224));
        btnInvoices.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvoices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Invoice2.png"))); // NOI18N
        btnInvoices.setText("Invoices");
        btnInvoices.setBorder(null);
        btnInvoices.setBorderPainted(false);
        btnInvoices.setContentAreaFilled(false);
        btnInvoices.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInvoices.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInvoices.setIconTextGap(-3);
        btnInvoices.setOpaque(true);
        btnInvoices.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Invoice3.png"))); // NOI18N
        btnInvoices.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Invoice1.png"))); // NOI18N
        btnInvoices.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInvoices.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInvoices.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnInvoicesActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(224, 224, 224));
        btnHelp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Help2.png"))); // NOI18N
        btnHelp.setText("HELP");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHelp.setIconTextGap(-3);
        btnHelp.setOpaque(true);
        btnHelp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Help3.png"))); // NOI18N
        btnHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Help1.png"))); // NOI18N
        btnHelp.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHelp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHelpActionPerformed(evt);
            }
        });

        btnOrders.setBackground(new java.awt.Color(224, 224, 224));
        btnOrders.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Order2.png"))); // NOI18N
        btnOrders.setText("Orders");
        btnOrders.setBorder(null);
        btnOrders.setBorderPainted(false);
        btnOrders.setContentAreaFilled(false);
        btnOrders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrders.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrders.setIconTextGap(-3);
        btnOrders.setOpaque(true);
        btnOrders.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Order3.png"))); // NOI18N
        btnOrders.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Order1.png"))); // NOI18N
        btnOrders.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnOrders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrders.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOrdersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransacts, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvoices, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransacts, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCustomers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContenido.setPreferredSize(new java.awt.Dimension(787, 500));
        pnlContenido.setLayout(new java.awt.CardLayout());

        pnlHome.setBackground(new java.awt.Color(210, 210, 210));
        pnlHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HOME");

        jPanel3.setBackground(new java.awt.Color(210, 210, 210));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("FACTURAS DE CLIENTES");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUERIES");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(432, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Database Connection", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/db.png"))); // NOI18N
        jButton3.setText("RECONECTAR");
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Change User or Password:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("User:");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Password:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                    .addGroup(pnlHomeLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlHomeLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pnlContenido.add(pnlHome, "pnlHome");

        pnlCustomers.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CUSTOMERS");

        jTableCust.setAutoCreateRowSorter(true);
        jTableCust.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "First Name", "Middle Name", "Last Name", "Gender", "E-mail", "Phone", "Address", "Other", "State"
            }
        ));
        jScrollPane2.setViewportView(jTableCust);
        if (jTableCust.getColumnModel().getColumnCount() > 0)
        {
            jTableCust.getColumnModel().getColumn(0).setPreferredWidth(130);
            jTableCust.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTableCust.getColumnModel().getColumn(2).setPreferredWidth(200);
            jTableCust.getColumnModel().getColumn(3).setPreferredWidth(250);
            jTableCust.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableCust.getColumnModel().getColumn(5).setPreferredWidth(200);
            jTableCust.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTableCust.getColumnModel().getColumn(7).setPreferredWidth(250);
            jTableCust.getColumnModel().getColumn(8).setPreferredWidth(250);
        }

        btnRemoveCust.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemoveCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemoveCust.setText("Remove");
        btnRemoveCust.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveCustActionPerformed(evt);
            }
        });

        btnUpdCust.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdCust.setText("Update");
        btnUpdCust.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdCustActionPerformed(evt);
            }
        });

        btnAddCust.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddCust.setText("Add");
        btnAddCust.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddCustActionPerformed(evt);
            }
        });

        lblSearchCust.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearchCust.setText("Search:");

        btnSearchCust.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearchCust.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchCustActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(403, Short.MAX_VALUE)
                .addComponent(lblSearchCust)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchCust, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSearchCust, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCustomer)
                    .addComponent(lblSearchCust, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCustomersLayout = new javax.swing.GroupLayout(pnlCustomers);
        pnlCustomers.setLayout(pnlCustomersLayout);
        pnlCustomersLayout.setHorizontalGroup(
            pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersLayout.createSequentialGroup()
                .addGroup(pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomersLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddCust, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdCust)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveCust))
                    .addGroup(pnlCustomersLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        pnlCustomersLayout.setVerticalGroup(
            pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveCust, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdCust, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCust, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlContenido.add(pnlCustomers, "pnlCustomers");

        pnlProducts.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnCatMeasure.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCatMeasure.setText("Categories / Measures");
        btnCatMeasure.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCatMeasureActionPerformed(evt);
            }
        });

        lisCategories.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                lisCategoriesMouseClicked(evt);
            }
        });
        slpCategories.setViewportView(lisCategories);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        slpProducts.setViewportView(tblProducts);

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        lblCategories.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategories.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCategories.setText("CATEGORIES");

        lblSearchCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearchCat.setText("Search:");

        btnSearchCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearchCat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(lblSearchCat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchCat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCategories)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSearchCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCategories))
                .addContainerGap())
        );

        lblProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProducts.setText("PRODUCTS");

        lblSearchPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearchPro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearchPro.setText("Search:");

        btnSearchPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearchPro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchProActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSearchPro, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchPro)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(lblProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                        .addComponent(lblSearchPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnSearchPro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlProductsLayout = new javax.swing.GroupLayout(pnlProducts);
        pnlProducts.setLayout(pnlProductsLayout);
        pnlProductsLayout.setHorizontalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slpCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCatMeasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slpProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlProductsLayout.setVerticalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(slpProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                    .addComponent(slpCategories))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCatMeasure, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11))
        );

        pnlContenido.add(pnlProducts, "pnlProducts");

        pnlTransacts.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnTypeAccount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTypeAccount.setText("Types / Accounts");
        btnTypeAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTypeAccountActionPerformed(evt);
            }
        });

        lisCustomers.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                lisCustomersValueChanged(evt);
            }
        });
        slpCustomers.setViewportView(lisCustomers);

        btnAddTransact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddTransact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddTransact.setText("Add");
        btnAddTransact.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddTransactActionPerformed(evt);
            }
        });

        btnUpdateTransact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateTransact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdateTransact.setText("Update");
        btnUpdateTransact.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateTransactActionPerformed(evt);
            }
        });

        btnRemoveTransact.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemoveTransact.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemoveTransact.setText("Remove");
        btnRemoveTransact.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveTransactActionPerformed(evt);
            }
        });

        tblTransacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "Account", "Invoice", "Type", "Date", "Amount", "Other", "Register"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        slpTransacts.setViewportView(tblTransacts);
        if (tblTransacts.getColumnModel().getColumnCount() > 0)
        {
            tblTransacts.getColumnModel().getColumn(0).setMinWidth(50);
            tblTransacts.getColumnModel().getColumn(0).setMaxWidth(50);
            tblTransacts.getColumnModel().getColumn(1).setMinWidth(60);
            tblTransacts.getColumnModel().getColumn(1).setMaxWidth(60);
            tblTransacts.getColumnModel().getColumn(3).setMinWidth(40);
            tblTransacts.getColumnModel().getColumn(3).setMaxWidth(40);
            tblTransacts.getColumnModel().getColumn(7).setMinWidth(40);
            tblTransacts.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CUSTOMERS");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblName.setText("Name:");

        btnSearchCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearchCustomer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(10, 10, 10)
                        .addComponent(txtCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomers)
                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSearchCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblTransacts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTransacts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTransacts.setText("TRANSACTS");

        lblSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSearch.setText("Search:");

        btnSearchTransacts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnSearchTransacts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchTransactsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTransacts, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchTransacts)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTransacts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTransacts, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtTransacts, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnSearchTransacts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlTransactsLayout = new javax.swing.GroupLayout(pnlTransacts);
        pnlTransacts.setLayout(pnlTransactsLayout);
        pnlTransactsLayout.setHorizontalGroup(
            pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransactsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTypeAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slpCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slpTransacts, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTransactsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddTransact, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateTransact)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveTransact, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTransactsLayout.setVerticalGroup(
            pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTransactsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slpCustomers)
                    .addComponent(slpTransacts, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlTransactsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddTransact, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdateTransact, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRemoveTransact, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTypeAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContenido.add(pnlTransacts, "pnlTransacts");

        pnlInvoices.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlInvoices.setPreferredSize(new java.awt.Dimension(802, 530));

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCustomers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCustomers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomers.setText("CUSTOMERS");

        lblSearchCus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearchCus.setText("Search:");

        btnSeaCusInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N

        txaCusInv.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                txaCusInvValueChanged(evt);
            }
        });
        slpCusInv.setViewportView(txaCusInv);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lblSearchCus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeaCusInv, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSeaCusInv, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(slpCusInv, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCustomers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblSearchCus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeaCusInv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSeaCusInv, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(slpCusInv, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblInvoices.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblInvoices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInvoices.setText("INVOICES");

        lblSearchInv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSearchInv.setText("Search:");

        btnSearchInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N

        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "N°", "Order ID", "Date", "Details", "State"
            }
        ));
        tblInvoices.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane6.setViewportView(tblInvoices);
        if (tblInvoices.getColumnModel().getColumnCount() > 0)
        {
            tblInvoices.getColumnModel().getColumn(0).setMinWidth(70);
            tblInvoices.getColumnModel().getColumn(0).setMaxWidth(70);
            tblInvoices.getColumnModel().getColumn(1).setMinWidth(70);
            tblInvoices.getColumnModel().getColumn(1).setMaxWidth(70);
            tblInvoices.getColumnModel().getColumn(2).setMinWidth(80);
            tblInvoices.getColumnModel().getColumn(2).setMaxWidth(80);
            tblInvoices.getColumnModel().getColumn(4).setMinWidth(50);
            tblInvoices.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInvoices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(lblSearchInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSeaInv, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchInv)
                        .addGap(273, 273, 273))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInvoices)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblSearchInv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSeaInv, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearchInv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblProductsInv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductsInv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductsInv.setText("DETAIL");

        tblInvoicesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Title", "Quantity", "Price", "Derived Cost", "Derived VAT Payable", "Derived Total Cost", "Details", "State"
            }
        ));
        tblInvoicesDetails.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane7.setViewportView(tblInvoicesDetails);
        if (tblInvoicesDetails.getColumnModel().getColumnCount() > 0)
        {
            tblInvoicesDetails.getColumnModel().getColumn(0).setMinWidth(190);
            tblInvoicesDetails.getColumnModel().getColumn(0).setMaxWidth(190);
            tblInvoicesDetails.getColumnModel().getColumn(1).setMinWidth(70);
            tblInvoicesDetails.getColumnModel().getColumn(1).setMaxWidth(70);
            tblInvoicesDetails.getColumnModel().getColumn(2).setMinWidth(70);
            tblInvoicesDetails.getColumnModel().getColumn(2).setMaxWidth(70);
            tblInvoicesDetails.getColumnModel().getColumn(3).setMinWidth(90);
            tblInvoicesDetails.getColumnModel().getColumn(3).setMaxWidth(90);
            tblInvoicesDetails.getColumnModel().getColumn(4).setMinWidth(90);
            tblInvoicesDetails.getColumnModel().getColumn(4).setMaxWidth(90);
            tblInvoicesDetails.getColumnModel().getColumn(5).setMinWidth(90);
            tblInvoicesDetails.getColumnModel().getColumn(5).setMaxWidth(90);
            tblInvoicesDetails.getColumnModel().getColumn(7).setMinWidth(60);
            tblInvoicesDetails.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        btnAddInv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddInv.setText("Add");
        btnAddInv.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddInvActionPerformed(evt);
            }
        });

        btnUpdInv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdInv.setText("Update");
        btnUpdInv.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdInvActionPerformed(evt);
            }
        });

        btnRmvInv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRmvInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRmvInv.setText("Remove");
        btnRmvInv.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRmvInvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInvoicesLayout = new javax.swing.GroupLayout(pnlInvoices);
        pnlInvoices.setLayout(pnlInvoicesLayout);
        pnlInvoicesLayout.setHorizontalGroup(
            pnlInvoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInvoicesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInvoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addComponent(lblProductsInv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInvoicesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlInvoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlInvoicesLayout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlInvoicesLayout.createSequentialGroup()
                                .addComponent(btnAddInv, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdInv, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRmvInv, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        pnlInvoicesLayout.setVerticalGroup(
            pnlInvoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInvoicesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInvoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductsInv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInvoicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRmvInv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdInv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddInv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlContenido.add(pnlInvoices, "pnlInvoices");

        pnlOrders.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "Date", "Total Amount", "Details", "State"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tblOrders);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Orden Id:");

        tblOrderDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Item Id", "Product", "Quantity", "Item Cost", "Other", "State"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(tblOrderDetails);

        btnAdd1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAdd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAdd1.setText("Add");
        btnAdd1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAdd1ActionPerformed(evt);
            }
        });

        btnUpdate1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdate1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdate1.setText("Update");

        btnRemove1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemove1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemove1.setText("Remove");

        btnInvoice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnInvoice.setText("Invoices");
        btnInvoice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnInvoiceActionPerformed(evt);
            }
        });

        txaCustomer.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                txaCustomerValueChanged(evt);
            }
        });
        jScrollPane10.setViewportView(txaCustomer);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("CUSTOMERS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Search:");

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        btnOk.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("ORDERS");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Search:");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        btnVerIteOrd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnVerIteOrd.setText("Ver Items");
        btnVerIteOrd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVerIteOrdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerIteOrd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(btnVerIteOrd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/search.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrdersLayout = new javax.swing.GroupLayout(pnlOrders);
        pnlOrders.setLayout(pnlOrdersLayout);
        pnlOrdersLayout.setHorizontalGroup(
            pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrdersLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove1))
                    .addGroup(pnlOrdersLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                            .addGroup(pnlOrdersLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtOrdenId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9))))
                .addContainerGap())
        );
        pnlOrdersLayout.setVerticalGroup(
            pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlOrdersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlOrdersLayout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOrdenId, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                    .addGroup(pnlOrdersLayout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOrdersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlContenido.add(pnlOrders, "pnlOrders");

        pnlHelp.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Sales System has buttons and interactive displays");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Button search");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Button add");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Button update");

        javax.swing.GroupLayout pnlHelpLayout = new javax.swing.GroupLayout(pnlHelp);
        pnlHelp.setLayout(pnlHelpLayout);
        pnlHelpLayout.setHorizontalGroup(
            pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addGroup(pnlHelpLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22))
                .addGap(144, 144, 144)
                .addGroup(pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlHelpLayout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(pnlHelpLayout.createSequentialGroup()
                        .addGroup(pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
        );
        pnlHelpLayout.setVerticalGroup(
            pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlHelpLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22))
                    .addGroup(pnlHelpLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel23)))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pnlContenido.add(pnlHelp, "pnlHelp");

        pnlTypeAccount.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnReturnTransacts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReturnTransacts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/return.png"))); // NOI18N
        btnReturnTransacts.setText("Return");
        btnReturnTransacts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnReturnTransactsActionPerformed(evt);
            }
        });

        lblCustomers1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCustomers1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomers1.setText("TRANSACTION TYPES");

        tbTrasactionTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Code", "Description", "Register State"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tbTrasactionTypes.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tbTrasactionTypesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbTrasactionTypes);

        btnAddTransactionTypes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddTransactionTypes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddTransactionTypes.setText("Add");
        btnAddTransactionTypes.setMinimumSize(new java.awt.Dimension(51, 29));
        btnAddTransactionTypes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddTransactionTypesActionPerformed(evt);
            }
        });

        btnUpdateTransactionTypes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateTransactionTypes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdateTransactionTypes.setText("Update");
        btnUpdateTransactionTypes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateTransactionTypesActionPerformed(evt);
            }
        });

        btnRemoveTransactionTypes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemoveTransactionTypes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemoveTransactionTypes.setText("Remove");
        btnRemoveTransactionTypes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveTransactionTypesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomers1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(btnAddTransactionTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateTransactionTypes)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveTransactionTypes))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCustomers1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTransactionTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateTransactionTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveTransactionTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCustomers2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCustomers2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomers2.setText("ACCOUNTS");

        tbAccounts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "ID", "Name", "Date Opened", "Register State"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tbAccounts.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tbAccountsMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbAccounts);

        btnAddAccounts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddAccounts.setText("Add");
        btnAddAccounts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddAccountsActionPerformed(evt);
            }
        });

        btnUpdateAccounts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdateAccounts.setText("Update");
        btnUpdateAccounts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateAccountsActionPerformed(evt);
            }
        });

        btnRemoveAccounts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemoveAccounts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemoveAccounts.setText("Remove");
        btnRemoveAccounts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveAccountsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblCustomers2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnAddAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateAccounts)
                .addGap(18, 18, 18)
                .addComponent(btnRemoveAccounts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCustomers2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveAccounts, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTypeAccountLayout = new javax.swing.GroupLayout(pnlTypeAccount);
        pnlTypeAccount.setLayout(pnlTypeAccountLayout);
        pnlTypeAccountLayout.setHorizontalGroup(
            pnlTypeAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTypeAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTypeAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTypeAccountLayout.createSequentialGroup()
                        .addComponent(btnReturnTransacts, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTypeAccountLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlTypeAccountLayout.setVerticalGroup(
            pnlTypeAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTypeAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTypeAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturnTransacts, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlContenido.add(pnlTypeAccount, "pnlTypeAccount");

        pnlCatMeasure.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnReturnProducts.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnReturnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/return.png"))); // NOI18N
        btnReturnProducts.setText("Return");
        btnReturnProducts.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnReturnProductsActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tblCategorias.setAutoCreateRowSorter(true);
        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Code", "Description", "VAT %", "State"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCategorias);
        if (tblCategorias.getColumnModel().getColumnCount() > 0)
        {
            tblCategorias.getColumnModel().getColumn(0).setMinWidth(70);
            tblCategorias.getColumnModel().getColumn(0).setMaxWidth(70);
            tblCategorias.getColumnModel().getColumn(1).setMinWidth(170);
            tblCategorias.getColumnModel().getColumn(1).setMaxWidth(170);
            tblCategorias.getColumnModel().getColumn(2).setMinWidth(50);
            tblCategorias.getColumnModel().getColumn(2).setMaxWidth(50);
            tblCategorias.getColumnModel().getColumn(3).setMinWidth(50);
            tblCategorias.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CATEGORIES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MEASURES");

        tblUnidades.setAutoCreateRowSorter(true);
        tblUnidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "Description", "State"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblUnidades);
        if (tblUnidades.getColumnModel().getColumnCount() > 0)
        {
            tblUnidades.getColumnModel().getColumn(0).setMinWidth(70);
            tblUnidades.getColumnModel().getColumn(0).setMaxWidth(70);
            tblUnidades.getColumnModel().getColumn(1).setMinWidth(170);
            tblUnidades.getColumnModel().getColumn(1).setMaxWidth(170);
            tblUnidades.getColumnModel().getColumn(2).setMinWidth(50);
            tblUnidades.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAddMea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddMea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddMea.setText("Add");
        btnAddMea.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddMeaActionPerformed(evt);
            }
        });

        btnUpdMea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdMea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdMea.setText("Update");
        btnUpdMea.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdMeaActionPerformed(evt);
            }
        });

        btnRemMea.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemMea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemMea.setText("Remove");
        btnRemMea.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemMeaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddMea, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdMea, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemMea, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddMea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdMea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemMea, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnAddCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAddCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/add.png"))); // NOI18N
        btnAddCat.setText("Add");
        btnAddCat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddCatActionPerformed(evt);
            }
        });

        btnUpdCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/update.png"))); // NOI18N
        btnUpdCat.setText("Update");
        btnUpdCat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdCatActionPerformed(evt);
            }
        });

        btnRemCat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnRemCat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png"))); // NOI18N
        btnRemCat.setText("Remove");
        btnRemCat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemCatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddCat, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdCat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemCat)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdCat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemCat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlCatMeasureLayout = new javax.swing.GroupLayout(pnlCatMeasure);
        pnlCatMeasure.setLayout(pnlCatMeasureLayout);
        pnlCatMeasureLayout.setHorizontalGroup(
            pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCatMeasureLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnReturnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlCatMeasureLayout.setVerticalGroup(
            pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCatMeasureLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCatMeasureLayout.createSequentialGroup()
                        .addGroup(pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCatMeasureLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReturnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlContenido.add(pnlCatMeasure, "pnlCatMeasure");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCustomersActionPerformed
    {//GEN-HEADEREND:event_btnCustomersActionPerformed
        interfaz.cambiarCustomers((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(1, menuBtn);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHomeActionPerformed
    {//GEN-HEADEREND:event_btnHomeActionPerformed
        interfaz.cambiarHome((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(0, menuBtn);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProductsActionPerformed
    {//GEN-HEADEREND:event_btnProductsActionPerformed
        interfaz.cambiarProducts((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(2, menuBtn);
        products.searchCategory(this.lisCategories);
        products.searchProduct(this.tblProducts);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnTransactsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTransactsActionPerformed
    {//GEN-HEADEREND:event_btnTransactsActionPerformed
        interfaz.cambiarTransacts((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(3, menuBtn);
    }//GEN-LAST:event_btnTransactsActionPerformed

    private void btnOrdersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOrdersActionPerformed
    {//GEN-HEADEREND:event_btnOrdersActionPerformed
        interfaz.cambiarOrders((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(4, menuBtn);
    }//GEN-LAST:event_btnOrdersActionPerformed

    private void btnInvoicesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnInvoicesActionPerformed
    {//GEN-HEADEREND:event_btnInvoicesActionPerformed
        interfaz.cambiarInvoices((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(5, menuBtn);
    }//GEN-LAST:event_btnInvoicesActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        interfaz.cambiarHelp((CardLayout)pnlContenido.getLayout(), pnlContenido);
        interfaz.colorear(6, menuBtn);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnReturnTransactsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnReturnTransactsActionPerformed
    {//GEN-HEADEREND:event_btnReturnTransactsActionPerformed
        interfaz.cambiarTransacts((CardLayout)pnlContenido.getLayout(), pnlContenido);
    }//GEN-LAST:event_btnReturnTransactsActionPerformed

    private void btnTypeAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnTypeAccountActionPerformed
    {//GEN-HEADEREND:event_btnTypeAccountActionPerformed
        interfaz.cambiarTypeAccount((CardLayout)pnlContenido.getLayout(), pnlContenido);
        typeAccounts.updateTableTrasactionTypes(tbTrasactionTypes);
        typeAccounts.updateTableAccounts(tbAccounts);
        typeAccounts.setCustomer_id(txtCustomers.getText(), lisCustomers);
    }//GEN-LAST:event_btnTypeAccountActionPerformed

    private void btnCatMeasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatMeasureActionPerformed
        interfaz.cambiarCatMeasure((CardLayout)pnlContenido.getLayout(), pnlContenido);
    }//GEN-LAST:event_btnCatMeasureActionPerformed

    private void btnReturnProductsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnReturnProductsActionPerformed
    {//GEN-HEADEREND:event_btnReturnProductsActionPerformed
        interfaz.cambiarProducts((CardLayout)pnlContenido.getLayout(), pnlContenido);
    }//GEN-LAST:event_btnReturnProductsActionPerformed

    private void btnSearchCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustActionPerformed
        customers.search(jTableCust, txtCustomer);
    }//GEN-LAST:event_btnSearchCustActionPerformed

    private void btnAddTransactionTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTransactionTypesActionPerformed
        typeAccounts.addTransactionTypes(0, tbTrasactionTypes);
        this.dispose();
    }//GEN-LAST:event_btnAddTransactionTypesActionPerformed

    private void btnUpdateTransactionTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTransactionTypesActionPerformed
        typeAccounts.updateTransactionTypes(1, tbTrasactionTypes);
        this.dispose();
    }//GEN-LAST:event_btnUpdateTransactionTypesActionPerformed

    private void btnRemoveTransactionTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTransactionTypesActionPerformed
        typeAccounts.removeTransactionTypes(tbTrasactionTypes);
    }//GEN-LAST:event_btnRemoveTransactionTypesActionPerformed

    private void btnAddAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAccountsActionPerformed
        typeAccounts.addAccounts(0, tbAccounts);
        this.dispose();
    }//GEN-LAST:event_btnAddAccountsActionPerformed

    private void btnUpdateAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAccountsActionPerformed
        typeAccounts.updateAccounts(1, tbAccounts);
        this.dispose();
    }//GEN-LAST:event_btnUpdateAccountsActionPerformed

    private void btnAddCatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddCatActionPerformed
    {//GEN-HEADEREND:event_btnAddCatActionPerformed
        catMeasures.agregarCategories();
        this.dispose();
    }//GEN-LAST:event_btnAddCatActionPerformed

    private void btnUpdCatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUpdCatActionPerformed
    {//GEN-HEADEREND:event_btnUpdCatActionPerformed
        if(catMeasures.modificarCategories(tblCategorias))
            this.dispose();
    }//GEN-LAST:event_btnUpdCatActionPerformed

    private void btnAddMeaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddMeaActionPerformed
    {//GEN-HEADEREND:event_btnAddMeaActionPerformed
        catMeasures.agregarMeasures();
        this.dispose();
    }//GEN-LAST:event_btnAddMeaActionPerformed

    private void btnUpdMeaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUpdMeaActionPerformed
    {//GEN-HEADEREND:event_btnUpdMeaActionPerformed
        if(catMeasures.modificarMeasures(tblUnidades))
            this.dispose();
    }//GEN-LAST:event_btnUpdMeaActionPerformed

    private void btnRemCatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemCatActionPerformed
    {//GEN-HEADEREND:event_btnRemCatActionPerformed
        catMeasures.eliminarCategories(tblCategorias);
    }//GEN-LAST:event_btnRemCatActionPerformed

    private void btnRemMeaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemMeaActionPerformed
    {//GEN-HEADEREND:event_btnRemMeaActionPerformed
        catMeasures.eliminarMeasures(tblUnidades);
    }//GEN-LAST:event_btnRemMeaActionPerformed

    private void btnRemoveCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCustActionPerformed
        customers.removeCustomers(jTableCust);
    }//GEN-LAST:event_btnRemoveCustActionPerformed

    private void btnUpdCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdCustActionPerformed
        if(customers.updateCustomers(jTableCust))
            this.dispose();
    }//GEN-LAST:event_btnUpdCustActionPerformed

    private void btnAddCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustActionPerformed
        customers.addCustomers();
        this.dispose();
    }//GEN-LAST:event_btnAddCustActionPerformed

    private void btnRmvInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRmvInvActionPerformed
        // TODO add your handling code here:
       // invoices.removeInvoices(tblInvoices);
    }//GEN-LAST:event_btnRmvInvActionPerformed

    private void btnUpdInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdInvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdInvActionPerformed

    private void btnAddInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInvActionPerformed
        // TODO add your handling code here:
        invoices.addInvoices();
        this.dispose();
    }//GEN-LAST:event_btnAddInvActionPerformed

    private void btnAddTransactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTransactActionPerformed
        transacts.agregarTransacts();
        this.dispose();
    }//GEN-LAST:event_btnAddTransactActionPerformed

    private void btnUpdateTransactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTransactActionPerformed
        if(transacts.modificarTransacts(tblTransacts))
            this.dispose();
    }//GEN-LAST:event_btnUpdateTransactActionPerformed

    private void btnRemoveTransactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTransactActionPerformed
        transacts.eliminarTransacts(tblTransacts);
    }//GEN-LAST:event_btnRemoveTransactActionPerformed

    private void btnRemoveAccountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAccountsActionPerformed
        typeAccounts.removeAccounts(tbAccounts);
    }//GEN-LAST:event_btnRemoveAccountsActionPerformed

    private void tbTrasactionTypesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTrasactionTypesMouseClicked
        typeAccounts.updateTransactionTypes(1, tbTrasactionTypes);
        this.dispose();
    }//GEN-LAST:event_tbTrasactionTypesMouseClicked

    private void tbAccountsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAccountsMouseClicked
        typeAccounts.updateAccounts(1, tbAccounts);
        this.dispose();
    }//GEN-LAST:event_tbAccountsMouseClicked

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        orders.search(txaCustomer, txtSearch);
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        orders.addOrders();
        this.dispose();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnSearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCustomerActionPerformed
        transacts.search(lisCustomers, txtCustomers);
    }//GEN-LAST:event_btnSearchCustomerActionPerformed

    private void btnSearchTransactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTransactsActionPerformed
        transacts.search(tblTransacts, txtTransacts);
    }//GEN-LAST:event_btnSearchTransactsActionPerformed

    private void lisCustomersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lisCustomersValueChanged
        transacts.search(lisCustomers, tblTransacts);
    }//GEN-LAST:event_lisCustomersValueChanged

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        // TODO add your handling code here:
        invoices.addInvoices();
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void btnVerIteOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerIteOrdActionPerformed
        // TODO add your handling code here:
        orders.displayDetails(tblOrders, tblOrderDetails);
        orders.autoComplete(tblOrderDetails, txtOrdenId);
    }//GEN-LAST:event_btnVerIteOrdActionPerformed

    private void btnSearchCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchCatActionPerformed
        this.lisCategories.setModel(new DefaultListModel());
        if(this.txtCategories.getText().isEmpty())
            products.searchCategory(this.lisCategories);
        else
            products.searchCategory(this.txtCategories, this.lisCategories);
    }//GEN-LAST:event_btnSearchCatActionPerformed

    private void lisCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lisCategoriesMouseClicked
        this.tblProducts.setModel(new DefaultTableModel());
        this.txtProducts.setText("");
        products.selectCategory(this.lisCategories.getSelectedIndex(), this.tblProducts);
    }//GEN-LAST:event_lisCategoriesMouseClicked

    private void btnSearchProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProActionPerformed
        products.searchProduct(this.txtProducts, this.tblProducts);
    }//GEN-LAST:event_btnSearchProActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        products.add();
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(this.tblProducts.getSelectedRow() != -1) {
            products.update(String.valueOf(tblProducts.getValueAt(tblProducts.getSelectedRow(), 0)));
            this.dispose();
        } else 
            JOptionPane.showMessageDialog(null, "Please select a record and try it again.", "Products", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
       if(this.tblProducts.getSelectedRow() != -1)
            products.remove(this.tblProducts.getSelectedRow(), this.tblProducts);
        else 
            JOptionPane.showMessageDialog(null, "Please select a record and try it again.", "Products", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        orders.search(tblOrders, txtSearchOrders);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txaCustomerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_txaCustomerValueChanged
        orders.search(txaCustomer, tblOrders);
    }//GEN-LAST:event_txaCustomerValueChanged

    private void txaCusInvValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_txaCusInvValueChanged
        // TODO add your handling code here:
        invoices.search(txaCusInv, tblInvoices);
    }//GEN-LAST:event_txaCusInvValueChanged

    private void btnSeaCusInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeaCusInvActionPerformed
        // TODO add your handling code here:
        invoices.search(txaCusInv, txtSeaCusInv);
    }//GEN-LAST:event_btnSeaCusInvActionPerformed

    private void btnSeaInvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeaInvActionPerformed
        // TODO add your handling code here:
        invoices.search(tblInvoices, txtSeaInv);
    }//GEN-LAST:event_btnSeaInvActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        orders.search(tblOrderDetails, txtOrdenId);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        if(home.reconectar(txtUser, txtPass))
        {
            this.dispose();
            CMain nuevo = new CMain(0);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAddAccounts;
    private javax.swing.JButton btnAddCat;
    private javax.swing.JButton btnAddCust;
    private javax.swing.JButton btnAddInv;
    private javax.swing.JButton btnAddMea;
    private javax.swing.JButton btnAddTransact;
    private javax.swing.JButton btnAddTransactionTypes;
    private javax.swing.JButton btnCatMeasure;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnInvoices;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnRemCat;
    private javax.swing.JButton btnRemMea;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRemove1;
    private javax.swing.JButton btnRemoveAccounts;
    private javax.swing.JButton btnRemoveCust;
    private javax.swing.JButton btnRemoveTransact;
    private javax.swing.JButton btnRemoveTransactionTypes;
    private javax.swing.JButton btnReturnProducts;
    private javax.swing.JButton btnReturnTransacts;
    private javax.swing.JButton btnRmvInv;
    private javax.swing.JButton btnSeaCusInv;
    private javax.swing.JButton btnSearchCat;
    private javax.swing.JButton btnSearchCust;
    private javax.swing.JButton btnSearchCustomer;
    private javax.swing.JButton btnSearchInv;
    private javax.swing.JButton btnSearchPro;
    private javax.swing.JButton btnSearchTransacts;
    private javax.swing.JButton btnTransacts;
    private javax.swing.JButton btnTypeAccount;
    private javax.swing.JButton btnUpdCat;
    private javax.swing.JButton btnUpdCust;
    private javax.swing.JButton btnUpdInv;
    private javax.swing.JButton btnUpdMea;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton btnUpdateAccounts;
    private javax.swing.JButton btnUpdateTransact;
    private javax.swing.JButton btnUpdateTransactionTypes;
    private javax.swing.JButton btnVerIteOrd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableCust;
    private javax.swing.JLabel lblCategories;
    private javax.swing.JLabel lblCustomers;
    private javax.swing.JLabel lblCustomers1;
    private javax.swing.JLabel lblCustomers2;
    private javax.swing.JLabel lblInvoices;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProducts;
    private javax.swing.JLabel lblProductsInv;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchCat;
    private javax.swing.JLabel lblSearchCus;
    private javax.swing.JLabel lblSearchCust;
    private javax.swing.JLabel lblSearchInv;
    private javax.swing.JLabel lblSearchPro;
    private javax.swing.JLabel lblTransacts;
    private javax.swing.JList lisCategories;
    private javax.swing.JList lisCustomers;
    private javax.swing.JPanel pnlCatMeasure;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlCustomers;
    private javax.swing.JPanel pnlHelp;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlInvoices;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlOrders;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JPanel pnlTransacts;
    private javax.swing.JPanel pnlTypeAccount;
    private javax.swing.JScrollPane slpCategories;
    private javax.swing.JScrollPane slpCusInv;
    private javax.swing.JScrollPane slpCustomers;
    private javax.swing.JScrollPane slpProducts;
    private javax.swing.JScrollPane slpTransacts;
    private javax.swing.JTable tbAccounts;
    private javax.swing.JTable tbTrasactionTypes;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTable tblInvoices;
    private javax.swing.JTable tblInvoicesDetails;
    private javax.swing.JTable tblOrderDetails;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblTransacts;
    private javax.swing.JTable tblUnidades;
    private javax.swing.JList txaCusInv;
    private javax.swing.JList txaCustomer;
    private javax.swing.JTextField txtCategories;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtCustomers;
    private javax.swing.JTextField txtOrdenId;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtProducts;
    private javax.swing.JTextField txtSeaCusInv;
    private javax.swing.JTextField txtSeaInv;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchOrders;
    private javax.swing.JTextField txtTransacts;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
