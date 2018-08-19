package com.reyzeny.androidauthentication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FeedAdapter adapter;
    private List<Feed> feedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        ///////////////////////////////////////////////////////////////////


        feedList = new ArrayList<>();
        adapter = new FeedAdapter(this, feedList);

        // sets our layout manager and recycler view
        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // create a new object feed to be inserted in our adapter.
        Feed feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial5.jpg",
                "In this tutorial, I’m going to teach you how to use Android Context Menu and " +
                        "GridView. We’re going to creating a simple wallpaper application that " +
                        "will allow the users to choose and apply a wallpaper in our gallery.",
                "3 DAYS AGO");
        feedList.add(0, feed);

        feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial6.jpg",
                "Remember the old Facebook Messenger app? In this tutorial, I’m going to teach " +
                        "you how to create a Facebook Messenger like layout using Android Design " +
                        "library, Fragments and ViewPager. I’ll also teach you how to support " +
                        "multiple screens by adding different sizes of drawables in your project.",
                "1 DAY AGO");
        feedList.add(0, feed);

        feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial7.jpg",
                "Being able to save data locally  is one of the most important feature of an app. " +
                        "In this tutorial, I’m going to teach you how to do that by using Android " +
                        "SQLite Database. I’ll also teach you how to apply basic material design " +
                        "in your application.",
                "10 HOURS AGO");
        feedList.add(0, feed);

        feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial8.jpg",
                "The quickest and easiest way of integrating user registration in your application " +
                        "is through existing social networks such as Google, Facebook, VK and etc.. " +
                        "In this tutorial, I’m going to teach you how to implement Google Plus " +
                        "Sign In using Android.",
                "26 MINUTES AGO");
        feedList.add(0, feed);

        //call this every time you're going to add new items in your recycler view
        adapter.notifyDataSetChanged();



}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
