package com.example.ossusum.hunter;

import android.app.AlarmManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    ListView BountyList;
    Bundle Alarm;
    int Hour;
    int Min;
    String Name;
    String Url;
    ArrayList items = new ArrayList();// must be instantiated otherwise null pointer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the List from activity_main
        BountyList = (ListView) findViewById(R.id.bounty_listView);
        items.add("TEST");
        ArrayAdapter mAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
        BountyList.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();
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
        if(id == R.id.new_bounty){
            //starts the Alarm making activity
            startActivityForResult((new Intent(this,AlarmMaker.class)),99);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 99){
            if(resultCode == RESULT_OK){
                //set alarm
                AlarmManager mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                //get all data

                //make it so it saves it in the bundle
                //mAlarmManager.setExact();

                //add inputs to this

                //Shows up if sucessful
            }

        }
    }
}
