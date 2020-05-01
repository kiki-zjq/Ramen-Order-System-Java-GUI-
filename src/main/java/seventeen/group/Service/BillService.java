package seventeen.group.Service;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.MostPopMeal;
import seventeen.group.Entity.Statistics;

import java.io.IOException;

public interface BillService {

    int chkBillMsg(Bill bill);

    Bill setBillMsg(Bill bill) throws IOException;

    String getBillMsg(Bill bill);

    MostPopMeal getSelfMost(Statistics statistics, String string);

    int saveBillMsg(Bill bill) throws IOException;

    Statistics getStatistic() throws IOException;
}
