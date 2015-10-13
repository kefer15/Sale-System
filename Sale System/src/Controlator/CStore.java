package Controlator;

import Interface.IStore;
import Model.Category;
import Model.Products;
import Model.ProofOfPayment;
import Model.Users;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class CStore implements IStore {
    private ArrayList <String> aryCategoriesIndexes;
    
    /*
        Fills all Categories into cbxCategory and links the información of each register with 
        each index of aryCategoriesIndexes.
    */
    private void fill(JComboBox cbxCategory) {
        ArrayList <Category> aryCategories = (new Category()).getList();
        aryCategoriesIndexes = new ArrayList <> ();
        
        aryCategories.stream().map((cCategory) -> {
            cbxCategory.addItem(cCategory.getDescription());
            return cCategory;
        }).forEach((cCategory) -> {
            aryCategoriesIndexes.add(cCategory.getCode());
        });
    }
    
    @Override
    public void changeProductSearch(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlStoreSearchPro");
    }
    
    @Override
    public void changeTicketSearch(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlStoreSearchTic");
    }
    
    @Override
    public void changeReportSale(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlStoreSaleReport");
    }
    
    @Override
    public void changeInventStore(CardLayout crdCard, JPanel pnlPanle, JTable tblTable) {
        crdCard.show(pnlPanle, "pnlStoreInvent");
        
        ArrayList <Products> aryProducts = (new Products()).getList(1, null, null);
        
        DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
        cModel.getDataVector().removeAllElements();
        
        aryProducts.stream().forEach((cProduct) -> {
            cModel.addRow(new Object[]{cProduct.getCode(), cProduct.getName(), cProduct.getBrand(), cProduct.getPresentation(), cProduct.getCategory(), cProduct.getStock(), cProduct.getPrice()});
        });
    }
    
    @Override
    public void changeModify(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlStoreModifyPro");
    }
    
    @Override
    public ArrayList <String> searchProduct(JTextField txtName, JTable tblTable) {
        ArrayList <Products> aryProducts = (new Products()).getList(2, null, txtName.getText());
        ArrayList <String> aryProductsIndexes = new ArrayList <>();
        
        if(!aryProducts.isEmpty()) {            
            DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
            cModel.getDataVector().removeAllElements();
            
            aryProducts.stream().map((cProduct) -> {
                cModel.addRow(new Object[]{cProduct.getStock(), cProduct.getName() + " " + cProduct.getBrand() + " " + cProduct.getPresentation(), cProduct.getPrice()});
                return cProduct;
            }).forEach((cProduct) -> {
                aryProductsIndexes.add(cProduct.getCode());
            });
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay usuarios para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return aryProductsIndexes;
    }
    
    @Override
    public String send(String strCode, JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtStock, 
            JComboBox cbxCategory, JTextField txtPrice) {        
        ArrayList <Products> aryProduct = (new Products()).getList(0, strCode, null);
        
        txtName.setText(aryProduct.get(0).getName());
        txtBrand.setText(aryProduct.get(0).getBrand());
        txtPresentation.setText(aryProduct.get(0).getPresentation());
        txtStock.setText(aryProduct.get(0).getStock());
        txtPrice.setText(aryProduct.get(0).getPrice());
        
        cbxCategory.removeAllItems();
        fill(cbxCategory);
                
        cbxCategory.setSelectedIndex(aryCategoriesIndexes.indexOf(aryProduct.get(0).getCategory()));
        
        return aryProduct.get(0).getCode();
    }
    
    @Override
    public void actProduct(String strCode, JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtStock, 
            JComboBox cbxCategory, JTextField txtPrice) {
        Products product = new Products();
        
        product.setCode(strCode);
        product.setName(txtName.getText());
        product.setBrand(txtBrand.getText());
        product.setPresentation(txtPresentation.getText());
        product.setStock(txtStock.getText());
        product.setCategory(aryCategoriesIndexes.get(cbxCategory.getSelectedIndex()));
        product.setPrice(txtPrice.getText());
        
        String strError = product.update();
        if(strError.equals(""))
            JOptionPane.showMessageDialog(  null, 
                                            "Los datos han sido modificados correctamente.", 
                                            "Modificar Producto", 
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null, 
                                            strError, 
                                            "Modificar Producto", 
                                            JOptionPane.WARNING_MESSAGE);
    }
    
    @Override
    public void chargeProduct(JTable tblTable, JComboBox cbxCombo) {
        ArrayList <Products> aryProducts = null;
        
        switch(cbxCombo.getSelectedIndex()){
            case 0: aryProducts = (new Products()).getList(1, null, null);
                    break;
                
            case 1: aryProducts = (new Products()).getList(6, null, null);
                    break;
                
            case 2: aryProducts = (new Products()).getList(7, null, null);
                    break;
        }
        
        DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
        cModel.getDataVector().removeAllElements();
        
        for (Products cProduct : aryProducts) {
            cModel.addRow(new Object[]{cProduct.getCode(), cProduct.getName(), cProduct.getBrand(), cProduct.getPresentation(), cProduct.getCategory(), cProduct.getStock(), cProduct.getPrice()});
        }
    }
    
    @Override
    public ArrayList <String> searchTicket(JTextField txtNumber, JTable tblTable) {
        ArrayList <String> aryTicketsIndexes = new ArrayList <>();
        ArrayList <ProofOfPayment> aryTickets = (new ProofOfPayment()).getList(txtNumber.getText());
        DecimalFormat cFormat = new DecimalFormat("00000000000");
        
        if(!aryTickets.isEmpty()) {            
            DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
            cModel.getDataVector().removeAllElements();
            
            for (ProofOfPayment cTicket : aryTickets) {
                cModel.addRow(new Object[]{cTicket.getCode(), cTicket.getAmount(), cTicket.getDate()});                
                aryTicketsIndexes.add("N° " + String.valueOf(cFormat.format(Integer.parseInt(cTicket.getCode()))));
            }
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay Comprobantes de Venta para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return aryTicketsIndexes;
    }
    
    @Override
    public boolean productReport(Users cUser) {
        JFileChooser fcsSave = new JFileChooser();
        fcsSave.setDialogTitle("Guardar Reporte PDF");

        FileFilter cFilter = new FileNameExtensionFilter("Archivo PDF","pdf");
        fcsSave.setAcceptAllFileFilterUsed(false);
        fcsSave.setFileFilter(cFilter);
        
        int iOption = fcsSave.showSaveDialog(null);

        if(iOption == JFileChooser.APPROVE_OPTION) {
            try {
                Document cDocument = new Document();
                String strPath = "" + fcsSave.getSelectedFile().getAbsoluteFile()+ "";
                
                if(!strPath.substring(strPath.length() - 3, strPath.length()).equals("pdf"))
                    strPath = strPath +".pdf";
                
                PdfWriter.getInstance(cDocument, new FileOutputStream(strPath));
                cDocument.open();

                Paragraph cParagraph = new Paragraph("SISTEMA DE VENTAS PARA UNA TIENDA DE ABARROTES\n\n",FontFactory.getFont(FontFactory.COURIER,10,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_CENTER);
                cDocument.add(cParagraph);
                
                cParagraph = new Paragraph("X & G CENTENO\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_CENTER);
                cDocument.add(cParagraph);

                PdfPTable cTable = new PdfPTable(1);

                PdfPCell cCell = new PdfPCell(new Paragraph("REPORTE DE INVENTARIO", FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD,BaseColor.WHITE)));
                cCell.setFixedHeight(50);
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cTable.addCell(cCell);
                cDocument.add(cTable);

                cParagraph = new Paragraph("\n");
                cDocument.add(cParagraph);
                
                SimpleDateFormat cFormat = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
                
                cParagraph = new Paragraph("Fecha: " + cFormat.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_RIGHT);
                cDocument.add(cParagraph);
                
                cFormat = new SimpleDateFormat("hh:mm aa");

                cParagraph = new Paragraph("Hora: " + cFormat.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_RIGHT);
                cDocument.add(cParagraph);

                cParagraph = new Paragraph("Administrador: " + cUser.getName() + " " + cUser.getFatherLastName() + " " + cUser.getMotherLastName() + "\n\n",FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_LEFT);
                cDocument.add(cParagraph);
                
                ArrayList <Products> aryProducts = (new Products()).getList(1, null, null);
                
                cTable = new PdfPTable(6);

                cCell = new PdfPCell(new Paragraph("Código", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Marca", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Categoría", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Stock", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Precio", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);

                for (Products cProduct : aryProducts) {
                    if (Integer.parseInt(cProduct.getStock()) <= 10) {
                        cCell = new PdfPCell(new Paragraph(cProduct.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.RED);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getName(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.RED);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getBrand(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.RED);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getCategory(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.RED);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getStock(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.RED);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getPrice(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.RED);
                        cTable.addCell(cCell);
                    } else if(Integer.parseInt(cProduct.getStock()) >= 50){
                        cCell = new PdfPCell(new Paragraph(cProduct.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getName(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getBrand(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getCategory(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getStock(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getPrice(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                    } else {
                        cCell = new PdfPCell(new Paragraph(cProduct.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getName(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getBrand(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getCategory(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getStock(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cProduct.getPrice(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                    }
                }
                cDocument.add(cTable);                
                cDocument.close();
                
                return true;                
            } catch (DocumentException | IOException cException) {
                return false;
            }            
        }
        
        return false;
    }
    
    @Override
    public boolean saleReport(Users cUser ,JCalendar cldStart, JCalendar cldEnd) {
        JFileChooser fcsSave = new JFileChooser();
        fcsSave.setDialogTitle("Guardar Reporte PDF");

        FileFilter cFilter = new FileNameExtensionFilter("Archivo PDF","pdf");
        fcsSave.setAcceptAllFileFilterUsed(false);
        fcsSave.setFileFilter(cFilter);
        
        int iOption = fcsSave.showSaveDialog(null);

        if(iOption == JFileChooser.APPROVE_OPTION)
        {
            try {
                Document cDocument = new Document();
                String cPath = "" + fcsSave.getSelectedFile().getAbsoluteFile()+ "";
                
                if(!cPath.substring(cPath.length() - 3, cPath.length()).equals("pdf"))
                    cPath = cPath +".pdf";
                
                PdfWriter.getInstance(cDocument, new FileOutputStream(cPath));
                cDocument.open();

                Paragraph cParagraph = new Paragraph("SISTEMA DE VENTAS PARA UNA TIENDA DE ABARROTES\n\n",FontFactory.getFont(FontFactory.COURIER,10,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_CENTER);
                cDocument.add(cParagraph);
                
                cParagraph = new Paragraph("X & G CENTENO\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_CENTER);
                cDocument.add(cParagraph);

                PdfPTable cTable = new PdfPTable(1);

                PdfPCell cCell = new PdfPCell(new Paragraph("REPORTE DE VENTAS", FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD,BaseColor.WHITE)));
                cCell.setFixedHeight(50);
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cTable.addCell(cCell);
                cDocument.add(cTable);

                cParagraph = new Paragraph("\n");
                cDocument.add(cParagraph);
                
                SimpleDateFormat cFormat = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
                
                cParagraph = new Paragraph("Fecha: " + cFormat.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_RIGHT);
                cDocument.add(cParagraph);
                
                cFormat = new SimpleDateFormat("hh:mm aa");

                cParagraph = new Paragraph("Hora: " + cFormat.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_RIGHT);
                cDocument.add(cParagraph);

                cParagraph = new Paragraph("Administrador: " + cUser.getName() + " " + cUser.getFatherLastName() + " " + cUser.getMotherLastName() + "\n\n",FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_LEFT);
                cDocument.add(cParagraph);
                
                cFormat = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
                
                cParagraph = new Paragraph("Periodo de Inicio: " + cFormat.format(cldStart.getCalendar().getTime()),FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_LEFT);
                cDocument.add(cParagraph);
                
                cParagraph = new Paragraph("Periodo de Fin: " + cFormat.format(cldEnd.getCalendar().getTime()) + "\n\n",FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_LEFT);
                cDocument.add(cParagraph);
                
                cParagraph = new Paragraph("INGRESOS GENERALES\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_CENTER);
                cDocument.add(cParagraph);
                
                cFormat = new SimpleDateFormat("yyyy/MM/dd");
                
                ArrayList <ProofOfPayment> aryTickets = (new ProofOfPayment()).getList(cFormat.format(cldStart.getCalendar().getTime()), cFormat.format(cldEnd.getCalendar().getTime()));                
                cTable = new PdfPTable(4);

                cCell = new PdfPCell(new Paragraph("Código", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Monto", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                DecimalFormat cFormatMoney = new DecimalFormat("#.##");
                
                for (ProofOfPayment cTicket : aryTickets) {
                    if (Double.parseDouble(cTicket.getAmount()) >= 50) {
                        cCell = new PdfPCell(new Paragraph(cTicket.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph("S/. " + cFormatMoney.format(Double.parseDouble(cTicket.getAmount())), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cTicket.getDate(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cTicket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.BLUE);
                        cTable.addCell(cCell);
                    } else {
                        cCell = new PdfPCell(new Paragraph(cTicket.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph("S/. " + cFormatMoney.format(Double.parseDouble(cTicket.getAmount())), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cTicket.getDate(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        
                        cCell = new PdfPCell(new Paragraph(cTicket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                    }
                }
                cDocument.add(cTable);
                
                cParagraph = new Paragraph("\nGANACIAS OBTENIDAS POR USUARIOS\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                cParagraph.setAlignment(Element.ALIGN_CENTER);
                cDocument.add(cParagraph);
                
                aryTickets = (new ProofOfPayment()).getUsersMount(cFormat.format(cldStart.getCalendar().getTime()), cFormat.format(cldEnd.getCalendar().getTime()));                
                cTable = new PdfPTable(2);

                cCell = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                cCell = new PdfPCell(new Paragraph("Monto Gando", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cCell.setBackgroundColor(BaseColor.BLACK);
                cCell.setBorderColor(BaseColor.WHITE);
                cCell.setFixedHeight(30);
                cTable.addCell(cCell);
                
                for (ProofOfPayment cTicket : aryTickets) {
                    if (Double.parseDouble(cTicket.getAmount()) >= 200) {
                        cCell = new PdfPCell(new Paragraph(cTicket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.MAGENTA);
                        cTable.addCell(cCell);
                        cCell = new PdfPCell(new Paragraph("S/. " + cFormatMoney.format(Double.parseDouble(cTicket.getAmount())), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cCell.setBackgroundColor(BaseColor.MAGENTA);
                        cTable.addCell(cCell);                        
                    } else {
                        cCell = new PdfPCell(new Paragraph(cTicket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                        cCell = new PdfPCell(new Paragraph(cTicket.getAmount(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cCell.setFixedHeight(20);
                        cTable.addCell(cCell);
                    }
                }
                cDocument.add(cTable);                
                cDocument.close();
                return true;                
            } catch (DocumentException | IOException cException) {
                return false;
            }            
        }
        
        return false;
    }
}