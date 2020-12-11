package com.example.wastesortingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.time.Instant;
import java.util.HashMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.core.Tag;


class Board{
    String phone="1";
    String id="1";
    String pw="1";
    Board(String phone,String id,String pw){
        this.phone=phone;
        this.id=id;
        this.pw=pw;
    }
    public String getPhone() {return phone;}
    public String id() {return id;}
    public String pw() {return pw;}
}
public class Real_loginActivity extends AppCompatActivity {

    Button btn;
    EditText enter_phone;
    EditText enter_id;
    EditText enter_pw;
    String s_enter_phone;
    String s_enter_id;
    String s_enter_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_login);
        enter_phone= findViewById(R.id.edit_phone);
        enter_id = findViewById(R.id.edit_id);
        enter_pw = findViewById(R.id.edit_pw);
        btn = findViewById(R.id.button6);




        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        s_enter_phone=enter_phone.getText().toString();
                        s_enter_id=enter_id.getText().toString();
                        s_enter_pw=enter_pw.getText().toString();

                        if(snapshot.child("users").child(s_enter_phone).child(s_enter_id).child("ok").exists())
                        {
                            if(snapshot.child("users").child(s_enter_phone).child(s_enter_pw).child("ok").exists())
                            {
                                if(snapshot.child("users").child(s_enter_phone).exists())
                                {
                                    System.out.println("야호 성공이다 : " + s_enter_phone);
                                    TextView textView;
                                    textView = (TextView) findViewById(R.id.textView3);
                                    textView.setText("로그인 성공!");
                                    Toast.makeText(Real_loginActivity.this, "로그인 성공", Toast.LENGTH_LONG).show();
//                                    Intent intent = new Intent(Real_loginActivity.this, MainActivity.class);
//                                    startActivity(intent);
                                }
                                else
                                {
                                    TextView textView;
                                    textView = (TextView) findViewById(R.id.textView3);
                                    textView.setText("로그인 실패!");
                                }
                            }
                            else
                            {
                                TextView textView;
                                textView = (TextView) findViewById(R.id.textView3);
                                textView.setText("로그인 실패!");
                            }
                        }
                        else
                        {
                            TextView textView;
                            textView = (TextView) findViewById(R.id.textView3);
                            textView.setText("로그인 실패!");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        });
    }
    public void end(View v){
        Intent intent = new Intent(Real_loginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

