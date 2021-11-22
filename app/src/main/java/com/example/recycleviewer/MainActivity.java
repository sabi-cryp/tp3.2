package com.example.recycleviewer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewer.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> title = new LinkedList<>();
    private final LinkedList<String> desc = new LinkedList<>();

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);
        title.addLast( " Mc Chicken fait maison ");
        desc.addLast(" disposer sur chaque petit pain le blanc de poulet pané, puis la salade verte, puis la mayonnaise et le chapeau du burger.");
        title.addLast("Les Deluxe Potatoes");
        desc.addLast("Bien mélanger et ajouter les pommes de terre. Mélanger à nouveau et ajouter la farine et mélanger à nouveau.");
        title.addLast("Les Chicken McNuggets™");
        desc.addLast(" Couper le poulet en morceaux en forme de nuggets. Saupoudrer de paprika, et assaisonner avec un peu de sel et de poivre. Mélanger.");
            // Get a handle to the RecyclerView.
            mRecyclerView = findViewById(R.id.recyclerview);
            // Create an adapter and supply the data to be displayed.
            WordListAdapter mAdapter = new WordListAdapter(this, title,desc);
// Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
// Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}