package com.example.admin.drawerlayout;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private WebView wbKenh14;
    private Toolbar toolbar;
    private DrawerLayout drawer ;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControllers();
        addEvents();
    }

    private void addControllers() {
        toolbar = (Toolbar) findViewById(R.id.toolbar); // get toobar trong activity
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout); // get layout DrawerLayout trong activity
        navigationView = (NavigationView) findViewById(R.id.nav_view); // get navigationView trong activity is template create menu
        wbKenh14 = (WebView) findViewById(R.id.url_kenh14); // get address web k14 trong activity
    }

    private void addEvents() {
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        wbKenh14.setWebViewClient(new WebViewClient());
        wbKenh14.loadUrl("http://www.kenh14.vn");
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_k14) {

        } else if (id == R.id.nav_bongda) {

        } else if (id == R.id.nav_dantri) {

        } else if (id == R.id.nav_zing) {

        } else if (id == R.id.nav_yan) {

        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (wbKenh14.canGoBack() == true) {
                wbKenh14.goBack();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
