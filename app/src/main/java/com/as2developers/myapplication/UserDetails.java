package com.as2developers.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class UserDetails extends AppCompatActivity {
    EditText mname,memail;
    Button mputname;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase fdata;
    String usernumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        mname = findViewById(R.id.Name);
        memail = findViewById(R.id.Email);
        mputname = findViewById(R.id.putName);
        firebaseAuth = FirebaseAuth.getInstance();
        fdata = FirebaseDatabase.getInstance();
        Intent intent = getIntent();
        usernumber = intent.getStringExtra("mobile");

        mname.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        mputname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email =memail.getText().toString().trim();
                String Name = mname.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    memail.setError("Email is required!");
                    return;
                }
                if(TextUtils.isEmpty(Name)){
                    mname.setError("Name is required!");
                    return;
                }

                DatabaseReference databaseReference = fdata.getReference("Users").child("+91"+usernumber);
                HashMap<Object, String> hashMap = new HashMap<>();
                hashMap.put("Email", Email);
                hashMap.put("Name", Name);
                hashMap.put("Mobile","+91"+usernumber);
                databaseReference.setValue(hashMap);
                startActivity(new Intent(getApplicationContext(),Verify_Number.class));
            }
        });



    }
}