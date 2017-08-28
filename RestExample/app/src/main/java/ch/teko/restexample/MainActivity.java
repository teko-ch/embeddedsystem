package ch.teko.restexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import java.util.List;

import ch.teko.restexample.model.Repository;
import ch.teko.restexample.model.RepositoryService;
import ch.teko.restexample.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RepositoryService repositoryService = RestClient.createService(RepositoryService.class);
        Call<List<Repository>> call = repositoryService.items();

        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                Log.d("@@@", response.message());
                List<Repository> list = response.body();
                Log.d("@@@", list.toString());

            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.d("@@@", "Error");
            }
        });


    }

}
