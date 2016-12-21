package com.example.oscar.m8uf1p3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class RelationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relation);

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        TextView label = (TextView) findViewById(R.id.textView);

        Intent intent = getIntent();
        String manName = intent.getStringExtra("man");
        String womanName = intent.getStringExtra("woman");
        Random random = new Random();
        String out = "";
        switch((int)random.nextInt(4))
        {
            case 0:
                out = manName + " no le ira muy bien con " + womanName;
                break;
            case 1:
                out = womanName + " será muy feliz con " + manName;
                break;

            case 2:
                out = "A " + womanName + " no le gustan los hombres. " + manName + " lo tiene difícil";
                break;

            case 3:
                out = "A " + manName + " no le gustan las mujeres. " + womanName + " lo tiene difícil";
                break;

        }

        label.setText(out);
    }
}
