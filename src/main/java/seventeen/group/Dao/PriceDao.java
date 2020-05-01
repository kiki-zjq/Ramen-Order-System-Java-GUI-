package seventeen.group.Dao;

import seventeen.group.Entity.Price;

import java.io.IOException;

public interface PriceDao {

    int setPrice(Price price) throws IOException;

    Price getPrice() throws IOException;

    String searchPrice(Price price, String name) throws IOException;

    Price changePrice(Price price, String name, double change) throws IOException;
}
