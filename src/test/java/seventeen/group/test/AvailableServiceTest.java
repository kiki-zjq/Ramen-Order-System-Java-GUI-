package seventeen.group.test;

import org.junit.Test;
import seventeen.group.Entity.Available;
import seventeen.group.Service.AvailableService;
import seventeen.group.Service.Impl.AvailableServiceImpl;

import java.io.IOException;

public class AvailableServiceTest {

    private AvailableService availableService = new AvailableServiceImpl();

    @Test
    public void testGetAvailableMsg() throws IOException {
        Available myAvailable = availableService.getAvailableMsg();
        System.out.println(myAvailable.getJudgeCode());
    }

    @Test
    public void testChangeState() throws IOException {
        Available myAvailable = new Available();
        myAvailable.setNori("nori");
        availableService.changeState(myAvailable,"nori","false");
        System.out.println(myAvailable.getJudgeCode());
    }

    @Test
    public void testSearchState() throws IOException {
        Available myAvailable = new Available();
        availableService.searchState(myAvailable, "nori");
        System.out.println(myAvailable.getNori());
    }
}
