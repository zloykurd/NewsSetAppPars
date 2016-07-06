package com.example.zloykurd.newsetapppars;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZloykurD on 29.06.2016.
 */
public class NewsListAdapter extends BaseAdapter implements View.OnClickListener {
    List<News> rNews = new ArrayList<News>();
    private Activity activity;

    private LayoutInflater inflater;

    Context mContext;

    public NewsListAdapter(List<News> rNews, Activity activity, LayoutInflater inflater, Context mContext) {
        this.rNews = rNews;
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = mContext;
    }

    @Override
    public void onClick(View view) {

    }

    public static class ViewHolder {
        public ImageView image;
        public TextView textv1;
        public TextView textv2;

    }


    @Override
    public int getCount() {
        return rNews.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            vi = inflater.inflate(R.layout.listviewadapter, null);


            holder = new ViewHolder();
            holder.image = (ImageView) vi.findViewById(R.id.imagelist);
            holder.textv1 = (TextView) vi.findViewById(R.id.newsTitle);
            holder.textv2 = (TextView) vi.findViewById(R.id.newsDatel);


            vi.setTag(holder);
        } else {
            holder = (ViewHolder) vi.getTag();
        }


        News item = rNews.get(position);


        Context context = parent.getContext();

        holder.image.setImageResource(R.drawable.ic_no_image);
        holder.textv1.setText(item.getNews_title());
        holder.textv2.setText(item.getNews_date());


        vi.setOnClickListener(new OnItemClickListener(position, item));

        // vi.setOnLongClickListener(new View.OnLongClickListener(position, item));
        return vi;
    }

    private class OnItemClickListener implements View.OnClickListener {
        private int mPosition;
        private News n;

        OnItemClickListener(int position, News news) {
            mPosition = position;
            n = news ;

        }


        public void onClick(View arg0) {
            Intent qIntent = new Intent(mContext, NavigationDrawerActivity.class);
            int flag = 1;
            qIntent.putExtra("link_news", String.valueOf(flag));
            qIntent.putExtra("text_news", String.valueOf(flag));
            qIntent.putExtra("date_news", String.valueOf(flag));
            qIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(qIntent);


        }
}}