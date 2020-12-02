package com.example.wastesortingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

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
        //Toast.makeText(this, "결과 : "+insertbarcode, Toast.LENGTH_LONG).show();

        ToMain.putExtra("Barcodenum", insertbarcode);
        setResult(RESULT_OK, ToMain);
        finish();
    }
}