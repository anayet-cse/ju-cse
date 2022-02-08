package com.example.juhub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private EditText email, password;
     Button login, register;
     FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.edtInput_Email);
        password = (EditText) findViewById(R.id.edtInput_Password);
        login = (Button) findViewById(R.id.button_login);
        register = (Button) findViewById(R.id.button_SignUp);

        fauth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupListeners();
            }
        });
    }

    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkEnteredData();

                String memail = email.getText().toString().trim();
                String mpassword= password.getText().toString().trim();
                if(TextUtils.isEmpty(memail)){
                    email.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(mpassword)){
                    password.setError("Password is Required");
                    return;
                }
                if(mpassword.length()<6){
                    password.setError("Password is Required");
                    return;
                }
                fauth.signInWithEmailAndPassword(memail,mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            //startActivity(intent);
                            Intent i = new Intent(MainActivity.this, BachelorProgramActivity.class);
                            startActivity(i);
                        }
                    }

                });
            }
        });
    }

    /*boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkEnteredData() {
        boolean isValid = true;
        if (isEmpty(email)) {
            email.setError("You must enter email to login!");
            isValid = false;
        }
        if (isEmpty(password)) {
            password.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }
        //check email and password
        //IMPORTANT: here should be call to backend or safer function for local check; For example simple check is cool
        //For example simple check is cool
        if (isValid) {

                this.finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong email or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }*/
}