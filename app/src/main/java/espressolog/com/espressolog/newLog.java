package espressolog.com.espressolog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class newLog extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log);
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

    public void save(View view){
        //saves the data from the new log screen.
        // Using dummy data for now.
        String filename = "myFile";
        String[] data = new String[3];
        EditText v = (EditText) findViewById(R.id.shot_time_input);
        data[0] = "Shot time: " + v.getText().toString();
        v = (EditText) findViewById(R.id.weight_input);
        data[1] = "Weight: " + v.getText().toString();
        v = (EditText) findViewById(R.id.temperature_input);
        data[2] = "Temperature: " +v.getText().toString();
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            for (String s : data) {
                outputStream.write(s.getBytes());

            }
            outputStream.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // takes user back to main activity.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void cancel(View view){

        // deletes the data file for testing purposes.
        deleteFile("myFile");
        // Simply starts the main activity.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
