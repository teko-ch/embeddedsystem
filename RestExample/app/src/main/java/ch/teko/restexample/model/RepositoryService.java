package ch.teko.restexample.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jonathan on 28.08.17.
 */

public interface RepositoryService {

    @GET("repositories")
    Call<List<Repository>> items();

    @GET("repositories/{key}")
    Call<Repository> item(@Path("key") String key);
}
