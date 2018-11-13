package examples;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

import java.util.concurrent.TimeUnit;

public class ObservableIntervalExample {

    private MockClass mockClass;

    public ObservableIntervalExample(MockClass mockClass) {
        this.mockClass = mockClass;
    }

    public void runInterval() {
        Observable.interval( 30, TimeUnit.SECONDS)
                .take(5)
                .subscribe(aLong -> mockClass.mockCalled());
    }
}
