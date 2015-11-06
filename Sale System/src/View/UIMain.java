package View;

import Controlator.CHelp;
import Controlator.CHome;
import Controlator.CProducts;
import Controlator.CSale;
import Controlator.CStore;
import Controlator.CSuppliers;
import Controlator.CTicket;
import Controlator.CUsers;

import Interface.IMain;

import Model.Products;
import Model.Users;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
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
import javax.swing.table.DefaultTableModel;

public class UIMain extends javax.swing.JFrame {
    private IMain iInterface;
    private CHome cHome;
    private CUsers cUsers;
    private CSuppliers cSuppliers;
    private CProducts cProducts;
    private CStore cStore;
    private CSale cSale;    
    private CHelp CHelp;
    private ArrayList <JButton> aMenuButtons;
    private Users cUser;
    private int iState;
    private ArrayList <String> aUsersSearch;
    private ArrayList <String> aProductsSearch;
    private String strUserCode;
    private ArrayList <String> aSuppliersSearch;
    private ArrayList <String> aTicketsSearch;
    private String strSupplierCode;
    private String strProductCode;
    private ArrayList <String> aProductsIndexes;
    private ArrayList <String> aSuppliersIndexes;
    private ArrayList <Products> aProductsList;
    private double dTtotal;
    private float fColor[];
    
    public UIMain(IMain iMain, int iWindowNumber) {
        initComponents();
        this.setVisible(true);
        this.setTitle("Sale System");
        setLocationRelativeTo(null);
        
        this.fColor = new float[3];
        Color.RGBtoHSB(240, 240, 240, this.fColor);
        this.aUsersSearch = new ArrayList <>();
        this.aProductsSearch = new ArrayList <>();
        this.aSuppliersSearch = new ArrayList <>();
        this.aTicketsSearch = new ArrayList <>();
        this.aProductsIndexes = new ArrayList <>();
        this.aSuppliersIndexes = new ArrayList <>();
        this.aProductsList = new ArrayList <>();
        
        this.strUserCode = "";
        this.strSupplierCode = "";
        this.strProductCode = "";
        this.dTtotal = 0;
        
        this.aMenuButtons = new ArrayList <>();
        this.aMenuButtons.add(btnHome);
        this.aMenuButtons.add(btnUsers);
        this.aMenuButtons.add(btnSuppliers);
        this.aMenuButtons.add(btnProducts);
        this.aMenuButtons.add(btnStore);
        this.aMenuButtons.add(btnSale);
        this.aMenuButtons.add(btnHelp);
        
        this.iInterface = iMain;
        this.cHome = new CHome();
        this.cUsers = new CUsers();
        this.cSuppliers = new CSuppliers();
        this.cProducts = new CProducts();
        this.cStore = new CStore();
        this.cSale = new CSale();
        
        switch(iWindowNumber) {
            case 0:
                this.iInterface.changeHome((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                this.iInterface.paint(0, this.aMenuButtons);
            break;
                
            case 1:
                this.iInterface.changeUsers((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                this.iInterface.paint(1, this.aMenuButtons);
                this.cUsers.changeUserShow((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.tblUserShow);
            break;
            
            case 2:
                this.iInterface.changeSuppliers((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                this.iInterface.paint(2, this.aMenuButtons);
                this.cSuppliers.changeSupplierShow((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.tblSupplierShow);
            break;
            
            case 3:
                this.iInterface.changeProducts((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                this.iInterface.paint(3, this.aMenuButtons);
                this.cProducts.changeProductShow((CardLayout)this.pnlProductSlave.getLayout(), this.pnlProductSlave, this.tblProductShow);
            break;
            
            case 4:
                this.iInterface.changeStore((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                this.iInterface.paint(4, this.aMenuButtons);
                this.cStore.changeInventStore((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave, this.tblProductShowStore);
            break;
            
            case 5:
                this.iInterface.changeSale((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                this.iInterface.paint(5, this.aMenuButtons);
                
                Date cDate = new Date();
                DateFormat cFormat = new SimpleDateFormat("yyyy/MM/dd");
                this.lblSaleOrderDateOn.setText(cFormat.format(cDate));
                this.iInterface.setOrderNumber(this.lblSaleOrderNumber);
                this.lblUserOnSale.setText("Usuario: " + this.cUser.getName() + " " + this.cUser.getFatherLastName());
            break;
        }
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
        lblForgottenPass = new javax.swing.JLabel();
        pnlDataAccess = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        tfpPass = new javax.swing.JPasswordField();
        btnShowPass = new javax.swing.JButton();
        btnLogIn = new javax.swing.JButton();
        lblShowPass = new javax.swing.JLabel();
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
        scpLinkedProducts = new javax.swing.JScrollPane();
        lstLinkedProducts = new javax.swing.JList();
        lblLinkedProducts = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnLinkSupplierSearch = new javax.swing.JButton();
        txtLinkSupplier = new javax.swing.JTextField();
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
        pnlStoreInvent = new javax.swing.JPanel();
        lblProductShowStore = new javax.swing.JLabel();
        scpProductShowStore = new javax.swing.JScrollPane();
        tblProductShowStore = new javax.swing.JTable();
        cbxSaleSearchProductStore = new javax.swing.JComboBox();
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
        btnGenerateReport = new javax.swing.JButton();
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
        cbxSaleSearchProduct = new javax.swing.JComboBox();
        btnSaleSearchProduct = new javax.swing.JButton();
        txtSaleSearchProduct = new javax.swing.JTextField();
        scpSaleSearchProduct = new javax.swing.JScrollPane();
        tblSaleSearchProduct = new javax.swing.JTable();
        lblSaleSearchProduct = new javax.swing.JLabel();
        lblGeneral = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Sources/icon.png")));
        setResizable(false);

        btnHome.setBackground(new java.awt.Color(224, 224, 224));
        btnHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Home2.png"))); // NOI18N
        btnHome.setText("Principal");
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setIconTextGap(-3);
        btnHome.setOpaque(true);
        btnHome.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Home3.png"))); // NOI18N
        btnHome.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Home1.png"))); // NOI18N
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnUsers.setBackground(new java.awt.Color(224, 224, 224));
        btnUsers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(0, 60, 120));
        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Customer2.png"))); // NOI18N
        btnUsers.setText("Usuarios");
        btnUsers.setBorder(null);
        btnUsers.setBorderPainted(false);
        btnUsers.setContentAreaFilled(false);
        btnUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsers.setEnabled(false);
        btnUsers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUsers.setIconTextGap(-3);
        btnUsers.setOpaque(true);
        btnUsers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Customer3.png"))); // NOI18N
        btnUsers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Customer1.png"))); // NOI18N
        btnUsers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsersMouseExited(evt);
            }
        });
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        btnProducts.setBackground(new java.awt.Color(224, 224, 224));
        btnProducts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(120, 0, 0));
        btnProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Transaction2.png"))); // NOI18N
        btnProducts.setText("Productos");
        btnProducts.setBorder(null);
        btnProducts.setBorderPainted(false);
        btnProducts.setContentAreaFilled(false);
        btnProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProducts.setEnabled(false);
        btnProducts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProducts.setIconTextGap(-3);
        btnProducts.setOpaque(true);
        btnProducts.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Transaction3.png"))); // NOI18N
        btnProducts.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Transaction1.png"))); // NOI18N
        btnProducts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductsMouseExited(evt);
            }
        });
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnSuppliers.setBackground(new java.awt.Color(224, 224, 224));
        btnSuppliers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSuppliers.setForeground(new java.awt.Color(0, 60, 0));
        btnSuppliers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Product2.png"))); // NOI18N
        btnSuppliers.setText("Proveedores");
        btnSuppliers.setBorder(null);
        btnSuppliers.setBorderPainted(false);
        btnSuppliers.setContentAreaFilled(false);
        btnSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuppliers.setEnabled(false);
        btnSuppliers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSuppliers.setIconTextGap(-3);
        btnSuppliers.setOpaque(true);
        btnSuppliers.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Product3.png"))); // NOI18N
        btnSuppliers.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Product1.png"))); // NOI18N
        btnSuppliers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuppliersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuppliersMouseExited(evt);
            }
        });
        btnSuppliers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppliersActionPerformed(evt);
            }
        });

        btnSale.setBackground(new java.awt.Color(224, 224, 224));
        btnSale.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSale.setForeground(new java.awt.Color(204, 122, 0));
        btnSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Invoice2.png"))); // NOI18N
        btnSale.setText("Venta");
        btnSale.setBorder(null);
        btnSale.setBorderPainted(false);
        btnSale.setContentAreaFilled(false);
        btnSale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSale.setEnabled(false);
        btnSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSale.setIconTextGap(-3);
        btnSale.setOpaque(true);
        btnSale.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Invoice3.png"))); // NOI18N
        btnSale.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Invoice1.png"))); // NOI18N
        btnSale.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaleMouseExited(evt);
            }
        });
        btnSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleActionPerformed(evt);
            }
        });

        btnHelp.setBackground(new java.awt.Color(224, 224, 224));
        btnHelp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(255, 102, 102));
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Help2.png"))); // NOI18N
        btnHelp.setText("AYUDA");
        btnHelp.setBorder(null);
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHelp.setIconTextGap(-3);
        btnHelp.setOpaque(true);
        btnHelp.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Help3.png"))); // NOI18N
        btnHelp.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Help1.png"))); // NOI18N
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHelpMouseExited(evt);
            }
        });
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnStore.setBackground(new java.awt.Color(224, 224, 224));
        btnStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnStore.setForeground(new java.awt.Color(102, 0, 102));
        btnStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Order2.png"))); // NOI18N
        btnStore.setText("Inventario");
        btnStore.setBorder(null);
        btnStore.setBorderPainted(false);
        btnStore.setContentAreaFilled(false);
        btnStore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStore.setEnabled(false);
        btnStore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStore.setIconTextGap(-3);
        btnStore.setOpaque(true);
        btnStore.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Order3.png"))); // NOI18N
        btnStore.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Order1.png"))); // NOI18N
        btnStore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnStoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnStoreMouseExited(evt);
            }
        });
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
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStore, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSale, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnSale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnStore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnSuppliers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnUsers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.setPreferredSize(new java.awt.Dimension(787, 500));
        pnlContent.setLayout(new java.awt.CardLayout());

        pnlHome.setBackground(new java.awt.Color(210, 210, 210));
        pnlHome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlHome.setPreferredSize(new java.awt.Dimension(800, 600));

        lblHome.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblHome.setForeground(new java.awt.Color(102, 51, 0));
        lblHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHome.setText("X & G Centeno");

        pnlAccess.setBackground(new java.awt.Color(210, 210, 210));
        pnlAccess.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "  Acceso  ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(102, 102, 0))); // NOI18N
        pnlAccess.setName(""); // NOI18N

        lblImgLog.setBackground(new java.awt.Color(255, 255, 255));
        lblImgLog.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblImgLog.setForeground(new java.awt.Color(204, 0, 51));
        lblImgLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/User.png"))); // NOI18N
        lblImgLog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblForgottenPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblForgottenPass.setForeground(new java.awt.Color(0, 0, 204));
        lblForgottenPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForgottenPass.setText("¿Olvidó su contraseña?");
        lblForgottenPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgottenPassMouseClicked(evt);
            }
        });

        pnlDataAccess.setBackground(new java.awt.Color(210, 210, 210));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("Id de Usuario:");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        lblPass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPass.setText("Contraseña:");

        tfpPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfpPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));

        btnShowPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Eye.jpg"))); // NOI18N
        btnShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnShowPassMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnShowPassMouseReleased(evt);
            }
        });

        btnLogIn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogIn.setText("Ingresar");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        lblShowPass.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblShowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
                    .addComponent(btnLogIn)
                    .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlDataAccessLayout.createSequentialGroup()
                            .addComponent(tfpPass, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtId))
                    .addComponent(lblShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDataAccessLayout.setVerticalGroup(
            pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataAccessLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnShowPass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfpPass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlDataAccessLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lblPass)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout pnlAccessLayout = new javax.swing.GroupLayout(pnlAccess);
        pnlAccess.setLayout(pnlAccessLayout);
        pnlAccessLayout.setHorizontalGroup(
            pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccessLayout.createSequentialGroup()
                .addGroup(pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAccessLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblImgLog, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlDataAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAccessLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblForgottenPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlAccessLayout.setVerticalGroup(
            pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccessLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlAccessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblImgLog, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDataAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblForgottenPass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHome, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHomeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblHome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(pnlAccess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        pnlAccess.getAccessibleContext().setAccessibleName(""); // NOI18N
        pnlAccess.getAccessibleContext().setAccessibleDescription("");

        pnlContent.add(pnlHome, "pnlHome");

        pnlUsers.setPreferredSize(new java.awt.Dimension(800, 550));

        pnlUserMaster.setBackground(new java.awt.Color(220, 228, 249));
        pnlUserMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        btnUserShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserShow.setForeground(new java.awt.Color(0, 60, 120));
        btnUserShow.setText("Usuarios Registrados");
        btnUserShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserShowActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(0, 60, 120));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("USUARIOS");

        btnUserSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserSearch.setForeground(new java.awt.Color(0, 60, 120));
        btnUserSearch.setText("Buscar Usuario");
        btnUserSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUserSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserSearchActionPerformed(evt);
            }
        });

        btnUserAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUserAdd.setForeground(new java.awt.Color(0, 60, 120));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUserSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlUserSlave.setLayout(new java.awt.CardLayout());

        pnlUserShow.setBackground(new java.awt.Color(255, 228, 255));
        pnlUserShow.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblUserShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserShow.setForeground(new java.awt.Color(0, 60, 120));
        lblUserShow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserShow.setText("USUARIOS REGISTRADOS");

        tblUserShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre(s)", "Apellido Paterno", "Apellido Materno", "Cargo", "DNI", "Celular", "E-Mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scpUserShow.setViewportView(tblUserShow);

        javax.swing.GroupLayout pnlUserShowLayout = new javax.swing.GroupLayout(pnlUserShow);
        pnlUserShow.setLayout(pnlUserShowLayout);
        pnlUserShowLayout.setHorizontalGroup(
            pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserShowLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(scpUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addComponent(lblUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlUserShowLayout.setVerticalGroup(
            pnlUserShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpUserShow, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUserSlave.add(pnlUserShow, "pnlUserShow");

        pnlUserAdd.setBackground(new java.awt.Color(220, 249, 228));
        pnlUserAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblNewUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNewUser.setForeground(new java.awt.Color(0, 60, 120));
        lblNewUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewUser.setText("REGISTRO DE NUEVO USUARIO");

        pnlNewUser.setBackground(new java.awt.Color(253, 254, 224));
        pnlNewUser.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtUserName.setForeground(new java.awt.Color(255, 0, 0));
        txtUserName.setText("*");
        txtUserName.setToolTipText("");
        txtUserName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });

        txtUserFatherLastName.setForeground(new java.awt.Color(255, 0, 0));
        txtUserFatherLastName.setText("*");
        txtUserFatherLastName.setToolTipText("");
        txtUserFatherLastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserFatherLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFatherLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFatherLastNameFocusLost(evt);
            }
        });

        txtUserMotherLastName.setForeground(new java.awt.Color(255, 0, 0));
        txtUserMotherLastName.setText("*");
        txtUserMotherLastName.setToolTipText("");
        txtUserMotherLastName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserMotherLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserMotherLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserMotherLastNameFocusLost(evt);
            }
        });

        txtUserNi.setForeground(new java.awt.Color(255, 0, 0));
        txtUserNi.setText("*");
        txtUserNi.setToolTipText("");
        txtUserNi.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserNi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNiFocusLost(evt);
            }
        });

        txtUserAddress.setForeground(new java.awt.Color(255, 0, 0));
        txtUserAddress.setText("*");
        txtUserAddress.setToolTipText("");
        txtUserAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserAddressFocusLost(evt);
            }
        });

        txtUserCellphone.setForeground(new java.awt.Color(255, 0, 0));
        txtUserCellphone.setText("*");
        txtUserCellphone.setToolTipText("");
        txtUserCellphone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserCellphone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserCellphoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserCellphoneFocusLost(evt);
            }
        });

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

        txtUserEmergencyNumber.setForeground(new java.awt.Color(255, 0, 0));
        txtUserEmergencyNumber.setText("*");
        txtUserEmergencyNumber.setToolTipText("");
        txtUserEmergencyNumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserEmergencyNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserEmergencyNumberFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserEmergencyNumberFocusLost(evt);
            }
        });

        txtUserEmail.setForeground(new java.awt.Color(255, 0, 0));
        txtUserEmail.setText("*");
        txtUserEmail.setToolTipText("");
        txtUserEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true));
        txtUserEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserEmailFocusLost(evt);
            }
        });

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
        txaUserOthers.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txaUserOthers.setRows(5);
        txaUserOthers.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        scpUserOther.setViewportView(txaUserOthers);

        btnUserRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUserRegister.setForeground(new java.awt.Color(0, 60, 120));
        btnUserRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/add.png"))); // NOI18N
        btnUserRegister.setText("   Registrar");
        btnUserRegister.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUserRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserRegisterActionPerformed(evt);
            }
        });

        lblUserMandatory.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblUserMandatory.setForeground(new java.awt.Color(255, 0, 0));
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
                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                .addComponent(lblUserPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbxUserPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUserCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtUserCellphone))
                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                .addComponent(lblUserMotherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtUserMotherLastName))
                            .addGroup(pnlNewUserLayout.createSequentialGroup()
                                .addGroup(pnlNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlNewUserLayout.createSequentialGroup()
                                        .addComponent(lblUserMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnUserRegister))
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
                                .addGap(0, 0, Short.MAX_VALUE)))
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
                    .addComponent(txtUserMotherLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(scpUserOther, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
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
                .addGroup(pnlUserAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlUserAddLayout.setVerticalGroup(
            pnlUserAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlUserSlave.add(pnlUserAdd, "pnlUserAdd");

        pnlUserSearch.setBackground(new java.awt.Color(255, 244, 225));
        pnlUserSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        pnlSeekUser.setBackground(new java.awt.Color(255, 244, 225));

        txtNameSearchUser.setForeground(new java.awt.Color(0, 60, 120));
        txtNameSearchUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchUser.setText("Ingrese Nombre de Usuario");
        txtNameSearchUser.setToolTipText("");
        txtNameSearchUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameSearchUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameSearchUserFocusLost(evt);
            }
        });

        btnSearchUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search2.png"))); // NOI18N
        btnSearchUser.setBorder(null);
        btnSearchUser.setBorderPainted(false);
        btnSearchUser.setContentAreaFilled(false);
        btnSearchUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchUser.setIconTextGap(-3);
        btnSearchUser.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search3.png"))); // NOI18N
        btnSearchUser.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search1.png"))); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekUserLayout.setVerticalGroup(
            pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultUser.setBackground(new java.awt.Color(220, 249, 228));
        pnlResultUser.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

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
        scpResultUser.setViewportView(tblResultUser);

        lblResultUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultUser.setForeground(new java.awt.Color(0, 60, 120));
        lblResultUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultUser.setText("RESULTADOS DE LA BÚSQUEDA");

        btnModifyUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifyUser.setForeground(new java.awt.Color(0, 60, 120));
        btnModifyUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/update.png"))); // NOI18N
        btnModifyUser.setText("  Modificar Datos");
        btnModifyUser.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
                    .addComponent(scpResultUser)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModifyUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblUserSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUserSearch.setForeground(new java.awt.Color(0, 60, 120));
        lblUserSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserSearch.setText("BUSCAR USUARIO");

        javax.swing.GroupLayout pnlUserSearchLayout = new javax.swing.GroupLayout(pnlUserSearch);
        pnlUserSearch.setLayout(pnlUserSearchLayout);
        pnlUserSearchLayout.setHorizontalGroup(
            pnlUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlSeekUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlResultUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlUserSearchLayout.setVerticalGroup(
            pnlUserSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUserSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSeekUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(pnlUserSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlUsersLayout.setVerticalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUserSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(pnlUserMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlUsers, "pnlUsers");

        pnlSupplierMaster.setBackground(new java.awt.Color(220, 249, 228));
        pnlSupplierMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnSupplierShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierShow.setForeground(new java.awt.Color(0, 60, 0));
        btnSupplierShow.setText("Proveedores Registrados");
        btnSupplierShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierShowActionPerformed(evt);
            }
        });

        lblSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(0, 60, 0));
        lblSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplier.setText("PROVEEDORES");

        btnSupplierSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierSearch.setForeground(new java.awt.Color(0, 60, 0));
        btnSupplierSearch.setText("Buscar Proveedor");
        btnSupplierSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierSearchActionPerformed(evt);
            }
        });

        btnSupplierAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierAdd.setForeground(new java.awt.Color(0, 60, 0));
        btnSupplierAdd.setText("Registrar Proveedor");
        btnSupplierAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupplierAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierAddActionPerformed(evt);
            }
        });

        btnSupplierLink.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSupplierLink.setForeground(new java.awt.Color(0, 60, 0));
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
                .addContainerGap(250, Short.MAX_VALUE))
        );

        pnlSupplierSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlSupplierSlave.setLayout(new java.awt.CardLayout());

        pnlSupplierShow.setBackground(new java.awt.Color(255, 244, 255));
        pnlSupplierShow.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblSupplierShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSupplierShow.setForeground(new java.awt.Color(0, 60, 0));
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
                    .addComponent(scpSupplierShow, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSupplierShowLayout.setVerticalGroup(
            pnlSupplierShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupplierShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpSupplierShow, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSupplierSlave.add(pnlSupplierShow, "pnlSupplierShow");

        pnlSupplierAdd.setBackground(new java.awt.Color(253, 254, 224));
        pnlSupplierAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblNewSupplier.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNewSupplier.setForeground(new java.awt.Color(0, 60, 0));
        lblNewSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewSupplier.setText("REGISTRO DE NUEVO PROVEEDOR");

        pnlNewSupplier.setBackground(new java.awt.Color(222, 255, 255));
        pnlNewSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtSupplierName.setForeground(java.awt.Color.red);
        txtSupplierName.setText("*");
        txtSupplierName.setToolTipText("");
        txtSupplierName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 1, true));
        txtSupplierName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSupplierNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSupplierNameFocusLost(evt);
            }
        });

        txtSupplierTr.setForeground(java.awt.Color.red);
        txtSupplierTr.setText("*");
        txtSupplierTr.setToolTipText("");
        txtSupplierTr.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 1, true));
        txtSupplierTr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSupplierTrFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSupplierTrFocusLost(evt);
            }
        });

        txtSupplierAddress.setForeground(java.awt.Color.red);
        txtSupplierAddress.setText("*");
        txtSupplierAddress.setToolTipText("");
        txtSupplierAddress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 1, true));
        txtSupplierAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSupplierAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSupplierAddressFocusLost(evt);
            }
        });

        txtSupplierPhone.setForeground(java.awt.Color.red);
        txtSupplierPhone.setText("*");
        txtSupplierPhone.setToolTipText("");
        txtSupplierPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 1, true));
        txtSupplierPhone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSupplierPhoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSupplierPhoneFocusLost(evt);
            }
        });

        lblSupplierName.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierName.setText("Nombre(s)");

        lblSupplierTr.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierTr.setText("RUC");

        lblSupplierAddress.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierAddress.setText("Dirección");

        lblSupplierPhone.setFont(new java.awt.Font("Gisha", 1, 11)); // NOI18N
        lblSupplierPhone.setText("Teléfono");

        btnSupplierRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSupplierRegister.setForeground(new java.awt.Color(0, 60, 0));
        btnSupplierRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/add.png"))); // NOI18N
        btnSupplierRegister.setText("   Registrar");
        btnSupplierRegister.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSupplierRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupplierRegisterActionPerformed(evt);
            }
        });

        lblSupplierMandatory.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblSupplierMandatory.setForeground(new java.awt.Color(255, 0, 51));
        lblSupplierMandatory.setText("* Obligatorio");

        javax.swing.GroupLayout pnlNewSupplierLayout = new javax.swing.GroupLayout(pnlNewSupplier);
        pnlNewSupplier.setLayout(pnlNewSupplierLayout);
        pnlNewSupplierLayout.setHorizontalGroup(
            pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                        .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSupplierTr, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addGroup(pnlNewSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSupplierTr))
                            .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSupplierName))))
                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                        .addComponent(lblSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSupplierAddress))
                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                        .addComponent(lblSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSupplierPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 124, Short.MAX_VALUE))
                    .addGroup(pnlNewSupplierLayout.createSequentialGroup()
                        .addComponent(lblSupplierMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSupplierRegister)))
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
                    .addComponent(txtSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnlSupplierAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNewSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSupplierAddLayout.setVerticalGroup(
            pnlSupplierAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSupplierSlave.add(pnlSupplierAdd, "pnlSupplierAdd");

        pnlSupplierSearch.setBackground(new java.awt.Color(255, 244, 225));
        pnlSupplierSearch.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        pnlSeekSupplier.setBackground(new java.awt.Color(255, 244, 225));

        txtNameSearchSupplier.setForeground(new java.awt.Color(0, 60, 0));
        txtNameSearchSupplier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchSupplier.setText("Ingrese Nombre de Proveedor");
        txtNameSearchSupplier.setToolTipText("");
        txtNameSearchSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameSearchSupplierFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameSearchSupplierFocusLost(evt);
            }
        });

        btnSearchSupplier.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search2.png"))); // NOI18N
        btnSearchSupplier.setBorderPainted(false);
        btnSearchSupplier.setContentAreaFilled(false);
        btnSearchSupplier.setFocusPainted(false);
        btnSearchSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchSupplier.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search3.png"))); // NOI18N
        btnSearchSupplier.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search1.png"))); // NOI18N
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
                .addComponent(txtNameSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekSupplierLayout.setVerticalGroup(
            pnlSeekSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultSupplier.setBackground(new java.awt.Color(220, 228, 249));
        pnlResultSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

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
        lblResultSupplier.setForeground(new java.awt.Color(0, 60, 0));
        lblResultSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultSupplier.setText("RESULTADOS DE LA BÚSQUEDA");

        btnModifySupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifySupplier.setForeground(new java.awt.Color(0, 60, 0));
        btnModifySupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/update.png"))); // NOI18N
        btnModifySupplier.setText("  Modificar Datos");
        btnModifySupplier.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
                    .addComponent(scpResultSupplier)
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
                .addComponent(scpResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModifySupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblSupplierSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSupplierSearch.setForeground(new java.awt.Color(0, 60, 0));
        lblSupplierSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSupplierSearch.setText("BUSCAR PROVEEDOR");

        javax.swing.GroupLayout pnlSupplierSearchLayout = new javax.swing.GroupLayout(pnlSupplierSearch);
        pnlSupplierSearch.setLayout(pnlSupplierSearchLayout);
        pnlSupplierSearchLayout.setHorizontalGroup(
            pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblSupplierSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSeekSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSupplierSearchLayout.setVerticalGroup(
            pnlSupplierSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSeekSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlSupplierSlave.add(pnlSupplierSearch, "pnlSupplierSearch");

        pnlSupplierLink.setBackground(new java.awt.Color(220, 228, 249));
        pnlSupplierLink.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        pnlLinkSupplier.setBackground(new java.awt.Color(255, 228, 255));
        pnlLinkSupplier.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLinkSupplier.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLinkSupplier.setForeground(new java.awt.Color(0, 60, 0));
        lblLinkSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinkSupplier.setText("PROVEEDORES");

        lstLinkSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstLinkSupplierMouseClicked(evt);
            }
        });
        scpLinkSupplier.setViewportView(lstLinkSupplier);

        lstLinkedProducts.setEnabled(false);
        scpLinkedProducts.setViewportView(lstLinkedProducts);

        lblLinkedProducts.setText("Productos Vinculados:");
        lblLinkedProducts.setEnabled(false);

        jPanel1.setBackground(new java.awt.Color(255, 228, 255));

        btnLinkSupplierSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLinkSupplierSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search2.png"))); // NOI18N
        btnLinkSupplierSearch.setBorderPainted(false);
        btnLinkSupplierSearch.setContentAreaFilled(false);
        btnLinkSupplierSearch.setFocusPainted(false);
        btnLinkSupplierSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLinkSupplierSearch.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search3.png"))); // NOI18N
        btnLinkSupplierSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search1.png"))); // NOI18N
        btnLinkSupplierSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinkSupplierSearchActionPerformed(evt);
            }
        });

        txtLinkSupplier.setForeground(new java.awt.Color(0, 60, 0));
        txtLinkSupplier.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLinkSupplier.setText("Ingrese Nombre de Proveedor");
        txtLinkSupplier.setToolTipText("");
        txtLinkSupplier.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLinkSupplierFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLinkSupplierFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnLinkSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnLinkSupplierSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlLinkSupplierLayout = new javax.swing.GroupLayout(pnlLinkSupplier);
        pnlLinkSupplier.setLayout(pnlLinkSupplierLayout);
        pnlLinkSupplierLayout.setHorizontalGroup(
            pnlLinkSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLinkSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLinkSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblLinkSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scpLinkSupplier)
                    .addComponent(lblLinkedProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scpLinkedProducts))
                .addContainerGap())
        );
        pnlLinkSupplierLayout.setVerticalGroup(
            pnlLinkSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLinkSupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLinkedProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpLinkedProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlLinkProducts.setBackground(new java.awt.Color(253, 254, 224));
        pnlLinkProducts.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLinkProducts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLinkProducts.setForeground(new java.awt.Color(0, 60, 0));
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

        btnLinkSupplier.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLinkSupplier.setForeground(new java.awt.Color(0, 60, 0));
        btnLinkSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/return.png"))); // NOI18N
        btnLinkSupplier.setText("  Vincular");
        btnLinkSupplier.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
                    .addComponent(lblLinkProducts, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(scpLinkProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLinkProductsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLinkSupplier)))
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

        lblLinkSupplierTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLinkSupplierTitle.setForeground(new java.awt.Color(0, 60, 0));
        lblLinkSupplierTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLinkSupplierTitle.setText("VINCULAR PRODUCTOS DISTRIBUIDOS");

        javax.swing.GroupLayout pnlSupplierLinkLayout = new javax.swing.GroupLayout(pnlSupplierLink);
        pnlSupplierLink.setLayout(pnlSupplierLinkLayout);
        pnlSupplierLinkLayout.setHorizontalGroup(
            pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSupplierLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinkSupplierTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlSupplierLinkLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(pnlLinkSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlLinkProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        pnlSupplierLinkLayout.setVerticalGroup(
            pnlSupplierLinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSupplierLinkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLinkSupplierTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(pnlSupplierSlave, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSuppliersLayout.setVerticalGroup(
            pnlSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSuppliersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSuppliersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSupplierSlave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSupplierMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlSuppliers, "pnlSuppliers");

        pnlProductMaster.setBackground(new java.awt.Color(255, 228, 255));
        pnlProductMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblProduct.setForeground(new java.awt.Color(120, 0, 0));
        lblProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProduct.setText("PRODUCTOS");

        btnProductShow.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProductShow.setForeground(new java.awt.Color(120, 0, 0));
        btnProductShow.setText("Productos Registrados");
        btnProductShow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProductShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductShowActionPerformed(evt);
            }
        });

        btnProductAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProductAdd.setForeground(new java.awt.Color(120, 0, 0));
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
                .addContainerGap(332, Short.MAX_VALUE))
        );

        pnlProductSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlProductSlave.setLayout(new java.awt.CardLayout());

        pnlProductAdd.setBackground(new java.awt.Color(255, 244, 225));
        pnlProductAdd.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblNewProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNewProduct.setForeground(new java.awt.Color(120, 0, 0));
        lblNewProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNewProduct.setText("REGISTRO DE NUEVO PRODUCTO");

        pnlNewProduct.setBackground(new java.awt.Color(220, 228, 249));
        pnlNewProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtProductName.setForeground(new java.awt.Color(255, 0, 0));
        txtProductName.setText("*");
        txtProductName.setToolTipText("");
        txtProductName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        txtProductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductNameFocusLost(evt);
            }
        });

        txtProductBrand.setForeground(new java.awt.Color(255, 0, 0));
        txtProductBrand.setText("*");
        txtProductBrand.setToolTipText("");
        txtProductBrand.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        txtProductBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductBrandFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductBrandFocusLost(evt);
            }
        });

        txtProductPresentation.setForeground(new java.awt.Color(255, 0, 0));
        txtProductPresentation.setText("*");
        txtProductPresentation.setToolTipText("");
        txtProductPresentation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        txtProductPresentation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductPresentationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductPresentationFocusLost(evt);
            }
        });

        txtProductStock.setForeground(new java.awt.Color(255, 0, 0));
        txtProductStock.setText("*");
        txtProductStock.setToolTipText("");
        txtProductStock.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        txtProductStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductStockFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductStockFocusLost(evt);
            }
        });

        txtProductPrice.setForeground(new java.awt.Color(255, 0, 0));
        txtProductPrice.setText("*");
        txtProductPrice.setToolTipText("");
        txtProductPrice.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 255), 1, true));
        txtProductPrice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductPriceFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductPriceFocusLost(evt);
            }
        });

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

        btnProductRegister.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductRegister.setForeground(new java.awt.Color(120, 0, 0));
        btnProductRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/add.png"))); // NOI18N
        btnProductRegister.setText("    Registrar");
        btnProductRegister.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProductRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductRegisterActionPerformed(evt);
            }
        });

        lblUserMandatory1.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblUserMandatory1.setForeground(new java.awt.Color(255, 0, 0));
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
                                .addComponent(cbxProductCategory, 0, 123, Short.MAX_VALUE))
                            .addGroup(pnlNewProductLayout.createSequentialGroup()
                                .addGroup(pnlNewProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlNewProductLayout.createSequentialGroup()
                                        .addComponent(lblProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblUserMandatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProductRegister))
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
                .addGroup(pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblNewProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlProductAddLayout.setVerticalGroup(
            pnlProductAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlProductSlave.add(pnlProductAdd, "pnlProductAdd");

        pnlProductShow.setBackground(new java.awt.Color(220, 249, 228));
        pnlProductShow.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblProductShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProductShow.setForeground(new java.awt.Color(120, 0, 0));
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
                    .addComponent(lblProductShow, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addComponent(scpProductShow))
                .addContainerGap())
        );
        pnlProductShowLayout.setVerticalGroup(
            pnlProductShowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductShowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductShow, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpProductShow, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(pnlProductSlave, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pnlStoreMaster.setBackground(new java.awt.Color(245, 220, 249));
        pnlStoreMaster.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnStoreReportProd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreReportProd.setForeground(new java.awt.Color(102, 0, 102));
        btnStoreReportProd.setText("Reporte Productos");
        btnStoreReportProd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreReportProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreReportProdActionPerformed(evt);
            }
        });
        btnStoreReportProd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnStoreReportProdFocusLost(evt);
            }
        });

        lblStore.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblStore.setForeground(new java.awt.Color(102, 0, 102));
        lblStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStore.setText("ALMACÉN");

        btnStoreSearchTic.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreSearchTic.setForeground(new java.awt.Color(102, 0, 102));
        btnStoreSearchTic.setText("Buscar Boleta");
        btnStoreSearchTic.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreSearchTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreSearchTicActionPerformed(evt);
            }
        });

        btnStoreSearchPro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreSearchPro.setForeground(new java.awt.Color(102, 0, 102));
        btnStoreSearchPro.setText("Buscar Producto");
        btnStoreSearchPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreSearchPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreSearchProActionPerformed(evt);
            }
        });

        btnStoreReportSale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreReportSale.setForeground(new java.awt.Color(102, 0, 102));
        btnStoreReportSale.setText("Reporte Ventas");
        btnStoreReportSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStoreReportSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStoreReportSaleActionPerformed(evt);
            }
        });

        btnStoreInvent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStoreInvent.setForeground(new java.awt.Color(102, 0, 102));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlStoreSlave.setPreferredSize(new java.awt.Dimension(500, 100));
        pnlStoreSlave.setLayout(new java.awt.CardLayout());

        pnlStoreInvent.setBackground(new java.awt.Color(220, 249, 228));
        pnlStoreInvent.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblProductShowStore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProductShowStore.setForeground(new java.awt.Color(102, 0, 102));
        lblProductShowStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductShowStore.setText("PRODUCTOS REGISTRADOS");

        tblProductShowStore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Marca", "Presentación", "Categoría", "Stock", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
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
                    .addComponent(scpProductShowStore, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlStoreInventLayout.setVerticalGroup(
            pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreInventLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreInventLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblProductShowStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSaleSearchProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpProductShowStore, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreInvent, "pnlStoreInvent");

        pnlStoreSaleReport.setBackground(new java.awt.Color(253, 254, 224));
        pnlStoreSaleReport.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblSaleReport.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSaleReport.setForeground(new java.awt.Color(102, 0, 102));
        lblSaleReport.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleReport.setText("PRODUCTOS REGISTRADOS");

        pnlContentSaleReport.setBackground(new java.awt.Color(222, 255, 255));
        pnlContentSaleReport.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lblSelectDateStartReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSelectDateStartReport.setText("Fecha Seleccionada:");

        lblSelectDateEndReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSelectDateEndReport.setText("Fecha Seleccionada:");

        btnGenerateReport.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGenerateReport.setForeground(new java.awt.Color(120, 0, 120));
        btnGenerateReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/return.png"))); // NOI18N
        btnGenerateReport.setText("Generar");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlContentSaleReportLayout = new javax.swing.GroupLayout(pnlContentSaleReport);
        pnlContentSaleReport.setLayout(pnlContentSaleReportLayout);
        pnlContentSaleReportLayout.setHorizontalGroup(
            pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(clrStart, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                .addComponent(lblSelectDateStart)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblSelectDateStartReport, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))))
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
                                .addComponent(clrEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblSelectDateEndReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                                        .addComponent(lblSelectDateEnd)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentSaleReportLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnGenerateReport)))))))
                .addContainerGap())
        );
        pnlContentSaleReportLayout.setVerticalGroup(
            pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentSaleReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSateReportStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addComponent(lblSelectDateStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSelectDateStartReport))
                    .addComponent(clrStart, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(lblSateReportEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContentSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addComponent(clrEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(pnlContentSaleReportLayout.createSequentialGroup()
                        .addComponent(lblSelectDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSelectDateEndReport, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlStoreSaleReportLayout = new javax.swing.GroupLayout(pnlStoreSaleReport);
        pnlStoreSaleReport.setLayout(pnlStoreSaleReportLayout);
        pnlStoreSaleReportLayout.setHorizontalGroup(
            pnlStoreSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSaleReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlContentSaleReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaleReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlStoreSaleReportLayout.setVerticalGroup(
            pnlStoreSaleReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSaleReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaleReport, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlContentSaleReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreSaleReport, "pnlStoreSaleReport");

        pnlStoreSearchPro.setBackground(new java.awt.Color(222, 255, 255));
        pnlStoreSearchPro.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        pnlStoreSearchPro.setPreferredSize(new java.awt.Dimension(777, 456));

        pnlSeekProduct.setBackground(new java.awt.Color(222, 255, 255));

        txtNameSearchProduct.setForeground(new java.awt.Color(102, 0, 102));
        txtNameSearchProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchProduct.setText("Ingrese Nombre de Producto");
        txtNameSearchProduct.setToolTipText("");
        txtNameSearchProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameSearchProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameSearchProductFocusLost(evt);
            }
        });

        btnSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search2.png"))); // NOI18N
        btnSearchProduct.setBorderPainted(false);
        btnSearchProduct.setContentAreaFilled(false);
        btnSearchProduct.setFocusPainted(false);
        btnSearchProduct.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchProduct.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search3.png"))); // NOI18N
        btnSearchProduct.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search1.png"))); // NOI18N
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
                .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekProductLayout.setVerticalGroup(
            pnlSeekProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultProduct.setBackground(new java.awt.Color(220, 249, 228));
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
        lblResultProduct.setForeground(new java.awt.Color(102, 0, 102));
        lblResultProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultProduct.setText("RESULTADOS DE LA BÚSQUEDA");

        btnModifyProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnModifyProduct.setForeground(new java.awt.Color(102, 0, 102));
        btnModifyProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/update.png"))); // NOI18N
        btnModifyProduct.setText("  Modificar Datos");
        btnModifyProduct.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
                    .addComponent(scpResultProduct)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModifyProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblProductSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProductSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblProductSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductSearch.setText("BUSCAR PRODUCTO");

        javax.swing.GroupLayout pnlStoreSearchProLayout = new javax.swing.GroupLayout(pnlStoreSearchPro);
        pnlStoreSearchPro.setLayout(pnlStoreSearchProLayout);
        pnlStoreSearchProLayout.setHorizontalGroup(
            pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSearchProLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSeekProduct, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlResultProduct, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlStoreSearchProLayout.setVerticalGroup(
            pnlStoreSearchProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSearchProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSeekProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreSearchPro, "pnlStoreSearchPro");

        pnlStoreSearchTic.setBackground(new java.awt.Color(255, 244, 225));
        pnlStoreSearchTic.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        pnlSeekTicket.setBackground(new java.awt.Color(255, 244, 225));

        txtNameSearchTicket.setForeground(new java.awt.Color(120, 0, 120));
        txtNameSearchTicket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNameSearchTicket.setText("Ingrese Número de la Boleta");
        txtNameSearchTicket.setToolTipText("");
        txtNameSearchTicket.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNameSearchTicketFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameSearchTicketFocusLost(evt);
            }
        });

        btnSearchTicket.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSearchTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search2.png"))); // NOI18N
        btnSearchTicket.setBorderPainted(false);
        btnSearchTicket.setContentAreaFilled(false);
        btnSearchTicket.setFocusPainted(false);
        btnSearchTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearchTicket.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search3.png"))); // NOI18N
        btnSearchTicket.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search1.png"))); // NOI18N
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
                .addComponent(btnSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSeekTicketLayout.setVerticalGroup(
            pnlSeekTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSeekTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSeekTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNameSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultTicket.setBackground(new java.awt.Color(253, 254, 224));
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
        lblResultTicket.setForeground(new java.awt.Color(102, 0, 102));
        lblResultTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultTicket.setText("RESULTADOS DE LA BÚSQUEDA");

        btnSeeTicket.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSeeTicket.setForeground(new java.awt.Color(120, 0, 120));
        btnSeeTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/update.png"))); // NOI18N
        btnSeeTicket.setText("  Visualizar Boleta");
        btnSeeTicket.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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
                    .addComponent(scpResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scpResultTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeeTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblTicketSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTicketSearch.setForeground(new java.awt.Color(102, 0, 102));
        lblTicketSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTicketSearch.setText("BUSCAR BOLETA DE VENTA");

        javax.swing.GroupLayout pnlStoreSearchTicLayout = new javax.swing.GroupLayout(pnlStoreSearchTic);
        pnlStoreSearchTic.setLayout(pnlStoreSearchTicLayout);
        pnlStoreSearchTicLayout.setHorizontalGroup(
            pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSearchTicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlSeekTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTicketSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStoreSearchTicLayout.setVerticalGroup(
            pnlStoreSearchTicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreSearchTicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTicketSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSeekTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStoreSlave.add(pnlStoreSearchTic, "pnlStoreSearchTic");

        pnlStoreModifyPro.setBackground(new java.awt.Color(220, 228, 249));
        pnlStoreModifyPro.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblProductStore.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblProductStore.setForeground(new java.awt.Color(102, 0, 102));
        lblProductStore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductStore.setText("MODIFICACIÓN PRODUCTO");

        pnlProductStore.setBackground(new java.awt.Color(255, 244, 225));
        pnlProductStore.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        txtProductNameStore.setForeground(new java.awt.Color(250, 0, 0));
        txtProductNameStore.setText("*");
        txtProductNameStore.setToolTipText("");
        txtProductNameStore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));
        txtProductNameStore.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductNameStoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductNameStoreFocusLost(evt);
            }
        });

        txtProductBrandStore.setForeground(new java.awt.Color(250, 0, 0));
        txtProductBrandStore.setText("*");
        txtProductBrandStore.setToolTipText("");
        txtProductBrandStore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));
        txtProductBrandStore.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductBrandStoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductBrandStoreFocusLost(evt);
            }
        });

        txtProductPresentationStore.setForeground(new java.awt.Color(250, 0, 0));
        txtProductPresentationStore.setText("*");
        txtProductPresentationStore.setToolTipText("");
        txtProductPresentationStore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));
        txtProductPresentationStore.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductPresentationStoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductPresentationStoreFocusLost(evt);
            }
        });

        txtProductStockStore.setForeground(new java.awt.Color(250, 0, 0));
        txtProductStockStore.setText("*");
        txtProductStockStore.setToolTipText("");
        txtProductStockStore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));
        txtProductStockStore.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductStockStoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductStockStoreFocusLost(evt);
            }
        });

        txtProductPriceStore.setForeground(new java.awt.Color(250, 0, 0));
        txtProductPriceStore.setText("*");
        txtProductPriceStore.setToolTipText("");
        txtProductPriceStore.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 1, true));
        txtProductPriceStore.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductPriceStoreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductPriceStoreFocusLost(evt);
            }
        });

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

        btnProductUpdateStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProductUpdateStore.setForeground(new java.awt.Color(102, 0, 102));
        btnProductUpdateStore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/update.png"))); // NOI18N
        btnProductUpdateStore.setText("Actualizar");
        btnProductUpdateStore.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnProductUpdateStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductUpdateStoreActionPerformed(evt);
            }
        });

        lblUserMandatoryStore.setFont(new java.awt.Font("Gisha", 0, 10)); // NOI18N
        lblUserMandatoryStore.setForeground(new java.awt.Color(250, 0, 0));
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
                                .addComponent(cbxProductCategoryStore, 0, 123, Short.MAX_VALUE))
                            .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                .addGroup(pnlProductStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlProductStoreLayout.createSequentialGroup()
                                        .addComponent(lblProductPriceStore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtProductPriceStore, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblUserMandatoryStore, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnProductUpdateStore))
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
                    .addComponent(txtProductPresentationStore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(pnlStoreModifyProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProductStore, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStoreModifyProLayout.setVerticalGroup(
            pnlStoreModifyProLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreModifyProLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProductStore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlStoreSlave.add(pnlStoreModifyPro, "pnlStoreModifyPro");

        javax.swing.GroupLayout pnlStoreLayout = new javax.swing.GroupLayout(pnlStore);
        pnlStore.setLayout(pnlStoreLayout);
        pnlStoreLayout.setHorizontalGroup(
            pnlStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlStoreMaster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlStoreSlave, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlStoreLayout.setVerticalGroup(
            pnlStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlStoreSlave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStoreMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlStore, "pnlStore");

        lblSale.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblSale.setForeground(new java.awt.Color(204, 122, 0));
        lblSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSale.setText("VENTA DE PRODUCTOS");

        pnlSaleOrder.setBackground(new java.awt.Color(220, 249, 228));
        pnlSaleOrder.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        lblSaleOrder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleOrder.setForeground(new java.awt.Color(153, 0, 102));
        lblSaleOrder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleOrder.setText("ORDEN DE VENTA");

        lblSaleOrderNumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleOrderNumber.setForeground(new java.awt.Color(0, 51, 0));
        lblSaleOrderNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleOrderNumber.setText("XXXXXXXXX");

        txtSaleOrderClient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaleOrderClient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSaleOrderClientFocusLost(evt);
            }
        });

        lblSaleOrderClient.setText("Cliente");

        lblSaleOrderDate.setText("Fecha:");

        lblSaleOrderDateOn.setForeground(new java.awt.Color(0, 51, 0));
        lblSaleOrderDateOn.setText("xxxxxxxxxxxxxxxxx");

        tblSaleOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cant.", "Nombre", "Precio Uni.", "Precio Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
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

        btnSaleOrderDelete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSaleOrderDelete.setForeground(new java.awt.Color(153, 0, 102));
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

        btnSaleOrderPrint.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSaleOrderPrint.setForeground(new java.awt.Color(153, 0, 102));
        btnSaleOrderPrint.setText("Imprimir Comprobante");
        btnSaleOrderPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleOrderPrintActionPerformed(evt);
            }
        });

        lblUserOnSale.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUserOnSale.setForeground(new java.awt.Color(0, 51, 0));
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
                        .addGap(5, 5, 5)
                        .addComponent(btnSaleOrderPrint))
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
                                .addComponent(lblSaleOrderDateOn, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
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
                .addComponent(scpSaleOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

        pnlSaleSearchProduct.setBackground(new java.awt.Color(253, 254, 224));
        pnlSaleSearchProduct.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        pnlSaleSearchProductOn.setBackground(new java.awt.Color(253, 254, 224));

        cbxSaleSearchProduct.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Marca", "Categoría" }));

        btnSaleSearchProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search2.png"))); // NOI18N
        btnSaleSearchProduct.setBorderPainted(false);
        btnSaleSearchProduct.setContentAreaFilled(false);
        btnSaleSearchProduct.setFocusPainted(false);
        btnSaleSearchProduct.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search3.png"))); // NOI18N
        btnSaleSearchProduct.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Sources/Search1.png"))); // NOI18N
        btnSaleSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaleSearchProductActionPerformed(evt);
            }
        });

        txtSaleSearchProduct.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout pnlSaleSearchProductOnLayout = new javax.swing.GroupLayout(pnlSaleSearchProductOn);
        pnlSaleSearchProductOn.setLayout(pnlSaleSearchProductOnLayout);
        pnlSaleSearchProductOnLayout.setHorizontalGroup(
            pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleSearchProductOnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSaleSearchProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSaleSearchProductOnLayout.setVerticalGroup(
            pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleSearchProductOnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleSearchProductOnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSaleSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSaleSearchProductMouseClicked(evt);
            }
        });
        scpSaleSearchProduct.setViewportView(tblSaleSearchProduct);

        lblSaleSearchProduct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSaleSearchProduct.setForeground(new java.awt.Color(0, 102, 51));
        lblSaleSearchProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaleSearchProduct.setText("BUSCAR PRODUCTO");

        javax.swing.GroupLayout pnlSaleSearchProductLayout = new javax.swing.GroupLayout(pnlSaleSearchProduct);
        pnlSaleSearchProduct.setLayout(pnlSaleSearchProductLayout);
        pnlSaleSearchProductLayout.setHorizontalGroup(
            pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleSearchProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpSaleSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(lblSaleSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlSaleSearchProductOn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlSaleSearchProductLayout.setVerticalGroup(
            pnlSaleSearchProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSaleSearchProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSaleSearchProductOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSaleLayout = new javax.swing.GroupLayout(pnlSale);
        pnlSale.setLayout(pnlSaleLayout);
        pnlSaleLayout.setHorizontalGroup(
            pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSale, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSaleOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlSaleLayout.setVerticalGroup(
            pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSaleLayout.createSequentialGroup()
                        .addComponent(lblSale, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addGap(11, 11, 11)
                        .addComponent(pnlSaleSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSaleOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlContent.add(pnlSale, "pnlSale");

        lblGeneral.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblGeneral.setForeground(new java.awt.Color(102, 51, 0));
        lblGeneral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
                    .addComponent(pnlContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUsersActionPerformed
    {//GEN-HEADEREND:event_btnUsersActionPerformed
        this.iInterface.changeUsers((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
        this.iInterface.paint(1, this.aMenuButtons);
        this.btnUserAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnUserSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnUserShow.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnUserAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnUserSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnUserShow.setBackground(Color.ORANGE);
        this.cUsers.changeUserShow((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.tblUserShow);
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHomeActionPerformed
    {//GEN-HEADEREND:event_btnHomeActionPerformed
        this.iInterface.changeHome((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
        this.iInterface.paint(0, this.aMenuButtons);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnSuppliersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSuppliersActionPerformed
    {//GEN-HEADEREND:event_btnSuppliersActionPerformed
        this.iInterface.changeSuppliers((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
        this.iInterface.paint(2, this.aMenuButtons);
        this.btnSupplierAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierLink.setFont(new Font("Tahoma", Font.BOLD, 12));        
        this.btnSupplierAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierLink.setBackground(Color.ORANGE);
        this.cSuppliers.changeSupplierShow((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.tblSupplierShow);
    }//GEN-LAST:event_btnSuppliersActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnProductsActionPerformed
    {//GEN-HEADEREND:event_btnProductsActionPerformed
        this.iInterface.changeProducts((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
        this.iInterface.paint(3, this.aMenuButtons);
        
        this.btnProductAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnProductShow.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnProductAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnProductShow.setBackground(Color.ORANGE);
        
        this.cProducts.changeProductShow((CardLayout)this.pnlProductSlave.getLayout(), this.pnlProductSlave, this.tblProductShow);
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnStoreActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStoreActionPerformed
    {//GEN-HEADEREND:event_btnStoreActionPerformed
        this.iInterface.changeStore((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
        this.iInterface.paint(4, this.aMenuButtons);
        
        this.btnStoreSearchPro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreSearchTic.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreInvent.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        this.btnStoreSearchPro.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreSearchTic.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportProd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportSale.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreInvent.setBackground(Color.ORANGE);
        
        this.cStore.changeInventStore((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave, this.tblProductShowStore);
    }//GEN-LAST:event_btnStoreActionPerformed

    private void btnSaleActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaleActionPerformed
    {//GEN-HEADEREND:event_btnSaleActionPerformed
        this.iInterface.changeSale((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
        this.iInterface.paint(5, this.aMenuButtons);
        
        Date CDate = new Date();
        DateFormat cFormat = new SimpleDateFormat("yyyy/MM/dd");
        this.lblSaleOrderDateOn.setText(cFormat.format(CDate));
        this.iInterface.setOrderNumber(this.lblSaleOrderNumber);
        this.lblUserOnSale.setText("Usuario: " + cUser.getName() + " " + this.cUser.getFatherLastName());
        this.aProductsList = this.cSale.search(this.cbxSaleSearchProduct, this.txtSaleSearchProduct, this.tblSaleSearchProduct);
        this.txtSaleOrderClient.setText("");
        this.txtSaleSearchProduct.setText("");               
    }//GEN-LAST:event_btnSaleActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        try {
            Desktop.getDesktop().open((new File("Ayuda.pdf")));
        } catch (IOException cExcepotion) {
            Logger.getLogger(UIMain.class.getName()).log(Level.SEVERE, null, cExcepotion);
        }
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnSaleOrderDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleOrderDeleteActionPerformed
        int iRow;
        if((iRow = this.tblSaleOrderTable.getSelectedRow()) != -1){
            this.dTtotal -= Double.parseDouble(String.valueOf(this.tblSaleOrderTable.getValueAt(iRow, 4)));
            
            DefaultTableModel cModel = (DefaultTableModel)this.tblSaleOrderTable.getModel();
            cModel.removeRow(iRow);
            
            DecimalFormat cFormat = new DecimalFormat("#.##");
            this.lblSaleOrderTotalOn.setText("S/. " + cFormat.format(this.dTtotal));
        }
        else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro de la Orden de Venta",
                                            "Dato no Seleccionado",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSaleOrderDeleteActionPerformed

    private void btnStoreInventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreInventActionPerformed
        this.btnStoreSearchPro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreSearchTic.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreInvent.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        this.btnStoreSearchPro.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreSearchTic.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportProd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportSale.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreInvent.setBackground(Color.ORANGE);
        this.cStore.changeInventStore((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave, this.tblProductShowStore);
    }//GEN-LAST:event_btnStoreInventActionPerformed

    private void btnStoreReportSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreReportSaleActionPerformed
        this.btnStoreSearchPro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreSearchTic.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportSale.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnStoreInvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnStoreSearchPro.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreSearchTic.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportProd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportSale.setBackground(Color.ORANGE);
        this.btnStoreInvent.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.cStore.changeReportSale((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave);
    }//GEN-LAST:event_btnStoreReportSaleActionPerformed

    private void btnStoreSearchProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreSearchProActionPerformed
        cleanProductSearch();
        this.btnStoreSearchPro.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnStoreSearchTic.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreInvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnStoreSearchPro.setBackground(Color.ORANGE);
        this.btnStoreSearchTic.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportProd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportSale.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreInvent.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        
        this.cStore.changeProductSearch((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave);
    }//GEN-LAST:event_btnStoreSearchProActionPerformed

    private void btnStoreSearchTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreSearchTicActionPerformed
        cleanTicketSearch();
        this.btnStoreSearchPro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreSearchTic.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnStoreReportProd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreInvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnStoreSearchPro.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreSearchTic.setBackground(Color.ORANGE);
        this.btnStoreReportProd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportSale.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreInvent.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        
        this.cStore.changeTicketSearch((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave);
    }//GEN-LAST:event_btnStoreSearchTicActionPerformed

    private void btnStoreReportProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStoreReportProdActionPerformed
        this.btnStoreSearchPro.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreSearchTic.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreReportProd.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnStoreReportSale.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnStoreInvent.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnStoreSearchPro.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreSearchTic.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreReportProd.setBackground(Color.ORANGE);
        this.btnStoreReportSale.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnStoreInvent.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        
        if(this.cStore.productReport(this.cUser))
                JOptionPane.showMessageDialog(  null,
                                                "El Reporte se ha generado correctamente. Se encuentra en la dirección consignada al crearlo",
                                                "Reporte Generado",
                                                JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null,
                                            "Hubieron problemas al generar el reporte. Revise los datos y vuelva a generarlo",
                                            "Reporte No Generado",
                                            JOptionPane.ERROR_MESSAGE);
        
        this.btnStoreReportProd.setFocusPainted(false);
        this.btnStoreInventActionPerformed(null);
        
    }//GEN-LAST:event_btnStoreReportProdActionPerformed

    private void btnProductRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductRegisterActionPerformed
        if(!(this.txtProductName.getText().equals("*") || this.txtProductBrand.getText().equals("*") || this.txtProductPresentation.getText().equals("*") || this.txtProductPrice.getText().equals("*") || this.txtProductStock.getText().equals("*"))) {
            this.cProducts.actProduct(this.txtProductName, this.txtProductBrand, this.txtProductPresentation, this.txtProductPrice, this.txtProductStock, this.cbxProductCategory);
            this.cProducts.changeProductShow((CardLayout)this.pnlProductSlave.getLayout(), this.pnlProductSlave, this.tblProductShow);
        } else 
            JOptionPane.showMessageDialog(  null,
                                            "Todos los campos obligatorios deber ser llenados.",
                                            "Datos Incompletos",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnProductRegisterActionPerformed

    private void btnProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductAddActionPerformed
        cleanProductAdd();        
        this.btnProductAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnProductShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnProductAdd.setBackground(Color.ORANGE);
        this.btnProductShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
                      
        this.cProducts.changeProductAdd((CardLayout)this.pnlProductSlave.getLayout(), this.pnlProductSlave, this.cbxProductCategory, this.lblNewProduct, this.btnProductRegister);
    }//GEN-LAST:event_btnProductAddActionPerformed

    private void btnProductShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductShowActionPerformed
        this.btnProductAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnProductShow.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnProductAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnProductShow.setBackground(Color.ORANGE);
        
        this.cProducts.changeProductShow((CardLayout)this.pnlProductSlave.getLayout(), this.pnlProductSlave, this.tblProductShow);
    }//GEN-LAST:event_btnProductShowActionPerformed

    private void btnLinkSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkSupplierActionPerformed
        int iSupplierSelected;
        boolean []bProductsSelected = new boolean[this.tblLinkProducts.getRowCount()];

        if((iSupplierSelected = this.lstLinkSupplier.getSelectedIndex()) != -1) {
            for(int i = 0;i < this.tblLinkProducts.getRowCount();i++)
                bProductsSelected[i] = (Boolean) this.tblLinkProducts.getValueAt(i, 0);

            if(bProductsSelected.length != 0) {
                cSuppliers.link(bProductsSelected, this.aProductsIndexes, this.aSuppliersIndexes.get(iSupplierSelected));
                cSuppliers.changeSupplierShow((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.tblSupplierShow);
            } else
                JOptionPane.showMessageDialog(  null,
                                                "No ha seleccionado ningún registro de productos.",
                                                "Dato no Seleccionado",
                                                JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro de proveedores.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnLinkSupplierActionPerformed

    private void btnLinkSupplierSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinkSupplierSearchActionPerformed
        this.lblLinkedProducts.setEnabled(false);
        this.lstLinkedProducts.setEnabled(false);
        this.lstLinkSupplier.setModel((new DefaultListModel()));
        this.lstLinkedProducts.setModel((new DefaultListModel()));
        this.aSuppliersIndexes = this.cSuppliers.searchSupplierLink(this.txtLinkSupplier, this.lstLinkSupplier);
    }//GEN-LAST:event_btnLinkSupplierSearchActionPerformed

    private void btnModifySupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifySupplierActionPerformed
        int iValue;
        if((iValue = this.tblResultSupplier.getSelectedRow()) != -1){
            cleanSupplierSearch();
            this.strSupplierCode = this.cSuppliers.send((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.aSuppliersSearch.get(iValue), this.lblNewSupplier, this.txtSupplierName, this.txtSupplierTr, this.txtSupplierPhone, this.txtSupplierAddress, this.btnSupplierRegister);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifySupplierActionPerformed

    private void btnSearchSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSupplierActionPerformed
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultSupplier.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultSupplier.removeAll();
        
        this.aSuppliersSearch = this.cSuppliers.searchSupplier(this.txtNameSearchSupplier, this.tblResultSupplier);
    }//GEN-LAST:event_btnSearchSupplierActionPerformed

    private void btnSupplierRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierRegisterActionPerformed
        String strMessage = "";
        
        if(this.txtSupplierName.getText().equals("*"))
            strMessage += "\n  * Campo Nombre";
    
        if(this.txtSupplierTr.getText().equals("*"))
            strMessage += "\n  * Campo RUC";
        
        if(this.txtSupplierPhone.getText().equals("*"))
            strMessage += "\n  * Campo Teléfono";
        
        if(this.txtSupplierAddress.getText().endsWith("*"))
            strMessage += "\n  * Campo Dirección";        
        
        if(strMessage.isEmpty()) {
            this.cSuppliers.actSupplier(this.iState, this.strSupplierCode, this.txtSupplierName, this.txtSupplierTr, this.txtSupplierPhone, this.txtSupplierAddress);
            this.cSuppliers.changeSupplierShow((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.tblSupplierShow);
        } else 
            JOptionPane.showMessageDialog(  null,
                                            "Todos los campos obligatorios deber ser llenados.\n Completar:" + strMessage,
                                            "Datos Incompletos",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSupplierRegisterActionPerformed

    private void btnSupplierLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierLinkActionPerformed
        cleanLinkSupplier();
        this.aProductsIndexes = this.cSuppliers.changeSupplierLink((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.tblLinkProducts);
        
        this.btnSupplierAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierLink.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        this.btnSupplierAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierLink.setBackground(Color.ORANGE);
    }//GEN-LAST:event_btnSupplierLinkActionPerformed

    private void btnSupplierAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierAddActionPerformed
        cleanSupplierAdd();        
        this.cSuppliers.changeSupplierAdd((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.lblNewSupplier, this.btnSupplierRegister);
        this.iState = 0;
        
        this.btnSupplierAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnSupplierAdd.setBackground(Color.ORANGE);
        this.btnSupplierSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierLink.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
    }//GEN-LAST:event_btnSupplierAddActionPerformed

    private void btnSupplierSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierSearchActionPerformed
        cleanSupplierSearch();
        this.cSuppliers.changeSupplierSearch((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave);
        this.iState = 1;
        this.strSupplierCode = "";
        
        this.btnSupplierAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnSupplierShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnSupplierAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierSearch.setBackground(Color.ORANGE);
        this.btnSupplierShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierLink.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
    }//GEN-LAST:event_btnSupplierSearchActionPerformed

    private void btnSupplierShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupplierShowActionPerformed
        this.cSuppliers.changeSupplierShow((CardLayout)this.pnlSupplierSlave.getLayout(), this.pnlSupplierSlave, this.tblSupplierShow);
        this.btnSupplierAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnSupplierShow.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnSupplierLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnSupplierAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnSupplierShow.setBackground(Color.ORANGE);
        this.btnSupplierLink.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
    }//GEN-LAST:event_btnSupplierShowActionPerformed

    private void btnModifyUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyUserActionPerformed
        int iValue;
        if((iValue = this.tblResultUser.getSelectedRow()) != -1){
            if(!this.aUsersSearch.get(iValue).equals("001")) {
                cleanUserAdd();
                this.strUserCode = this.cUsers.send((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.aUsersSearch.get(iValue), this.lblNewSupplier, this.txtUserName, this.txtUserFatherLastName, this.txtUserMotherLastName, this.txtUserNi, this.cbxUserGender, this.txtUserAddress, this.cbxUserPosition, this.txtUserCellphone, this.txtUserEmail, this.txtUserEmergencyNumber, this.txaUserOthers, this.btnUserRegister);
            } else
                JOptionPane.showMessageDialog(  null,
                                                "NO PUEDE MODIFICAR EL ACCESO GLOBAL AL SISTEMA.",
                                                "Protección",
                                                JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifyUserActionPerformed

    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultUser.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultUser.removeAll();
        this.aUsersSearch = this.cUsers.searchUser(this.txtNameSearchUser, this.tblResultUser);
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void btnUserRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserRegisterActionPerformed
        String strMessage = "";
        
        if(this.txtUserName.getText().equals("*"))
            strMessage += "\n  * Campo Nombre";
    
        if(this.txtUserFatherLastName.getText().equals("*"))
            strMessage += "\n  * Campo Apellido Paterno";
        
        if(this.txtUserMotherLastName.getText().equals("*"))
            strMessage += "\n  * Campo Apellido Materno";
        
        if(this.txtUserNi.getText().equals("*"))
            strMessage += "\n  * Campo DNI";
        
        if(this.txtUserAddress.getText().equals("*"))
            strMessage += "\n  * Campo Dirección";
        
        if(this.txtUserCellphone.getText().equals("*"))
            strMessage += "\n  * Campo Celular";
        
        if(this.txtUserEmail.getText().equals("*"))
            strMessage += "\n  * Campo Correo Electrónico";
        
        if(this.txtUserEmergencyNumber.getText().equals("*"))
            strMessage += "\n  * Campo Numero de Emergencia";
        
        if(strMessage.isEmpty()) {
            this.cUsers.actUser(this.iState, this.strUserCode, this.txtUserName, this.txtUserFatherLastName, this.txtUserMotherLastName, this.txtUserNi, this.cbxUserGender, this.txtUserAddress, this.cbxUserPosition, this.txtUserCellphone, this.txtUserEmail, this.txtUserEmergencyNumber, this.txaUserOthers);
            this.cUsers.changeUserShow((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.tblUserShow);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "Todos los campos obligatorios deber ser llenados.\n Completar:" + strMessage,
                                            "Datos Incompletos",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnUserRegisterActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        cleanUserAdd();
        this.cUsers.changeUserAdd((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.cbxUserGender, this.cbxUserPosition, this.lblNewUser, this.btnUserRegister);
        this.iState = 0;
        
        this.btnUserAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnUserSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnUserShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnUserAdd.setBackground(Color.ORANGE);
        this.btnUserSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnUserShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnUserSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserSearchActionPerformed
        cleanUserSearch();
        this.cUsers.changeUserSearch((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave);
        this.iState = 1;
        this.strUserCode = "";
        
        this.btnUserAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnUserSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
        this.btnUserShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        this.btnUserAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnUserSearch.setBackground(Color.ORANGE);
        this.btnUserShow.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
    }//GEN-LAST:event_btnUserSearchActionPerformed

    private void btnUserShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserShowActionPerformed
        this.cUsers.changeUserShow((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.tblUserShow);
        
        this.btnUserAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnUserSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
        this.btnUserShow.setFont(new Font("Tahoma", Font.BOLD, 12));
        
        this.btnUserAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnUserSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
        this.btnUserShow.setBackground(Color.ORANGE);
    }//GEN-LAST:event_btnUserShowActionPerformed

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        if((this.cUser = this.cHome.logIn(this.txtId, this.tfpPass)) != null) {
            this.lblWelcome.setText("Bienvenid@ " + this.cUser.getName());
            this.lblLogOut.setText("Cerrar Sesión");
            this.lblGeneral.setText("X & G Centeno");
            this.cHome.activate(Integer.parseInt(this.cUser.getPositionCode()), this.btnHome, this.btnUsers, this.btnSuppliers, this.btnProducts, this.btnStore, this.btnSale);
            
            switch(Integer.parseInt(this.cUser.getPositionCode())){
                case 1: this.iInterface.changeUsers((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                        this.iInterface.paint(1, this.aMenuButtons);
                        this.cUsers.changeUserShow((CardLayout)this.pnlUserSlave.getLayout(), this.pnlUserSlave, this.tblUserShow);
                        
                        this.btnUserAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
                        this.btnUserSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
                        this.btnUserShow.setFont(new Font("Tahoma", Font.BOLD, 12));

                        this.btnUserAdd.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
                        this.btnUserSearch.setBackground(Color.getHSBColor(this.fColor[0],this.fColor[1],this.fColor[2]));
                        this.btnUserShow.setBackground(Color.ORANGE);
                        break;
                    
                case 2: this.iInterface.changeSale((CardLayout)this.pnlContent.getLayout(), this.pnlContent);
                
                        this.iInterface.paint(5, this.aMenuButtons);
                        Date cDate = new Date();
                        DateFormat cFormat = new SimpleDateFormat("yyyy/MM/dd");
                        this.lblSaleOrderDateOn.setText(cFormat.format(cDate));
                        this.iInterface.setOrderNumber(this.lblSaleOrderNumber);
                        this.lblUserOnSale.setText("Usuario: " + this.cUser.getName() + " " + this.cUser.getFatherLastName());
                        this.aProductsList = this.cSale.search(this.cbxSaleSearchProduct, this.txtSaleSearchProduct, this.tblSaleSearchProduct);
                        this.txtSaleOrderClient.setText("");
                        this.txtSaleSearchProduct.setText(""); 
                        break;
            }
        }
    }//GEN-LAST:event_btnLogInActionPerformed

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        this.iInterface.logOut();
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblForgottenPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgottenPassMouseClicked
        this.iInterface.forgottenPass(this.txtId);
    }//GEN-LAST:event_lblForgottenPassMouseClicked

    private void btnSaleSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleSearchProductActionPerformed
        this.aProductsList = this.cSale.search(this.cbxSaleSearchProduct, this.txtSaleSearchProduct, this.tblSaleSearchProduct);
    }//GEN-LAST:event_btnSaleSearchProductActionPerformed

    private void tblSaleSearchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSaleSearchProductMouseClicked
        this.dTtotal = this.cSale.addProduct(this.tblSaleOrderTable, this.tblSaleSearchProduct.getSelectedRow(), this.aProductsList, this.dTtotal);
        this.lblSaleOrderTotalOn.setText("S/. " + String.format("%.1f", this.dTtotal) + "0");
    }//GEN-LAST:event_tblSaleSearchProductMouseClicked

    private void tblSaleOrderTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tblSaleOrderTablePropertyChange
        int iRow;
        if((iRow = this.tblSaleOrderTable.getSelectedRow()) != -1){
            this.dTtotal -= Double.parseDouble(String.valueOf(this.tblSaleOrderTable.getValueAt(iRow, 4)));
            
            String strResult = this.cSale.verifyQuantity(String.valueOf(this.tblSaleOrderTable.getValueAt(iRow, 0)), String.valueOf(this.tblSaleOrderTable.getValueAt(iRow, 1))); 
            if(!strResult.isEmpty()){
                this.tblSaleOrderTable.setValueAt("1" , iRow, 1);
                JOptionPane.showMessageDialog(  null,
                                                strResult,
                                                "Error en la Entrada",
                                                JOptionPane.WARNING_MESSAGE);
            }
            
            int iAmount = Integer.parseInt(String.valueOf(this.tblSaleOrderTable.getValueAt(iRow, 1)));
            double dPrice = Double.parseDouble(String.valueOf(this.tblSaleOrderTable.getValueAt(iRow, 3)));
            this.tblSaleOrderTable.setValueAt(iAmount*dPrice, iRow, 4);
            dTtotal += iAmount*dPrice;
            
            this.lblSaleOrderTotalOn.setText("S/. " + String.format("%.1f", this.dTtotal) + "0");
        }
    }//GEN-LAST:event_tblSaleOrderTablePropertyChange

    private void btnSaleOrderPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaleOrderPrintActionPerformed
        if(this.tblSaleOrderTable.getRowCount() != 0) {
            this.btnSaleOrderDelete.setVisible(false);
            
            try {
                BufferedImage cImage = new BufferedImage(this.pnlSaleOrder.getWidth(), this.pnlSaleOrder.getHeight(), BufferedImage.TYPE_INT_ARGB);
                this.pnlSaleOrder.paint(cImage.getGraphics());
                ImageIO.write(cImage, "png", new File("Boletas/" + lblSaleOrderNumber.getText() + ".png"));
            } catch (IOException cException) {
                Logger.getLogger(UIMain.class.getName()).log(Level.SEVERE, null, cException);
            }         
            
            CTicket cTicket = new CTicket(lblSaleOrderNumber.getText(), 1);
            
            this.btnSaleOrderDelete.setVisible(true);
            this.cSale.safeSale(this.cUser, this.txtSaleOrderClient, this.lblSaleOrderTotalOn, this.lblSaleOrderDateOn, this.tblSaleOrderTable);
            cleanSale();
            this.iInterface.setOrderNumber(this.lblSaleOrderNumber);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No se ha ingresado algún registro a la Orden de Venta",
                                            "Datos No Ingresados",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSaleOrderPrintActionPerformed

    private void btnProductUpdateStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductUpdateStoreActionPerformed
        String strMessage = "";
        
        if(this.txtProductNameStore.getText().equals("*"))
            strMessage += "\n  * Campo Nombre";
    
        if(this.txtProductBrandStore.getText().equals("*"))
            strMessage += "\n  * Campo Marca";
        
        if(this.txtProductPresentationStore.getText().equals("*"))
            strMessage += "\n  * Campo Presentación";
        
        if(this.txtProductStockStore.getText().equals("*"))
            strMessage += "\n  * Campo Stock";
        
        if(this.txtProductPriceStore.getText().equals("*"))
            strMessage += "\n  * Campo Precio";
        
        if(strMessage.isEmpty()) {
            this.cStore.actProduct(this.strProductCode, this.txtProductNameStore, this.txtProductBrandStore, this.txtProductPresentationStore, this.txtProductStockStore, this.cbxProductCategoryStore, this.txtProductPriceStore);
            this.cStore.changeInventStore((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave, this.tblProductShowStore);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "Todos los campos obligatorios deber ser llenados.\n Completar:" + strMessage,
                                            "Datos Incompletos",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnProductUpdateStoreActionPerformed

    private void btnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchProductActionPerformed
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultProduct.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultProduct.removeAll();
        
        this.aProductsSearch = this.cStore.searchProduct(this.txtNameSearchProduct, this.tblResultProduct);
    }//GEN-LAST:event_btnSearchProductActionPerformed

    private void btnModifyProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyProductActionPerformed
        int iValue;
        if((iValue = this.tblResultProduct.getSelectedRow()) != -1) {
            this.cStore.changeModify((CardLayout)this.pnlStoreSlave.getLayout(), this.pnlStoreSlave);
            this.strProductCode = this.cStore.send(this.aProductsSearch.get(iValue), this.txtProductNameStore, this.txtProductBrandStore, this.txtProductPresentationStore, this.txtProductStockStore, this.cbxProductCategoryStore, this.txtProductPriceStore);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnModifyProductActionPerformed

    private void btnSearchTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTicketActionPerformed
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultTicket.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultTicket.removeAll();
        
        this.aTicketsSearch = this.cStore.searchTicket(this.txtNameSearchTicket, this.tblResultTicket);
    }//GEN-LAST:event_btnSearchTicketActionPerformed

    private void btnSeeTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeTicketActionPerformed
        int iRow;
        if((iRow = this.tblResultTicket.getSelectedRow()) != -1){
            CTicket cTicket = new CTicket(this.aTicketsSearch.get(iRow), 0);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No ha seleccionado ningún registro.",
                                            "Dato no Seleccionado",
                                            JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnSeeTicketActionPerformed

    private void cbxSaleSearchProductStoreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSaleSearchProductStoreItemStateChanged
         if (evt.getStateChange() == ItemEvent.SELECTED) {
             this.cStore.chargeProduct(this.tblProductShowStore, this.cbxSaleSearchProductStore);
         }
    }//GEN-LAST:event_cbxSaleSearchProductStoreItemStateChanged

    private void clrStartPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clrStartPropertyChange
        SimpleDateFormat cFormat = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
        this.lblSelectDateStartReport.setText(cFormat.format(this.clrStart.getCalendar().getTime()));
    }//GEN-LAST:event_clrStartPropertyChange

    private void clrEndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_clrEndPropertyChange
        SimpleDateFormat cFormat = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
        this.lblSelectDateEndReport.setText(cFormat.format(clrEnd.getCalendar().getTime()));
    }//GEN-LAST:event_clrEndPropertyChange

    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed
        if(this.cStore.saleReport(this.cUser,  this.clrStart, this.clrEnd))
            JOptionPane.showMessageDialog(  null,
                                            "El Reporte se ha generado correctamente. Se encuentra en la dirección consignada al crearlo",
                                            "Reporte Generado",
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null,
                                            "Hubieron problemas al generar el reporte. Revise los datos y vuelva a generarlo",
                                            "Reporte No Generado",
                                            JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        if(this.txtUserName.getText().isEmpty()){
            this.txtUserName.setText("*");
            this.txtUserName.setForeground(Color.RED);
        } else {
            String strName = this.txtUserName.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtUserName.setText("*");
                this.txtUserName.setForeground(Color.RED);
            }            
        }            
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
        if(this.txtUserName.getText().equals("*")){
            this.txtUserName.setText("");
            this.txtUserName.setForeground(Color.BLACK);
        }     
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserFatherLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFatherLastNameFocusGained
        if(this.txtUserFatherLastName.getText().equals("*")){
            this.txtUserFatherLastName.setText("");
            this.txtUserFatherLastName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserFatherLastNameFocusGained

    private void txtUserFatherLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFatherLastNameFocusLost
        if(this.txtUserFatherLastName.getText().isEmpty()){
            this.txtUserFatherLastName.setText("*");
            this.txtUserFatherLastName.setForeground(Color.RED);
        } else {
            String strName = this.txtUserFatherLastName.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtUserFatherLastName.setText("*");
                this.txtUserFatherLastName.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtUserFatherLastNameFocusLost

    private void txtUserMotherLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserMotherLastNameFocusGained
        if(this.txtUserMotherLastName.getText().equals("*")){
            this.txtUserMotherLastName.setText("");
            this.txtUserMotherLastName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserMotherLastNameFocusGained

    private void txtUserMotherLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserMotherLastNameFocusLost
        if(this.txtUserMotherLastName.getText().isEmpty()){
            this.txtUserMotherLastName.setText("*");
            this.txtUserMotherLastName.setForeground(Color.RED);
        } else {
            String strName = this.txtUserMotherLastName.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtUserMotherLastName.setText("*");
                this.txtUserMotherLastName.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtUserMotherLastNameFocusLost

    private void txtUserNiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNiFocusGained
        if(this.txtUserNi.getText().equals("*")){
            this.txtUserNi.setText("");
            this.txtUserNi.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserNiFocusGained

    private void txtUserNiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNiFocusLost
        if(this.txtUserNi.getText().isEmpty() || this.txtUserNi.getText().length() != 8){
            this.txtUserNi.setText("*");
            this.txtUserNi.setForeground(Color.RED);
        } else {
            String strName = this.txtUserNi.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtUserNi.setText("*");
                this.txtUserNi.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtUserNiFocusLost

    private void txtUserAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserAddressFocusGained
        if(this.txtUserAddress.getText().equals("*")){
            this.txtUserAddress.setText("");
            this.txtUserAddress.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserAddressFocusGained

    private void txtUserAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserAddressFocusLost
        if(this.txtUserAddress.getText().isEmpty()){
            this.txtUserAddress.setText("*");
            this.txtUserAddress.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtUserAddressFocusLost

    private void txtUserCellphoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserCellphoneFocusGained
        if(this.txtUserCellphone.getText().equals("*")){
            this.txtUserCellphone.setText("");
            this.txtUserCellphone.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserCellphoneFocusGained

    private void txtUserCellphoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserCellphoneFocusLost
        if(this.txtUserCellphone.getText().isEmpty() || this.txtUserCellphone.getText().length() != 9) {
            this.txtUserCellphone.setText("*");
            this.txtUserCellphone.setForeground(Color.RED);
        } else {
            String strName = this.txtUserCellphone.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtUserCellphone.setText("*");
                this.txtUserCellphone.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtUserCellphoneFocusLost

    private void txtUserEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserEmailFocusGained
        if(this.txtUserEmail.getText().equals("*")){
            this.txtUserEmail.setText("");
            this.txtUserEmail.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserEmailFocusGained

    private void txtUserEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserEmailFocusLost
        if(this.txtUserEmail.getText().isEmpty()){
            this.txtUserEmail.setText("*");
            this.txtUserEmail.setForeground(Color.RED);
        } else {
            String strName = this.txtUserEmail.getText().toLowerCase();
            if(!(strName.contains("@") && strName.contains("."))) {
                this.txtUserEmail.setText("*");
                this.txtUserEmail.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtUserEmailFocusLost

    private void txtUserEmergencyNumberFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserEmergencyNumberFocusGained
        if(this.txtUserEmergencyNumber.getText().equals("*")){
            this.txtUserEmergencyNumber.setText("");
            this.txtUserEmergencyNumber.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUserEmergencyNumberFocusGained

    private void txtUserEmergencyNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserEmergencyNumberFocusLost
        if(this.txtUserEmergencyNumber.getText().isEmpty() || this.txtUserEmergencyNumber.getText().length() != 9){
            this.txtUserEmergencyNumber.setText("*");
            this.txtUserEmergencyNumber.setForeground(Color.RED);
        } else {
            String strName = this.txtUserEmergencyNumber.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtUserEmergencyNumber.setText("*");
                this.txtUserEmergencyNumber.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtUserEmergencyNumberFocusLost

    private void txtNameSearchUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchUserFocusGained
        if(this.txtNameSearchUser.getText().equals("Ingrese Nombre de Usuario")){
            this.txtNameSearchUser.setText("");
            this.txtNameSearchUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchUserFocusGained

    private void txtNameSearchUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchUserFocusLost
        if(this.txtNameSearchUser.getText().isEmpty()) {
            this.txtNameSearchUser.setText("Ingrese Nombre de Usuario");
            this.txtNameSearchUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchUserFocusLost

    private void txtSupplierNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierNameFocusGained
        if(this.txtSupplierName.getText().equals("*")){
            this.txtSupplierName.setText("");
            this.txtSupplierName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSupplierNameFocusGained

    private void txtSupplierNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierNameFocusLost
        if(this.txtSupplierName.getText().isEmpty()){
            this.txtSupplierName.setText("*");
            this.txtSupplierName.setForeground(Color.RED);
        } else {
            String strName = this.txtSupplierName.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtSupplierName.setText("*");
                this.txtSupplierName.setForeground(Color.RED);
            }            
        } 
    }//GEN-LAST:event_txtSupplierNameFocusLost

    private void txtSupplierTrFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierTrFocusGained
        if(this.txtSupplierTr.getText().equals("*")){
            this.txtSupplierTr.setText("");
            this.txtSupplierTr.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSupplierTrFocusGained

    private void txtSupplierTrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierTrFocusLost
        if(this.txtSupplierTr.getText().isEmpty() || this.txtSupplierTr.getText().length() != 11){
            this.txtSupplierTr.setText("*");
            this.txtSupplierTr.setForeground(Color.RED);
        } else {
            String strName = this.txtSupplierTr.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtSupplierTr.setText("*");
                this.txtSupplierTr.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtSupplierTrFocusLost

    private void txtSupplierAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierAddressFocusGained
        if(this.txtSupplierAddress.getText().equals("*")){
            this.txtSupplierAddress.setText("");
            this.txtSupplierAddress.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSupplierAddressFocusGained

    private void txtSupplierAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierAddressFocusLost
        if(this.txtSupplierAddress.getText().isEmpty()){
            this.txtSupplierAddress.setText("*");
            this.txtSupplierAddress.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtSupplierAddressFocusLost

    private void txtSupplierPhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierPhoneFocusGained
        if(this.txtSupplierPhone.getText().equals("*")){
            this.txtSupplierPhone.setText("");
            this.txtSupplierPhone.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtSupplierPhoneFocusGained

    private void txtSupplierPhoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSupplierPhoneFocusLost
        if(this.txtSupplierPhone.getText().isEmpty() || this.txtSupplierPhone.getText().length() != 9){
            this.txtSupplierPhone.setText("*");
            this.txtSupplierPhone.setForeground(Color.RED);
        } else {
            String strName = this.txtSupplierPhone.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtSupplierPhone.setText("*");
                this.txtSupplierPhone.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtSupplierPhoneFocusLost

    private void txtNameSearchSupplierFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchSupplierFocusGained
        if(this.txtNameSearchSupplier.getText().equals("Ingrese Nombre de Usuario")){
            this.txtNameSearchSupplier.setText("");
            this.txtNameSearchSupplier.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchSupplierFocusGained

    private void txtNameSearchSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchSupplierFocusLost
        if(this.txtNameSearchSupplier.getText().isEmpty()) {
            this.txtNameSearchSupplier.setText("Ingrese Nombre de Usuario");
            this.txtNameSearchSupplier.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchSupplierFocusLost

    private void txtLinkSupplierFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLinkSupplierFocusGained
        if(this.txtLinkSupplier.getText().equals("Ingrese Nombre de Proveedor")){
            this.txtLinkSupplier.setText("");
            this.txtLinkSupplier.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtLinkSupplierFocusGained

    private void txtLinkSupplierFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLinkSupplierFocusLost
        if(this.txtLinkSupplier.getText().isEmpty()) {
            this.txtLinkSupplier.setText("Ingrese Nombre de Proveedor");
            this.txtLinkSupplier.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtLinkSupplierFocusLost

    private void lstLinkSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstLinkSupplierMouseClicked
        this.lblLinkedProducts.setEnabled(false);
        this.lstLinkedProducts.setEnabled(false);
        int iSupplierSelected;
        if((iSupplierSelected = this.lstLinkSupplier.getSelectedIndex()) != -1)
            this.cSuppliers.linkedProducts(this.aSuppliersIndexes.get(iSupplierSelected), this.lstLinkedProducts, this.lblLinkedProducts);
    }//GEN-LAST:event_lstLinkSupplierMouseClicked

    private void txtProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusGained
        if(this.txtProductName.getText().equals("*")){
            this.txtProductName.setText("");
            this.txtProductName.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductNameFocusGained

    private void txtProductNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusLost
        if(this.txtProductName.getText().isEmpty()){
            this.txtProductName.setText("*");
            this.txtProductName.setForeground(Color.RED);
        } else {
            String strName = this.txtProductName.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductName.setText("*");
                this.txtProductName.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductNameFocusLost

    private void txtProductBrandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductBrandFocusGained
        if(this.txtProductBrand.getText().equals("*")){
            this.txtProductBrand.setText("");
            this.txtProductBrand.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductBrandFocusGained

    private void txtProductBrandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductBrandFocusLost
        if(this.txtProductBrand.getText().isEmpty()){
            this.txtProductBrand.setText("*");
            this.txtProductBrand.setForeground(Color.RED);
        } else {
            String strName = this.txtProductBrand.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductBrand.setText("*");
                this.txtProductBrand.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductBrandFocusLost

    private void txtProductPresentationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPresentationFocusGained
        if(this.txtProductPresentation.getText().equals("*")){
            this.txtProductPresentation.setText("");
            this.txtProductPresentation.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductPresentationFocusGained

    private void txtProductPresentationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPresentationFocusLost
        if(this.txtProductPresentation.getText().isEmpty()){
            this.txtProductPresentation.setText("*");
            this.txtProductPresentation.setForeground(Color.RED);
        } else {
            String strName = this.txtProductPresentation.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!((strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z') || strName.charAt(i) == ' ' || strName.charAt(i) == '.'  || (strName.charAt(i) >= '0' && strName.charAt(i) <= '9'))){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductPresentation.setText("*");
                this.txtProductPresentation.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductPresentationFocusLost

    private void txtProductStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductStockFocusGained
        if(this.txtProductStock.getText().equals("*")){
            this.txtProductStock.setText("");
            this.txtProductStock.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductStockFocusGained

    private void txtProductStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductStockFocusLost
        if(this.txtProductStock.getText().isEmpty()){
            this.txtProductStock.setText("*");
            this.txtProductStock.setForeground(Color.RED);
        } else {
            String strName = this.txtProductStock.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductStock.setText("*");
                this.txtProductStock.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductStockFocusLost

    private void txtProductPriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPriceFocusGained
        if(this.txtProductPrice.getText().equals("*")){
            this.txtProductPrice.setText("");
            this.txtProductPrice.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductPriceFocusGained

    private void txtProductPriceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPriceFocusLost
        if(this.txtProductPrice.getText().isEmpty()){
            this.txtProductPrice.setText("*");
            this.txtProductPrice.setForeground(Color.RED);
        } else {
            String strName = this.txtProductPrice.getText().toLowerCase();
            boolean bState = true;
            
            try { 
                Double.parseDouble(strName); 
            } catch(NumberFormatException cException) { 
                bState = false;
            } 
            
            if(!bState){
                this.txtProductPrice.setText("*");
                this.txtProductPrice.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductPriceFocusLost

    private void txtNameSearchProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchProductFocusGained
        if(this.txtNameSearchProduct.getText().equals("Ingrese Nombre de Producto")){
            this.txtNameSearchProduct.setText("");
            this.txtNameSearchProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchProductFocusGained

    private void txtNameSearchProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchProductFocusLost
        if(this.txtNameSearchProduct.getText().isEmpty()) {
            this.txtNameSearchProduct.setText("Ingrese Nombre de Producto");
            this.txtNameSearchProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchProductFocusLost

    private void txtNameSearchTicketFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchTicketFocusGained
        if(this.txtNameSearchTicket.getText().equals("Ingrese Número de la Boleta")){
            this.txtNameSearchTicket.setText("");
            this.txtNameSearchTicket.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchTicketFocusGained

    private void txtNameSearchTicketFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameSearchTicketFocusLost
        if(this.txtNameSearchTicket.getText().isEmpty()) {
            this.txtNameSearchTicket.setText("Ingrese Número de la Boleta");
            this.txtNameSearchTicket.setFont(new Font("Tahoma", Font.PLAIN, 11));
        }
    }//GEN-LAST:event_txtNameSearchTicketFocusLost

    private void btnStoreReportProdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnStoreReportProdFocusLost
        // Check it after 
    }//GEN-LAST:event_btnStoreReportProdFocusLost

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        this.btnHome.setText("");
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        this.btnHome.setText("Principal");
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnUsersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseEntered
        this.btnUsers.setText("");
    }//GEN-LAST:event_btnUsersMouseEntered

    private void btnUsersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsersMouseExited
        this.btnUsers.setText("Usuarios");
    }//GEN-LAST:event_btnUsersMouseExited

    private void btnHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMouseEntered
        this.btnHelp.setText("");
    }//GEN-LAST:event_btnHelpMouseEntered

    private void btnHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMouseExited
        this.btnHelp.setText("AYUDA");
    }//GEN-LAST:event_btnHelpMouseExited

    private void btnSuppliersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppliersMouseEntered
        this.btnSuppliers.setText("");
    }//GEN-LAST:event_btnSuppliersMouseEntered

    private void btnSuppliersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppliersMouseExited
        this.btnSuppliers.setText("Proveedores");
    }//GEN-LAST:event_btnSuppliersMouseExited

    private void btnProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseEntered
        this.btnProducts.setText("");
    }//GEN-LAST:event_btnProductsMouseEntered

    private void btnProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductsMouseExited
        this.btnProducts.setText("Productos");
    }//GEN-LAST:event_btnProductsMouseExited

    private void btnStoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStoreMouseEntered
        this.btnStore.setText("");
    }//GEN-LAST:event_btnStoreMouseEntered

    private void btnStoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStoreMouseExited
        this.btnStore.setText("Inventario");
    }//GEN-LAST:event_btnStoreMouseExited

    private void btnSaleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseEntered
        this.btnSale.setText("");
    }//GEN-LAST:event_btnSaleMouseEntered

    private void btnSaleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaleMouseExited
        this.btnSale.setText("Venta");
    }//GEN-LAST:event_btnSaleMouseExited

    private void txtProductNameStoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameStoreFocusGained
        if(this.txtProductName.getText().equals("*")){
            this.txtProductName.setText("");
            this.txtProductName.setForeground(Color.BLACK);
        }        
    }//GEN-LAST:event_txtProductNameStoreFocusGained

    private void txtProductNameStoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameStoreFocusLost
        if(this.txtProductNameStore.getText().isEmpty()){
            this.txtProductNameStore.setText("*");
            this.txtProductNameStore.setForeground(Color.RED);
        } else {
            String strName = this.txtProductNameStore.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductNameStore.setText("*");
                this.txtProductNameStore.setForeground(Color.RED);
            }            
        }        
    }//GEN-LAST:event_txtProductNameStoreFocusLost

    private void txtProductBrandStoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductBrandStoreFocusGained
        if(this.txtProductBrandStore.getText().equals("*")){
            this.txtProductBrandStore.setText("");
            this.txtProductBrandStore.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductBrandStoreFocusGained

    private void txtProductBrandStoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductBrandStoreFocusLost
        if(this.txtProductBrandStore.getText().isEmpty()){
            this.txtProductBrandStore.setText("*");
            this.txtProductBrandStore.setForeground(Color.RED);
        } else {
            String strName = this.txtProductBrandStore.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductBrandStore.setText("*");
                this.txtProductBrandStore.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductBrandStoreFocusLost

    private void txtProductPresentationStoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPresentationStoreFocusGained
        if(this.txtProductPresentationStore.getText().equals("*")){
            this.txtProductPresentationStore.setText("");
            this.txtProductPresentationStore.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductPresentationStoreFocusGained

    private void txtProductPresentationStoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPresentationStoreFocusLost
        if(this.txtProductPresentationStore.getText().isEmpty()){
            this.txtProductPresentationStore.setText("*");
            this.txtProductPresentationStore.setForeground(Color.RED);
        } else {
            String strName = this.txtProductPresentationStore.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!((strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z') || strName.charAt(i) == ' ' || strName.charAt(i) == '.'  || (strName.charAt(i) >= '0' && strName.charAt(i) <= '9'))){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductPresentationStore.setText("*");
                this.txtProductPresentationStore.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductPresentationStoreFocusLost

    private void txtProductStockStoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductStockStoreFocusGained
        if(this.txtProductStockStore.getText().equals("*")){
            this.txtProductStockStore.setText("");
            this.txtProductStockStore.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductStockStoreFocusGained

    private void txtProductStockStoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductStockStoreFocusLost
        if(this.txtProductStockStore.getText().isEmpty()){
            this.txtProductStockStore.setText("*");
            this.txtProductStockStore.setForeground(Color.RED);
        } else {
            String strName = this.txtProductStockStore.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= '0' && strName.charAt(i) <= '9')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState){
                this.txtProductStockStore.setText("*");
                this.txtProductStockStore.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductStockStoreFocusLost

    private void txtProductPriceStoreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPriceStoreFocusGained
        if(this.txtProductPriceStore.getText().equals("*")){
            this.txtProductPriceStore.setText("");
            this.txtProductPriceStore.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtProductPriceStoreFocusGained

    private void txtProductPriceStoreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductPriceStoreFocusLost
        if(this.txtProductPriceStore.getText().isEmpty()){
            this.txtProductPriceStore.setText("*");
            this.txtProductPriceStore.setForeground(Color.RED);
        } else {
            String strName = this.txtProductPriceStore.getText().toLowerCase();
            boolean bState = true;
            
            try { 
                Double.parseDouble(strName); 
            } catch(NumberFormatException cException) { 
                bState = false;
            } 
            
            if(!bState){
                this.txtProductPriceStore.setText("*");
                this.txtProductPriceStore.setForeground(Color.RED);
            }            
        }
    }//GEN-LAST:event_txtProductPriceStoreFocusLost

    private void btnShowPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowPassMousePressed
        String strPassword = String.valueOf(this.tfpPass.getPassword());
        this.lblShowPass.setText(strPassword);
    }//GEN-LAST:event_btnShowPassMousePressed

    private void btnShowPassMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowPassMouseReleased
        this.lblShowPass.setText("");
    }//GEN-LAST:event_btnShowPassMouseReleased

    private void txtSaleOrderClientFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSaleOrderClientFocusLost
        if(!this.txtSaleOrderClient.getText().isEmpty()){
            String strName = this.txtSaleOrderClient.getText().toLowerCase();
            boolean bState = true;
            for(int i = 0;i < strName.length();i++){
                if(!(strName.charAt(i) >= 'a' && strName.charAt(i) <= 'z' || strName.charAt(i) == ' ')){
                    bState = false;
                    break;
                }
            }
            
            if(!bState)
                this.txtProductNameStore.setText("");
        }
    }//GEN-LAST:event_txtSaleOrderClientFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateReport;
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
    private javax.swing.JButton btnShowPass;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbProductName;
    private javax.swing.JLabel lbProductNameStore;
    private javax.swing.JLabel lblForgottenPass;
    private javax.swing.JLabel lblGeneral;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImgLog;
    private javax.swing.JLabel lblLinkProducts;
    private javax.swing.JLabel lblLinkSupplier;
    private javax.swing.JLabel lblLinkSupplierTitle;
    private javax.swing.JLabel lblLinkedProducts;
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
    private javax.swing.JLabel lblShowPass;
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
    private javax.swing.JList lstLinkedProducts;
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
    private javax.swing.JScrollPane scpLinkedProducts;
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
    private javax.swing.JPasswordField tfpPass;
    private javax.swing.JTextArea txaUserOthers;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLinkSupplier;
    private javax.swing.JTextField txtNameSearchProduct;
    private javax.swing.JTextField txtNameSearchSupplier;
    private javax.swing.JTextField txtNameSearchTicket;
    private javax.swing.JTextField txtNameSearchUser;
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
    
    private void cleanUserAdd(){
        this.txtUserName.setText("*");
        this.txtUserName.setForeground(Color.RED);
        this.txtUserFatherLastName.setText("*");
        this.txtUserFatherLastName.setForeground(Color.RED);
        this.txtUserMotherLastName.setText("*");
        this.txtUserMotherLastName.setForeground(Color.RED);
        this.txtUserNi.setText("*");
        this.txtUserNi.setForeground(Color.RED);
        this.txtUserAddress.setText("*");
        this.txtUserAddress.setForeground(Color.RED);
        this.txtUserCellphone.setText("*");
        this.txtUserCellphone.setForeground(Color.RED);
        this.txtUserEmail.setText("*");
        this.txtUserEmail.setForeground(Color.RED);
        this.txtUserEmergencyNumber.setText("*");
        this.txtUserEmergencyNumber.setForeground(Color.RED);
        this.txaUserOthers.setText("");
        this.cbxUserGender.removeAllItems();
        this.cbxUserPosition.removeAllItems();
    }
    
    private void cleanUserSearch(){
        this.txtNameSearchUser.setText("Ingrese Nombre de Usuario");
        this.txtNameSearchUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
                        
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultUser.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultUser.removeAll();
        this.tblResultUser.clearSelection();
    }
    
    private void cleanSupplierAdd(){
        this.txtSupplierName.setText("*");
        this.txtSupplierName.setForeground(Color.RED);
        this.txtSupplierTr.setText("*");
        this.txtSupplierTr.setForeground(Color.RED);
        this.txtSupplierAddress.setText("*");
        this.txtSupplierAddress.setForeground(Color.RED);
        this.txtSupplierPhone.setText("*");
        this.txtSupplierPhone.setForeground(Color.RED);
    }
    
    private void cleanSupplierSearch(){
        this.txtNameSearchSupplier.setText("Ingrese Nombre de Proveedor");
        this.txtNameSearchSupplier.setFont(new Font("Tahoma", Font.PLAIN, 11));
                        
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultSupplier.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultSupplier.removeAll();
        this.tblResultSupplier.clearSelection();
    }
    
    private void cleanLinkSupplier(){
        this.txtLinkSupplier.setText("Ingrese Nombre de Proveedor");
        this.txtLinkSupplier.setFont(new Font("Tahoma", Font.PLAIN, 11));
                    
        this.lstLinkSupplier.setModel((new DefaultListModel()));
        this.lstLinkedProducts.setModel((new DefaultListModel()));
    }
    
    private void cleanProductAdd(){
        this.txtProductName.setText("*");
        this.txtProductName.setForeground(Color.RED);
        this.txtProductBrand.setText("*");
        this.txtProductBrand.setForeground(Color.RED);
        this.txtProductPresentation.setText("*");
        this.txtProductPresentation.setForeground(Color.RED);
        this.txtProductStock.setText("*");
        this.txtProductStock.setForeground(Color.RED);
        this.txtProductPrice.setText("*");
        this.txtProductPrice.setForeground(Color.RED);
    }
    
    private void cleanProductSearch(){
        this.txtNameSearchProduct.setText("Ingrese Nombre de Producto");
        this.txtNameSearchProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
                        
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultProduct.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultProduct.removeAll();
        this.tblResultProduct.clearSelection();
    }
    
    private void cleanTicketSearch(){
        this.txtNameSearchTicket.setText("Ingrese Número de la Boleta");
        this.txtNameSearchTicket.setFont(new Font("Tahoma", Font.PLAIN, 11));
                        
        DefaultTableModel cModel = (DefaultTableModel) this.tblResultTicket.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblResultTicket.removeAll();
        this.tblResultTicket.clearSelection();
    }
    
    private void cleanSale(){
        this.txtSaleOrderClient.setText("");
        this.lblSaleOrderNumber.setText("");
        this.lblSaleOrderTotalOn.setText("S/. 0,00");
        this.dTtotal = 0.0;

        DefaultTableModel cModel = (DefaultTableModel) tblSaleOrderTable.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblSaleOrderTable.removeAll();
        this.tblSaleOrderTable.clearSelection();
        
        cModel = (DefaultTableModel) tblSaleSearchProduct.getModel();
        cModel.getDataVector().removeAllElements();
        this.tblSaleSearchProduct.removeAll();
        this.tblSaleSearchProduct.clearSelection();       
    }
}