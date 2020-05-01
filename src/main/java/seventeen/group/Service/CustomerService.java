package seventeen.group.Service;

import seventeen.group.Entity.Customer;

import java.io.IOException;

public interface CustomerService {

    Customer chkCustomer(Customer customer);

    Customer setCustomerMsg(Customer customer) throws IOException;

    int saveCustomer(Customer customer) throws IOException;

    Customer getCustMsg(String uid) throws IOException;

    Customer chkExist(Customer customer) throws IOException;
}
