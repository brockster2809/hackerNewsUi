package com.fissionlabs.hackernews;

import android.content.Context;
import android.util.LruCache;


import com.fissionlabs.hackernews.interfaces.IndentRequestService;
import com.fissionlabs.hackernews.model.Entity;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by user on 21-03-2016.
 */
public class HttpService {
    private static HttpService instance = new HttpService();
    private Context context;
    private LruCache<String, Object> cache = new LruCache<>(4 * 1024 * 1024);
    private IndentRequestService indentRequestService;
    private RestAdapter adapter;


    private HttpService() {
    }

    public static HttpService getInstance() {
        return instance;
    }

    public void setup(Context context) {
        this.context = context;

        OkHttpClient okHttpClient = new OkHttpClient();
        OkClient okClient = new OkClient(okHttpClient);

        Cache cache = new Cache(context.getCacheDir(), 1024);
        okHttpClient.setCache(cache);
        adapter  = new RestAdapter.Builder()
                .setLogLevel((AppConstants.IS_DEVELOPMENT) ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setEndpoint(AppConstants.HOST)
                .setClient(okClient)
                .build();
        indentRequestService =  adapter.create(IndentRequestService.class);
    }

    public void getTopStoriesList(Callback<ArrayList<Long>> callback) {
        indentRequestService.getTopStoriesList(callback);
    }

    public void getItemDetails(String id, Callback<Entity> callback){
        indentRequestService.getItemDetails(id, callback);
    }

}
