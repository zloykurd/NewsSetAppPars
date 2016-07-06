package com.example.zloykurd.newsetapppars.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.zloykurd.newsetapppars.Database;
import com.example.zloykurd.newsetapppars.News;
import com.example.zloykurd.newsetapppars.NewsActivity;
import com.example.zloykurd.newsetapppars.R;
import com.example.zloykurd.newsetapppars.imageloader.LazyImageLoadNewsAdapter;

import java.util.ArrayList;

/**
 * Created by ZloykurD on 24.06.2016.
 */
public class ZanozaNewsfragment  extends ListFragment {
    LazyImageLoadNewsAdapter adapter;
    ListView list;

    public ZanozaNewsfragment() {
    }

    final String LOG_TAG = "NewsLog";

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = (ListView) getActivity().findViewById(R.id.lV);// mStrings

        adapter = new LazyImageLoadNewsAdapter(getActivity(), getData(),
                getActivity().getApplicationContext());// mStrings
        list.setAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Intent i = new Intent(getActivity(), NewsActivity.class);
        i.putExtra("mPosition", position);
        startActivity(i);

    }

    private ArrayList<News> getData() {
        Database db = new Database(getActivity()
                .getApplicationContext());
        final ArrayList<News> stringItems = new ArrayList<News>();

        ArrayList<News> pr = (ArrayList<News>) db.get24News();

        for (News p : pr) {
            stringItems.add(p);
        }


        return stringItems;

    }
}
