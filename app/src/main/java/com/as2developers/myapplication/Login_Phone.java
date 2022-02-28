package com.as2developers.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login_Phone extends AppCompatActivity {
    EditText mPhoneNumber;
    Button mgetOTP;
    FirebaseAuth fAuth;
    FirebaseUser currentUser;
    FirebaseDatabase fdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_phone);
        mPhoneNumber = findViewById(R.id.PhoneNumber);
        mgetOTP = findViewById(R.id.getOTP);
        fAuth = FirebaseAuth.getInstance();
        currentUser = fAuth.getCurrentUser();
        fdata = FirebaseDatabase.getInstance();

        mPhoneNumber.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        if (currentUser != null) {
            Intent intent = new Intent(Login_Phone.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            mgetOTP.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String mobileNo = mPhoneNumber.getText().toString().trim();

                    if (mobileNo.isEmpty() | mobileNo.length()!=10) {
                        mPhoneNumber.setError("Enter a valid Phone Number");
                        mPhoneNumber.requestFocus();
                        return;
                    }

                    DatabaseReference databaseReference = fdata.getReference("Users").child("+91"+mobileNo);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //Toast.makeText(Login_Phone.this, "inside OnClick", Toast.LENGTH_SHORT).show();
                            if(!snapshot.exists()){
                                Intent intent1 = new Intent(Login_Phone.this, UserDetails.class);
                                intent1.putExtra("mobile", mobileNo);
                                startActivity(intent1);
                            }
                            else{
                                Intent intent = new Intent(Login_Phone.this, Verify_Number.class);
                                intent.putExtra("mobile", mobileNo);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(Login_Phone.this, "Error:inside OnClick: "+error, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }
    }
}