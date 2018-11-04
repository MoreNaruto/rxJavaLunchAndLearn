package service;

import io.reactivex.Observable;
import model.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ZipRxService extends RxService {
    public ZipRxService() {
    }

    public Observable<List<User>> mergeMultipleUsersOnly() {
       return Observable.zip(getUser("morenaruto"), getUser("kys"), getUser("linkedin"), (e1, e2, e3) -> Arrays.asList(e1, e2, e3))
               .flatMapIterable(users -> users)
               .filter(user -> user.type.equals("User"))
               .toSortedList(Comparator.comparingInt(user1 -> user1.id))
               .toObservable();
    }
}
