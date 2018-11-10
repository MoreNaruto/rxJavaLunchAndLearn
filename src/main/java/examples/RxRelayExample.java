package examples;

import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observer;

public class RxRelayExample {

    private final BehaviorRelay<Integer> behaviorRelay;

    public RxRelayExample() {
        behaviorRelay = BehaviorRelay.create();
    }

    public void subscribeObserver(Observer<Integer> observer){
        behaviorRelay.subscribe(observer);
    }

    public void callRelay(int sentValue) {
        behaviorRelay.accept(sentValue);
    }
}
