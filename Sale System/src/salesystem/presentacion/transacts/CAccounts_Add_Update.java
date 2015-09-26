package salesystem.presentacion.transacts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import salesystem.negocio.Accounts;
import salesystem.presentacion.CMain;

public class CAccounts_Add_Update implements IAccounts_Add_Update{
    
    private UI_Accounts_Add_Update winAccounts;
    private int type;
    private String customer_id;
    
    public CAccounts_Add_Update()
    {
        this.type = 0;
    }
    public CAccounts_Add_Update(int type, String customer)
    {
        
        this.type = type;
        this.customer_id = customer;
        winAccounts = new UI_Accounts_Add_Update(this, customer_id, generateNext());
    }
    public CAccounts_Add_Update(int type, String Account_id, String customer_id, Date Date_account_opened, String Account_name, String Other_account_details) throws ParseException
    {
        if(type == 0)
            Account_id = generateNext();
        
        this.customer_id = customer_id;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(Date_account_opened);
        winAccounts = new UI_Accounts_Add_Update(this, Account_id, customer_id, reportDate, Account_name, Other_account_details);
        this.type = type;
    }
    public CAccounts_Add_Update(int type, String Account_id, String customer_id, String date_account_opened, String Account_name, String Other_account_details) throws ParseException
    {
        if(type == 0)
            Account_id = generateNext();
        
        this.customer_id = customer_id;
        winAccounts = new UI_Accounts_Add_Update(this, Account_id, customer_id, date_account_opened, Account_name, Other_account_details);
        this.type = type;
    }
    public String generateNext()
    {
        Accounts n = new Accounts();
        int foo = Integer.parseInt(n.count());
        foo++;
        String nS = Integer.toString(foo);
        
        int au = 7 - nS.length();
        for(int i = 0; i < au; i++)
            nS = "0" + nS;
        return nS;
    }
    
    public void close()
    {
        CMain principal = new CMain(7);
        winAccounts.dispose();
    }
    
    public void addUpdateAccounts(String Account_id, Date Date_account_opened, String Account_name, String Other_account_details)
    {
        switch(type)
        {
            case 0:     //agregar
                addAccounts(Account_id, customer_id, Date_account_opened, Account_name, Other_account_details);
                break;
            case 1:     //modificar
                updateAccounts(Account_id, customer_id, Date_account_opened, Account_name, Other_account_details);
                break;
        }
    }
    private void addAccounts(String Account_id, String Customer_id, Date Date_account_opened, String Account_name, String Other_account_details)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(Date_account_opened);
        Accounts nuevo = new Accounts(Account_id, Customer_id, reportDate, Account_name,Other_account_details, "A");
        nuevo.add();
        close();
    }
    private void updateAccounts(String Account_id, String Customer_id, Date Date_account_opened, String Account_name, String Other_account_details)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(Date_account_opened);
        Accounts nuevo = new Accounts(Account_id, Customer_id, reportDate, Account_name,Other_account_details, "A");
        nuevo.update(Account_id);
        close();
    }
    
}
