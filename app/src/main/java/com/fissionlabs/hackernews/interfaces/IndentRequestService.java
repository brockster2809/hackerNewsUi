package com.fissionlabs.hackernews.interfaces;

import com.fissionlabs.hackernews.model.Entity;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by user on 21-03-2016.
 */
public interface IndentRequestService {
    @GET("/topstories.json?print=pretty")
    public void getTopStoriesList(Callback<ArrayList<Long>> callback);

    @GET("/item/{itemId}.json?print=pretty")
    public void getItemDetails(@Path("itemId") String id,Callback<Entity> callback);

}


