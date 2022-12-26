package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Register extends AppCompatActivity {
    ImageView logo;
    TextInputLayout name, phone, password, cpasword;
    Button signup;
    TextView login;
    String Fullname, Phone, Password, Cpassword;
    String getid, getphone, getmail;
    String Reg_status = "";
    String logourl = "https://www.dailikart.com/public/uploads/all/l74YCRpMT63hdqpypAYCbOD4EIfBnb88McDIiqyM.png",
            profileurl = "https://testapi.innovasivtech.com/emp_attendance/profile_api/read.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        logo = findViewById(R.id.dailikart_logo);
        Glide.with(this).load(logourl).into(logo);

        name = findViewById(R.id.full_name);

        phone = findViewById(R.id.phone_no);
        password = findViewById(R.id.password);
        cpasword = findViewById(R.id.confirm_password);
        signup = findViewById(R.id.signup_button);
        login = findViewById(R.id.login_text);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getuserdata(profileurl);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getuserdata(String profileurl) {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        @SuppressLint("SetTextI18n") StringRequest stringRequest = new StringRequest(Request.Method.GET, profileurl, response -> {
            try {
                Fullname = Objects.requireNonNull(name.getEditText()).getText().toString();
                Phone = Objects.requireNonNull(phone.getEditText()).getText().toString();
                Password = Objects.requireNonNull(password.getEditText()).getText().toString();
                Cpassword = Objects.requireNonNull(cpasword.getEditText()).getText().toString();


                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("body");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    getid = jsonObject1.getString("id");

                    getphone = jsonObject1.getString("mobile_no");
                    getmail = jsonObject1.getString("official_email_id");

                    if (getphone.equals(Phone) ) {
                        Reg_status = "exist";
                        Toast.makeText(Register.this, "Account already exists!", Toast.LENGTH_SHORT).show();
                    }

                }

                if (!Reg_status.equals("exist")) {
                    if (Password.equals(Cpassword)) {
                        Toast.makeText(Register.this, "Account created!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Register.this, "Password Mismatch!", Toast.LENGTH_SHORT).show();
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, Throwable::printStackTrace);
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }
}