package Vista;

import Controlador.CHelp;
import Controlador.CHome;
import Controlador.CProducts;
import Controlador.CSale;
import Controlador.CStore;
import Controlador.CSuppliers;
import Controlador.CTicket;
import Controlador.CUsers;
import Controlador.IMain;
import Modelo.Products;
import Modelo.Users;
import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class UIMain extends javax.swing.JFrame
{
    private IMain interfaz;
    private CHome home;
    private CUsers users;
    private CSuppliers suppliers;
    private CProducts products;
    private CStore store;
    private CSale sale;
    
    
    private CHelp help;
    private ArrayList <JButton> menuBtn;
    private ListSelectionModel cellSelectionModel;
    
    private Users user;
    private int state;
    private ArrayList <String> usersSearch;
    private ArrayList <String> productsSearch;
    private String userCode;
    private ArrayList <String> suppliersSearch;
    private ArrayList <String> ticketsSearch;
    private String supplierCode;
    private String productCode;
    private ArrayList <String> productsInd;
    private ArrayList <String> suppliersInd;
    private ArrayList <Products> productsList;
    double total;
    
    public UIMain(IMain interfaz, int num_ventana)
    {
        initComponents();
        this.setVisible(true);
        this.setTitle("Sale System");
        setLocationRelativeTo(null);
        
        usersSearch = new ArrayList <>();
        productsSearch = new ArrayList <>();
        suppliersSearch = new ArrayList <>();
        ticketsSearch = new ArrayList <>();
        productsInd = new ArrayList <>();
        suppliersInd = new ArrayList <>();
        productsList = new ArrayList <>();
        
        userCode = "";
        supplierCode = "";
        productCode = "";
        total = 0;
        menuBtn = new ArrayList <>();
        menuBtn.add(btnHome);
        menuBtn.add(btnUsers);
        menuBtn.add(btnSuppliers);
        menuBtn.add(btnProducts);
        menuBtn.add(btnStore);
        menuBtn.add(btnSale);
        menuBtn.add(btnHelp);
        this.interfaz = interfaz;
        
        switch(num_ventana)
        {
            case 0:
                this.interfaz.changeHome((CardLayout)pnlContent.getLayout(), pnlContent);
                this.interfaz.paint(0, menuBtn);
            break;
                
            case 1:
                this.interfaz.changeUsers((CardLayout)pnlContent.getLayout(), pnlContent);
                this.interfaz.paint(1, menuBtn);
                users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
            break;
            
            case 2:
                this.interfaz.changeSuppliers((CardLayout)pnlContent.getLayout(), pnlContent);
                this.interfaz.paint(2, menuBtn);
                suppliers.changeSupplierShow((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, tblSupplierShow);
            break;
            
            case 3:
                this.interfaz.changeProducts((CardLayout)pnlContent.getLayout(), pnlContent);
                this.interfaz.paint(3, menuBtn);
                products.changeProductShow((CardLayout)pnlProductSlave.getLayout(), pnlProductSlave, tblProductShow);
            break;
            
            case 4:
                this.interfaz.changeStore((CardLayout)pnlContent.getLayout(), pnlContent);
                this.interfaz.paint(4, menuBtn);
                store.changeInventStore((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave, tblProductShowStore);
            break;
            
            case 5:
                this.interfaz.changeSale((CardLayout)pnlContent.getLayout(), pnlContent);
                this.interfaz.paint(5, menuBtn);
                
                Date date = new Date();
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                this.lblSaleOrderDateOn.setText(format.format(date));
                this.interfaz.setOrderNumber(lblSaleOrderNumber);
                this.lblUserOnSale.setText("Usuario: " + user.getName() + " " + user.getFatherLastName());
            break;
        }
        
        
        this.home = new CHome();
        this.users = new CUsers();
        this.suppliers = new CSuppliers();
        this.products = new CProducts();
        this.store = new CStore();
        this.sale = new CSale();
        
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
        txtNameSearchUser = new javax.swing.JTextField();
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
        pnlSupplierShow = new javax.swing.JPanel();
        lblSupplierShow = new javax.swing.JLabel();
        scpSupplierShow = new javax.swing.JScrollPane();
        tblSupplierShow = new javax.swing.JTable();
        pnlSupplierAdd = new javax.swing.JPanel();
        lblNewSupplier = new javax.swing.JLabel();
        pnlNewSupplier = new javax.swing.JPanel();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierTr = new javax.swing.JTextField();
        txtSupplierAddress = new javax.swing.JTextField();
        txtSupplierPhone = new javax.swing.JTextField();
        lblSupplierName = new javax.swing.JLabel();
        lblSupplierTr = new javax.swing.JLabel();
        lblSupplierAddress = new javax.swing.JLabel();
        lblSupplierPhone = new javax.swing.JLabel();
        btnSupplierRegister = new javax.swing.JButton();
        lblSupplierMandatory = new javax.swing.JLabel();
        pnlSupplierSearch = new javax.swing.JPanel();
        pnlSeekSupplier = new javax.swing.JPanel();
        txtNameSearchSupplier = new javax.swing.JTextField();
        btnSearchSupplier = new javax.swing.JButton();
        pnlResultSupplier = new javax.swing.JPanel();
        scpResultSupplier = new javax.swing.JScrollPane();
        tblResultSupplier = new javax.swing.JTable();
        lblResultSupplier = new javax.swing.JLabel();
        btnModifySupplier = new javax.swing.JButton();
        lblSupplierSearch = new javax.swing.JLabel();
        pnlSupplierLink = new javax.swing.JPanel();
        pnlLinkSupplier = new javax.swing.JPanel();
        lblLinkSupplier = new javax.swing.JLabel();
        scpLinkSupplier = new javax.swing.JScrollPane();
        lstLinkSupplier = new javax.swing.JList();
        txtLinkSupplier = new javax.swing.JTextField();
        btnLinkSupplierSearch = new javax.swing.JButton();
        pnlLinkProducts = new javax.swing.JPanel();
        lblLinkProducts = new javax.swing.JLabel();
        scpLinkProducts = new javax.swing.JScrollPane();
        tblLinkProducts = new javax.swing.JTable();
        btnLinkSupplier = new javax.swing.JButton();
        lblLinkSupplierTitle = new javax.swing.JLabel();
        pnlProducts = new javax.swing.JPanel();
        pnlProductMaster = new javax.swing.JPanel();
        lblProduct = new javax.swing.JLabel();
        btnProductShow = new javax.swing.JButton();
        btnProductAdd = new javax.swing.JButton();
        pnlProductSlave = new javax.swing.JPanel();
        pnlProductAdd = new javax.swing.JPanel();
        lblNewProduct = new javax.swing.JLabel();
        pnlNewProduct = new javax.swing.JPanel();
        txtProductName = new javax.swing.JTextField();
        txtProductBrand = new javax.swing.JTextField();
        txtProductPresentation = new javax.swing.JTextField();
        txtProductStock = new javax.swing.JTextField();
        txtProductPrice = new javax.swing.JTextField();
        lbProductName = new javax.swing.JLabel();
        lblProductBrand = new javax.swing.JLabel();
        lblProductPresentation = new javax.swing.JLabel();
        lblProductStock = new javax.swing.JLabel();
        lblProductPrice = new javax.swing.JLabel();
        cbxProductCategory = new javax.swing.JComboBox();
        lblProductCategory = new javax.swing.JLabel();
        btnProductRegister = new javax.swing.JButton();
        lblUserMandatory1 = new javax.swing.JLabel();
        pnlProductShow = new javax.swing.JPanel();
        lblProductShow = new javax.swing.JLabel();
        scpProductShow = new javax.swing.JScrollPane();
        tblProductShow = new javax.swing.JTable();
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
        pnlSeekProduct = new javax.swing.JPanel();
        txtNameSearchProduct = new javax.swing.JTextField();
        btnSearchProduct = new javax.swing.JButton();
        pnlResultProduct = new javax.swing.JPanel();
        scpResultProduct = new javax.swing.JScrollPane();
        tblResultProduct = new javax.swing.JTable();
        lblResultProduct = new javax.swing.JLabel();
        btnModifyProduct = new javax.swing.JButton();
        lblProductSearch = new javax.swing.JLabel();
        pnlStoreSearchTic = new javax.swing.JPanel();
        pnlSeekTicket = new javax.swing.JPanel();
        txtNameSearchTicket = new javax.swing.JTextField();
        btnSearchTicket = new javax.swing.JButton();
        pnlResultTicket = new javax.swing.JPanel();
        scpResultTicket = new javax.swing.JScrollPane();
        tblResultTicket = new javax.swing.JTable();
        lblResultTicket = new javax.swing.JLabel();
        btnSeeTicket = new javax.swing.JButton();
        lblTicketSearch = new javax.swing.JLabel();
        pnlStoreInvent = new javax.swing.JPanel();
        lblProductShowStore = new javax.swing.JLabel();
        scpProductShowStore = new javax.swing.JScrollPane();
        tblProductShowStore = new javax.swing.JTable();
        cbxSaleSearchProductStore = new javax.swing.JComboBox();
        pnlStoreModifyPro = new javax.swing.JPanel();
        lblProductStore = new javax.swing.JLabel();
        pnlProductStore = new javax.swing.JPanel();
        txtProductNameStore = new javax.swing.JTextField();
        txtProductBrandStore = new javax.swing.JTextField();
        txtProductPresentationStore = new javax.swing.JTextField();
        txtProductStockStore = new javax.swing.JTextField();
        txtProductPriceStore = new javax.swing.JTextField();
        lbProductNameStore = new javax.swing.JLabel();
        lblProductBrandStore = new javax.swing.JLabel();
        lblProductPresentationStore = new javax.swing.JLabel();
        lblProductStockStore = new javax.swing.JLabel();
        lblProductPriceStore = new javax.swing.JLabel();
        cbxProductCategoryStore = new javax.swing.JComboBox();
        lblProductCategoryStore = new javax.swing.JLabel();
        btnProductUpdateStore = new javax.swing.JButton();
        lblUserMandatoryStore = new javax.swing.JLabel();
        pnlStoreSaleReport = new javax.swing.JPanel();
        lblSaleReport = new javax.swing.JLabel();
        pnlContentSaleReport = new javax.swing.JPanel();
        clrStart = new com.toedter.calendar.JCalendar();
        lblSateReportStart = new javax.swing.JLabel();
        lblSateReportEnd = new javax.swing.JLabel();
        clrEnd = new com.toedter.calendar.JCalendar();
        lblSelectDateStart = new javax.swing.JLabel();
        lblSelectDateEnd = new javax.swing.JLabel();
        lblSelectDateStartReport = new javax.swing.JLabel();
        lblSelectDateEndReport = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlSale = new javax.swing.JPanel();
        lblSale = new javax.swing.JLabel();
        pnlSaleOrder = new javax.swing.JPanel();
        lblSaleOrder = new javax.swing.JLabel();
        lblSaleOrderNumber = new javax.swing.JLabel();
        txtSaleOrderClient = new javax.swing.JTextField();
        lblSaleOrderClient = new javax.swing.JLabel();
        lblSaleOrderDate = new javax.swing.JLabel();
        lblSaleOrderDateOn = new javax.swing.JLabel();
        scpSaleOrderTable = new javax.swing.JScrollPane();
        tblSaleOrderTable = new javax.swing.JTable();
        btnSaleOrderDelete = new javax.swing.JButton();
        lblSaleOrderTotal = new javax.swing.JLabel();
        lblSaleOrderTotalOn = new javax.swing.JLabel();
        btnSaleOrderPrint = new javax.swing.JButton();
        lblUserOnSale = new javax.swing.JLabel();
        pnlSaleSearchProduct = new javax.swing.JPanel();
        pnlSaleSearchProductOn = new javax.swing.JPanel();
        lblSaleSearchProduct = new javax.swing.JLabel();
        cbxSaleSearchProduct = new javax.swing.JComboBox();
        btnSaleSearchProduct = new javax.swing.JButton();
        txtSaleSearchProduct = new javax.swing.JTextField();
        scpSaleSearchProduct = new javax.swing.JScrollPane();
        tblSaleSearchProduct = new javax.swing.JTable();
        lblWelcome = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("recursos/icon.png")));
        setResizable(false);

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
        lblForgottenPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgottenPassMouseClicked(evt);
            }
        });

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
                .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
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
                .addContainerGap(239, Short.MAX_VALUE))
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
                .addContainerGap(323, Short.MAX_VALUE))
        );

        pnlUserSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlUserSlave.setLayout(new java.awt.CardLayout());

        lblUserShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserShow.setText("USUARIOS REGISTRADOS");

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
                    .addComponent(scpUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlUserShowLayout.setVerticalGroup(
            pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
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
                .addComponent(scpUserOther, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
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
                .addContainerGap(83, Short.MAX_VALUE))
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

        txtNameSearchUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchUser.setText("Ingrese nombre de Usuario");
        txtNameSearchUser.setToolTipText("");

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
                .addComponent(txtNameSearchUser, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekUserLayout.setVerticalGroup(
            pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(scpResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
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
                .addComponent(scpResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
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
                .addComponent(pnlUserSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
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
                .addContainerGap(282, Short.MAX_VALUE))
        );

        pnlSupplierSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlSupplierSlave.setLayout(new java.awt.CardLayout());

        lblSupplierShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSupplierShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplierShow.setText("PROVEEDORES REGISTRADOS");

        tblSupplierShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "RUC", "Teléfono", "Dirección"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpSupplierShow.setViewportView(tblSupplierShow);

        javax.swing.GroupLayout pnlSupplierShowLayout = new javax.swing.GroupLayout(pnlSupplierShow);
        pnlSupplierShow.setLayout(pnlSupplierShowLayout);
        pnlSupplierShowLayout.setHorizontalGroup(
            pnlSupplierShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierShowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSupplierShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSupplierShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpSupplierShow, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSupplierShowLayout.setVerticalGroup(
            pnlSupplierShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupplierShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpSupplierShow, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSupplierSlave.add(pnlSupplierShow, "pnlSupplierShow");

        lblNewSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNewSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewSupplier.setText("REGISTRO DE NUEVO PROVEEDOR");

        pnlNewSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtSupplierName.setToolTipText("");

        txtSupplierTr.setToolTipText("");

        txtSupplierAddress.setToolTipText("");
        txtSupplierAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierAddressActionPerformed(evt);
            }
        });

        txtSupplierPhone.setToolTipText("");

        lblSupplierName.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierName.setText("Nombre(s)");

        lblSupplierTr.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierTr.setText("RUC");

        lblSupplierAddress.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierAddress.setText("Dirección");

        lblSupplierPhone.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierPhone.setText("Teléfono");

        btnSupplierRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierRegister.setText("Registrar");
        btnSupplierRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierRegisterActionPerformed(evt);
            }
        });

        lblSupplierMandatory.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblSupplierMandatory.setText("* Obligatorio");

        javax.swing.GroupLayout pnlNewSupplierLayout = new javax.swing.GroupLayout(pnlNewSupplier);
        pnlNewSupplier.setLayout(pnlNewSupplierLayout);
        pnlNewSupplierLayout.setHorizontalGroup(
            pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewSupplierLayout.createSequentialGroup()
                        .addComponent(lblSupplierMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                        .addComponent(btnSupplierRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                        .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                                .addComponent(lblSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSupplierTr, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSupplierTr, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
                                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSupplierName)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                        .addComponent(lblSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSupplierAddress)))
                .addGap(10, 10, 10))
        );
        pnlNewSupplierLayout.setVerticalGroup(
            pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierTr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierTr, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSupplierRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplierMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSupplierAddLayout = new javax.swing.GroupLayout(pnlSupplierAdd);
        pnlSupplierAdd.setLayout(pnlSupplierAddLayout);
        pnlSupplierAddLayout.setHorizontalGroup(
            pnlSupplierAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlSupplierAddLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(pnlNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pnlSupplierAddLayout.setVerticalGroup(
            pnlSupplierAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSupplierSlave.add(pnlSupplierAdd, "pnlSupplierAdd");

        txtNameSearchSupplier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchSupplier.setText("Ingrese nombre de Proveedor");
        txtNameSearchSupplier.setToolTipText("");

        btnSearchSupplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchSupplier.setText("Buscar");
        btnSearchSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSeekSupplierLayout = new javax.swing.GroupLayout(pnlSeekSupplier);
        pnlSeekSupplier.setLayout(pnlSeekSupplierLayout);
        pnlSeekSupplierLayout.setHorizontalGroup(
            pnlSeekSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameSearchSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekSupplierLayout.setVerticalGroup(
            pnlSeekSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblResultSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpResultSupplier.setViewportView(tblResultSupplier);

        lblResultSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultSupplier.setText("RESULTADOS DE LA BÚSQUEDA");

        btnModifySupplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModifySupplier.setText("Modificar Datos");
        btnModifySupplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModifySupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifySupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultSupplierLayout = new javax.swing.GroupLayout(pnlResultSupplier);
        pnlResultSupplier.setLayout(pnlResultSupplierLayout);
        pnlResultSupplierLayout.setHorizontalGroup(
            pnlResultSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addComponent(lblResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultSupplierLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModifySupplier)))
                .addContainerGap())
        );
        pnlResultSupplierLayout.setVerticalGroup(
            pnlResultSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModifySupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblSupplierSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSupplierSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplierSearch.setText("BUSCAR PROVEEDOR");

        javax.swing.GroupLayout pnlSupplierSearchLayout = new javax.swing.GroupLayout(pnlSupplierSearch);
        pnlSupplierSearch.setLayout(pnlSupplierSearchLayout);
        pnlSupplierSearchLayout.setHorizontalGroup(
            pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSupplierSearchLayout.createSequentialGroup()
                .addGroup(pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSupplierSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSupplierSearchLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlSupplierSearchLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(pnlSeekSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSupplierSearchLayout.setVerticalGroup(
            pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSeekSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSupplierSlave.add(pnlSupplierSearch, "pnlSupplierSearch");

        pnlLinkSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLinkSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLinkSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinkSupplier.setText("PROVEEDORES");

        scpLinkSupplier.setViewportView(lstLinkSupplier);

        txtLinkSupplier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLinkSupplier.setText("Ingrese nombre de Proveedor");
        txtLinkSupplier.setToolTipText("");

        btnLinkSupplierSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLinkSupplierSearch.setText("Buscar");
        btnLinkSupplierSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinkSupplierSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkSupplierSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLinkSupplierLayout = new javax.swing.GroupLayout(pnlLinkSupplier);
        pnlLinkSupplier.setLayout(pnlLinkSupplierLayout);
        pnlLinkSupplierLayout.setHorizontalGroup(
            pnlLinkSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLinkSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLinkSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLinkSupplierSearch)
                    .addComponent(txtLinkSupplier)
                    .addComponent(lblLinkSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(pnlLinkSupplierLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scpLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        pnlLinkSupplierLayout.setVerticalGroup(
            pnlLinkSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLinkSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLinkSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpLinkSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlLinkProducts.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLinkProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLinkProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinkProducts.setText("PRODUCTOS DISPONIBLES");

        tblLinkProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Producto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpLinkProducts.setViewportView(tblLinkProducts);

        btnLinkSupplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLinkSupplier.setText("Vincular");
        btnLinkSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinkSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkSupplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlLinkProductsLayout = new javax.swing.GroupLayout(pnlLinkProducts);
        pnlLinkProducts.setLayout(pnlLinkProductsLayout);
        pnlLinkProductsLayout.setHorizontalGroup(
            pnlLinkProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLinkProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLinkProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLinkProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpLinkProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLinkProductsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlLinkProductsLayout.setVerticalGroup(
            pnlLinkProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLinkProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinkProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpLinkProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblLinkSupplierTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLinkSupplierTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinkSupplierTitle.setText("VINCULAR PRODUCTOS DISTRIBUIDOS");

        javax.swing.GroupLayout pnlSupplierLinkLayout = new javax.swing.GroupLayout(pnlSupplierLink);
        pnlSupplierLink.setLayout(pnlSupplierLinkLayout);
        pnlSupplierLinkLayout.setHorizontalGroup(
            pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSupplierLinkLayout.createSequentialGroup()
                        .addComponent(pnlLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlLinkProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblLinkSupplierTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSupplierLinkLayout.setVerticalGroup(
            pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSupplierLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinkSupplierTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLinkSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlLinkProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(pnlSupplierSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
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
                .addContainerGap(364, Short.MAX_VALUE))
        );

        pnlProductSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlProductSlave.setLayout(new java.awt.CardLayout());

        lblNewProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNewProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewProduct.setText("REGISTRO DE NUEVO USUARIO");

        pnlNewProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtProductName.setToolTipText("");

        txtProductBrand.setToolTipText("");

        txtProductPresentation.setToolTipText("");
        txtProductPresentation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductPresentationActionPerformed(evt);
            }
        });

        txtProductStock.setToolTipText("");

        txtProductPrice.setToolTipText("");

        lbProductName.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lbProductName.setText("Nombre");

        lblProductBrand.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductBrand.setText("Marca");

        lblProductPresentation.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductPresentation.setText("Presentación");

        lblProductStock.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductStock.setText("Stock");

        lblProductPrice.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductPrice.setText("Precio");

        lblProductCategory.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductCategory.setText("Categoría");

        btnProductRegister.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProductRegister.setText("Registrar");
        btnProductRegister.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductRegisterActionPerformed(evt);
            }
        });

        lblUserMandatory1.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblUserMandatory1.setText("* Obligatorio");

        javax.swing.GroupLayout pnlNewProductLayout = new javax.swing.GroupLayout(pnlNewProduct);
        pnlNewProduct.setLayout(pnlNewProductLayout);
        pnlNewProductLayout.setHorizontalGroup(
            pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNewProductLayout.createSequentialGroup()
                        .addComponent(lblProductPresentation, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtProductPresentation))
                    .addGroup(pnlNewProductLayout.createSequentialGroup()
                        .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlNewProductLayout.createSequentialGroup()
                                .addComponent(lblProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxProductCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlNewProductLayout.createSequentialGroup()
                                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNewProductLayout.createSequentialGroup()
                                        .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblUserMandatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(btnProductRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlNewProductLayout.createSequentialGroup()
                                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNewProductLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductBrand))
                                    .addGroup(pnlNewProductLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductName)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        pnlNewProductLayout.setVerticalGroup(
            pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewProductLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductPresentation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductPresentation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductStock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserMandatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlProductAddLayout = new javax.swing.GroupLayout(pnlProductAdd);
        pnlProductAdd.setLayout(pnlProductAddLayout);
        pnlProductAddLayout.setHorizontalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlProductAddLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(pnlNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pnlProductAddLayout.setVerticalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlProductSlave.add(pnlProductAdd, "pnlProductAdd");

        lblProductShow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductShow.setText("PRODUCTOS REGISTRADOS");

        tblProductShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Presentación", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpProductShow.setViewportView(tblProductShow);

        javax.swing.GroupLayout pnlProductShowLayout = new javax.swing.GroupLayout(pnlProductShow);
        pnlProductShow.setLayout(pnlProductShowLayout);
        pnlProductShowLayout.setHorizontalGroup(
            pnlProductShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductShowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpProductShow, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlProductShowLayout.setVerticalGroup(
            pnlProductShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpProductShow, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
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
                .addComponent(pnlProductSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
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
                .addContainerGap(241, Short.MAX_VALUE))
        );

        pnlStoreSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlStoreSlave.setLayout(new java.awt.CardLayout());

        txtNameSearchProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchProduct.setText("Ingrese nombre de Producto");
        txtNameSearchProduct.setToolTipText("");
        txtNameSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameSearchProductMouseClicked(evt);
            }
        });
        txtNameSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameSearchProductActionPerformed(evt);
            }
        });

        btnSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchProduct.setText("Buscar");
        btnSearchProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSeekProductLayout = new javax.swing.GroupLayout(pnlSeekProduct);
        pnlSeekProduct.setLayout(pnlSeekProductLayout);
        pnlSeekProductLayout.setHorizontalGroup(
            pnlSeekProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekProductLayout.setVerticalGroup(
            pnlSeekProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblResultProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock", "Nombre del Producto", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpResultProduct.setViewportView(tblResultProduct);

        lblResultProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultProduct.setText("RESULTADOS DE LA BÚSQUEDA");

        btnModifyProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnModifyProduct.setText("Modificar Datos");
        btnModifyProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModifyProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultProductLayout = new javax.swing.GroupLayout(pnlResultProduct);
        pnlResultProduct.setLayout(pnlResultProductLayout);
        pnlResultProductLayout.setHorizontalGroup(
            pnlResultProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(lblResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultProductLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnModifyProduct)))
                .addContainerGap())
        );
        pnlResultProductLayout.setVerticalGroup(
            pnlResultProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModifyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblProductSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductSearch.setText("BUSCAR PRODUCTO");

        javax.swing.GroupLayout pnlStoreSearchProLayout = new javax.swing.GroupLayout(pnlStoreSearchPro);
        pnlStoreSearchPro.setLayout(pnlStoreSearchProLayout);
        pnlStoreSearchProLayout.setHorizontalGroup(
            pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStoreSearchProLayout.createSequentialGroup()
                .addGroup(pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblProductSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlStoreSearchProLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlStoreSearchProLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(pnlSeekProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStoreSearchProLayout.setVerticalGroup(
            pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSearchProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSeekProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreSearchPro, "pnlStoreSearchPro");

        txtNameSearchTicket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchTicket.setText("Ingrese número de la Boleta");
        txtNameSearchTicket.setToolTipText("");
        txtNameSearchTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameSearchTicketActionPerformed(evt);
            }
        });

        btnSearchTicket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchTicket.setText("Buscar");
        btnSearchTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSeekTicketLayout = new javax.swing.GroupLayout(pnlSeekTicket);
        pnlSeekTicket.setLayout(pnlSeekTicketLayout);
        pnlSeekTicketLayout.setHorizontalGroup(
            pnlSeekTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNameSearchTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekTicketLayout.setVerticalGroup(
            pnlSeekTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultTicket.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblResultTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Ganancia", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scpResultTicket.setViewportView(tblResultTicket);

        lblResultTicket.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultTicket.setText("RESULTADOS DE LA BÚSQUEDA");

        btnSeeTicket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSeeTicket.setText("Visualizar Boleta");
        btnSeeTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeeTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlResultTicketLayout = new javax.swing.GroupLayout(pnlResultTicket);
        pnlResultTicket.setLayout(pnlResultTicketLayout);
        pnlResultTicketLayout.setHorizontalGroup(
            pnlResultTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(lblResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResultTicketLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSeeTicket)))
                .addContainerGap())
        );
        pnlResultTicketLayout.setVerticalGroup(
            pnlResultTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblResultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeeTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblTicketSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTicketSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTicketSearch.setText("BUSCAR BOLETA DE VENTA");

        javax.swing.GroupLayout pnlStoreSearchTicLayout = new javax.swing.GroupLayout(pnlStoreSearchTic);
        pnlStoreSearchTic.setLayout(pnlStoreSearchTicLayout);
        pnlStoreSearchTicLayout.setHorizontalGroup(
            pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStoreSearchTicLayout.createSequentialGroup()
                .addGroup(pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTicketSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlStoreSearchTicLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlStoreSearchTicLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(pnlSeekTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStoreSearchTicLayout.setVerticalGroup(
            pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSearchTicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTicketSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSeekTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreSearchTic, "pnlStoreSearchTic");

        lblProductShowStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductShowStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductShowStore.setText("PRODUCTOS REGISTRADOS");

        tblProductShowStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Marca", "Presentación", "Categoría", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpProductShowStore.setViewportView(tblProductShowStore);

        cbxSaleSearchProductStore.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Marca", "Categoría" }));
        cbxSaleSearchProductStore.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxSaleSearchProductStoreItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlStoreInventLayout = new javax.swing.GroupLayout(pnlStoreInvent);
        pnlStoreInvent.setLayout(pnlStoreInventLayout);
        pnlStoreInventLayout.setHorizontalGroup(
            pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreInventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStoreInventLayout.createSequentialGroup()
                        .addComponent(lblProductShowStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxSaleSearchProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scpProductShowStore, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlStoreInventLayout.setVerticalGroup(
            pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreInventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblProductShowStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSaleSearchProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpProductShowStore, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreInvent, "pnlStoreInvent");

        lblProductStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProductStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductStore.setText("REGISTRO DE NUEVO USUARIO");

        pnlProductStore.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtProductNameStore.setToolTipText("");

        txtProductBrandStore.setToolTipText("");

        txtProductPresentationStore.setToolTipText("");

        txtProductStockStore.setToolTipText("");

        txtProductPriceStore.setToolTipText("");

        lbProductNameStore.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lbProductNameStore.setText("Nombre");

        lblProductBrandStore.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductBrandStore.setText("Marca");

        lblProductPresentationStore.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductPresentationStore.setText("Presentación");

        lblProductStockStore.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductStockStore.setText("Stock");

        lblProductPriceStore.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductPriceStore.setText("Precio");

        lblProductCategoryStore.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblProductCategoryStore.setText("Categoría");

        btnProductUpdateStore.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProductUpdateStore.setText("Actualizar");
        btnProductUpdateStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductUpdateStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductUpdateStoreActionPerformed(evt);
            }
        });

        lblUserMandatoryStore.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblUserMandatoryStore.setText("* Obligatorio");

        javax.swing.GroupLayout pnlProductStoreLayout = new javax.swing.GroupLayout(pnlProductStore);
        pnlProductStore.setLayout(pnlProductStoreLayout);
        pnlProductStoreLayout.setHorizontalGroup(
            pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProductStoreLayout.createSequentialGroup()
                        .addComponent(lblProductPresentationStore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtProductPresentationStore))
                    .addGroup(pnlProductStoreLayout.createSequentialGroup()
                        .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                .addComponent(lblProductStockStore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtProductStockStore, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblProductCategoryStore, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxProductCategoryStore, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                        .addComponent(lblProductPriceStore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductPriceStore, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblUserMandatoryStore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(btnProductUpdateStore, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbProductNameStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProductBrandStore, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductBrandStore))
                                    .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductNameStore)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        pnlProductStoreLayout.setVerticalGroup(
            pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductStoreLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbProductNameStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductNameStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductBrandStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductBrandStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductPresentationStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductPresentationStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductStockStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductStockStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProductCategoryStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductCategoryStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductPriceStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductPriceStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserMandatoryStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductUpdateStore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlStoreModifyProLayout = new javax.swing.GroupLayout(pnlStoreModifyPro);
        pnlStoreModifyPro.setLayout(pnlStoreModifyProLayout);
        pnlStoreModifyProLayout.setHorizontalGroup(
            pnlStoreModifyProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreModifyProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlStoreModifyProLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(pnlProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        pnlStoreModifyProLayout.setVerticalGroup(
            pnlStoreModifyProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreModifyProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProductStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreModifyPro, "pnlStoreModifyPro");

        lblSaleReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleReport.setText("PRODUCTOS REGISTRADOS");

        clrStart.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                clrStartPropertyChange(evt);
            }
        });

        lblSateReportStart.setText("Seleccione fecha de Inicio:");

        lblSateReportEnd.setText("Seleccione fecha de Fin:");

        clrEnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                clrEndPropertyChange(evt);
            }
        });

        lblSelectDateStart.setText("Fecha Seleccionada:");

        lblSelectDateEnd.setText("Fecha Seleccionada:");

        lblSelectDateStartReport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSelectDateStartReport.setText("Fecha Seleccionada:");

        lblSelectDateEndReport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSelectDateEndReport.setText("Fecha Seleccionada:");

        javax.swing.GroupLayout pnlContentSaleReportLayout = new javax.swing.GroupLayout(pnlContentSaleReport);
        pnlContentSaleReport.setLayout(pnlContentSaleReportLayout);
        pnlContentSaleReportLayout.setHorizontalGroup(
            pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(clrStart, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                .addComponent(lblSelectDateStart)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSelectDateStartReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSateReportStart)
                                    .addComponent(lblSateReportEnd))
                                .addGap(100, 100, 100))
                            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(clrEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblSelectDateEndReport, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                        .addComponent(lblSelectDateEnd)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        pnlContentSaleReportLayout.setVerticalGroup(
            pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentSaleReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSateReportStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clrStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addComponent(lblSelectDateStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSelectDateStartReport)))
                .addGap(13, 13, 13)
                .addComponent(lblSateReportEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clrEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addComponent(lblSelectDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSelectDateEndReport, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStoreSaleReportLayout = new javax.swing.GroupLayout(pnlStoreSaleReport);
        pnlStoreSaleReport.setLayout(pnlStoreSaleReportLayout);
        pnlStoreSaleReportLayout.setHorizontalGroup(
            pnlStoreSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSaleReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContentSaleReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaleReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStoreSaleReportLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlStoreSaleReportLayout.setVerticalGroup(
            pnlStoreSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSaleReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaleReport, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlContentSaleReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlStoreSlave.add(pnlStoreSaleReport, "pnlStoreSaleReport");

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

        lblSale.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSale.setText("VENTA DE PRODUCTOS");

        pnlSaleOrder.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSaleOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleOrder.setText("ORDEN DE VENTA");

        lblSaleOrderNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleOrderNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleOrderNumber.setText("XXXXXXXXX");

        lblSaleOrderClient.setText("Cliente");

        lblSaleOrderDate.setText("Fecha:");

        lblSaleOrderDateOn.setText("xxxxxxxxxxxxxxxxx");

        tblSaleOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cant.", "Nombre", "Precio Uni.", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSaleOrderTable.getTableHeader().setReorderingAllowed(false);
        tblSaleOrderTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tblSaleOrderTablePropertyChange(evt);
            }
        });
        scpSaleOrderTable.setViewportView(tblSaleOrderTable);

        btnSaleOrderDelete.setText("Eliminar");
        btnSaleOrderDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleOrderDeleteActionPerformed(evt);
            }
        });

        lblSaleOrderTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleOrderTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleOrderTotal.setText("Total");

        lblSaleOrderTotalOn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleOrderTotalOn.setForeground(new java.awt.Color(255, 0, 0));
        lblSaleOrderTotalOn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleOrderTotalOn.setText("Total");

        btnSaleOrderPrint.setText("Imprimir Comprobante");
        btnSaleOrderPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleOrderPrintActionPerformed(evt);
            }
        });

        lblUserOnSale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUserOnSale.setText("xxxxxxxxxxxxxxxxx");

        javax.swing.GroupLayout pnlSaleOrderLayout = new javax.swing.GroupLayout(pnlSaleOrder);
        pnlSaleOrder.setLayout(pnlSaleOrderLayout);
        pnlSaleOrderLayout.setHorizontalGroup(
            pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpSaleOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                        .addComponent(btnSaleOrderDelete)
                        .addGap(155, 155, 155)
                        .addComponent(lblSaleOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSaleOrderTotalOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSaleOrderLayout.createSequentialGroup()
                        .addComponent(lblUserOnSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSaleOrderPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                        .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                                .addComponent(lblSaleOrderClient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSaleOrderClient, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSaleOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSaleOrderDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSaleOrderDateOn, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSaleOrderNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        pnlSaleOrderLayout.setVerticalGroup(
            pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleOrderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaleOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaleOrderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSaleOrderClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaleOrderClient)
                    .addComponent(lblSaleOrderDate)
                    .addComponent(lblSaleOrderDateOn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpSaleOrderTable, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSaleOrderTotalOn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaleOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaleOrderDelete))
                .addGap(18, 18, 18)
                .addGroup(pnlSaleOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblUserOnSale)
                    .addComponent(btnSaleOrderPrint))
                .addContainerGap())
        );

        pnlSaleSearchProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblSaleSearchProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleSearchProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleSearchProduct.setText("BUSCAR PRODUCTO");

        cbxSaleSearchProduct.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Marca", "Categoría" }));

        btnSaleSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleSearchProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSaleSearchProductOnLayout = new javax.swing.GroupLayout(pnlSaleSearchProductOn);
        pnlSaleSearchProductOn.setLayout(pnlSaleSearchProductOnLayout);
        pnlSaleSearchProductOnLayout.setHorizontalGroup(
            pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleSearchProductOnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSaleSearchProductOnLayout.createSequentialGroup()
                        .addGroup(pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cbxSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSaleSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSaleSearchProductOnLayout.createSequentialGroup()
                        .addComponent(txtSaleSearchProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        pnlSaleSearchProductOnLayout.setVerticalGroup(
            pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleSearchProductOnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSaleSearchProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSaleSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSaleSearchProductMouseClicked(evt);
            }
        });
        scpSaleSearchProduct.setViewportView(tblSaleSearchProduct);

        javax.swing.GroupLayout pnlSaleSearchProductLayout = new javax.swing.GroupLayout(pnlSaleSearchProduct);
        pnlSaleSearchProduct.setLayout(pnlSaleSearchProductLayout);
        pnlSaleSearchProductLayout.setHorizontalGroup(
            pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleSearchProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scpSaleSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSaleSearchProductLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlSaleSearchProductOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pnlSaleSearchProductLayout.setVerticalGroup(
            pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSaleSearchProductLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(scpSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlSaleSearchProductLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlSaleSearchProductOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(330, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlSaleLayout = new javax.swing.GroupLayout(pnlSale);
        pnlSale.setLayout(pnlSaleLayout);
        pnlSaleLayout.setHorizontalGroup(
            pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSaleLayout.createSequentialGroup()
                        .addComponent(lblSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(pnlSaleLayout.createSequentialGroup()
                        .addComponent(pnlSaleSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlSaleOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlSaleLayout.setVerticalGroup(
            pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSaleOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSaleSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlSale, "pnlSale");

        lblWelcome.setForeground(new java.awt.Color(0, 0, 204));

        lblLogOut.setForeground(new java.awt.Color(255, 0, 0));
        lblLogOut.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogOut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
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
        suppliers.changeSupplierShow((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, tblSupplierShow);
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProductsActionPerformed
    {//GEN-HEADEREND:event_btnProductsActionPerformed
        interfaz.changeProducts((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(3, menuBtn);
        products.changeProductShow((CardLayout)pnlProductSlave.getLayout(), pnlProductSlave, tblProductShow);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnStoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStoreActionPerformed
    {//GEN-HEADEREND:event_btnStoreActionPerformed
        interfaz.changeStore((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(4, menuBtn);
        store.changeInventStore((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave, tblProductShowStore);
    }//GEN-LAST:event_btnStoreActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaleActionPerformed
    {//GEN-HEADEREND:event_btnSaleActionPerformed
        interfaz.changeSale((CardLayout)pnlContent.getLayout(), pnlContent);
        interfaz.paint(5, menuBtn);
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        this.lblSaleOrderDateOn.setText(format.format(date));
        this.interfaz.setOrderNumber(lblSaleOrderNumber);
        this.lblUserOnSale.setText("Usuario: " + user.getName() + " " + user.getFatherLastName());
    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed

    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnSaleOrderDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleOrderDeleteActionPerformed
        int row = 0;
        if((row = tblSaleOrderTable.getSelectedRow()) != -1){
            total -= Double.parseDouble(String.valueOf(tblSaleOrderTable.getValueAt(row, 4)));
            DefaultTableModel model = (DefaultTableModel) tblSaleOrderTable.getModel();
            model.removeRow(row);
            DecimalFormat format = new DecimalFormat("#.##");
            this.lblSaleOrderTotalOn.setText("S/. " + format.format(total));
        }
        else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro de la Orden de Venta",
                                            "Dato no Seleccionado",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSaleOrderDeleteActionPerformed

    private void btnStoreInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreInventActionPerformed
        store.changeInventStore((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave, tblProductShowStore);
    }//GEN-LAST:event_btnStoreInventActionPerformed

    private void btnStoreReportSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreReportSaleActionPerformed
        store.changeReportSale((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave);
    }//GEN-LAST:event_btnStoreReportSaleActionPerformed

    private void btnStoreSearchProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreSearchProActionPerformed
        //clean(1);
        store.changeProductSearch((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave);
        //userCode = "";
    }//GEN-LAST:event_btnStoreSearchProActionPerformed

    private void btnStoreSearchTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreSearchTicActionPerformed
        store.changeTicketSearch((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave);
    }//GEN-LAST:event_btnStoreSearchTicActionPerformed

    private void btnStoreReportProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreReportProdActionPerformed
        if(store.productReport(user))
                JOptionPane.showMessageDialog(  null,
                                            "El Reporte se ha generado correctamente. Se encuentra en la dirección consignada al crearlo",
                                            "Reporte Generado",
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null,
                                            "Hubieron problemas al generar el resporte. Revise los datos y vuelva a generarlo",
                                            "Reporte No Generado",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnStoreReportProdActionPerformed

    private void btnProductRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductRegisterActionPerformed
        products.actProduct(txtProductName, txtProductBrand, txtProductPresentation, txtProductPrice, txtProductStock, cbxProductCategory);
        products.changeProductShow((CardLayout)pnlProductSlave.getLayout(), pnlProductSlave, tblProductShow);
    }//GEN-LAST:event_btnProductRegisterActionPerformed

    private void txtProductPresentationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductPresentationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductPresentationActionPerformed

    private void btnProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductAddActionPerformed
        clean(3);
        products.changeProductAdd((CardLayout)pnlProductSlave.getLayout(), pnlProductSlave, cbxProductCategory, lblNewProduct, btnProductRegister);
    }//GEN-LAST:event_btnProductAddActionPerformed

    private void btnProductShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductShowActionPerformed
        clean(3);
        products.changeProductShow((CardLayout)pnlProductSlave.getLayout(), pnlProductSlave, tblProductShow);
    }//GEN-LAST:event_btnProductShowActionPerformed

    private void btnLinkSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkSupplierActionPerformed
        int supplierSelected = 0;
        boolean []productsSelected = new boolean[tblLinkProducts.getRowCount()];

        if((supplierSelected = lstLinkSupplier.getSelectedIndex()) != -1)
        {
            for(int i = 0;i < tblLinkProducts.getRowCount();i++)
            productsSelected[i] = (Boolean) tblLinkProducts.getValueAt(i, 0);

            if(productsSelected.length != 0){
                suppliers.link(productsSelected, productsInd, suppliersInd.get(supplierSelected));
                suppliers.changeSupplierShow((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, tblSupplierShow);
            }
            else
            JOptionPane.showMessageDialog(  null,
                "No ha seleccionado ningún registro de productos.",
                "Dato no Seleccionado",
                JOptionPane.WARNING_MESSAGE);
        }
        else
        JOptionPane.showMessageDialog(  null,
            "No ha seleccionado ningún registro de proveedores.",
            "Dato no Seleccionado",
            JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnLinkSupplierActionPerformed

    private void btnLinkSupplierSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkSupplierSearchActionPerformed
        suppliersInd = suppliers.searchSupplierLink(txtLinkSupplier, lstLinkSupplier);
    }//GEN-LAST:event_btnLinkSupplierSearchActionPerformed

    private void btnModifySupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifySupplierActionPerformed
        int value = 0;
        if((value = tblResultSupplier.getSelectedRow()) != -1){
            clean(2);
            supplierCode = suppliers.sent((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, suppliersSearch.get(value), lblNewSupplier, txtSupplierName, txtSupplierTr, txtSupplierPhone, txtSupplierAddress, btnSupplierRegister);
        } else
        JOptionPane.showMessageDialog(  null,
                                        "No ha seleccionado ningún registro.",
                                        "Dato no Seleccionado",
                                        JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifySupplierActionPerformed

    private void btnSearchSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSupplierActionPerformed
        ((DefaultTableModel) tblResultSupplier.getModel()).getDataVector().clear();
        suppliersSearch = suppliers.searchSupplier(txtNameSearchSupplier, tblResultSupplier);
    }//GEN-LAST:event_btnSearchSupplierActionPerformed

    private void btnSupplierRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierRegisterActionPerformed
        suppliers.actSupplier(state, supplierCode, txtSupplierName, txtSupplierTr, txtSupplierPhone, txtSupplierAddress);
        suppliers.changeSupplierShow((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, tblSupplierShow);
    }//GEN-LAST:event_btnSupplierRegisterActionPerformed

    private void txtSupplierAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierAddressActionPerformed

    private void btnSupplierLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierLinkActionPerformed
        clean(2);
        productsInd = suppliers.changeSupplierLink((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, tblLinkProducts);
    }//GEN-LAST:event_btnSupplierLinkActionPerformed

    private void btnSupplierAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierAddActionPerformed
        clean(2);
        suppliers.changeSupplierAdd((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, lblNewSupplier, btnSupplierRegister);
        state = 0;
    }//GEN-LAST:event_btnSupplierAddActionPerformed

    private void btnSupplierSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierSearchActionPerformed
        clean(2);
        suppliers.changeSupplierSearch((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave);
        state = 1;
        supplierCode = "";
    }//GEN-LAST:event_btnSupplierSearchActionPerformed

    private void btnSupplierShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierShowActionPerformed
        clean(2);
        suppliers.changeSupplierShow((CardLayout)pnlSupplierSlave.getLayout(), pnlSupplierSlave, tblSupplierShow);
    }//GEN-LAST:event_btnSupplierShowActionPerformed

    private void btnModifyUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyUserActionPerformed
        int value = 0;
        if((value = tblResultUser.getSelectedRow()) != -1){
            clean(2);
            userCode = users.sent((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, usersSearch.get(value), lblNewSupplier, txtUserName, txtUserFatherLastName, txtUserMotherLastName, txtUserNi, cbxUserGender, txtUserAddress, cbxUserPosition, txtUserCellphone, txtUserEmail, txtUserEmergencyNumber, txaUserOthers, btnUserRegister);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifyUserActionPerformed

    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        clean(1);
        usersSearch = users.searchUser(txtNameSearchUser, tblResultUser);
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void btnUserRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserRegisterActionPerformed
        users.actUser(state, userCode, txtUserName, txtUserFatherLastName, txtUserMotherLastName, txtUserNi, cbxUserGender, txtUserAddress, cbxUserPosition, txtUserCellphone, txtUserEmail, txtUserEmergencyNumber, txaUserOthers);
        users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
    }//GEN-LAST:event_btnUserRegisterActionPerformed

    private void txtUserMotherLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserMotherLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserMotherLastNameActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        clean(1);
        users.changeUserAdd((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave,cbxUserGender, cbxUserPosition, lblNewUser, btnUserRegister);
        state = 0;
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnUserSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSearchActionPerformed
        clean(1);
        users.changeUserSearch((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave);
        state = 1;
        userCode = "";
    }//GEN-LAST:event_btnUserSearchActionPerformed

    private void btnUserShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserShowActionPerformed
        clean(1);
        users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
    }//GEN-LAST:event_btnUserShowActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed

    }//GEN-LAST:event_txtPassActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        if((user = home.logIn(txtId, txtPass)) != null)
        {
            clean(1);
            this.lblWelcome.setText("Bienvenid@ " + user.getName());
            this.lblLogOut.setText("Cerrar Sesión");
            home.activate(Integer.parseInt(user.getPositionCode()), btnHome, btnUsers, btnSuppliers, btnProducts, btnStore, btnSale);
            
            switch(Integer.parseInt(user.getPositionCode())){
                case 1: interfaz.changeUsers((CardLayout)pnlContent.getLayout(), pnlContent);
                        interfaz.paint(1, menuBtn);
                        users.changeUserShow((CardLayout)pnlUserSlave.getLayout(), pnlUserSlave, tblUserShow);
                        break;
                    
                case 2: interfaz.changeSale((CardLayout)pnlContent.getLayout(), pnlContent);
                        interfaz.paint(5, menuBtn);
                        Date date = new Date();
                        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                        this.lblSaleOrderDateOn.setText(format.format(date));
                        this.interfaz.setOrderNumber(lblSaleOrderNumber);
                        this.lblUserOnSale.setText("Usuario: " + user.getName() + " " + user.getFatherLastName());
                        break;
            }
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        this.interfaz.logOut();
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblForgottenPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgottenPassMouseClicked
        this.interfaz.forgottenPass(txtId);
    }//GEN-LAST:event_lblForgottenPassMouseClicked

    private void btnSaleSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleSearchProductActionPerformed
        productsList = this.sale.search(cbxSaleSearchProduct, txtSaleSearchProduct, tblSaleSearchProduct);
    }//GEN-LAST:event_btnSaleSearchProductActionPerformed

    private void tblSaleSearchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSaleSearchProductMouseClicked
        total = this.sale.addProduct(tblSaleOrderTable, tblSaleSearchProduct.getSelectedRow(), productsList, total);
        DecimalFormat format = new DecimalFormat("#.##");
        this.lblSaleOrderTotalOn.setText("S/. " + format.format(total));
    }//GEN-LAST:event_tblSaleSearchProductMouseClicked

    private void tblSaleOrderTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblSaleOrderTablePropertyChange
        int row = 0;
        if((row = tblSaleOrderTable.getSelectedRow()) != -1){
            total -= Double.parseDouble(String.valueOf(this.tblSaleOrderTable.getValueAt(row, 4)));
            
            if(!this.sale.verifyQuantity(String.valueOf(this.tblSaleOrderTable.getValueAt(row, 0)), String.valueOf(this.tblSaleOrderTable.getValueAt(row, 1)))){
                this.tblSaleOrderTable.setValueAt("1" , row, 1);
                JOptionPane.showMessageDialog(  null,
                                                "El stock del producto es menor al solicitado.",
                                                "Cantidad Incorrecta",
                                                JOptionPane.WARNING_MESSAGE);
            }
            
            int cant = Integer.parseInt(String.valueOf(this.tblSaleOrderTable.getValueAt(row, 1)));
            double price = Double.parseDouble(String.valueOf(this.tblSaleOrderTable.getValueAt(row, 3)));
            this.tblSaleOrderTable.setValueAt(cant*price, row, 4);
            total += cant*price;
            DecimalFormat format = new DecimalFormat("#.##");
            this.lblSaleOrderTotalOn.setText("S/. " + format.format(total));
        }
    }//GEN-LAST:event_tblSaleOrderTablePropertyChange

    private void btnSaleOrderPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleOrderPrintActionPerformed
        if(this.tblSaleOrderTable.getRowCount() != 0){
            btnSaleOrderDelete.setVisible(false);
            
            try {
                BufferedImage imagen = new BufferedImage(pnlSaleOrder.getWidth(), pnlSaleOrder.getHeight(), BufferedImage.TYPE_INT_ARGB);
                pnlSaleOrder.paint(imagen.getGraphics());
                ImageIO.write(imagen, "png", new File("Boletas/"+lblSaleOrderNumber.getText()+".png"));
            } catch (IOException ex) {
                Logger.getLogger(UIMain.class.getName()).log(Level.SEVERE, null, ex);
            }         
            
            btnSaleOrderDelete.setVisible(true);
            this.sale.safeSale(user, txtSaleOrderClient, lblSaleOrderTotalOn, lblSaleOrderDateOn, tblSaleOrderTable);
            clean(5);
            this.interfaz.setOrderNumber(lblSaleOrderNumber);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No se ha ingresado algún registro a la Orden de Venta",
                                            "Datos No Ingresados",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSaleOrderPrintActionPerformed

    private void btnProductUpdateStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductUpdateStoreActionPerformed
        store.actProduct(productCode, txtProductNameStore, txtProductBrandStore, txtProductPresentationStore, txtProductStockStore, cbxProductCategoryStore, txtProductPriceStore);
        store.changeInventStore((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave, tblProductShowStore);
    }//GEN-LAST:event_btnProductUpdateStoreActionPerformed

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        //Clean
        productsSearch = store.searchProduct(txtNameSearchProduct, tblResultProduct);
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnModifyProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyProductActionPerformed
        int value = 0;
        if((value = tblResultProduct.getSelectedRow()) != -1){
            //clean(2);
            store.changeModify((CardLayout)pnlStoreSlave.getLayout(), pnlStoreSlave);
            productCode = store.sendProduct(productsSearch.get(value), txtProductNameStore, txtProductBrandStore, txtProductPresentationStore, txtProductStockStore, cbxProductCategoryStore, txtProductPriceStore);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifyProductActionPerformed

    private void btnSearchTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTicketActionPerformed
        //Clean
        ticketsSearch = store.searchTicket(txtNameSearchTicket, tblResultTicket);
    }//GEN-LAST:event_btnSearchTicketActionPerformed

    private void btnSeeTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeTicketActionPerformed
        int row = 0;
        if((row = tblResultTicket.getSelectedRow()) != -1){
            CTicket ticket = new CTicket(ticketsSearch.get(row));
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnSeeTicketActionPerformed

    private void cbxSaleSearchProductStoreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSaleSearchProductStoreItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
             store.chargeProduct(tblProductShowStore, cbxSaleSearchProductStore);
         }
    }//GEN-LAST:event_cbxSaleSearchProductStoreItemStateChanged

    private void clrStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clrStartPropertyChange
        SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
        lblSelectDateStartReport.setText(format.format(clrStart.getCalendar().getTime()));
    }//GEN-LAST:event_clrStartPropertyChange

    private void clrEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clrEndPropertyChange
        SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
        lblSelectDateEndReport.setText(format.format(clrEnd.getCalendar().getTime()));
    }//GEN-LAST:event_clrEndPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(store.saleReport(user,  clrStart, clrEnd))
            JOptionPane.showMessageDialog(  null,
                                            "El Reporte se ha generado correctamente. Se encuentra en la dirección consignada al crearlo",
                                            "Reporte Generado",
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null,
                                            "Hubieron problemas al generar el resporte. Revise los datos y vuelva a generarlo",
                                            "Reporte No Generado",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNameSearchTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameSearchTicketActionPerformed
        this.txtNameSearchTicket.setText("");
    }//GEN-LAST:event_txtNameSearchTicketActionPerformed

    private void txtNameSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameSearchProductActionPerformed
        
    }//GEN-LAST:event_txtNameSearchProductActionPerformed

    private void txtNameSearchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameSearchProductMouseClicked
        this.txtNameSearchProduct.setText("");
    }//GEN-LAST:event_txtNameSearchProductMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLinkSupplier;
    private javax.swing.JButton btnLinkSupplierSearch;
    private javax.swing.JButton btnLogIn;
    private javax.swing.JButton btnModifyProduct;
    private javax.swing.JButton btnModifySupplier;
    private javax.swing.JButton btnModifyUser;
    private javax.swing.JButton btnProductAdd;
    private javax.swing.JButton btnProductRegister;
    private javax.swing.JButton btnProductShow;
    private javax.swing.JButton btnProductUpdateStore;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnSale;
    private javax.swing.JButton btnSaleOrderDelete;
    private javax.swing.JButton btnSaleOrderPrint;
    private javax.swing.JButton btnSaleSearchProduct;
    private javax.swing.JButton btnSearchProduct;
    private javax.swing.JButton btnSearchSupplier;
    private javax.swing.JButton btnSearchTicket;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JButton btnSeeTicket;
    private javax.swing.JButton btnStore;
    private javax.swing.JButton btnStoreInvent;
    private javax.swing.JButton btnStoreReportProd;
    private javax.swing.JButton btnStoreReportSale;
    private javax.swing.JButton btnStoreSearchPro;
    private javax.swing.JButton btnStoreSearchTic;
    private javax.swing.JButton btnSupplierAdd;
    private javax.swing.JButton btnSupplierLink;
    private javax.swing.JButton btnSupplierRegister;
    private javax.swing.JButton btnSupplierSearch;
    private javax.swing.JButton btnSupplierShow;
    private javax.swing.JButton btnSuppliers;
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JButton btnUserRegister;
    private javax.swing.JButton btnUserSearch;
    private javax.swing.JButton btnUserShow;
    private javax.swing.JButton btnUsers;
    private javax.swing.JComboBox cbxProductCategory;
    private javax.swing.JComboBox cbxProductCategoryStore;
    private javax.swing.JComboBox cbxSaleSearchProduct;
    private javax.swing.JComboBox cbxSaleSearchProductStore;
    private javax.swing.JComboBox cbxUserGender;
    private javax.swing.JComboBox cbxUserPosition;
    private com.toedter.calendar.JCalendar clrEnd;
    private com.toedter.calendar.JCalendar clrStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JLabel lbProductNameStore;
    private javax.swing.JLabel lblForgottenPass;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImgLog;
    private javax.swing.JLabel lblLinkProducts;
    private javax.swing.JLabel lblLinkSupplier;
    private javax.swing.JLabel lblLinkSupplierTitle;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblNewProduct;
    private javax.swing.JLabel lblNewSupplier;
    private javax.swing.JLabel lblNewUser;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblProduct;
    private javax.swing.JLabel lblProductBrand;
    private javax.swing.JLabel lblProductBrandStore;
    private javax.swing.JLabel lblProductCategory;
    private javax.swing.JLabel lblProductCategoryStore;
    private javax.swing.JLabel lblProductPresentation;
    private javax.swing.JLabel lblProductPresentationStore;
    private javax.swing.JLabel lblProductPrice;
    private javax.swing.JLabel lblProductPriceStore;
    private javax.swing.JLabel lblProductSearch;
    private javax.swing.JLabel lblProductShow;
    private javax.swing.JLabel lblProductShowStore;
    private javax.swing.JLabel lblProductStock;
    private javax.swing.JLabel lblProductStockStore;
    private javax.swing.JLabel lblProductStore;
    private javax.swing.JLabel lblResultProduct;
    private javax.swing.JLabel lblResultSupplier;
    private javax.swing.JLabel lblResultTicket;
    private javax.swing.JLabel lblResultUser;
    private javax.swing.JLabel lblSale;
    private javax.swing.JLabel lblSaleOrder;
    private javax.swing.JLabel lblSaleOrderClient;
    private javax.swing.JLabel lblSaleOrderDate;
    private javax.swing.JLabel lblSaleOrderDateOn;
    private javax.swing.JLabel lblSaleOrderNumber;
    private javax.swing.JLabel lblSaleOrderTotal;
    private javax.swing.JLabel lblSaleOrderTotalOn;
    private javax.swing.JLabel lblSaleReport;
    private javax.swing.JLabel lblSaleSearchProduct;
    private javax.swing.JLabel lblSateReportEnd;
    private javax.swing.JLabel lblSateReportStart;
    private javax.swing.JLabel lblSelectDateEnd;
    private javax.swing.JLabel lblSelectDateEndReport;
    private javax.swing.JLabel lblSelectDateStart;
    private javax.swing.JLabel lblSelectDateStartReport;
    private javax.swing.JLabel lblStore;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblSupplierAddress;
    private javax.swing.JLabel lblSupplierMandatory;
    private javax.swing.JLabel lblSupplierName;
    private javax.swing.JLabel lblSupplierPhone;
    private javax.swing.JLabel lblSupplierSearch;
    private javax.swing.JLabel lblSupplierShow;
    private javax.swing.JLabel lblSupplierTr;
    private javax.swing.JLabel lblTicketSearch;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserAdress;
    private javax.swing.JLabel lblUserCellphone;
    private javax.swing.JLabel lblUserEmail;
    private javax.swing.JLabel lblUserEmergencyNumber;
    private javax.swing.JLabel lblUserFatherLastName;
    private javax.swing.JLabel lblUserGender;
    private javax.swing.JLabel lblUserMandatory;
    private javax.swing.JLabel lblUserMandatory1;
    private javax.swing.JLabel lblUserMandatoryStore;
    private javax.swing.JLabel lblUserMotherLastName;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNi;
    private javax.swing.JLabel lblUserOnSale;
    private javax.swing.JLabel lblUserOther;
    private javax.swing.JLabel lblUserPosition;
    private javax.swing.JLabel lblUserSearch;
    private javax.swing.JLabel lblUserShow;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList lstLinkSupplier;
    private javax.swing.JPanel pnlAccess;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlContentSaleReport;
    private javax.swing.JPanel pnlDataAccess;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLinkProducts;
    private javax.swing.JPanel pnlLinkSupplier;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlNewProduct;
    private javax.swing.JPanel pnlNewSupplier;
    private javax.swing.JPanel pnlNewUser;
    private javax.swing.JPanel pnlProductAdd;
    private javax.swing.JPanel pnlProductMaster;
    private javax.swing.JPanel pnlProductShow;
    private javax.swing.JPanel pnlProductSlave;
    private javax.swing.JPanel pnlProductStore;
    private javax.swing.JPanel pnlProducts;
    private javax.swing.JPanel pnlResultProduct;
    private javax.swing.JPanel pnlResultSupplier;
    private javax.swing.JPanel pnlResultTicket;
    private javax.swing.JPanel pnlResultUser;
    private javax.swing.JPanel pnlSale;
    private javax.swing.JPanel pnlSaleOrder;
    private javax.swing.JPanel pnlSaleSearchProduct;
    private javax.swing.JPanel pnlSaleSearchProductOn;
    private javax.swing.JPanel pnlSeekProduct;
    private javax.swing.JPanel pnlSeekSupplier;
    private javax.swing.JPanel pnlSeekTicket;
    private javax.swing.JPanel pnlSeekUser;
    private javax.swing.JPanel pnlStore;
    private javax.swing.JPanel pnlStoreInvent;
    private javax.swing.JPanel pnlStoreMaster;
    private javax.swing.JPanel pnlStoreModifyPro;
    private javax.swing.JPanel pnlStoreSaleReport;
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
    private javax.swing.JScrollPane scpLinkProducts;
    private javax.swing.JScrollPane scpLinkSupplier;
    private javax.swing.JScrollPane scpProductShow;
    private javax.swing.JScrollPane scpProductShowStore;
    private javax.swing.JScrollPane scpResultProduct;
    private javax.swing.JScrollPane scpResultSupplier;
    private javax.swing.JScrollPane scpResultTicket;
    private javax.swing.JScrollPane scpResultUser;
    private javax.swing.JScrollPane scpSaleOrderTable;
    private javax.swing.JScrollPane scpSaleSearchProduct;
    private javax.swing.JScrollPane scpSupplierShow;
    private javax.swing.JScrollPane scpUserOther;
    private javax.swing.JScrollPane scpUserShow;
    private javax.swing.JTable tblLinkProducts;
    private javax.swing.JTable tblProductShow;
    private javax.swing.JTable tblProductShowStore;
    private javax.swing.JTable tblResultProduct;
    private javax.swing.JTable tblResultSupplier;
    private javax.swing.JTable tblResultTicket;
    private javax.swing.JTable tblResultUser;
    private javax.swing.JTable tblSaleOrderTable;
    private javax.swing.JTable tblSaleSearchProduct;
    private javax.swing.JTable tblSupplierShow;
    private javax.swing.JTable tblUserShow;
    private javax.swing.JTextArea txaUserOthers;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLinkSupplier;
    private javax.swing.JTextField txtNameSearchProduct;
    private javax.swing.JTextField txtNameSearchSupplier;
    private javax.swing.JTextField txtNameSearchTicket;
    private javax.swing.JTextField txtNameSearchUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtProductBrand;
    private javax.swing.JTextField txtProductBrandStore;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtProductNameStore;
    private javax.swing.JTextField txtProductPresentation;
    private javax.swing.JTextField txtProductPresentationStore;
    private javax.swing.JTextField txtProductPrice;
    private javax.swing.JTextField txtProductPriceStore;
    private javax.swing.JTextField txtProductStock;
    private javax.swing.JTextField txtProductStockStore;
    private javax.swing.JTextField txtSaleOrderClient;
    private javax.swing.JTextField txtSaleSearchProduct;
    private javax.swing.JTextField txtSupplierAddress;
    private javax.swing.JTextField txtSupplierName;
    private javax.swing.JTextField txtSupplierPhone;
    private javax.swing.JTextField txtSupplierTr;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JTextField txtUserCellphone;
    private javax.swing.JTextField txtUserEmail;
    private javax.swing.JTextField txtUserEmergencyNumber;
    private javax.swing.JTextField txtUserFatherLastName;
    private javax.swing.JTextField txtUserMotherLastName;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtUserNi;
    // End of variables declaration//GEN-END:variables
    
    private void clean(int option){
        DefaultTableModel model = null;
        
        switch(option){
            case 1:
                    txtUserName.setText("");
                    txtUserFatherLastName.setText("");
                    txtUserMotherLastName.setText("");
                    txtUserNi.setText("");   
                    txtUserAddress.setText("");    
                    txtUserCellphone.setText("");
                    txtUserEmail.setText("");
                    txtUserEmergencyNumber.setText("");
                    txaUserOthers.setText("");
                    
                    txtNameSearchUser.setText("");
                    
                    cbxUserGender.removeAllItems();
                    cbxUserPosition.removeAllItems();

                    model = (DefaultTableModel) tblResultUser.getModel();
                    model.getDataVector().removeAllElements();

                    model = (DefaultTableModel) tblUserShow.getModel();
                    model.getDataVector().removeAllElements();

                    lblNewUser.removeAll();
                    break;
            case 2:
                    txtSupplierName.setText("");
                    txtSupplierTr.setText("");
                    txtSupplierPhone.setText("");
                    txtSupplierAddress.setText("");
                    txtLinkSupplier.setText("");
                    txtNameSearchSupplier.setText("");
                    
                    model = (DefaultTableModel) tblResultSupplier.getModel();
                    model.getDataVector().removeAllElements();

                    model = (DefaultTableModel) tblSupplierShow.getModel();
                    model.getDataVector().removeAllElements();
                    
                    model = (DefaultTableModel) tblLinkProducts.getModel();
                    model.getDataVector().removeAllElements();
                    
                    
                    lstLinkSupplier.setModel((new DefaultListModel()));
                    lblNewSupplier.removeAll();
                    break;    
            case 3:
                    txtProductName.setText("");
                    txtProductBrand.setText("");
                    txtProductPresentation.setText("");
                    txtProductPrice.setText("");
                    txtProductStock.setText("");
                    txtLinkSupplier.setText("");
                    
                    cbxProductCategory.removeAllItems();
                    
                    model = (DefaultTableModel) tblProductShow.getModel();
                    model.getDataVector().removeAllElements();
                    
                    lblNewProduct.removeAll();     
                    break;
                
            case 5: txtSaleOrderClient.setText("");
                    lblSaleOrderNumber.setText("");
                    lblSaleOrderTotalOn.setText("");
                    
                    model = (DefaultTableModel) tblSaleOrderTable.getModel();
                    model.getDataVector().removeAllElements();
                    tblSaleOrderTable.removeAll();
                    break;
                    
        }
    }
}
