package seventeen.group.Dao;

import seventeen.group.Entity.Customer;

import java.io.IOException;

public interface CustomerDao {

    Customer setCustomerMsg(Customer customer) throws IOException;

    int saveCustomer(Customer customer) throws IOException;

    Customer getCustMsg(String uid) throws IOException;

    Customer chkExist(Customer customer) throws IOException;
}
