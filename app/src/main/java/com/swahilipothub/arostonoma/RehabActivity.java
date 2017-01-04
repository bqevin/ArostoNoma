package com.swahilipothub.arostonoma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rehab);

        recyclerView = (RecyclerView)findViewById(R.id.rehab_recycler);

        //Ensures every item on recycler view has fixed size
        recyclerView.setHasFixedSize(true);

        //Use LinearLayout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Create data for the recipe items
        articles = new ArrayList<>();

        //Render articles
        loadArticles();
    }

    //Fetch articles
    private void loadArticles() {


        p = new ProgressDialog(this);
        p.setMessage("Fetching Articles");
        p.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        p.dismiss();

                        //MUST be in the try catch clause
                        try {

                            //Get the Object
                            JSONObject jsonObj = new JSONObject(response);

                            // Get Array
                            JSONArray recipeArray = jsonObj.getJSONArray("articles");
                            for (int i = 0; i < recipeArray.length(); i++ ) {

                                //fetch individual objects
                                JSONObject o = recipeArray.getJSONObject(i);

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


                        } catch (JSONException e){
                            //Volley Error
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Internet Error
                        Toast.makeText(getApplicationContext(), "Ensure internet connectivity to load new articles", Toast.LENGTH_SHORT).show();
                        //Dismiss dialogue and print error
                        p.dismiss();
                    }
                });
        RequestQueue requestQue = Volley.newRequestQueue(this);
        requestQue.add(stringRequest);
    }
}
