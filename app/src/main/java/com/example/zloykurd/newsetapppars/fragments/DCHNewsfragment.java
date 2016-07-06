package com.example.zloykurd.newsetapppars.fragments;

        import android.database.sqlite.*;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.ProgressBar;
        import java.io.IOException;
        import java.io.StringReader;
        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.ParserConfigurationException;
        import org.apache.http.HttpResponse;
        import org.apache.http.StatusLine;
        import org.apache.http.client.ClientProtocolException;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.util.EntityUtils;
        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.Node;
        import org.w3c.dom.NodeList;
        import org.xml.sax.InputSource;
        import org.xml.sax.SAXException;
        import android.os.AsyncTask;

        import com.example.zloykurd.newsetapppars.Database;
        import com.example.zloykurd.newsetapppars.MainActivity;
        import com.example.zloykurd.newsetapppars.NavigationDrawerActivity;
        import com.example.zloykurd.newsetapppars.News;
        import com.example.zloykurd.newsetapppars.R;
        import android.os.Bundle;
        import android.view.View;
        import com.example.zloykurd.newsetapppars.News;
        import com.example.zloykurd.newsetapppars.Database;
        import com.example.zloykurd.newsetapppars.NewsActivity;
        import com.example.zloykurd.newsetapppars.NewsListAdapter;
        import com.example.zloykurd.newsetapppars.imageloader.LazyImageLoadNewsAdapter;

        import android.content.Intent;
        import java.util.ArrayList;
        import android.support.v4.app.ListFragment;
        import android.widget.ListView;

public class DCHNewsfragment extends ListFragment {
    LazyImageLoadNewsAdapter adapter;
    ListView list;
    public DCHNewsfragment() {
    }

    final String LOG_TAG = "NewsLog";
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        list = (ListView)getActivity().findViewById(R.id.lV);// mStrings
        
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