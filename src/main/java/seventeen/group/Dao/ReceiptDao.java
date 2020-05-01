package seventeen.group.Dao;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;

public interface ReceiptDao {

    int setReceipt(Bill bill, Customer customer) throws Exception;
}
