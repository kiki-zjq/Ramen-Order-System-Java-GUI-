package seventeen.group.Service;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;

public interface ReceiptService {

    int setReceipt(Bill bill, Customer customer) throws Exception;
}
