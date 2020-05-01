package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Price;
import seventeen.group.Service.Impl.PriceServiceImpl;
import seventeen.group.Service.PriceService;

import java.io.IOException;

public class PriceServiceTest {

    private PriceService priceService = new PriceServiceImpl();
    private Price price = new Price();

    @Test
    public void testChgPriceData() {
        price.setRamen(1.234);
        price.setExNori(2.345);
        price.setExChashu(3.456);
        price.setExBamboo(4.567);
        price.setExEgg(5.678);
        priceService.chgPriceData(price);
        System.out.println(price.getRamen() + "/r/n");
        System.out.println(price.getExNori() + "/r/n");
        System.out.println(price.getExChashu() + "/r/n");
        System.out.println(price.getExBamboo() + "/r/n");
        System.out.println(price.getExEgg() + "/r/n");
    }

    @Test
    public void testChkPriceData() {
        String price = "2.00";
        Double chkPrice = priceService.chkPriceData(price);
        System.out.println(chkPrice);
    }

    @Test
    public void testSetPrice() throws IOException {
        price.setRamen(1.234);
        price.setExNori(2.345);
        price.setExChashu(3.456);
        price.setExBamboo(4.567);
        price.setExEgg(5.678);
        System.out.println(priceService.setPrice(price));
    }

    @Test
    public void testGetPrice() throws IOException {
        Price price = priceService.getPrice();
        System.out.println(price.getRamen() + "/r/n");
        System.out.println(price.getExNori() + "/r/n");
        System.out.println(price.getExChashu() + "/r/n");
        System.out.println(price.getExBamboo() + "/r/n");
        System.out.println(price.getExEgg() + "/r/n");
    }

    @Test
    public void testSearchPrice() throws IOException {
        Price myPrice = new Price();
        priceService.searchPrice(myPrice, "Extra_Nori");
        System.out.println(myPrice.getExNori());
    }

    @Test
    public void testChangePrice() throws IOException {
        Price myPrice = new Price();
        priceService.changePrice(myPrice,"Extra_Nori", 9.99);
        System.out.println(myPrice.getExNori());
    }


}
