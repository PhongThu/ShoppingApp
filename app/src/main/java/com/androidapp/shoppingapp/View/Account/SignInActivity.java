package com.androidapp.shoppingapp.View.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapp.shoppingapp.MainActivity;
import com.androidapp.shoppingapp.Models.UserModel;
import com.androidapp.shoppingapp.R;
import com.androidapp.shoppingapp.Utils.Api;
import com.androidapp.shoppingapp.Utils.RetrofitClient;
import com.androidapp.shoppingapp.Utils.Utils;

import java.security.spec.ECField;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SignInActivity extends AppCompatActivity {

    EditText email, password;
    Button btnSignin, btnSignup;
    TextView txtForgot_pass;
    Api api;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    boolean isSignin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
        initControl();
    }

    private void initView(){
        //Paper.init(this);
        api = RetrofitClient.getInstane(Utils.BASE_URL).create(Api.class);

        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPassword);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnSignin = (Button) findViewById(R.id.btnSignin);
        txtForgot_pass = (TextView) findViewById(R.id.forgot_password);

    }

    private void initControl(){
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(signUp);
            }
        });

        txtForgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_email = email.getText().toString();
                String str_password = password.getText().toString();

                if (TextUtils.isEmpty(str_email)){
                    Toast.makeText(getApplicationContext(),"Bạn chưa nhập email",Toast.LENGTH_LONG).show();
                    email.requestFocus();
                } else if (TextUtils.isEmpty(str_password)){
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mật khẩu", Toast.LENGTH_LONG).show();
                    password.requestFocus();
                } else {
                    signIn(str_email, str_password);

                }
            }
        });
    }

    public void signIn(String str_email, String str_password){
        compositeDisposable.add(api.signIn(str_email, str_password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        UserModel -> {

                            if (UserModel.isSuccess()){
                                isSignin = true;
                                Utils.user_current = UserModel.getResult().get(0);
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), UserModel.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        },
                        throwable -> {
                            Toast.makeText(getApplicationContext(),throwable.getMessage(),Toast.LENGTH_LONG).show();
                        }
                )
        );
    }
    protected void onDestroy ( ) {
        compositeDisposable.clear ();
        super.onDestroy ();
    }
}