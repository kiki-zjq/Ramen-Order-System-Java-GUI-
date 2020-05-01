package seventeen.group.Service;

import seventeen.group.Entity.Available;

import java.io.IOException;

public interface AvailableService {

    Available getAvailableMsg() throws IOException;

    int setAvailable(Available available) throws IOException;

    Available changeState(Available available, String name, String state) throws IOException;

    String searchState(Available available, String name) throws IOException;
}
