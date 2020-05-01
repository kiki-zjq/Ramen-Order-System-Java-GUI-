package seventeen.group.Service;

import seventeen.group.Entity.Price;

import java.io.IOException;

public interface PriceService {

    void chgPriceData(Price price);

    Double chkPriceData(String price);

    int setPrice(Price price) throws IOException;

    Price getPrice() throws IOException;

    String searchPrice(Price price, String name) throws IOException;

    Price changePrice(Price price, String name, double change) throws IOException;
}
