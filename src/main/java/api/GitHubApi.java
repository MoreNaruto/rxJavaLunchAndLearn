package api;

import io.reactivex.Observable;
import model.User;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {
    @GET("users/{user}")
    Observable<User> getUser(@Path("user") String username);
}
