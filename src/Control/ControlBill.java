package Control;

import Dao.PriceDao;
import Entity.Bill;
import Entity.Price;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlBill {
    private String soupChk;
    private String noodChk;
    private String onionChk;
    private String noriChk;
    private String chashuChk;
    private String boiledEggChk;
    private String spicinessChk;

    public ControlBill(Bill bill) {
        this.soupChk = bill.getSoup();
        this.noodChk = bill.getNood();
        this.onionChk = bill.getOnion();
        this.noriChk = bill.getNori();
        this.chashuChk = bill.getChashu();
        this.boiledEggChk = bill.getBoiledEgg();
        this.spicinessChk = bill.getSpiciness();
    }

    public int chkBillMsg() {
        // Check whether the message of bill is null.
        if (soupChk.isEmpty() || noodChk.isEmpty() || onionChk.isEmpty()
                || noriChk.isEmpty() || chashuChk.isEmpty()
                || boiledEggChk.isEmpty() || spicinessChk.isEmpty())
            return 0;
        else
            return 1;
    }

    public Bill setBillMsg(Bill bill) throws IOException {
        // Set basic Message for bill.
        // Set price for bill.
        Price price = new Price();
        PriceDao priceDao = new PriceDao();
        price = priceDao.getPrice();
        double totalPrice = price.getRamen();
        if(bill.getExtraNori().equals("Yes")) {
            totalPrice += price.getExNori();
        }
        if (bill.getExtraEgg().equals("Yes")) {
            totalPrice += price.getExEgg();
        }
        if (bill.getBambooShoot().equals("Yes")) {
            totalPrice += price.getExBamboo();
        }
        if (bill.getExtraChashu().equals("Yes")) {
            totalPrice += price.getExChashu();
        }
        // Set date for bill.
        DecimalFormat df = new DecimalFormat("0.00");
        String num;
        num = df.format(totalPrice);
        bill.setPrice(num);
        SimpleDateFormat b= new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = new Date();
        bill.setDate(b.format(date));
        return bill;
    }

    public String getBillMsg(Bill bill) {
        String billMessage = bill.getDate()+" " + bill.getUid() + " "
                +bill.getSoup()+" "+bill.getNood()+" "+bill.getOnion() +" "
                +bill.getNori()+" "+bill.getChashu()+" "+bill.getBoiledEgg() +" "
                +bill.getSpiciness() +" "+bill.getExtraNori()+" "+bill.getExtraEgg()+" "
                +bill.getBambooShoot()+" "+bill.getExtraChashu() +" "+bill.getIfFree()
                +" "+bill.getPrice()+" "+bill.getPayoption() + " "+bill.getPacket()+"\r\n";
        return billMessage;
    }

}