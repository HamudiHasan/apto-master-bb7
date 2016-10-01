package com.rh_navana_sorrento_am.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rh_navana_sorrento_am.ModelClass.User;
import com.rh_navana_sorrento_am.R;

public class reg_page extends AppCompatActivity implements View.OnClickListener {

    private Button registerbutton;
    private EditText edittextemail;
    private EditText editpassword;
    private TextView alreadyregister;
    private EditText name;
    private EditText floor;
    private Button btn;
    private ProgressDialog progressDialog;
    private Firebase mRootRef;

    private FirebaseAuth firebaseAuth;
    FirebaseDatabase db;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_page);
        //mRootRef = new Firebase("https://rhnavana.firebaseio.com/Users");

//        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
/*

        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),ActivityMenu.class));
        }
*/
        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        ref = db.getReference("User");

        registerbutton = (Button) findViewById(R.id.registerbutton);
        edittextemail = (EditText) findViewById(R.id.edittextemail);
        editpassword = (EditText) findViewById(R.id.editpassword);
        alreadyregister = (TextView) findViewById(R.id.alreadyregister);
        name = (EditText) findViewById(R.id.name);
        floor = (EditText) findViewById(R.id.floor);
        btn = (Button) findViewById(R.id.btn);

        alreadyregister.setOnClickListener(this);
        registerbutton.setOnClickListener(this);

        receiveDataFromFirebase();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add data to firebase DB .
               ref.push().setValue(new User(name.getText().toString(),floor.getText().toString()));
            }
        });

    }

    private void registerUser() {
        String email = edittextemail.getText().toString().trim();
        String password = editpassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
        }

        progressDialog.setMessage("registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(reg_page.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                            finish();
                            startActivity(new Intent(getApplicationContext(), ActivityMenu.class));

                        } else {
                            Toast.makeText(reg_page.this, "Please Try Again", Toast.LENGTH_SHORT).show();

                        }

                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == registerbutton) {
            registerUser();
        }
        if (view == alreadyregister) {
            startActivity(new Intent(this, login_page.class));
        }

    }
    public void receiveDataFromFirebase(){

        // show live change
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Toast.makeText(reg_page.this, snapshot.getValue().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

        //show data from DB
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("userList", dataSnapshot.getValue().toString());
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    User student = child.getValue(User.class);
                    Toast.makeText(reg_page.this, student.getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
