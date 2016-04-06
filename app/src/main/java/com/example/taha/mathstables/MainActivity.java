package com.example.taha.mathstables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    LinearLayout TableLinearView;
    EditText TableNumberValue;
    EditText TableStartValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button CalculateButton = (Button) findViewById(R.id.CalculateButton);
        CalculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(TableNumberValue.length() < 1)
                {
                    Toast.makeText(MainActivity.this, "Please Fill ''Table Of:' field", Toast.LENGTH_SHORT).show();
                }
                if(TableStartValue.length() < 1)
                {
                    Toast.makeText(MainActivity.this, "Please Fill 'Start From:' field", Toast.LENGTH_SHORT).show();
                }
                if(TableNumberValue.length() > 0 && TableStartValue.length() > 0)
                {
                    CreateTable();
                }

            }
        });

         TableLinearView = (LinearLayout) findViewById(R.id.TableLinearView);
         TableNumberValue = (EditText) findViewById(R.id.TableNumberValue);
         TableStartValue = (EditText) findViewById(R.id.TableStartValue);
    }

    public void CreateTable() {
        try

        {
            int j = Integer.parseInt(TableStartValue.getText().toString());
            int TableNumber = Integer.parseInt(TableNumberValue.getText().toString());
            TableLinearView.removeAllViews();
            for (int i = j; i <= j + 9; i++) {
                TextView textView = new TextView(this);
                textView.setTextSize((float) 20);
                textView.setGravity(Gravity.CENTER);
                textView.setText(TableNumberValue.getText() + " x " + i + " = " + (TableNumber * i));
                TableLinearView.addView(textView);
            }
        }
        catch (Exception ex)
        {
            Toast.makeText(MainActivity.this, "Ooops Application Crash...", Toast.LENGTH_SHORT).show();
        }
    }
}
