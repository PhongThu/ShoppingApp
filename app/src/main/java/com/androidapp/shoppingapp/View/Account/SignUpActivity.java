package com.androidapp.shoppingapp.View.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapp.shoppingapp.R;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUpActivity extends AppCompatActivity {


    EditText edtEmail, edtPassword, edtPassword_rp;
    Button btnSignup;
    TextView txtSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
    }

    public void initView(){
        edtEmail = (EditText) findViewById(R.id.editEmail);
        edtPassword = (EditText) findViewById(R.id.editPassword);
        edtPassword_rp = (EditText) findViewById(R.id.editPassword_repeat);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        txtSignin = (TextView) findViewById(R.id.txtSignin_repeat);
    }

    public void initControl(){
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });
    }

    public void signUp(){

    }
}