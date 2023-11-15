package com.androidapp.shoppingapp.View.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapp.shoppingapp.R;
import com.androidapp.shoppingapp.Ultils.Api;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUpActivity extends AppCompatActivity {


    EditText edtEmail, edtPassword, edtPassword_rp, edtPhone;
    Button btnSignup;
    TextView txtSignin;
    Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
        initControl();
    }

    public void initView(){
        edtEmail = (EditText) findViewById(R.id.editEmail);
        edtPassword = (EditText) findViewById(R.id.editPassword);
        edtPassword_rp = (EditText) findViewById(R.id.editPassword_repeat);
        edtPhone = (EditText) findViewById(R.id.editPhone);
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
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String password_rp = edtPassword_rp.getText().toString();
        String phone = edtPhone.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(password_rp) || TextUtils.isEmpty(phone)){
            if (TextUtils.isEmpty(email)){

            }
        }
    }
}