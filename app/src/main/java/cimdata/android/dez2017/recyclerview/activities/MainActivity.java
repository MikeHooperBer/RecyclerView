package cimdata.android.dez2017.recyclerview.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import cimdata.android.dez2017.recyclerview.R;
import cimdata.android.dez2017.recyclerview.adapter.ListViewAdapter;
import cimdata.android.dez2017.recyclerview.models.AnimalImages;
import cimdata.android.dez2017.recyclerview.services.DataServices;

public class MainActivity extends AppCompatActivity {

    RecyclerView listView;


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

        installRecyclerView();
    }

    private void installRecyclerView() {
        // Daten holen
        AnimalImages[] data = DataServices.animalImages;


        // Hier steuern wir wie die Daten dargestelllt werden sollen
        // unabhängig von den Werten

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);

        RecyclerView.Adapter adapter = new ListViewAdapter(
                this,
                data
        );

        listView = findViewById(R.id.rcy_acmain);
        listView.setLayoutManager(manager);
        listView.setAdapter(adapter);
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
}
