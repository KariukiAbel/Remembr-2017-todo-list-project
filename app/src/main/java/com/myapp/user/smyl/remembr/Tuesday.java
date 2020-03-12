package com.myapp.user.smyl.remembr;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tuesday extends AppCompatActivity {
EditText mtitle,mapp,mdate,mtime;

    TextView tx;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);
//        tx=(TextView)findViewById(R.id.textView3);
//        Typeface c=Typeface.createFromAsset(getAssets(),"fonts/raleway.ttf");
//        tx.setTypeface(c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.next){
            startActivity(new Intent(this,Tuesday.class));
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Save(View view) {
        //gets the data from the field from the user interface
        String title=mtitle.getText().toString().trim();
        String app= mapp.getText().toString().trim();
        String time= mtime.getText().toString().trim();
        String kdate= mdate.getText().toString().trim();
      long date=Long.parseLong(kdate);
        if (!kdate.isEmpty()&& !time.isEmpty()){
            //save the values
            Database db=new Database(this);
            db.saveUser(title,app,date,time);
            Toast.makeText(this, "Records are"+db.countRecords(), Toast.LENGTH_LONG).show();
            mtitle.setText("");
            mapp.setText("");
            mdate.setText("");
            mtime.setText("");

        }
        else{
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();}
    }

    }

