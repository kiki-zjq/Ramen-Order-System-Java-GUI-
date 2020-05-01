package seventeen.group.Service.Impl;

import seventeen.group.Dao.Impl.ReceiptDaoImpl;
import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Customer;
import seventeen.group.Service.ReceiptService;

public class ReceiptServiceImpl implements ReceiptService {

    private ReceiptDaoImpl receiptDao = new ReceiptDaoImpl();

    public int setReceipt(Bill bill, Customer customer) throws Exception {
        return receiptDao.setReceipt(bill, customer);
    }
}
