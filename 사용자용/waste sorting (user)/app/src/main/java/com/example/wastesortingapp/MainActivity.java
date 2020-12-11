package com.example.wastesortingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.wastesortingapp.ui.main.SectionsPagerAdapter;
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

    public void login(View v)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void real_login(View v){
        Intent intent = new Intent(this, Real_loginActivity.class);
        startActivity(intent);
    }
    public void manual(View v){
        Intent intent = new Intent(this, introduce.class);
        startActivity(intent);
    }
    public void waste(View v){
        Intent intent = new Intent(this, Waste.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        String n="";
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (requestCode == 0){
            if(resultCode == RESULT_OK){
                Barcodenum = data.getStringExtra("Barcodenum");
                Toast.makeText(this, "결과 : "+Barcodenum, Toast.LENGTH_LONG).show();
                n = Barcodenum;
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
            Intent paper = new Intent(this, Paper.class);
            startActivity(paper);
        }

        if(result2.equalsIgnoreCase("박스"))
        {
            Intent box = new Intent(this, box.class);
            startActivity(box);
        }

        if(result2.equalsIgnoreCase("유리병"))
        {
            Intent glassbottle = new Intent(this, Glassbottle.class);
            startActivity(glassbottle);
        }

        if(result2.equalsIgnoreCase("캔"))
        {
            Intent intent = new Intent(this, Can.class);
            startActivity(intent);
        }

        if(result2.equalsIgnoreCase("고철"))
        {
            Intent intent = new Intent(this, Iron.class);
            startActivity(intent);
        }

        if(result2.equalsIgnoreCase("노트"))
        {
            Intent intent = new Intent(this, Note.class);
            startActivity(intent);
        }

        if(result2.equalsIgnoreCase("종이팩"))
        {
            Intent intent = new Intent(this, Paperpack.class);
            startActivity(intent);
        }
        if(result2.equalsIgnoreCase("컵라면"))
        {
            Intent intent = new Intent(this, CupNoodle.class);
            startActivity(intent);
        }
        if(result2.equalsIgnoreCase("바아이스크림"))
        {
            Intent intent = new Intent(this, BarIcecream.class);
            startActivity(intent);
        }
        if(result2.equalsIgnoreCase("페트"))
        {
            Intent intent = new Intent(this, Pet.class);
            startActivity(intent);
        }
        if(result2.equalsIgnoreCase("비닐포장"))
        {
            Intent intent = new Intent(this, PlasticBag.class);
            startActivity(intent);
        }





       // Toast.makeText(getApplicationContext(), "정보를 조회했습니다."+result2, Toast.LENGTH_LONG).show();

    }
}
