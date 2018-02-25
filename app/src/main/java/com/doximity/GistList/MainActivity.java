package com.doximity.GistList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.doximity.GistList.databinding.ActivityMainBinding;
import com.doximity.GistList.models.Gist;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String SHOW_IMAGE_KEY = "ShowImage";

    private Subscription subscription;

    private PublishSubject<Boolean> showImageStream = PublishSubject.create();
    private boolean showImage = true;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (savedInstanceState != null) {
            showImage = savedInstanceState.getBoolean(SHOW_IMAGE_KEY);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GistInteractor interactor = new GistInteractor(retrofit.create(GithubApi.class));

        subscription = interactor.getGistsWithUserImage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Gist>>() {
                    @Override
                    public void call(List<Gist> gists) {
                        float imageWidth = getResources().getDimension(R.dimen.image_size);
                        binding.listview.setHasFixedSize(true);
                        binding.listview.setAdapter(new ListViewAdapter(gists, showImageStream, showImage, imageWidth));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        Log.e(TAG, "Request for Gists failed", throwable);
                    }
                });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(SHOW_IMAGE_KEY, showImage);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.change_image_visibility) {
            // invert visibility, update UI, notify subscribers in adapter
            showImage = !showImage;
            item.setTitle(showImage ? R.string.hide_images : R.string.show_images);
            showImageStream.onNext(showImage);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    interface GithubApi {

        @GET("/gists/public?per_page=100") Call<ArrayList<Gist>> getGists();
        // Used for Task 3
        @GET("/gists/public?per_page=100") Observable<ArrayList<Gist>> getGistsObservable();
    }
}
