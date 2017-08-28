package ch.teko.restexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.List;

import ch.teko.restexample.model.RepoRecyclerAdapter;
import ch.teko.restexample.model.Repository;
import ch.teko.restexample.model.RepositoryService;
import ch.teko.restexample.rest.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecycler;

    RepoRecyclerAdapter mAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycler = (RecyclerView) findViewById(R.id.recPlaceholder);
        mRecycler.setHasFixedSize(false);

        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mAdpater = new RepoRecyclerAdapter();

        RepositoryService repositoryService = RestClient.createService(RepositoryService.class);
        Call<List<Repository>> call = repositoryService.items();

        call.enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                Log.d("@@@", response.message());

                List<Repository> list = response.body();
                mAdpater = new RepoRecyclerAdapter(list);
                mRecycler.setAdapter(mAdpater);

            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.d("@@@", "Error");
            }
        });



    }

}
