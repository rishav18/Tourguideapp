package com.example.android.chandigarhtourguideapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MarketActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.Navigation_v);
        navigationView.setNavigationItemSelectedListener(this);
        ArrayList<Tour> places = new ArrayList<Tour>();
        places.add(new Tour(R.drawable.market1pic, getString(R.string.market1), getString(R.string.market1desc)));
        places.add(new Tour(R.drawable.market2pic, getString(R.string.market2), getString(R.string.market2desc)));
        places.add(new Tour(R.drawable.market3pic, getString(R.string.market3), getString(R.string.market3desc)));
        places.add(new Tour(R.drawable.market4pic, getString(R.string.market4), getString(R.string.market4desc)));
        TourAdapter adapter = new TourAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.monument) {
            Intent monumentsIntent = new Intent(MarketActivity.this, MonumentsActivity.class);
            startActivity(monumentsIntent);
        } else if (id == R.id.garden) {
            Intent gardensIntent = new Intent(MarketActivity.this, PlaygroundActivity.class);
            startActivity(gardensIntent);
        } else if (id == R.id.market) {
            Intent marketsIntent = new Intent(MarketActivity.this, MarketActivity.class);
            startActivity(marketsIntent);
        } else if (id == R.id.restaurant) {
            Intent restaurantsIntent = new Intent(MarketActivity.this, RestaurantsActivity.class);
            startActivity(restaurantsIntent);
        }
        return false;
    }
}