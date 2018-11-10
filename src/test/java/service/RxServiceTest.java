package service;

import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RxServiceTest {

    private RxService subject;

    @Before
    public void setUp() {
        subject = new ZipRxService();
    }

    @Test
    public void getUser_retrieveUserInformation() {
        User actualUser = subject.getUser("MoreNaruto")
                .test()
                .values()
                .get(0);

        assertEquals(actualUser.getId(), 2292947);
    }
}