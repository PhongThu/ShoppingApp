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

import com.androidapp.shoppingapp.Models.UserModel;
import com.androidapp.shoppingapp.R;
import com.androidapp.shoppingapp.Utils.Api;
import com.androidapp.shoppingapp.Utils.RetrofitClient;
import com.androidapp.shoppingapp.Utils.Utils;
import com.vishnusivadas.advanced_httpurlconnection.PutData;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
public class SignUpActivity extends AppCompatActivity {


    EditText edtEmail, edtPassword, edtPassword_rp, edtPhone;
    Button btnSignup;
    TextView txtSignin;
    Api api;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initView();
        initControl();
    }

    public void initView(){
        api = RetrofitClient.getInstane(Utils.BASE_URL).create(Api.class);
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

        txtSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent return_signIn = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(return_signIn);
            }
        });
    }


    public void signUp(){
        String str_email = edtEmail.getText().toString();
        String str_password = edtPassword.getText().toString();
        String str_password_rp = edtPassword_rp.getText().toString();
        String str_phone = edtPhone.getText().toString();

        //if (TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_password) || TextUtils.isEmpty(str_password_rp) || TextUtils.isEmpty(str_phone)){
            if (TextUtils.isEmpty(str_email)){
                Toast.makeText(getApplicationContext(),"Bạn chưa nhập email",Toast.LENGTH_LONG).show();
                edtEmail.requestFocus();
            } else if (TextUtils.isEmpty(str_phone)){
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập số điện thoại",Toast.LENGTH_LONG).show();
                edtPhone.requestFocus();
            } else if (TextUtils.isEmpty(str_password)){
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập mật khẩu",Toast.LENGTH_LONG).show();
                edtPassword.requestFocus();
            } else if ( str_password.equals(str_password_rp)){
                compositeDisposable.add(api.signUp(str_email, str_password, str_phone)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                UserModel -> {
                                    if (UserModel.isSuccess()){
                                        Utils.user_current.setEmail(str_email);
                                        Utils.user_current.setPass(str_password);
                                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                                        Intent return_signIn = new Intent(getApplicationContext(), SignInActivity.class);
                                        startActivity(return_signIn);
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), UserModel.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                },
                                throwable -> {
                                    Toast.makeText(getApplicationContext(), throwable.getMessage(),Toast.LENGTH_LONG).show();
                                }
                        )
                );
            } else {
                Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_LONG).show();
                edtPassword_rp.requestFocus();
            }
    }
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}