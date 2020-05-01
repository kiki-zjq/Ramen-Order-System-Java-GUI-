package seventeen.group.Dao;

import seventeen.group.Entity.Bill;
import seventeen.group.Entity.Statistics;

import java.io.IOException;

public interface BillDao {

    int saveBillMsg(Bill bill) throws IOException;

    Statistics getStatistic() throws IOException;
}
