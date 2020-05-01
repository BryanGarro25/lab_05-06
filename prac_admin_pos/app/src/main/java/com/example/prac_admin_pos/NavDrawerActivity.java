package com.example.prac_admin_pos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.prac_admin_pos.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NavDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
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
        userPrivileges();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        /*NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();*/
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.nav_list_job){
            this.openListApplication();
        } else {
            if (id == R.id.nav_apply_position) {
                this.openJobApplication();
            } else{
                if (id == R.id.nav_logout){
                    this.logout();
                }
            }
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void userPrivileges() {

        SharedPreferences prefs = this.getSharedPreferences(getString(R.string.preference_user_key), Context.MODE_PRIVATE);
        String defaultValue = getResources().getString(R.string.preference_user_key_default);
        String privilegio = prefs.getString(getString(R.string.preference_user_key), defaultValue);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        MenuItem holder;
        switch (privilegio){
            case "admin":
                holder = menu.findItem(R.id.nav_list_job);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_logout);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_apply_position);
                holder.setEnabled(true);
                break;
            case "user":
                holder = menu.findItem(R.id.nav_apply_position);
                holder.setEnabled(true);
                holder = menu.findItem(R.id.nav_logout);
                holder.setEnabled(true);
                break;
            default:
                break;
        }
    }
    private void openListApplication(){
        finish();
        Intent listApplication = new Intent(this, JobAppList.class);
        startActivity(listApplication);
    }
    private void openJobApplication(){
        finish();
        Intent jobApp = new Intent(this, JobActivity.class);
        startActivity(jobApp);
    }
    private void logout(){
        finish();
        Intent logout = new Intent(this, MainActivity.class);
        startActivity(logout);
    }
}
