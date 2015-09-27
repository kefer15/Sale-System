package Vista;

import Controlador.CHelp;
import Controlador.CHome;
import Controlador.CUsers;
import Controlador.IMain;
import Modelo.Users;
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
    private CUsers users;
    private CCustomers customers;
    private CProducts products;
    private CTransacts transacts;
    private COrders orders;
    private CInvoices invoices;
    private CHelp help;
    private CCategory_Measure catMeasures;
    private CType_Account typeAccounts;
    private ArrayList <JButton> menuBtn;
    private ListSelectionModel cellSelectionModel;
    private Users user;
    private int state;
    private ArrayList <String> usersSearch;
    private String userCode;
    
    public UIMain(IMain interfaz, int num_ventana)
    {
        initComponents();
        this.setVisible(true);
        this.setTitle("Sale System");
        setLocationRelativeTo(null);
        usersSearch = new ArrayList <>();
        userCode = "";
        
        menuBtn = new ArrayList <>();
        menuBtn.add(btnHome);
        menuBtn.add(btnUsers);
        menuBtn.add(btnSuppliers);
        menuBtn.add(btnProducts);
        menuBtn.add(btnStore);
        menuBtn.add(btnSale);
        menuBtn.add(btnHelp);
        
        switch(num_ventana)
        {
            case 0:
                interfaz.changeHome((CardLayout)pnlContent.getLayout(), pnlContent);
                interfaz.paint(0, menuBtn);
            break;
                
            case 1:
                interfaz.changeUsers((CardLayout)pnlContent.getLayout(), pnlContent);
                interfaz.paint(1, menuBtn);
                users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
            break;
            
            case 2:
                interfaz.changeSuppliers((CardLayout)pnlContent.getLayout(), pnlContent);
                interfaz.paint(2, menuBtn);
            break;
            
            case 3:
                interfaz.changeProducts((CardLayout)pnlContent.getLayout(), pnlContent);
                interfaz.paint(3, menuBtn);
            break;
            
            case 4:
                interfaz.changeStore((CardLayout)pnlContent.getLayout(), pnlContent);
                interfaz.paint(4, menuBtn);
            break;
            
            case 5:
                interfaz.changeSale((CardLayout)pnlContent.getLayout(), pnlContent);
                interfaz.paint(5, menuBtn);
            break;
        }
        
        this.interfaz = interfaz;
        
        this.home = new CHome();
        this.users = new CUsers();
        /*this.customers = new CCustomers(jTableCust);
        this.products = new CProducts();
        this.transacts = new CTransacts(tblTransacts, lisCustomers);
        this.orders = new COrders(tblOrders, tblOrderDetails, txaCustomer);
        this.invoices = new CInvoices(tblInvoices , tblOrders, tblOrderDetails,txaCusInv);
        this.help = new CHelp();
        this.catMeasures = new CCategory_Measure(tblCategorias, tblUnidades);
        this.typeAccounts = new CType_Account();
        
        this.user = new Users();
        
        /*typeAccounts.updateTableTrasactionTypes(tbTrasactionTypes);
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
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                invoices.displayDetails(tblInvoices, tblInvoicesDetails);
            }
        });
        */
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnProducts = new javax.swing.JButton();
        btnSuppliers = new javax.swing.JButton();
        btnSale = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnStore = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        pnlAccess = new javax.swing.JPanel();
        lblImgLog = new javax.swing.JLabel();
        pnlDataAccess = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        btnLogIn = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        lblForgottenPass = new javax.swing.JLabel();
        pnlUsers = new javax.swing.JPanel();
        pnlUserMaster = new javax.swing.JPanel();
        btnUserShow = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        btnUserSearch = new javax.swing.JButton();
        btnUserAdd = new javax.swing.JButton();
        pnlUserSlave = new javax.swing.JPanel();
        pnlUserShow = new javax.swing.JPanel();
        lblUserShow = new javax.swing.JLabel();
        scpUserShow = new javax.swing.JScrollPane();
        tblUserShow = new javax.swing.JTable();
        pnlUserAdd = new javax.swing.JPanel();
        lblNewUser = new javax.swing.JLabel();
        pnlNewUser = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        txtUserFatherLastName = new javax.swing.JTextField();
        txtUserMotherLastName = new javax.swing.JTextField();
        txtUserNi = new javax.swing.JTextField();
        txtUserAddress = new javax.swing.JTextField();
        txtUserCellphone = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblUserFatherLastName = new javax.swing.JLabel();
        lblUserMotherLastName = new javax.swing.JLabel();
        lblUserNi = new javax.swing.JLabel();
        lblUserAdress = new javax.swing.JLabel();
        txtUserEmergencyNumber = new javax.swing.JTextField();
        txtUserEmail = new javax.swing.JTextField();
        lblUserPosition = new javax.swing.JLabel();
        lblUserEmail = new javax.swing.JLabel();
        lblUserEmergencyNumber = new javax.swing.JLabel();
        cbxUserGender = new javax.swing.JComboBox();
        lblUserGender = new javax.swing.JLabel();
        lblUserCellphone = new javax.swing.JLabel();
        cbxUserPosition = new javax.swing.JComboBox();
        lblUserOther = new javax.swing.JLabel();
        scpUserOther = new javax.swing.JScrollPane();
        txaUserOthers = new javax.swing.JTextArea();
        btnUserRegister = new javax.swing.JButton();
        lblUserMandatory = new javax.swing.JLabel();
        pnlUserSearch = new javax.swing.JPanel();
        pnlSeekUser = new javax.swing.JPanel();
        txtNameSearch = new javax.swing.JTextField();
        btnSearchUser = new javax.swing.JButton();
        pnlResultUser = new javax.swing.JPanel();
        scpResultUser = new javax.swing.JScrollPane();
        tblResultUser = new javax.swing.JTable();
        lblResultUser = new javax.swing.JLabel();
        btnModifyUser = new javax.swing.JButton();
        lblUserSearch = new javax.swing.JLabel();
        pnlSuppliers = new javax.swing.JPanel();
        pnlSupplierMaster = new javax.swing.JPanel();
        btnSupplierShow = new javax.swing.JButton();
        lblSupplier = new javax.swing.JLabel();
        btnSupplierSearch = new javax.swing.JButton();
        btnSupplierAdd = new javax.swing.JButton();
        btnSupplierLink = new javax.swing.JButton();
        pnlSupplierSlave = new javax.swing.JPanel();
        pnlSupplierAdd = new javax.swing.JPanel();
        pnlSupplierSearch = new javax.swing.JPanel();
        pnlSupplierShow = new javax.swing.JPanel();
        pnlSupplierLink = new javax.swing.JPanel();
        pnlProducts = new javax.swing.JPanel();
        pnlProductMaster = new javax.swing.JPanel();
        lblProduct = new javax.swing.JLabel();
        btnProductShow = new javax.swing.JButton();
        btnProductAdd = new javax.swing.JButton();
        pnlProductSlave = new javax.swing.JPanel();
        pnlProductAdd = new javax.swing.JPanel();
        pnlProductShow = new javax.swing.JPanel();
        pnlStore = new javax.swing.JPanel();
        pnlStoreMaster = new javax.swing.JPanel();
        btnStoreReportProd = new javax.swing.JButton();
        lblStore = new javax.swing.JLabel();
        btnStoreSearchTic = new javax.swing.JButton();
        btnStoreSearchPro = new javax.swing.JButton();
        btnStoreReportSale = new javax.swing.JButton();
        btnStoreInvent = new javax.swing.JButton();
        pnlStoreSlave = new javax.swing.JPanel();
        pnlStoreSearchPro = new javax.swing.JPanel();
        pnlStoreSearchTic = new javax.swing.JPanel();
        pnlStoreReportProd = new javax.swing.JPanel();
        pnlStoreReportSale = new javax.swing.JPanel();
        pnlStoreInvent = new javax.swing.JPanel();
        pnlSale = new javax.swing.JPanel();

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
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnUsers.setBackground(new java.awt.Color(224, 224, 224));
        btnUsers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Customer2.png"))); // NOI18N
        btnUsers.setText("Users");
        btnUsers.setBorder(null);
        btnUsers.setBorderPainted(false);
        btnUsers.setContentAreaFilled(false);
        btnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsers.setEnabled(false);
        btnUsers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsers.setIconTextGap(-3);
        btnUsers.setOpaque(true);
        btnUsers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Customer3.png"))); // NOI18N
        btnUsers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Customer1.png"))); // NOI18N
        btnUsers.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnUsers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnProducts.setBackground(new java.awt.Color(224, 224, 224));
        btnProducts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Transaction2.png"))); // NOI18N
        btnProducts.setText("Products");
        btnProducts.setBorder(null);
        btnProducts.setBorderPainted(false);
        btnProducts.setContentAreaFilled(false);
        btnProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducts.setEnabled(false);
        btnProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducts.setIconTextGap(-3);
        btnProducts.setOpaque(true);
        btnProducts.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Transaction3.png"))); // NOI18N
        btnProducts.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Transaction1.png"))); // NOI18N
        btnProducts.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnProducts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnSuppliers.setBackground(new java.awt.Color(224, 224, 224));
        btnSuppliers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Product2.png"))); // NOI18N
        btnSuppliers.setText("Suppliers");
        btnSuppliers.setBorder(null);
        btnSuppliers.setBorderPainted(false);
        btnSuppliers.setContentAreaFilled(false);
        btnSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuppliers.setEnabled(false);
        btnSuppliers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSuppliers.setIconTextGap(-3);
        btnSuppliers.setOpaque(true);
        btnSuppliers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Product3.png"))); // NOI18N
        btnSuppliers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Product1.png"))); // NOI18N
        btnSuppliers.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSuppliers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppliersActionPerformed(evt);
            }
        });

        btnSale.setBackground(new java.awt.Color(224, 224, 224));
        btnSale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Invoice2.png"))); // NOI18N
        btnSale.setText("Sale");
        btnSale.setBorder(null);
        btnSale.setBorderPainted(false);
        btnSale.setContentAreaFilled(false);
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.setEnabled(false);
        btnSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSale.setIconTextGap(-3);
        btnSale.setOpaque(true);
        btnSale.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Invoice3.png"))); // NOI18N
        btnSale.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Invoice1.png"))); // NOI18N
        btnSale.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSale.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
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
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnStore.setBackground(new java.awt.Color(224, 224, 224));
        btnStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Order2.png"))); // NOI18N
        btnStore.setText("Store");
        btnStore.setBorder(null);
        btnStore.setBorderPainted(false);
        btnStore.setContentAreaFilled(false);
        btnStore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStore.setEnabled(false);
        btnStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStore.setIconTextGap(-3);
        btnStore.setOpaque(true);
        btnStore.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Order3.png"))); // NOI18N
        btnStore.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Order1.png"))); // NOI18N
        btnStore.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnStore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStore, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStore, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContent.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlContent.setPreferredSize(new java.awt.Dimension(787, 500));
        pnlContent.setLayout(new java.awt.CardLayout());

        pnlHome.setBackground(new java.awt.Color(210, 210, 210));
        pnlHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlHome.setPreferredSize(new java.awt.Dimension(800, 550));

        lblHome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("X & G Centeno");

        pnlAccess.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "  Acceso  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        pnlAccess.setName(""); // NOI18N

        lblImgLog.setBackground(new java.awt.Color(255, 255, 255));
        lblImgLog.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblImgLog.setForeground(new java.awt.Color(204, 0, 51));
        lblImgLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgLog.setIcon(new javax.swing.ImageIcon("C:\\Users\\Miguel\\Pictures\\Penguins.jpg")); // NOI18N
        lblImgLog.setText("Imagen");
        lblImgLog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("Id de Usuario:");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPass.setText("Contraseña:");

        btnLogIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogIn.setText("Ingresar");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDataAccessLayout = new javax.swing.GroupLayout(pnlDataAccess);
        pnlDataAccess.setLayout(pnlDataAccessLayout);
        pnlDataAccessLayout.setHorizontalGroup(
            pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(lblPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addComponent(txtPass))
                .addGap(11, 11, 11))
            .addGroup(pnlDataAccessLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(btnLogIn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDataAccessLayout.setVerticalGroup(
            pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataAccessLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblForgottenPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblForgottenPass.setForeground(new java.awt.Color(0, 0, 204));
        lblForgottenPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForgottenPass.setText("¿Olvidó su contraseña?");

        javax.swing.GroupLayout pnlAccessLayout = new javax.swing.GroupLayout(pnlAccess);
        pnlAccess.setLayout(pnlAccessLayout);
        pnlAccessLayout.setHorizontalGroup(
            pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccessLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccessLayout.createSequentialGroup()
                        .addComponent(lblImgLog, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDataAccess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblForgottenPass, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlAccessLayout.setVerticalGroup(
            pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccessLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImgLog, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDataAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(lblForgottenPass)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(pnlAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        pnlAccess.getAccessibleContext().setAccessibleName(""); // NOI18N
        pnlAccess.getAccessibleContext().setAccessibleDescription("");

        pnlContent.add(pnlHome, "pnlHome");

        pnlUsers.setPreferredSize(new java.awt.Dimension(800, 550));

        pnlUserMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnUserShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserShow.setText("Usuarios Registrados");
        btnUserShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserShowActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("USUARIOS");

        btnUserSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserSearch.setText("Buscar Usuario");
        btnUserSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserSearchActionPerformed(evt);
            }
        });

        btnUserAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserAdd.setText("Registrar Usuario");
        btnUserAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUserMasterLayout = new javax.swing.GroupLayout(pnlUserMaster);
        pnlUserMaster.setLayout(pnlUserMasterLayout);
        pnlUserMasterLayout.setHorizontalGroup(
            pnlUserMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserMasterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlUserMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserShow, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUserMasterLayout.setVerticalGroup(
            pnlUserMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUserShow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        pnlUserSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlUserSlave.setLayout(new java.awt.CardLayout());

        lblUserShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserShow.setText("REGISTRO DE NUEVO USUARIO");

        tblUserShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Apellido Paterno", "Apellido Materno", "Cargo", "DNI", "Celular", "E-Mail", "Género"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpUserShow.setViewportView(tblUserShow);

        javax.swing.GroupLayout pnlUserShowLayout = new javax.swing.GroupLayout(pnlUserShow);
        pnlUserShow.setLayout(pnlUserShowLayout);
        pnlUserShowLayout.setHorizontalGroup(
            pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserShowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlUserShowLayout.setVerticalGroup(
            pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUserSlave.add(pnlUserShow, "pnlUserShow");

        lblNewUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNewUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewUser.setText("REGISTRO DE NUEVO USUARIO");

        pnlNewUser.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtUserName.setToolTipText("");

        txtUserFatherLastName.setToolTipText("");

        txtUserMotherLastName.setToolTipText("");
        txtUserMotherLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserMotherLastNameActionPerformed(evt);
            }
        });

        txtUserNi.setToolTipText("");

        txtUserAddress.setToolTipText("");

        txtUserCellphone.setToolTipText("");

        lblUserName.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserName.setText("Nombre(s)");

        lblUserFatherLastName.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserFatherLastName.setText("Apellido Paterno");

        lblUserMotherLastName.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserMotherLastName.setText("Apellido Materno");

        lblUserNi.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserNi.setText("DNI");

        lblUserAdress.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserAdress.setText("Dirección");

        txtUserEmergencyNumber.setToolTipText("");

        txtUserEmail.setToolTipText("");

        lblUserPosition.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserPosition.setText("Cargo");

        lblUserEmail.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserEmail.setText("Correo Electrónico");

        lblUserEmergencyNumber.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserEmergencyNumber.setText("Num. Emergencia");

        lblUserGender.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserGender.setText("Género");

        lblUserCellphone.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserCellphone.setText("Celular");

        lblUserOther.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblUserOther.setText("Otros");

        txaUserOthers.setColumns(20);
        txaUserOthers.setRows(5);
        scpUserOther.setViewportView(txaUserOthers);

        btnUserRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserRegister.setText("Registrar");
        btnUserRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserRegisterActionPerformed(evt);
            }
        });

        lblUserMandatory.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblUserMandatory.setText("* Obligatorio");

        javax.swing.GroupLayout pnlNewUserLayout = new javax.swing.GroupLayout(pnlNewUser);
        pnlNewUser.setLayout(pnlNewUserLayout);
        pnlNewUserLayout.setHorizontalGroup(
            pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserOther, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlNewUserLayout.createSequentialGroup()
                        .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpUserOther)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewUserLayout.createSequentialGroup()
                                .addComponent(lblUserMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUserRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                .addComponent(lblUserPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxUserPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUserCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtUserCellphone))
                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlNewUserLayout.createSequentialGroup()
                                        .addComponent(lblUserNi, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtUserNi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblUserGender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxUserGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlNewUserLayout.createSequentialGroup()
                                        .addComponent(lblUserAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlNewUserLayout.createSequentialGroup()
                                        .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblUserEmergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                                .addComponent(txtUserEmergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtUserEmail)))
                                    .addGroup(pnlNewUserLayout.createSequentialGroup()
                                        .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblUserFatherLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                        .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtUserFatherLastName))
                                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtUserName)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                .addComponent(lblUserMotherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUserMotherLastName)))
                        .addGap(10, 10, 10))))
        );
        pnlNewUserLayout.setVerticalGroup(
            pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewUserLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserFatherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserFatherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserMotherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserMotherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserNi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserNi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUserGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserGender, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxUserPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserEmergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserEmergencyNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUserOther, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpUserOther, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserMandatory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlUserAddLayout = new javax.swing.GroupLayout(pnlUserAdd);
        pnlUserAdd.setLayout(pnlUserAddLayout);
        pnlUserAddLayout.setHorizontalGroup(
            pnlUserAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlUserAddLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(pnlNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pnlUserAddLayout.setVerticalGroup(
            pnlUserAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUserSlave.add(pnlUserAdd, "pnlUserAdd");

        txtNameSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearch.setText("Ingrese nombre de Usuario");
        txtNameSearch.setToolTipText("");

        btnSearchUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchUser.setText("Buscar");
        btnSearchUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSeekUserLayout = new javax.swing.GroupLayout(pnlSeekUser);
        pnlSeekUser.setLayout(pnlSeekUserLayout);
        pnlSeekUserLayout.setHorizontalGroup(
            pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekUserLayout.setVerticalGroup(
            pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultUser.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblResultUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cargo", "Celular"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpResultUser.setViewportView(tblResultUser);

        lblResultUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultUser.setText("RESULTADOS DE LA BÚSQUEDA");

        btnModifyUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModifyUser.setText("Modificar Datos");
        btnModifyUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModifyUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultUserLayout = new javax.swing.GroupLayout(pnlResultUser);
        pnlResultUser.setLayout(pnlResultUserLayout);
        pnlResultUserLayout.setHorizontalGroup(
            pnlResultUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(lblResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultUserLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModifyUser)))
                .addContainerGap())
        );
        pnlResultUserLayout.setVerticalGroup(
            pnlResultUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModifyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblUserSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserSearch.setText("BUSCAR USUARIO");

        javax.swing.GroupLayout pnlUserSearchLayout = new javax.swing.GroupLayout(pnlUserSearch);
        pnlUserSearch.setLayout(pnlUserSearchLayout);
        pnlUserSearchLayout.setHorizontalGroup(
            pnlUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUserSearchLayout.createSequentialGroup()
                .addGroup(pnlUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUserSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlUserSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlUserSearchLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(pnlSeekUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlUserSearchLayout.setVerticalGroup(
            pnlUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSeekUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUserSlave.add(pnlUserSearch, "pnlUserSearch");

        javax.swing.GroupLayout pnlUsersLayout = new javax.swing.GroupLayout(pnlUsers);
        pnlUsers.setLayout(pnlUsersLayout);
        pnlUsersLayout.setHorizontalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlUserMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlUserSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlUsersLayout.setVerticalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUserMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUserSlave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlUsers, "pnlUsers");

        pnlSupplierMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSupplierShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierShow.setText("Proveedores Registrados");
        btnSupplierShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierShowActionPerformed(evt);
            }
        });

        lblSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier.setText("PROVEEDORES");

        btnSupplierSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierSearch.setText("Buscar Proveedor");
        btnSupplierSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierSearchActionPerformed(evt);
            }
        });

        btnSupplierAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierAdd.setText("Registrar Proveedor");
        btnSupplierAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierAddActionPerformed(evt);
            }
        });

        btnSupplierLink.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierLink.setText("Vincular Productos");
        btnSupplierLink.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierLinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSupplierMasterLayout = new javax.swing.GroupLayout(pnlSupplierMaster);
        pnlSupplierMaster.setLayout(pnlSupplierMasterLayout);
        pnlSupplierMasterLayout.setHorizontalGroup(
            pnlSupplierMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSupplierMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSupplierLink, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupplierShow, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSupplierAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSupplierMasterLayout.setVerticalGroup(
            pnlSupplierMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSupplierMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupplierAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupplierShow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSupplierLink, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(268, Short.MAX_VALUE))
        );

        pnlSupplierSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlSupplierSlave.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnlSupplierAddLayout = new javax.swing.GroupLayout(pnlSupplierAdd);
        pnlSupplierAdd.setLayout(pnlSupplierAddLayout);
        pnlSupplierAddLayout.setHorizontalGroup(
            pnlSupplierAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlSupplierAddLayout.setVerticalGroup(
            pnlSupplierAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlSupplierSlave.add(pnlSupplierAdd, "pnlSupplierAdd");

        javax.swing.GroupLayout pnlSupplierSearchLayout = new javax.swing.GroupLayout(pnlSupplierSearch);
        pnlSupplierSearch.setLayout(pnlSupplierSearchLayout);
        pnlSupplierSearchLayout.setHorizontalGroup(
            pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlSupplierSearchLayout.setVerticalGroup(
            pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlSupplierSlave.add(pnlSupplierSearch, "pnlSupplierSearch");

        javax.swing.GroupLayout pnlSupplierShowLayout = new javax.swing.GroupLayout(pnlSupplierShow);
        pnlSupplierShow.setLayout(pnlSupplierShowLayout);
        pnlSupplierShowLayout.setHorizontalGroup(
            pnlSupplierShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlSupplierShowLayout.setVerticalGroup(
            pnlSupplierShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlSupplierSlave.add(pnlSupplierShow, "pnlSupplierShow");

        javax.swing.GroupLayout pnlSupplierLinkLayout = new javax.swing.GroupLayout(pnlSupplierLink);
        pnlSupplierLink.setLayout(pnlSupplierLinkLayout);
        pnlSupplierLinkLayout.setHorizontalGroup(
            pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlSupplierLinkLayout.setVerticalGroup(
            pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlSupplierSlave.add(pnlSupplierLink, "pnlSupplierLink");

        javax.swing.GroupLayout pnlSuppliersLayout = new javax.swing.GroupLayout(pnlSuppliers);
        pnlSuppliers.setLayout(pnlSuppliersLayout);
        pnlSuppliersLayout.setHorizontalGroup(
            pnlSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSupplierMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSupplierSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSuppliersLayout.setVerticalGroup(
            pnlSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSupplierMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSupplierSlave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlSuppliers, "pnlSuppliers");

        pnlProductMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct.setText("PRODUCTOS");

        btnProductShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProductShow.setText("Productos Registrados");
        btnProductShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductShowActionPerformed(evt);
            }
        });

        btnProductAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProductAdd.setText("Registrar Producto");
        btnProductAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProductMasterLayout = new javax.swing.GroupLayout(pnlProductMaster);
        pnlProductMaster.setLayout(pnlProductMasterLayout);
        pnlProductMasterLayout.setHorizontalGroup(
            pnlProductMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductMasterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlProductMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnProductShow, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProductMasterLayout.setVerticalGroup(
            pnlProductMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlProductMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProductAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProductShow, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        pnlProductSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlProductSlave.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnlProductAddLayout = new javax.swing.GroupLayout(pnlProductAdd);
        pnlProductAdd.setLayout(pnlProductAddLayout);
        pnlProductAddLayout.setHorizontalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlProductAddLayout.setVerticalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlProductSlave.add(pnlProductAdd, "pnlProductAdd");

        javax.swing.GroupLayout pnlProductShowLayout = new javax.swing.GroupLayout(pnlProductShow);
        pnlProductShow.setLayout(pnlProductShowLayout);
        pnlProductShowLayout.setHorizontalGroup(
            pnlProductShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlProductShowLayout.setVerticalGroup(
            pnlProductShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlProductSlave.add(pnlProductShow, "pnlProductShow");

        javax.swing.GroupLayout pnlProductsLayout = new javax.swing.GroupLayout(pnlProducts);
        pnlProducts.setLayout(pnlProductsLayout);
        pnlProductsLayout.setHorizontalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlProductMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProductSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlProductsLayout.setVerticalGroup(
            pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProductMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProductSlave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlProducts, "pnlProducts");

        pnlStoreMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnStoreReportProd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreReportProd.setText("Reporte Productos");
        btnStoreReportProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreReportProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreReportProdActionPerformed(evt);
            }
        });

        lblStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStore.setText("ALMACÉN");

        btnStoreSearchTic.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreSearchTic.setText("Buscar Boleta");
        btnStoreSearchTic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreSearchTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreSearchTicActionPerformed(evt);
            }
        });

        btnStoreSearchPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreSearchPro.setText("Buscar Producto");
        btnStoreSearchPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreSearchPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreSearchProActionPerformed(evt);
            }
        });

        btnStoreReportSale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreReportSale.setText("Reporte Ventas");
        btnStoreReportSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreReportSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreReportSaleActionPerformed(evt);
            }
        });

        btnStoreInvent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreInvent.setText("Inventario de Productos");
        btnStoreInvent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreInvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreInventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStoreMasterLayout = new javax.swing.GroupLayout(pnlStoreMaster);
        pnlStoreMaster.setLayout(pnlStoreMasterLayout);
        pnlStoreMasterLayout.setHorizontalGroup(
            pnlStoreMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreMasterLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlStoreMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnStoreInvent, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStoreReportSale, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStoreReportProd, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStoreSearchTic, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStoreSearchPro, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStore, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStoreMasterLayout.setVerticalGroup(
            pnlStoreMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStoreMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStoreSearchPro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStoreSearchTic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStoreReportProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStoreReportSale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnStoreInvent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );

        pnlStoreSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlStoreSlave.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnlStoreSearchProLayout = new javax.swing.GroupLayout(pnlStoreSearchPro);
        pnlStoreSearchPro.setLayout(pnlStoreSearchProLayout);
        pnlStoreSearchProLayout.setHorizontalGroup(
            pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlStoreSearchProLayout.setVerticalGroup(
            pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlStoreSlave.add(pnlStoreSearchPro, "pnlStoreSearchPro");

        javax.swing.GroupLayout pnlStoreSearchTicLayout = new javax.swing.GroupLayout(pnlStoreSearchTic);
        pnlStoreSearchTic.setLayout(pnlStoreSearchTicLayout);
        pnlStoreSearchTicLayout.setHorizontalGroup(
            pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlStoreSearchTicLayout.setVerticalGroup(
            pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlStoreSlave.add(pnlStoreSearchTic, "pnlStoreSearchTic");

        javax.swing.GroupLayout pnlStoreReportProdLayout = new javax.swing.GroupLayout(pnlStoreReportProd);
        pnlStoreReportProd.setLayout(pnlStoreReportProdLayout);
        pnlStoreReportProdLayout.setHorizontalGroup(
            pnlStoreReportProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlStoreReportProdLayout.setVerticalGroup(
            pnlStoreReportProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlStoreSlave.add(pnlStoreReportProd, "pnlStoreReportProd");

        javax.swing.GroupLayout pnlStoreReportSaleLayout = new javax.swing.GroupLayout(pnlStoreReportSale);
        pnlStoreReportSale.setLayout(pnlStoreReportSaleLayout);
        pnlStoreReportSaleLayout.setHorizontalGroup(
            pnlStoreReportSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlStoreReportSaleLayout.setVerticalGroup(
            pnlStoreReportSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlStoreSlave.add(pnlStoreReportSale, "pnlStoreReportSale");

        javax.swing.GroupLayout pnlStoreInventLayout = new javax.swing.GroupLayout(pnlStoreInvent);
        pnlStoreInvent.setLayout(pnlStoreInventLayout);
        pnlStoreInventLayout.setHorizontalGroup(
            pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        pnlStoreInventLayout.setVerticalGroup(
            pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 474, Short.MAX_VALUE)
        );

        pnlStoreSlave.add(pnlStoreInvent, "pnlStoreInvent");

        javax.swing.GroupLayout pnlStoreLayout = new javax.swing.GroupLayout(pnlStore);
        pnlStore.setLayout(pnlStoreLayout);
        pnlStoreLayout.setHorizontalGroup(
            pnlStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStoreMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlStoreSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlStoreLayout.setVerticalGroup(
            pnlStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStoreMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStoreSlave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlStore, "pnlStore");

        javax.swing.GroupLayout pnlSaleLayout = new javax.swing.GroupLayout(pnlSale);
        pnlSale.setLayout(pnlSaleLayout);
        pnlSaleLayout.setHorizontalGroup(
            pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        pnlSaleLayout.setVerticalGroup(
            pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        pnlContent.add(pnlSale, "pnlSale");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUsersActionPerformed
    {//GEN-HEADEREND:event_btnUsersActionPerformed
        interfaz.changeUsers((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(1, menuBtn);
        users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHomeActionPerformed
    {//GEN-HEADEREND:event_btnHomeActionPerformed
        interfaz.changeHome((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(0, menuBtn);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSuppliersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSuppliersActionPerformed
    {//GEN-HEADEREND:event_btnSuppliersActionPerformed
        interfaz.changeSuppliers((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(2, menuBtn);
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProductsActionPerformed
    {//GEN-HEADEREND:event_btnProductsActionPerformed
        interfaz.changeProducts((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(3, menuBtn);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnStoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStoreActionPerformed
    {//GEN-HEADEREND:event_btnStoreActionPerformed
        interfaz.changeStore((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(4, menuBtn);
    }//GEN-LAST:event_btnStoreActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaleActionPerformed
    {//GEN-HEADEREND:event_btnSaleActionPerformed
        interfaz.changeSale((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(5, menuBtn);
    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed

    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        clean();
        users.changeUserAdd((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave,cbxUserGender, cbxUserPosition, lblNewUser, btnUserRegister);
        state = 0;
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnUserSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSearchActionPerformed
        clean();
        users.changeUserSearch((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave);
        state = 1;
        userCode = "";
    }//GEN-LAST:event_btnUserSearchActionPerformed

    private void btnUserShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserShowActionPerformed
        clean();
        users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
    }//GEN-LAST:event_btnUserShowActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLogInActionPerformed
    {//GEN-HEADEREND:event_btnLogInActionPerformed
        if((user = home.logIn(txtId, txtPass)) != null)
        {
            clean();
            home.activate(Integer.parseInt(user.getPositionCode()), btnHome, btnUsers, btnSuppliers, btnProducts, btnStore, btnSale);
            
            switch(Integer.parseInt(user.getPositionCode())){
                case 1:
                    interfaz.changeUsers((CardLayout)pnlContent.getLayout(), pnlContent);
                    interfaz.paint(1, menuBtn);
                    users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
                    break;
                case 2:
                    interfaz.changeSale((CardLayout)pnlContent.getLayout(), pnlContent);
                    interfaz.paint(5, menuBtn);
                    break;
            }            
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed

    }//GEN-LAST:event_txtPassActionPerformed

    private void btnSupplierShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierShowActionPerformed

    }//GEN-LAST:event_btnSupplierShowActionPerformed

    private void btnSupplierSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierSearchActionPerformed

    }//GEN-LAST:event_btnSupplierSearchActionPerformed

    private void btnSupplierAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierAddActionPerformed

    }//GEN-LAST:event_btnSupplierAddActionPerformed

    private void btnSupplierLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierLinkActionPerformed

    }//GEN-LAST:event_btnSupplierLinkActionPerformed

    private void btnProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductAddActionPerformed

    }//GEN-LAST:event_btnProductAddActionPerformed

    private void btnProductShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductShowActionPerformed

    }//GEN-LAST:event_btnProductShowActionPerformed

    private void btnStoreReportProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreReportProdActionPerformed

    }//GEN-LAST:event_btnStoreReportProdActionPerformed

    private void btnStoreSearchTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreSearchTicActionPerformed

    }//GEN-LAST:event_btnStoreSearchTicActionPerformed

    private void btnStoreSearchProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreSearchProActionPerformed

    }//GEN-LAST:event_btnStoreSearchProActionPerformed

    private void btnStoreReportSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreReportSaleActionPerformed

    }//GEN-LAST:event_btnStoreReportSaleActionPerformed

    private void btnStoreInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreInventActionPerformed

    }//GEN-LAST:event_btnStoreInventActionPerformed

    private void txtUserMotherLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserMotherLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserMotherLastNameActionPerformed

    private void btnUserRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserRegisterActionPerformed
        users.actUser(state, userCode, txtUserName, txtUserFatherLastName, txtUserMotherLastName, txtUserNi, cbxUserGender, txtUserAddress, cbxUserPosition, txtUserCellphone, txtUserEmail, txtUserEmergencyNumber, txaUserOthers); 
        users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
    }//GEN-LAST:event_btnUserRegisterActionPerformed

    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        clean();
        usersSearch = users.searchUser(txtNameSearch, tblResultUser);
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void btnModifyUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyUserActionPerformed
        int value = 0;
        if((value = tblResultUser.getSelectedRow()) != -1){
            clean();
            userCode = users.sent((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, usersSearch.get(value), lblNewUser, txtUserName, txtUserFatherLastName, txtUserMotherLastName, txtUserNi, cbxUserGender, txtUserAddress, cbxUserPosition, txtUserCellphone, txtUserEmail, txtUserEmergencyNumber, txaUserOthers, btnUserRegister);
        } else
            JOptionPane.showMessageDialog(  null, 
                                            "No ha seleccionado ningún registro.", 
                                            "Dato no Seleccionado", 
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifyUserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnModifyUser;
    private javax.swing.JButton btnProductAdd;
    private javax.swing.JButton btnProductShow;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JButton btnStore;
    private javax.swing.JButton btnStoreInvent;
    private javax.swing.JButton btnStoreReportProd;
    private javax.swing.JButton btnStoreReportSale;
    private javax.swing.JButton btnStoreSearchPro;
    private javax.swing.JButton btnStoreSearchTic;
    private javax.swing.JButton btnSupplierAdd;
    private javax.swing.JButton btnSupplierLink;
    private javax.swing.JButton btnSupplierSearch;
    private javax.swing.JButton btnSupplierShow;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JButton btnUserRegister;
    private javax.swing.JButton btnUserSearch;
    private javax.swing.JButton btnUserShow;
    private javax.swing.JButton btnUsers;
    private javax.swing.JComboBox cbxUserGender;
    private javax.swing.JComboBox cbxUserPosition;
    private javax.swing.JLabel lblForgottenPass;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImgLog;
    private javax.swing.JLabel lblNewUser;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblResultUser;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserAdress;
    private javax.swing.JLabel lblUserCellphone;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserEmergencyNumber;
    private javax.swing.JLabel lblUserFatherLastName;
    private javax.swing.JLabel lblUserGender;
    private javax.swing.JLabel lblUserMandatory;
    private javax.swing.JLabel lblUserMotherLastName;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNi;
    private javax.swing.JLabel lblUserOther;
    private javax.swing.JLabel lblUserPosition;
    private javax.swing.JLabel lblUserSearch;
    private javax.swing.JLabel lblUserShow;
    private javax.swing.JPanel pnlAccess;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlDataAccess;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNewUser;
    private javax.swing.JPanel pnlProductAdd;
    private javax.swing.JPanel pnlProductMaster;
    private javax.swing.JPanel pnlProductShow;
    private javax.swing.JPanel pnlProductSlave;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JPanel pnlResultUser;
    private javax.swing.JPanel pnlSale;
    private javax.swing.JPanel pnlSeekUser;
    private javax.swing.JPanel pnlStore;
    private javax.swing.JPanel pnlStoreInvent;
    private javax.swing.JPanel pnlStoreMaster;
    private javax.swing.JPanel pnlStoreReportProd;
    private javax.swing.JPanel pnlStoreReportSale;
    private javax.swing.JPanel pnlStoreSearchPro;
    private javax.swing.JPanel pnlStoreSearchTic;
    private javax.swing.JPanel pnlStoreSlave;
    private javax.swing.JPanel pnlSupplierAdd;
    private javax.swing.JPanel pnlSupplierLink;
    private javax.swing.JPanel pnlSupplierMaster;
    private javax.swing.JPanel pnlSupplierSearch;
    private javax.swing.JPanel pnlSupplierShow;
    private javax.swing.JPanel pnlSupplierSlave;
    private javax.swing.JPanel pnlSuppliers;
    private javax.swing.JPanel pnlUserAdd;
    private javax.swing.JPanel pnlUserMaster;
    private javax.swing.JPanel pnlUserSearch;
    private javax.swing.JPanel pnlUserShow;
    private javax.swing.JPanel pnlUserSlave;
    private javax.swing.JPanel pnlUsers;
    private javax.swing.JScrollPane scpResultUser;
    private javax.swing.JScrollPane scpUserOther;
    private javax.swing.JScrollPane scpUserShow;
    private javax.swing.JTable tblResultUser;
    private javax.swing.JTable tblUserShow;
    private javax.swing.JTextArea txaUserOthers;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JTextField txtUserCellphone;
    private javax.swing.JTextField txtUserEmail;
    private javax.swing.JTextField txtUserEmergencyNumber;
    private javax.swing.JTextField txtUserFatherLastName;
    private javax.swing.JTextField txtUserMotherLastName;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserNi;
    // End of variables declaration//GEN-END:variables
    
    private void clean(){
        txtUserName.setText("");
        txtUserFatherLastName.setText("");
        txtUserMotherLastName.setText("");
        txtUserNi.setText("");   
        txtUserAddress.setText("");    
        txtUserCellphone.setText("");
        txtUserEmail.setText("");
        txtUserEmergencyNumber.setText("");
        txaUserOthers.setText("");
       
        cbxUserGender.removeAllItems();
        cbxUserPosition.removeAllItems();
        
        DefaultTableModel model = (DefaultTableModel) tblResultUser.getModel();
        model.getDataVector().removeAllElements();
        
        model = (DefaultTableModel) tblUserShow.getModel();
        model.getDataVector().removeAllElements();
        
        lblNewUser.removeAll();
    }

}
