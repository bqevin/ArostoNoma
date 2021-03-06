package com.swahilipothub.arostonoma;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.swahilipothub.arostonoma.app.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Barassa on 03-Jan-17.
 */

public class CHelpActivity extends AppCompatActivity {
    // Log tag
    private static final String TAG = CHelpActivity.class.getSimpleName();

    // Help json url
    private static final String url = "http://arostonoma.co.ke/help.json";
    private ProgressDialog pDialog;
    private List<CHelp> cHelpList = new ArrayList<CHelp>();
    private ListView listView;
    private CHelpListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Inflate CHelp Layout
        setContentView(R.layout.activity_chelp);

        // declare layout binding
        listView = (ListView) findViewById(R.id.chelp_list);

        adapter = new CHelpListAdapter(this, cHelpList);

        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);

        // Showing progress dialog before making http request
        pDialog.setMessage("Preparing help categories...");
        pDialog.show();

        //Render articles
        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJSONUrl(new JSONArray(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // Make a request online
            JsonArrayRequest movieReq = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d(TAG, response.toString());
                            hidePDialog();

                            // Parsing json
                            for (int i = 0; i < response.length(); i++) {
                                try {

                                    JSONObject obj = response.getJSONObject(i);
                                    //Init CHelp object Constructor
                                    CHelp chelp = new CHelp();
                                    chelp.setTitle(obj.getString("title"));
                                    chelp.setDetails(obj.getString("description"));
                                    chelp.setIcon(obj.getString("icon"));
                                    chelp.setCounsellors(obj.getString("counsellor"));

                                    cHelpList.add(chelp);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                            // notifying list adapter about data changes
                            // so that it renders the list view with updated data
                            adapter.notifyDataSetChanged();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                    hidePDialog();

                }
            });

            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(movieReq);
        }

        //Opens Counselling Help details view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Title
                String title  = (cHelpList.get(position)).getTitle();
                //Bit Description
                String desc = (cHelpList.get(position)).getDetails();
                //Icon
                String icon = cHelpList.get(position).getIcon();
                //Counsellors
                String counsellor = cHelpList.get(position).getCounsellors();


                //Soft transfer
                Intent intent = new Intent(getApplicationContext(), CHelpDetails.class);
                intent.putExtra("EXTRA_TITLE", title);
                intent.putExtra("EXTRA_DESC", desc);
                intent.putExtra("EXTRA_ICON", icon);
                intent.putExtra("EXTRA_COUNSELLOR", counsellor);
                startActivity(intent);
            }
        });
    }

    //Call data locally from cache
    private void parseJSONUrl(JSONArray response){
        pDialog.dismiss();
        try {

            for (int i = 0; i < response.length(); i++) {

                JSONObject obj = response.getJSONObject(i);
                //Init CHelp object Constructor
                CHelp chelp = new CHelp();
                chelp.setTitle(obj.getString("title"));
                chelp.setDetails(obj.getString("description"));
                chelp.setIcon(obj.getString("icon"));
                chelp.setCounsellors(obj.getString("counsellor"));

                cHelpList.add(chelp);
            }
            // notify data changes to recycler
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

}
