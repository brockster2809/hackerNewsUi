package com.fissionlabs.hackernews.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fissionlabs.hackernews.R;
import com.fissionlabs.hackernews.model.Entity;

import java.util.ArrayList;

import retrofit.client.Client;

/**
 * Created by user on 07-05-2016.
 */
public class TopStoriesAdapter extends ArrayAdapter<Entity> {

    ArrayList<Entity> storiesList;
    Context context;

    public TopStoriesAdapter(ArrayList<Entity> storiesList,Context context){
        super(context, R.layout.story_row_layout,storiesList);
        this.storiesList = storiesList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        StoryViewHolder holder;
        if (row== null){
            LayoutInflater inflater = LayoutInflater.from(context);
            row = inflater.inflate(R.layout.story_row_layout,parent,false);
            holder = new StoryViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (StoryViewHolder)row.getTag();
        }

        holder.populateFrom(storiesList.get(position),position + 1);

        return row;
    }

    public void setStoriesList(ArrayList<Entity> storiesList) {
        this.storiesList = storiesList;
    }

    public static class StoryViewHolder{
        TextView tvSrNo;
        TextView tvTitle;
        TextView tvOtherDesc;
        TextView tvCommentsNo;

        public StoryViewHolder(View view){
            tvSrNo = (TextView)view.findViewById(R.id.tv_s_no);
            tvTitle = (TextView)view.findViewById(R.id.tv_title);
            tvOtherDesc = (TextView)view.findViewById(R.id.tv_other_desc);
            tvCommentsNo = (TextView)view.findViewById(R.id.tv_no_of_comments);
        }

        public void populateFrom(Entity story,int srNo){
            tvSrNo.setText(String.valueOf(srNo) + ".");
            if (!TextUtils.isEmpty(story.getTitle())) tvTitle.setText(story.getTitle());
            String otherDescStr = String.valueOf(story.getScore()) + " points by " + story.getBy();
            tvOtherDesc.setText(otherDescStr);
            if (story.getKids()!=null) tvCommentsNo.setText(String.valueOf(story.getKids().size()) + " comments");
        }

    }

}
