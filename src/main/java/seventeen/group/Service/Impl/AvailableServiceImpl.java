package seventeen.group.Service.Impl;

import seventeen.group.Dao.AvailableDao;
import seventeen.group.Dao.Impl.AvailableDaoImpl;
import seventeen.group.Entity.Available;
import seventeen.group.Service.AvailableService;

import java.io.IOException;

public class AvailableServiceImpl implements AvailableService {

    private AvailableDao availableDao = new AvailableDaoImpl();

    public Available getAvailableMsg() throws IOException {
        return availableDao.getAvailableMsg();
    }

    public int setAvailable(Available available) throws IOException {
        return availableDao.setAvailable(available);
    }

    public Available changeState(Available available, String name, String state) throws IOException {
        return availableDao.changeState(available, name, state);
    }

    public String searchState(Available available, String name) throws IOException {
        return availableDao.searchState(available, name);
    }
}
