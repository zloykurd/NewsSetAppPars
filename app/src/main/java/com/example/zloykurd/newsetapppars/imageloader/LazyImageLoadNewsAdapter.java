package com.example.zloykurd.newsetapppars.imageloader;



import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zloykurd.newsetapppars.News;
import com.example.zloykurd.newsetapppars.NewsActivity;
import com.example.zloykurd.newsetapppars.R;
import com.example.zloykurd.newsetapppars.imageloader.ImageLoader;

public class LazyImageLoadNewsAdapter extends BaseAdapter implements
		OnClickListener {
	final String LOG_TAG = "NewsApp";
	private Activity activity;
	private String[] data;
	private ArrayList<News> rData = new ArrayList<News>();
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;
	private Context mContext;

	public LazyImageLoadNewsAdapter(Activity a, ArrayList<News> rD,
			Context context) {
		this.mContext = context;
		activity = a;
		// data = d;
		rData = rD;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// Create ImageLoader object to download and show image in list
		// Call ImageLoader constructor to initialize FileCache
		imageLoader = new ImageLoader(activity.getApplicationContext());
	}

	public int getCount() {

		return rData.size();

	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	/********* Create a holder Class to contain inflated xml file elements *********/
	public static class ViewHolder {

		public TextView text;
		public TextView text1;
		public ImageView image;

	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View vi = convertView;
		ViewHolder holder;

		if (convertView == null) {

			/****** Inflate tabitem.xml file for each row ( Defined below ) *******/
			vi = inflater.inflate(R.layout.listviewadapter, null);

			/****** View Holder Object to contain tabitem.xml file elements ******/

			holder = new ViewHolder();
			holder.text = (TextView) vi.findViewById(R.id.newsTitle);
			holder.text1 = (TextView) vi.findViewById(R.id.newsDatel);
			holder.image = (ImageView) vi.findViewById(R.id.imagelist);

			/************ Set holder with LayoutInflater ************/
			vi.setTag(holder);
		} else
			holder = (ViewHolder) vi.getTag();
		News item = rData.get(position);

		Context context = parent.getContext();

		holder.text.setText(item.getNews_title());
        Log.d(LOG_TAG,"getNews_title " + item.getNews_title());
		holder.text1.setText(item.getNews_date());
        Log.d(LOG_TAG,"item.getNews_date()); " + item.getNews_date());
		ImageView image = holder.image;
        //Log.d(LOG_TAG,"getNews_title " + item.getNews_title());

		// DisplayImage function from ImageLoader Class
		imageLoader.DisplayImage(item.getNews_image(), image);

		/******** Set Item Click Listner for LayoutInflater for each row ***********/
		vi.setOnClickListener(new OnItemClickListener(position));

		return vi;
	}

	/********* Called when Item click in ListView ************/
	private class OnItemClickListener implements OnClickListener {
		private int mPosition;

		OnItemClickListener(int position) {
			mPosition = position;
		}

		@Override
		public void onClick(View arg0) {
			// Toast.makeText(activity, "Toast", Toast.LENGTH_SHORT).show();
			Intent myIntent = new Intent(mContext, NewsActivity.class);
			myIntent.putExtra("mPosition", String.valueOf(mPosition));
			Log.d(LOG_TAG, "mPosition " + mPosition);
			myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			mContext.startActivity(myIntent);

			// MainActivity sct = (MainActivity)activity;
			// sct.onItemClick(mPosition);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}