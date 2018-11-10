package examples;

import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ObservableIntervalExampleTest {
    private ObservableIntervalExample subject;
    private TestScheduler testComputationScheduler;

    @Mock
    MockClass mockClass;

    @Before
    public void setUp() {
        initMocks(this);

        testComputationScheduler = new TestScheduler();
        subject = new ObservableIntervalExample(mockClass, testComputationScheduler);
    }

    @Test
    public void runInterval() {
        subject.runInterval();

        testComputationScheduler.advanceTimeBy(35, TimeUnit.SECONDS);

        verify(mockClass).mockCalled();
    }
}