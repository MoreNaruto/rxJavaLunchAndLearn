package examples;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {

    private MockClass mockClass;
    private Scheduler scheduler;

    public ObservableIntervalExample(MockClass mockClass, Scheduler scheduler) {
        this.mockClass = mockClass;
        this.scheduler = scheduler;
    }

    public void runInterval() {
        Observable.interval( 30, TimeUnit.SECONDS, scheduler)
                .take(5)
                .subscribe(aLong -> mockClass.mockCalled());
    }
}
