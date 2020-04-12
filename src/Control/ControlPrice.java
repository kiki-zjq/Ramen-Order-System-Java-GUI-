package Control;

import Entity.Price;

import java.text.DecimalFormat;

public class ControlPrice {

    public Price chgPriceData(Price price) {
        // Set the data format as A.BC to each price.
        DecimalFormat df = new DecimalFormat("0.00");
        String num;
        num = df.format(price.getRamen());
        price.setRamen(Double.parseDouble(num));

        num = df.format(price.getExNori());
        price.setExNori(Double.parseDouble(num));

        num = df.format(price.getExEgg());
        price.setExEgg(Double.parseDouble(num));

        num = df.format(price.getExBamboo());
        price.setExBamboo(Double.parseDouble(num));

        num = df.format(price.getExChashu());
        price.setExChashu(Double.parseDouble(num));
        return price;
    }
}
