package com.example.ossusum.hunter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;


public class AlarmMaker extends Activity {
    EditText Name;
    EditText Hour;
    EditText Min;
    EditText Url;
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_maker);

        //get all variables
        Name = (EditText) findViewById(R.id.nameID);
        Hour = (EditText) findViewById(R.id.hourID);
        Min = (EditText) findViewById(R.id.minuteID);
        Url = (EditText) findViewById(R.id.urlID);
        createButton = (Button) findViewById(R.id.createButton);

        //make returned intent
        final Intent returnIntent = new Intent();

        //set the onClickListener
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //put all variables in Intent
                returnIntent.putExtra("name",Name.getText().toString());
                returnIntent.putExtra("url", Url.getText().toString());
                returnIntent.putExtra("hour",Integer.parseInt(Hour.getText().toString()));
                returnIntent.putExtra("minute",Integer.parseInt(Min.getText().toString()));

            }
        });

        setResult(99,returnIntent);
        finish();

    }


}
