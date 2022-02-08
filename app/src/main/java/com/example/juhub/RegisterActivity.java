package com.example.juhub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class RegisterActivity<isValid> extends AppCompatActivity {
    private EditText name;
    private EditText user_name;
    EditText email;
    private EditText registration_number;
    private EditText exam_roll;
    EditText password;
    EditText confirm_password;

    private Button register;
    String userID;

    FirebaseAuth fauth;
    FirebaseFirestore fstore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.edtInput_FullName);
        user_name = (EditText) findViewById(R.id.edtInput_UserName);
        email = (EditText) findViewById(R.id.edtInput_Email);
        registration_number = (EditText) findViewById(R.id.edtInput_Registration_Number);
        exam_roll = (EditText) findViewById(R.id.edtInput_Exam_Roll);
        password = (EditText) findViewById(R.id.edtInput_Password);
        confirm_password = (EditText) findViewById(R.id.edtInput_Confirm_Password);
        register = (Button) findViewById(R.id.button_SignUp);

        fauth = FirebaseAuth.getInstance();
        fstore= FirebaseFirestore.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              /*  String mname = name.getText().toString();
                String muser_name =  user_name.getText().toString().trim();
                String memail = email.getText().toString().trim();
                String  mregistration_number =  registration_number.getText().toString().trim();
                String mexam_roll =  exam_roll.getText().toString().trim();
                String mpassword = password.getText().toString().trim();
                String mconfirm_password =  confirm_password.getText().toString().trim();

                if (TextUtils.isEmpty(memail)) {
                    email.setError("Email is Required");
                }

                else if (TextUtils.isEmpty(mpassword)) {
                    password.setError("Password is Required");
                }
                else if (mpassword.length() < 6) {
                    password.setError("Password is Required");
                }else {
                    fauth.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                userID = fauth.getCurrentUser().getUid();
                                DocumentReference documentReference = fstore.collection("profile").document(userID);
                                Map<String, Object> user = new HashMap<>();

                                user.put("Name", mname);
                                user.put("User Name", muser_name);
                                user.put("Email", memail);
                                user.put("Registration Number", mregistration_number);
                                user.put("Exam Roll", mexam_roll);

                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "ok" + user);
                                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    });

                }*/
                //} //else {
                //Toast t = Toast.makeText(this, "You must match password and confirm password to register!", Toast.LENGTH_SHORT);
                // t.show();
                //   }


                 checkDataEntered();
            }
        });
    }




    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    void checkDataEntered() {
        boolean isValid = true;
        if (isEmpty(name)) {
            name.setError("Full name is required!");
            isValid = false;
        }
        if (isEmpty(user_name)) {
            user_name.setError("User name name is required!");
            isValid = false;
        }
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");

            isValid = false;
        }
        if (isEmpty(registration_number)) {
            registration_number.setError("Registration no is required!");
            isValid = false;
        }
        if (isEmpty(exam_roll)) {
            exam_roll.setError("Exam roll is required!");
            isValid = false;
        }
        if (isEmpty(password)) {
            password.setError("Password is required!");
            isValid = false;

        }else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }
        if (isEmpty(confirm_password)) {
            confirm_password.setError("Confirm password name is required!");
            isValid = false;
        }

        if (isValid==true) {
            String Password = password.getText().toString();
            String Confirm_Password = confirm_password.getText().toString();
            boolean retval = Password.equals(Confirm_Password);
            if (retval == true) {

                String mname = name.getText().toString();
                String muser_name =  user_name.getText().toString().trim();
                String memail = email.getText().toString().trim();
                String  mregistration_number =  registration_number.getText().toString().trim();
                String mexam_roll =  exam_roll.getText().toString().trim();
                String mpassword = password.getText().toString().trim();
                String mconfirm_password =  confirm_password.getText().toString().trim();



                    fauth.createUserWithEmailAndPassword(memail, mpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                userID = fauth.getCurrentUser().getUid();
                                DocumentReference documentReference = fstore.collection("profile").document(userID);
                                Map<String, Object> user = new HashMap<>();

                                user.put("Name", mname);
                                user.put("User Name", muser_name);
                                user.put("Email", memail);
                                user.put("Registration Number", mregistration_number);
                                user.put("Exam Roll", mexam_roll);

                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "ok" + user);
                                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                });
                            }
                        }
                    });


            } else {
                Toast t = Toast.makeText(this, "You must match password and confirm password to register!", Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

}

//}
