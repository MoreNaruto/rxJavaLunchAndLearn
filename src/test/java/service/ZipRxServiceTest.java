package service;

import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ZipRxServiceTest {

    private ZipRxService subject;

    @Before
    public void setUp() {
        subject = new ZipRxService();
    }

    @Test
    public void mergeMultipleUsersOnly() {
        List<User> users = subject.mergeMultipleUsersOnly()
                .test()
                .values()
                .get(0);

        assertEquals(users.size(), 2);
        assertEquals(users.get(0).getLogin(), "kys");
        assertEquals(users.get(1).getLogin(), "MoreNaruto");
    }
}