package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Customer;
import seventeen.group.Service.CustomerService;
import seventeen.group.Service.Impl.CustomerServiceImpl;

import java.io.IOException;

public class CustomerServiceTest {

    private CustomerService customerService = new CustomerServiceImpl();
    private Customer customer = new Customer();

    @Test
    public void testChkCustomer() {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        customerService.chkCustomer(customer);
        System.out.println(customer.getJudgeCode());
    }

    @Test
    public void testSetCustomer() throws IOException {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        customerService.setCustomerMsg(customer);
        System.out.println(customer.getUid() + "\r\n");
        System.out.println(customer.getStamp() + "\r\n");
    }

    @Test
    public void testSaveCustomer() throws IOException {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        System.out.println(customerService.saveCustomer(customer));
    }

    @Test
    public void testGetCustomerMsg() throws IOException {
        Customer myCustomer = new Customer();
        myCustomer = customerService.getCustMsg("JC0001");
        System.out.println(myCustomer.getUid());
    }

    @Test
    public void testChkExist() throws IOException {
        customer.setFirname("Junhan");
        customer.setSurname("Chen");
        customer.setMobile("15070055999");
        customer.setEmail("850475@qq.com");
        System.out.println(customerService.chkExist(customer));
    }


}
