package com.example.wastesortingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
    BarDatabase database;
    String Barcodenum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // open database
        if (database != null) {
            database.close();
            database = null;
        }

        database = BarDatabase.getInstance(this);
        boolean isOpen = database.open();

    }

    public void startBarcodeReader(View v){
        new IntentIntegrator(this).initiateScan();
    }
    public void startBarcodeInsert(View v) {
        Intent insertbarcode = new Intent(this, InsertBarcode.class);
        startActivityForResult(insertbarcode, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        String n="";
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (requestCode == 0){
            if(resultCode == RESULT_OK){
                Barcodenum = data.getStringExtra("Barcodenum");
                Toast.makeText(this, "결과 : "+Barcodenum, Toast.LENGTH_LONG).show();

            }
        }
        else{
            if(result != null) { //정상적으로 스캔
                if(result.getContents() == null) {
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
                } else {
                    n = result.getContents();
                    Toast.makeText(this, "Scanned", Toast.LENGTH_LONG).show();
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }
        }


        String result2 = database.selectAll(n);


        if(result2.equalsIgnoreCase("종이"))
        {
            Toast.makeText(this, "if문 들어옴", Toast.LENGTH_LONG).show();
            Intent paper = new Intent(this, Paper.class);
            startActivity(paper);
            //여기에 이미지 나오게 해줘

        }



        Toast.makeText(getApplicationContext(), "정보를 조회했습니다."+result2, Toast.LENGTH_LONG).show();

    }
}
