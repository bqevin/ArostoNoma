package com.swahilipothub.arostonoma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.swahilipothub.arostonoma.helper.SQLiteHandler;
import com.swahilipothub.arostonoma.helper.SessionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZoomIT User1 on 8/25/2016.
 */
public class SectionActivity extends AppCompatActivity{

    private GridLayoutManager lLayout;
    private SQLiteHandler db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_main);
        setTitle(null);

        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(topToolBar);
        //topToolBar.setLogo(R.drawable.logo);
        topToolBar.setLogoDescription(getResources().getString(R.string.app_name));

        List<SectionFragObject> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(SectionActivity.this, 2);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        SectionAdapter rcAdapter = new SectionAdapter(SectionActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());
        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            logoutUser();
        }


        return super.onOptionsItemSelected(item);
    }

    private List<SectionFragObject> getAllItemList(){

        List<SectionFragObject> allItems = new ArrayList<SectionFragObject>();
        allItems.add(new SectionFragObject(getString(R.string.my_profile), R.drawable.profile));
        allItems.add(new SectionFragObject(getString(R.string.e_rehab), R.drawable.rehab));
        allItems.add(new SectionFragObject(getString(R.string.report_dealers), R.drawable.ok));
        allItems.add(new SectionFragObject(getString(R.string.counselling), R.drawable.help));



        return allItems;
    }

    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(SectionActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
