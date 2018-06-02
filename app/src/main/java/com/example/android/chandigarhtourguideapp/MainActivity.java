package com.example.android.chandigarhtourguideapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.Navigation_v);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
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
            Intent monumentsIntent = new Intent(MainActivity.this, MonumentsActivity.class);
            startActivity(monumentsIntent);
        } else if (id == R.id.garden) {
            Intent gardensIntent = new Intent(MainActivity.this, PlaygroundActivity.class);
            startActivity(gardensIntent);
        } else if (id == R.id.market) {
            Intent marketsIntent = new Intent(MainActivity.this, MarketActivity.class);
            startActivity(marketsIntent);
        } else if (id == R.id.restaurant) {
            Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
            startActivity(restaurantsIntent);
        }
        return false;
    }
}