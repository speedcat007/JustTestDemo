package com.example.hasee.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    break;
                case 2:
                    getApplicationContext().startActivity(new Intent(getApplicationContext(),Activity2.class).setFlags(FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 3:
                    getApplicationContext().startActivity(new Intent(getApplicationContext(),Activity3.class).setFlags(FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 4:
                    getApplicationContext().startActivity(new Intent(getApplicationContext(),Activity4.class).setFlags(FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 5:
                    getApplicationContext().startActivity(new Intent(getApplicationContext(),Activity5.class).setFlags(FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 6:
                    getApplicationContext().startActivity(new Intent("com.test.activity").setPackage(getApplicationContext().getPackageName()).setFlags(FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 7:
                    getApplicationContext().startActivity(new Intent("com.test.activity2").setPackage(getApplicationContext().getPackageName()).setFlags(FLAG_ACTIVITY_NEW_TASK));
                    break;
            }
        }
    };
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
            startActivity(new Intent(this,Activity1.class));
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
            //startActivity(new Intent(this,Activity2.class));
            mHandler.sendEmptyMessageDelayed(2,500);
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(this,Activity3.class));
            mHandler.sendEmptyMessageDelayed(3,500);
        } else if (id == R.id.nav_slideshow) {
            //startActivity(new Intent(this,Activity4.class));
            mHandler.sendEmptyMessageDelayed(4,500);
        } else if (id == R.id.nav_manage) {
            //startActivity(new Intent(this,Activity5.class));
            mHandler.sendEmptyMessageDelayed(5,500);
        } else if (id == R.id.nav_share) {
            //startActivity(new Intent("com.test.activity").setPackage(getPackageName()));
            mHandler.sendEmptyMessageDelayed(6,500);
        } else if (id == R.id.nav_send) {
            //startActivity(new Intent("com.test.activity2").setPackage(getPackageName()));
            mHandler.sendEmptyMessageDelayed(7,500);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
