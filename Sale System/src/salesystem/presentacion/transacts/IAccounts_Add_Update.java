package salesystem.presentacion.transacts;

import java.util.Date;

public interface IAccounts_Add_Update {
    public void close();   
    public void addUpdateAccounts(String Account_id, Date Date_account_opened, String Account_name, String Other_account_details);
}
