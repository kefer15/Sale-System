package Controlador;

import Modelo.Category;
import Modelo.Products;
import Modelo.ProofOfPayment;
import Modelo.Users;
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

public class CStore implements IStore{
    private ArrayList <String> categoriesInd;
    
    private void fill(JComboBox category){
         ArrayList <Category> categories = (new Category()).getList();
        categoriesInd = new ArrayList <> ();
        
        for (Category categoryAux : categories) {
            category.addItem(categoryAux.getDescription());
            categoriesInd.add(categoryAux.getCode());
        }
    }
    
    @Override
    public void changeProductSearch(CardLayout card, JPanel panel){
        card.show(panel, "pnlStoreSearchPro");
    }
    
    @Override
    public void changeTicketSearch(CardLayout card, JPanel panel){
        card.show(panel, "pnlStoreSearchTic");
    }
    
    @Override
    public void changeReportSale(CardLayout card, JPanel panel){
        card.show(panel, "pnlStoreSaleReport");
    }
    
    @Override
    public void changeInventStore(CardLayout card, JPanel panel, JTable table){
        card.show(panel, "pnlStoreInvent");
        
        ArrayList <Products> products = (new Products()).getList(1, null, null);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        for (Products product : products) {
            model.addRow(new Object[]{product.getCode(), product.getName(), product.getBrand(), product.getPresentation(), product.getCategory(), product.getStock(), product.getPrice()});
        }
    }
    
    @Override
    public void changeModify(CardLayout card, JPanel panel){
        card.show(panel, "pnlStoreModifyPro");
    }
    
    @Override
    public ArrayList <String> searchProduct(JTextField name, JTable table){
        ArrayList <String> productsInd = new ArrayList <>();
        ArrayList <Products> products = (new Products()).getList(2, null, name.getText());
        
        if(!products.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.getDataVector().removeAllElements();
            for (Products product : products) {
                model.addRow(new Object[]{product.getStock(), product.getName() + " " + product.getBrand() + " " + product.getPresentation(), product.getPrice()});
                productsInd.add(product.getCode());
            }
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay usuarios para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return productsInd;
    }
    
    @Override
    public String sendProduct(String code, JTextField name, JTextField brand, JTextField presentation, JTextField stock, 
            JComboBox category, JTextField price){
        
        ArrayList <Products> product = (new Products()).getList(0, code, null);
        
        name.setText(product.get(0).getName());
        brand.setText(product.get(0).getBrand());
        presentation.setText(product.get(0).getPresentation());
        stock.setText(product.get(0).getStock());
        price.setText(product.get(0).getPrice());
        
        category.removeAllItems();
        fill(category);
                
        category.setSelectedIndex(categoriesInd.indexOf(product.get(0).getCategory()));
        
        return product.get(0).getCode();
    }
    
    @Override
    public void actProduct(String code, JTextField name, JTextField brand, JTextField presentation, JTextField stock, 
            JComboBox category, JTextField price){
        Products product = new Products();
        
        product.setCode(code);
        product.setName(name.getText());
        product.setBrand(brand.getText());
        product.setPresentation(presentation.getText());
        product.setStock(stock.getText());
        product.setCategory(categoriesInd.get(category.getSelectedIndex()));
        product.setPrice(price.getText());
        
        String error = product.update();
        if(error.equals(""))
            JOptionPane.showMessageDialog(  null, 
                                            "Los datos han sido modificados correctamente.", 
                                            "Modificar Producto", 
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null, 
                                            error, 
                                            "Modificar Producto", 
                                            JOptionPane.WARNING_MESSAGE);
    }
    
    @Override
    public void chargeProduct(JTable table, JComboBox combo){
        ArrayList <Products> products = null;
        
        switch(combo.getSelectedIndex()){
            case 0: products = (new Products()).getList(1, null, null);
                    break;
                
            case 1: products = (new Products()).getList(6, null, null);
                    break;
                
            case 2: products = (new Products()).getList(7, null, null);
                    break;
        }
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        for (Products product : products) {
            model.addRow(new Object[]{product.getCode(), product.getName(), product.getBrand(), product.getPresentation(), product.getCategory(), product.getStock(), product.getPrice()});
        }
    }
    
    @Override
    public ArrayList <String> searchTicket(JTextField number, JTable table){
        ArrayList <String> ticketsInd = new ArrayList <>();
        ArrayList <ProofOfPayment> tickets = (new ProofOfPayment()).getList(number.getText());
        DecimalFormat format = new DecimalFormat("00000000000");
        
        if(!tickets.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.getDataVector().removeAllElements();
            for (ProofOfPayment ticket : tickets) {
                model.addRow(new Object[]{ticket.getCode(), ticket.getAmount(), ticket.getDate()});                
                ticketsInd.add("N° " + String.valueOf(format.format(Integer.parseInt(ticket.getCode()))));
            }
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay Comprobantes de Venta para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return ticketsInd;
    }
    
    @Override
    public boolean productReport(Users user){
        JFileChooser save = new JFileChooser();
        save.setDialogTitle("Guardar Reporte PDF");

        FileFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf");
        save.setAcceptAllFileFilterUsed(false);
        save.setFileFilter(filter);
        
        int option = save.showSaveDialog(null);

        if(option == JFileChooser.APPROVE_OPTION)
        {
            try {
                Document doc = new Document();
                String path = "" + save.getSelectedFile().getAbsoluteFile()+ "";
                System.out.println("PATH " + path);
                
                if(!path.substring(path.length() - 3, path.length()).equals("pdf"))
                    path = path +".pdf";
                
                PdfWriter.getInstance(doc, new FileOutputStream(path));
                doc.open();

                Paragraph prg = new Paragraph("SISTEMA DE VENTAS PARA UNA TIENDA DE ABARROTES\n\n",FontFactory.getFont(FontFactory.COURIER,10,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_CENTER);
                doc.add(prg);
                
                prg = new Paragraph("X & G CENTENO\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_CENTER);
                doc.add(prg);

                PdfPTable tba = new PdfPTable(1);

                PdfPCell cell = new PdfPCell(new Paragraph("REPORTE DE INVENTARIO", FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD,BaseColor.WHITE)));
                cell.setFixedHeight(50);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                tba.addCell(cell);
                doc.add(tba);

                prg = new Paragraph("\n");
                doc.add(prg);
                
                SimpleDateFormat format1 = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
                SimpleDateFormat format2 = new SimpleDateFormat("hh:mm aa");
                
                prg = new Paragraph("Fecha: " + format1.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_RIGHT);
                doc.add(prg);

                prg = new Paragraph("Hora: " + format2.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_RIGHT);
                doc.add(prg);

                prg = new Paragraph("Administrador: " + user.getName() + " " + user.getFatherLastName() + " " + user.getMotherLastName() + "\n\n",FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_LEFT);
                doc.add(prg);
                
                ArrayList <Products> products = (new Products()).getList(1, null, null);
                
                tba = new PdfPTable(6);

                cell = new PdfPCell(new Paragraph("Código", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Nombre", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Marca", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Categoría", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Stock", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Precio", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);

                for (Products product : products) {
                    if (Integer.parseInt(product.getStock()) <= 10) {
                        cell = new PdfPCell(new Paragraph(product.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.RED);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getName(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.RED);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getBrand(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.RED);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getCategory(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.RED);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getStock(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.RED);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getPrice(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.RED);
                        tba.addCell(cell);
                    } else if(Integer.parseInt(product.getStock()) >= 50){
                        cell = new PdfPCell(new Paragraph(product.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getName(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getBrand(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getCategory(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getStock(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getPrice(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                    } else {
                        cell = new PdfPCell(new Paragraph(product.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getName(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getBrand(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getCategory(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getStock(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(product.getPrice(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                    }
                }
                doc.add(tba);
                
                doc.close();
                return true;                
            } catch (DocumentException | IOException ex) {
                return false;
            }            
        }
        
        return false;
    }
    
    @Override
    public boolean saleReport(Users user, JCalendar start, JCalendar end){
        JFileChooser save = new JFileChooser();
        save.setDialogTitle("Guardar Reporte PDF");

        FileFilter filter = new FileNameExtensionFilter("Archivo PDF","pdf");
        save.setAcceptAllFileFilterUsed(false);
        save.setFileFilter(filter);
        
        int option = save.showSaveDialog(null);

        if(option == JFileChooser.APPROVE_OPTION)
        {
            try {
                Document doc = new Document();
                String path = "" + save.getSelectedFile().getAbsoluteFile()+ "";
                System.out.println("PATH " + path);
                
                if(!path.substring(path.length() - 3, path.length()).equals("pdf"))
                    path = path +".pdf";
                
                PdfWriter.getInstance(doc, new FileOutputStream(path));
                doc.open();

                Paragraph prg = new Paragraph("SISTEMA DE VENTAS PARA UNA TIENDA DE ABARROTES\n\n",FontFactory.getFont(FontFactory.COURIER,10,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_CENTER);
                doc.add(prg);
                
                prg = new Paragraph("X & G CENTENO\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_CENTER);
                doc.add(prg);

                PdfPTable tba = new PdfPTable(1);

                PdfPCell cell = new PdfPCell(new Paragraph("REPORTE DE VENTAS", FontFactory.getFont(FontFactory.COURIER,18,Font.BOLD,BaseColor.WHITE)));
                cell.setFixedHeight(50);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                tba.addCell(cell);
                doc.add(tba);

                prg = new Paragraph("\n");
                doc.add(prg);
                
                SimpleDateFormat format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
                
                prg = new Paragraph("Fecha: " + format.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_RIGHT);
                doc.add(prg);
                
                format = new SimpleDateFormat("hh:mm aa");

                prg = new Paragraph("Hora: " + format.format(Calendar.getInstance().getTime()),FontFactory.getFont(FontFactory.COURIER,12,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_RIGHT);
                doc.add(prg);

                prg = new Paragraph("Administrador: " + user.getName() + " " + user.getFatherLastName() + " " + user.getMotherLastName() + "\n\n",FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_LEFT);
                doc.add(prg);
                
                format = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");
                
                prg = new Paragraph("Periodo de Inicio: " + format.format(start.getCalendar().getTime()),FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_LEFT);
                doc.add(prg);
                
                prg = new Paragraph("Periodo de Fin: " + format.format(end.getCalendar().getTime()) + "\n\n",FontFactory.getFont(FontFactory.COURIER,12,Font.BOLD,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_LEFT);
                doc.add(prg);
                
                prg = new Paragraph("INGRESOS GENERALES\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_CENTER);
                doc.add(prg);
                
                format = new SimpleDateFormat("yyyy/MM/dd");
                
                ArrayList <ProofOfPayment> tickets = (new ProofOfPayment()).getList(format.format(start.getCalendar().getTime()), format.format(end.getCalendar().getTime()));                
                tba = new PdfPTable(4);

                cell = new PdfPCell(new Paragraph("Código", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Monto", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Fecha", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                DecimalFormat formatMoney = new DecimalFormat("#.##");
                
                for (ProofOfPayment ticket : tickets) {
                    if (Double.parseDouble(ticket.getAmount()) >= 50) {
                        cell = new PdfPCell(new Paragraph(ticket.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph("S/. " + formatMoney.format(Double.parseDouble(ticket.getAmount())), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(ticket.getDate(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(ticket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.BLUE);
                        tba.addCell(cell);
                    } else {
                        cell = new PdfPCell(new Paragraph(ticket.getCode(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph("S/. " + formatMoney.format(Double.parseDouble(ticket.getAmount())), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(ticket.getDate(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(ticket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                    }
                }
                doc.add(tba);
                
                prg = new Paragraph("\nGANACIAS OBTENIDAS POR USUARIOS\n\n",FontFactory.getFont(FontFactory.COURIER,13,BaseColor.BLACK));
                prg.setAlignment(Element.ALIGN_CENTER);
                doc.add(prg);
                
                tickets = (new ProofOfPayment()).getUsersMount(format.format(start.getCalendar().getTime()), format.format(end.getCalendar().getTime()));                
                tba = new PdfPTable(2);

                cell = new PdfPCell(new Paragraph("Usuario", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                cell = new PdfPCell(new Paragraph("Monto Gando", FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setBackgroundColor(BaseColor.BLACK);
                cell.setBorderColor(BaseColor.WHITE);
                cell.setFixedHeight(30);
                tba.addCell(cell);
                
                for (ProofOfPayment ticket : tickets) {
                    if (Double.parseDouble(ticket.getAmount()) >= 200) {
                        cell = new PdfPCell(new Paragraph(ticket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.MAGENTA);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph("S/. " + formatMoney.format(Double.parseDouble(ticket.getAmount())), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.WHITE)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        cell.setBackgroundColor(BaseColor.MAGENTA);
                        tba.addCell(cell);                        
                    } else {
                        cell = new PdfPCell(new Paragraph(ticket.getUser(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                        cell = new PdfPCell(new Paragraph(ticket.getAmount(), FontFactory.getFont(FontFactory.COURIER,11,Font.BOLD,BaseColor.BLACK)));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setFixedHeight(20);
                        tba.addCell(cell);
                    }
                }
                doc.add(tba);                
                doc.close();
                return true;                
            } catch (DocumentException | IOException ex) {
                return false;
            }            
        }
        
        return false;
    }
}