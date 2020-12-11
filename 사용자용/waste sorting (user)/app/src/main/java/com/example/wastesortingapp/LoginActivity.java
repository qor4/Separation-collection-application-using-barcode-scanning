package com.example.wastesortingapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    Button btn;
    EditText edit_ID;
    EditText edit_pw;
    EditText edit_Email;


    private DatabaseReference mDatabase;

    //회원가입
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        edit_Email= findViewById(R.id.edit_email);
        edit_ID = findViewById(R.id.edit_id);
        edit_pw = findViewById(R.id.edit_pwd);
        btn = findViewById(R.id.button);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getUserid = edit_ID.getText().toString();
                String getUserpw = edit_pw.getText().toString();
                String getUseremail = edit_Email.getText().toString();

                myRef.child(getUseremail).child(getUserid).setValue(getUserid);
                myRef.child(getUseremail).child(getUserid).child("ok").setValue(1);
                myRef.child(getUseremail).child(getUserpw).setValue(getUserpw);
                myRef.child(getUseremail).child(getUserpw).child("ok").setValue(1);
                myRef.child(getUseremail).child(getUseremail).setValue(getUseremail);
                myRef.child(getUseremail).child(getUseremail).child("ok").setValue(1);

                Toast.makeText(getApplicationContext(), "회원가입 성공", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

        });
        //회원가입 끝

    }
    public void end(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
