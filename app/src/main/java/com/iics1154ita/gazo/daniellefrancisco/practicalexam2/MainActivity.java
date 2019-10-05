package com.iics1154ita.gazo.daniellefrancisco.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SUBJECT REQUEST");
    }

    public void save(View v) throws Exception{
        String FILENAME = "localdata.txt";
        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
        String string = "";
        if(((CheckBox)findViewById(R.id.checkBox1)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox1)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox2)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox2)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox3)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox3)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox4)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox4)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox5)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox5)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox6)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox6)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox7)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox7)).getText().toString() + ",";
        }
        if(((CheckBox)findViewById(R.id.checkBox8)).isChecked()){
            string += ((CheckBox)findViewById(R.id.checkBox8)).getText().toString() + ",";
        }
        if(((EditText)findViewById(R.id.editText)).getText().length() > 0){
            string += "comment:" + ((EditText)findViewById(R.id.editText)).getText().toString();
        }

        byte[] buf = string.getBytes();
        fos.write(buf);
        fos.close();
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void next(View view){
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
