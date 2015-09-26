package salesystem.presentacion.transacts;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import salesystem.negocio.Accounts;
import salesystem.negocio.Financial_Transactions;
import salesystem.negocio.Invoices;
import salesystem.negocio.Transaction_Types;
import salesystem.presentacion.CMain;
import salesystem.presentacion.transacts.UITransactions_Add_Update;

public class CTransacts_Add_Update implements ITransactions_Add_Update
{
    private UITransactions_Add_Update winTransacts;
    private boolean type;
    private String id;
    
    public CTransacts_Add_Update()
    {
        winTransacts = new UITransactions_Add_Update(this,false);
    }
    
    public CTransacts_Add_Update(boolean type)
    {
        winTransacts = new UITransactions_Add_Update(this,type);
        this.type = type;
    }
    
    public CTransacts_Add_Update(boolean type,String code)
    {
        this.id = code;
        this.type = type;
        winTransacts = new UITransactions_Add_Update(this,type);
        
        
    }
    public void cerrar()
    {
        CMain principal = new CMain(3);
        winTransacts.dispose();
    }
    
    public void agregarModificarTransacts(String code,String account, String invoice,String typeTrans,String dateOpened, String amount, String other)
    {
        if(!type)
        {
            agregarTransacts(account, invoice,typeTrans,dateOpened,amount,other);
        }
                    
        else
        {
            modificarTransacts(code,account, invoice,typeTrans,dateOpened,amount,other);
        }
    }
    
    public void agregarTransacts(String account, String invoice,String typeTrans,String dateOpened, String amount, String other)
    {
        Financial_Transactions nuevo = new Financial_Transactions(null,account,invoice,typeTrans,dateOpened,amount,other,"A");
        String err = nuevo.insertar();
                
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been added successfully", "ADD", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(3);
            winTransacts.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void modificarTransacts(String code, String account, String invoice,String typeTrans,String dateOpened, String amount, String other)
    {
        Financial_Transactions nuevo = new Financial_Transactions(code,account, invoice,typeTrans,dateOpened,amount,other,"A");
        String err = nuevo.actualizar(code);
        
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been updates successfully", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(3);
            winTransacts.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void cargar(JTextField txtTransaction_id, JTextField txtAccount,JTextField txtInvoice,JTextField txtTraTyp, JDateChooser dcDateOpened, JTextField txtAmount, JTextField txtOther)
    {
        
            Financial_Transactions financial_transaction = new Financial_Transactions();
            financial_transaction.buscar(id);
            txtTransaction_id.setText(financial_transaction.getTransaction_id());
            txtAccount.setText(financial_transaction.getAccount_id());
            txtInvoice.setText(financial_transaction.getInvoice_number());
            txtTraTyp.setText(financial_transaction.getTransaction_type_code());
                                   
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
            Date date = null;
            try {
                date = format.parse(financial_transaction.getTransaction_date());
                dcDateOpened.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(CTransacts_Add_Update.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtAmount.setText(financial_transaction.getTransaction_amount());
            txtOther.setText(financial_transaction.getOther_transaction_details());            
        
    }
    public void autoComplete(JTextField txtSearch,int ch)
    {    
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtSearch );
        
        switch (ch)
        {
            case 1:
                    ArrayList <Accounts> accounts = new Accounts().getList();
                    textAutoAcompleter.setMode(0); // infijo
                    textAutoAcompleter.setCaseSensitive(false);
        
                    for(int i = 0; i < accounts.size(); i++)
                        textAutoAcompleter.addItem(accounts.get(i).getAccount_id());
                    
                    break;
                
            case 2:
                    ArrayList <Invoices> invoices = new Invoices().getList();
                    textAutoAcompleter.setMode(0); // infijo
                    textAutoAcompleter.setCaseSensitive(false);
        
                    for(int i = 0; i < invoices.size(); i++)
                        textAutoAcompleter.addItem(invoices.get(i).getInvoice_number());
            break;   
            case 3:
                    ArrayList <Transaction_Types> trans = new Transaction_Types().getList();
                    textAutoAcompleter.setMode(0); // infijo
                    textAutoAcompleter.setCaseSensitive(false);
        
                    for(int i = 0; i < trans.size(); i++)
                        textAutoAcompleter.addItem(trans.get(i).getTransaction_type_code());
            break;
        }
    }
}
