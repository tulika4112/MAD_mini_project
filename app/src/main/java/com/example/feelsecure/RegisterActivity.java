package com.example.feelsecure;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    EditText edusername,edpass,edmail;
    Button btnregs;
    TextView already;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        edusername=findViewById(R.id.editTextname);
        edpass=findViewById(R.id.editTextPassword);
        edmail=findViewById(R.id.editTextemail);
        btnregs=findViewById(R.id.buttonregs);
        already=findViewById(R.id.textViewregis);

        mAuth=FirebaseAuth.getInstance();


        btnregs.setOnClickListener(new View.OnClickListener() {

            String user_name=edusername.getText().toString();
            String pass=edpass.getText().toString();
            String email=edmail.getText().toString();



            @Override
            public void onClick(View view) {

                mAuth.createUserWithEmailAndPassword(email, pass)


                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "register Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));


                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(RegisterActivity.this, "register failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });



            }
        }
        );

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }







    });


    }
}