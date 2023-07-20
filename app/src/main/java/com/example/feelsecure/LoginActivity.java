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

public class LoginActivity extends AppCompatActivity {
    EditText email,edpass;
    Button btnlogin;
    TextView regs;

    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.editTextname);
        edpass=findViewById(R.id.editTextPassword);
        btnlogin=findViewById(R.id.buttonregs);
        regs=findViewById(R.id.textViewregis);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=email.getText().toString();
                String pass=edpass.getText().toString();

                if(user.length()==0||pass.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "fill all details", Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(user,pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Toast.makeText(getApplicationContext(), "login Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));


                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(LoginActivity.this, "login failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });












                       Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        regs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


    }
}