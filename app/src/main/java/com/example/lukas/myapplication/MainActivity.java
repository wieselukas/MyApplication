package com.example.lukas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import data.Data;
import dataInputs.RSSReader;

public class MainActivity extends AppCompatActivity {
    private List<Data> myData;

    //test Data initialization
    private void initializeData(){
        myData = new ArrayList<>();
        myData.add(new Data(0,21,"Berlin","Mo",32,"01"));
        myData.add(new Data(0,22,"Finowfurt","Mo",32,"02"));
        myData.add(new Data(0,23,"Berlin","Mo",32,"03"));
        myData.add(new Data(0,24,"Frankfurt","Mo",32,"05"));
        myData.add(new Data(1,"Erste Überschrift","erster Text erster Text erster Text erster Text erster Text erster Text erster Text ","from FAZ"));
        myData.add(new Data(1,"Erste Überschrift","erster Text erster Text erster Text erster Text erster Text erster Text erster Text ","from Spiegel"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        //Obtaining the RecyclerView
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv_id);
        rv.setHasFixedSize(true);

        //Setting up the LayoutManager
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        /*@Vitus PLACE TO PUT YOUR CODE IN*/
        RSSReader rssReader = new RSSReader(this);
        rssReader.execute();

        rvAdapter adapter = new rvAdapter(myData);
        rv.setAdapter(adapter);

    }

    //create the settings button in the Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        return true;
    }

    //Call the settings Activity when "Settings" is pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.settings_id){
            //Settings Button pressed
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

