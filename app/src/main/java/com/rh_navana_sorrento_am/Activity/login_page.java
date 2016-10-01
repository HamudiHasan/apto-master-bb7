package com.rh_navana_sorrento_am.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rh_navana_sorrento_am.R;

public class login_page extends AppCompatActivity implements View.OnClickListener {

    private Button loginbutton;
    private EditText loginemail;
    private EditText loginpassword;
    private TextView reghere;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),ActivityMenu.class));
        }

        loginbutton = (Button) findViewById(R.id.loginbutton);
        loginemail = (EditText) findViewById(R.id.loginemail);
        loginpassword = (EditText) findViewById(R.id.loginpassword);
        reghere = (TextView) findViewById(R.id.reghere);

        reghere.setOnClickListener(this);
        loginbutton.setOnClickListener(this);
    }

    private void loginuser()
    {
        String email = loginemail.getText().toString().trim();
        String password = loginpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"Please enter email",Toast.LENGTH_SHORT).show();
        }
        if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please enter password",Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("Siginig in...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            finish();
                            startActivity(new Intent(getApplicationContext(),ActivityMenu.class));
                        }

                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == loginbutton)
        {
            loginuser();
        }
        if(view == reghere) {
            finish();
            startActivity(new Intent(this,reg_page.class));
        }
    }
}
