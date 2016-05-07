package com.fissionlabs.hackernews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.fissionlabs.hackernews.adapter.TopStoriesAdapter;
import com.fissionlabs.hackernews.model.Entity;

import java.util.ArrayList;
import java.util.Collections;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private ListView topStoriesListView;
    private ArrayList<Long> storiesIdList;
    private ArrayList<Entity> storiesList = new ArrayList<Entity>();
    private TopStoriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topStoriesListView = (ListView)findViewById(R.id.top_stories_listview);
        adapter = new TopStoriesAdapter(new ArrayList<Entity>(),MainActivity.this);
        topStoriesListView.setAdapter(adapter);

        getTopStoriesList();
    }

    private void getTopStoriesList() {
            HttpService.getInstance().getTopStoriesList(new Callback<ArrayList<Long>>() {
                @Override
                public void success(ArrayList<Long> storiesArrayList, Response response) {
                    if (storiesArrayList != null && storiesArrayList.size() > 0) {
                        storiesIdList = storiesArrayList;
                        int size = storiesIdList.size();
                        for (int i=0;i < 10;i++){
                            getStory(storiesIdList.get(i));
                        }
                    }

                }

                @Override
                public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this,"No data found",Toast.LENGTH_LONG).show();
//                    hideProgressHUDInLayout();
//                    hideSnackbar();
//                    handleRetrofitError(rellayIndentRequestsActivity, error);
                }
            });
    }

    private void getStory(Long id) {
        HttpService.getInstance().getItemDetails(String.valueOf(id),new Callback<Entity>() {
            @Override
            public void success(Entity story, Response response) {
                if (story != null) {
                    storiesList.add(story);
                    adapter.setStoriesList(storiesList);
                    adapter.notifyDataSetChanged();
                }

//                hideProgressHUDInLayout();
//                hideSnackbar();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this,"No Story found",Toast.LENGTH_LONG).show();
//                hideProgressHUDInLayout();
//                hideSnackbar();
//                handleRetrofitError(rellayIndentRequestsActivity, error);
            }
        });
    }



}
