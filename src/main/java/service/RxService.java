package service;

import api.GitHubApi;
import io.reactivex.Observable;
import model.User;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RxService {
    private GitHubApi gitHubApi;

    public RxService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        gitHubApi = retrofit.create(GitHubApi.class);
    }

    public Observable<User> getUser(String username){
        return gitHubApi.getUser(username);
    }
}
