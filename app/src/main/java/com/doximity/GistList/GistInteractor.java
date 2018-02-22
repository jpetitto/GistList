package com.doximity.GistList;

import com.doximity.GistList.models.Gist;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public class GistInteractor {
    private MainActivity.GithubApi api;

    public GistInteractor(MainActivity.GithubApi api) {
        this.api = api;
    }

    public Observable<List<Gist>> getGistsWithUserImage() {
        return api.getGistsObservable()
                .flatMap(new Func1<ArrayList<Gist>, Observable<Gist>>() {
                    @Override
                    public Observable<Gist> call(ArrayList<Gist> gists) {
                        return Observable.from(gists);
                    }
                })
                .filter(new Func1<Gist, Boolean>() {
                    @Override
                    public Boolean call(Gist gist) {
                        return gist.owner != null;
                    }
                })
                .filter(new Func1<Gist, Boolean>() {
                    @Override
                    public Boolean call(Gist gist) {
                        return !Strings.isNullOrEmpty(gist.owner.avatarUrl);
                    }
                })
                .toList();
    }
}
