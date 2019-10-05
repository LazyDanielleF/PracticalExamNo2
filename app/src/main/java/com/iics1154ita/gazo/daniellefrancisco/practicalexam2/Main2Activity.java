package com.iics1154ita.gazo.daniellefrancisco.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("SUMMARY");
        try{
            Generate();
        } catch (Exception e){
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public void Generate() throws Exception{
        String FILENAME = "localdata.txt";
        FileInputStream fin = openFileInput(FILENAME);
        int c;
        String temp = "";
        while( (c = fin.read()) != -1) {
            temp += Character.toString((char)c);
        }
        fin.close();
        if(temp.length() > 0){
            String[] test = temp.split(",");
            String subjects = "  ";
            String comment = "";
            int length = 0;
            if(test[test.length - 1].contains("comment:")){
                comment = test[test.length - 1];
                length = test.length - 1;
            } else {
                length = test.length;
            }
            for(int i = 0; i < length; i++){
                if(i != length - 1){
                    subjects += test[i] + ", ";
                }
                else {
                    subjects += test[i];
                }
            }
            ((TextView)findViewById(R.id.textView4)).setText(subjects);
            ((TextView)findViewById(R.id.textView5)).setText(" "+comment.split("comment:")[1]);
        } else {
            Toast.makeText(this, "no content", Toast.LENGTH_LONG).show();
        }
    }

    public void send(View v){
        Toast.makeText(this, "request sent...", Toast.LENGTH_LONG).show();
    }

    public void previous(View v){
        finish();
    }
}
