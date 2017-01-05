package com.swahilipothub.arostonoma;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.swahilipothub.arostonoma.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoomIT User1 on 8/28/2016.
 */
public class RehabActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RehabAdapter adapter;
    private ProgressDialog p;
    private List<RehabArticles> articles;
    private static final String URL_DATA = "http://arostonoma.co.ke/articles.json";
    //For snackbar
    private CoordinatorLayout coordinatorLayout;
    //Swipe to refresh
    SwipeRefreshLayout refresherL;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rehab);

        recyclerView = (RecyclerView)findViewById(R.id.rehab_recycler);

        //Enable snackbar viewing
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);

        //Swipe refresh layout init
        refresherL = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        //Ensures every item on recycler view has fixed size
        recyclerView.setHasFixedSize(true);

        //Use LinearLayout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Create data for the recipe items
        articles = new ArrayList<>();
        //Initiate network action with screen message
        p = new ProgressDialog(this);
//        p.setMessage("Fetching Articles");
//        p.show();

        //Render articles
        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_DATA);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            //Make completely new request
            //Activate dialog
            p.setMessage("Fetching Articles");
            p.show();
            newArticleRequest();
        }

        /*
         *
         * Refreshes Articles
         */
        refresherL.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        // Makes a new network call
                        newArticleRequest();
                        //Stop loading animation
                        refresherL.setRefreshing(false);
                    }
                });
    }


    /**
     * Parsing json reponse and passing the data to Rehab adapter
     * */
    private void parseJsonFeed(JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("articles");

            for (int i = 0; i < feedArray.length(); i++) {

                //fetch individual objects
                JSONObject o = (JSONObject) feedArray.get(i);

                //Article objects
                RehabArticles item = new RehabArticles();

                item.setAuthor(o.getString("author"));
                item.setTitle(o.getString("title"));
                item.setImage(o.getString("image"));
                item.setBody(o.getString("body"));
                item.setTime(o.getString("time"));

                articles.add(item);
            }
            //Create adapter object
            adapter = new RehabAdapter(articles, getApplicationContext());
            //Set adapter
            recyclerView.setAdapter(adapter);
            // notify data changes to recycler
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void newArticleRequest(){
        // making fresh volley request and getting json
        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                URL_DATA, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //VolleyLog.d(TAG, "Response: " + response.toString());
                if (response != null) {
                    parseJsonFeed(response);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // VolleyLog.d(TAG, "Error: " + error.getMessage());
                //Dismiss dialog
                p.dismiss();

                //Enable SnackBar
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "No internet connection!", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(Color.RED);

                // Changing action button text color
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.YELLOW);
                snackbar.show();

            }
        });

        // Adding request to volley request queue
        AppController.getInstance().addToRequestQueue(jsonReq);
    }


}
