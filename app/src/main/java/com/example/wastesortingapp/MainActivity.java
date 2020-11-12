package com.example.wastesortingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Buttonscan(View v){
        Toast.makeText(this, "버튼이 눌렸어요.", Toast.LENGTH_LONG).show();
    }

}
