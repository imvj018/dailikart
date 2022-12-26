package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
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

public class MainActivity extends AppCompatActivity {
    ImageView logo;
    TextView forgot_password, register;
    Button Login;
    String logourl = "https://www.dailikart.com/public/uploads/all/l74YCRpMT63hdqpypAYCbOD4EIfBnb88McDIiqyM.png",
            profileurl = "https://testapi.innovasivtech.com/emp_attendance/profile_api/read.php";
    String getid, getname, getpassword, getphoneno, getmailid;
    String username, password;
    String Login_Status = "";
    TextInputLayout Username, Password;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
            logo = findViewById(R.id.dailikart_logo);
            Glide.with(this).load(logourl).into(logo);
            Username = findViewById(R.id.login_Username);
            Password = findViewById(R.id.login_Password);
            forgot_password = findViewById(R.id.fgtpw);
            register = findViewById(R.id.rgn);
            Login = findViewById(R.id.login_button);

            sessionManager = new SessionManager(getApplicationContext());

            Login.setOnClickListener(v -> {

                getuserdata(profileurl);
            });
            if (sessionManager.getlogin()) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
            }
            register.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            });


    }

    private void getuserdata(String profileurl) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        @SuppressLint("SetTextI18n") StringRequest stringRequest = new StringRequest(Request.Method.GET, profileurl, response -> {
            try {
                username = Objects.requireNonNull(Username.getEditText()).getText().toString();
                password = Objects.requireNonNull(Password.getEditText()).getText().toString();
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("body");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    getid = jsonObject1.getString("id");
                    getname = jsonObject1.getString("first_name");
                    getpassword = jsonObject1.getString("user_password");
                    getphoneno = jsonObject1.getString("mobile_no");
                    getmailid = jsonObject1.getString("official_email_id");


                    if (((getphoneno.equals(username)) || (getmailid.equals(username))) && (getpassword.equals(password))) {
                        Login_Status = "OK";

                        SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("name", getname);
                        editor.putString("phone", getphoneno);
                        editor.putString("mail", getmailid);

                        editor.apply();

                        sessionManager.setlogin(true);
                        sessionManager.setUsername(username);
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));


                    }

                }

                if (!Login_Status.equals("OK")) {

                    Toast.makeText(MainActivity.this, "Incorrect Username or Password!", Toast.LENGTH_SHORT).show();

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

//Videoview
//   VideoView videoView = findViewById(R.id.videoView);
//      videoView.setVideoPath("http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4");
//         videoView.start();