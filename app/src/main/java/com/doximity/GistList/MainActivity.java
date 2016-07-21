package com.doximity.GistList;

import com.doximity.GistList.models.Gist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.listview);
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(GsonConverterFactory.create()).build();

        retrofit.create(GithubApi.class).getGists().enqueue(new Callback<ArrayList<Gist>>() {
            @Override public void onResponse(Call<ArrayList<Gist>> call, Response<ArrayList<Gist>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Gist> gists = response.body();
                    listView.setAdapter(new ListViewAdapter(gists));
                }
            }

            @Override public void onFailure(Call<ArrayList<Gist>> call, Throwable t) {

            }
        });

    }

    interface GithubApi {

        @GET("/gists/public?per_page=100") Call<ArrayList<Gist>> getGists();
        @GET("/gists/public?per_page=100") Observable<ArrayList<Gist>> getGistsObservable();
    }
}
