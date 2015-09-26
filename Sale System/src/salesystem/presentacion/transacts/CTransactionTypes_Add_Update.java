package salesystem.presentacion.transacts;

import salesystem.negocio.Transaction_Types;
import salesystem.presentacion.CMain;

public class CTransactionTypes_Add_Update implements ITransactionTypes_Add_Update{
    
    private UI_TransactionTypes_Add_Update winTransactionTypes;
    private int type;
    
    public CTransactionTypes_Add_Update()
    {
        this.type = 0;
    }
    public CTransactionTypes_Add_Update(int type)
    {
        winTransactionTypes = new UI_TransactionTypes_Add_Update(this, generateNext());
        this.type = type;
    }
    public CTransactionTypes_Add_Update(int type, String code, String description)
    {
        if(type == 0)
            code = generateNext();
        winTransactionTypes = new UI_TransactionTypes_Add_Update(this, code, description);
        this.type = type;
    }
    public String generateNext(){
        Transaction_Types n = new Transaction_Types();
        int foo = Integer.parseInt(n.count());
        foo++;
        String nS = Integer.toString(foo);
        
        int au = 3 - nS.length();
        for(int i = 0; i < au; i++)
            nS = "0" + nS;
        return nS;
    }
    
    public void close()
    {
        CMain principal = new CMain(7);
        winTransactionTypes.dispose();
    }
    public void addUpdateTransactionTypes(String code, String description)
    {
        switch(type)
        {
            case 0:     //agregar
                addTransactionTypes(code, description);
                break;
            case 1:     //modificar
                updateTransactionTypes(code, description);
                break;
        }
    }
    public void addTransactionTypes(String code, String description)
    {
        Transaction_Types nuevo = new Transaction_Types(code, description, "A");
        nuevo.add();
        close();
    }
    public void updateTransactionTypes(String code, String description)
    {
        Transaction_Types nuevo = new Transaction_Types(code, description, "A");
        nuevo.update(code);
        close();
    }
}
