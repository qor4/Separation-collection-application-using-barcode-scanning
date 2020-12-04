package com.example.wastesortingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InsertBarcode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_barcode);
    }

    public void btn_Click(View v) {
        Intent ToMain = new Intent();
        String insertbarcode;
        EditText editText = (EditText)findViewById(R.id.editText);
        insertbarcode = String.valueOf(editText.getText());

        ToMain.putExtra("Barcodenum", insertbarcode);
        setResult(RESULT_OK, ToMain);
        finish();
    }
}