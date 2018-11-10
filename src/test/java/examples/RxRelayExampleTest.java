package examples;

import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.Test;

public class RxRelayExampleTest {

    private RxRelayExample subject;
    private TestObserver<Integer> testObserver;

    @Before
    public void setUp() throws Exception {
        subject = new RxRelayExample();
        testObserver = TestObserver.create();
    }

    @Test
    public void shouldEmitIntegerToObserver() {
        subject.subscribeObserver(testObserver);
        subject.callRelay(5);
        subject.callRelay(10);

        testObserver.assertValues(5, 10);
    }
}