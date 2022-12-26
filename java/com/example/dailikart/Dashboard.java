package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Dashboard extends AppCompatActivity {
    SessionManager sessionManager;

    String name, phone, mail;
    String sliderurl = "https://raw.githubusercontent.com/imvj018/newjson/main/testautoslide.json",
            logourl = "https://raw.githubusercontent.com/imvj018/newjson/main/l74YCRpMT63hdqpypAYCbOD4EIfBnb88McDIiqyM.png",
            produrlx = "https://raw.githubusercontent.com/imvj018/newjson/main/prodlist.json";
    private SliderView sliderView;
    private SliderAdapter adapter;

    private ArrayList<SliderData> sliderDataArrayList;
    String banner = "https://raw.githubusercontent.com/imvj018/newjson/main/Screenshot_1.png";
    String img1 = "https://www.dailikart.com/public/uploads/all/MYyuRsJi0aCBnDaTzVaU0FHQwhSDR0oYwlEOpaRq.jpg",
            img2 = "https://www.dailikart.com/public/uploads/all/7Mbx0YPYqNflWOdrmOwi439ZVy99lpm62q6N7iz6.jpg",
            img3 = "https://www.dailikart.com/public/uploads/all/VncinE5xewNMeHZbNP5m4nmAPGRV1AV2CRP8vKEZ.jpg";
    String story1 = "https://www.dailikart.com/public/uploads/all/zPM9hWcVSWEN6pok0ogcxJyVtejFfOUSb02ty6Vs.jpg",
            story2 = "https://www.dailikart.com/public/uploads/all/ArOdwJVXRxKieKr6NTskqca41kqAEO1gLr0RJisW.jpg",
            story3 = "https://www.dailikart.com/public/uploads/all/BBwLuMiqDYq4MGSsX9JgbnBnAEqRRa6Lb2RxEyYh.jpg",
            story4 = "https://www.dailikart.com/public/uploads/all/7vojLjpM2kwKs66m8Qu7cm6fBpVFqud9cu7JfeiI.jpg",
            story5 = "https://www.dailikart.com/public/uploads/all/dfjrygyYk8eSERcLxSebTDTk0izABDsC41qysfb7.jpg",
            story6 = "https://www.dailikart.com/public/uploads/all/SAhgWJtmBfbNUvTuYwa8vCrLetcBsVlRhZmi8yOO.jpg",
            story7 = "https://www.dailikart.com/public/uploads/all/BBwLuMiqDYq4MGSsX9JgbnBnAEqRRa6Lb2RxEyYh.jpg",
            story8 = "https://www.dailikart.com/public/uploads/all/hwqCivOOUfL8ycqqHQbL0sZXi3drqrzKHs3DdeYO.jpg";
    String cat1 = "https://images-na.ssl-images-amazon.com/images/G/31/img22/Fashion/Event/Jupiter22/Eventpage/Phase1/SBC/Women/V2/New-Women-SBC_13._SS400_QL85_.jpg",
            cat2 = "https://m.media-amazon.com/images/G/31/img21/Jupiter22/phase2/P0/SBC/6._SY530_QL85_.jpg",
            cat3 = "https://m.media-amazon.com/images/G/31/img22/Fashion/Event/Jupiter22/Eventpage/Phase1/SBC/Women/V2/WOMEN-SBC_new_03._SS400_QL85_.jpg",
            cat4 = "https://m.media-amazon.com/images/G/31/img21/Jupiter22/phase2/P0/SBC/2._SY530_QL85_.jpg",
            cat5 = "https://m.media-amazon.com/images/G/31/img22/Fashion/Event/Jupiter22/kidsfashion/sbc/SBC_02._SS400_QL85_.jpg",
            cat6 = "https://m.media-amazon.com/images/G/31/img22/Fashion/Event/Jupiter22/kidsfashion/sbc/SBC_05._SS400_QL85_.jpg";
    CircleImageView test1, test2, test3, test4, test5, test6, test7, test8;
    ImageView earn, store, share, profile;
    ImageView logo, cart, Banner;
    //    ImageView image1, image2, image3;
    ImageView category1, category2, category3, category4, category5, category6;
    GridView toprateditems;
//    private ArrayList<prodlist_db> prodlist_db;

    String produrl = "https://raw.githubusercontent.com/imvj018/newjson/main/prodnew1.json";
    GridView coursesGV;
    private ArrayList<CourseModel> courseModelArrayList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        earn = findViewById(R.id.earn);
        store = findViewById(R.id.shop);
        share = findViewById(R.id.shared);
        profile = findViewById(R.id.profile);
        logo = findViewById(R.id.logo);
        cart = findViewById(R.id.cart);

        Banner = findViewById(R.id.offer_banner);
        Glide.with(this).load(banner).into(Banner);


        category1 = findViewById(R.id.cat1);
        category2 = findViewById(R.id.cat2);
        category3 = findViewById(R.id.cat3);
        category4 = findViewById(R.id.cat4);
        category5 = findViewById(R.id.cat5);
        category6 = findViewById(R.id.cat6);

        sliderView = findViewById(R.id.image_slider);
        sliderDataArrayList = new ArrayList<>();

//        toprateditems = findViewById(R.id.toprated_list);
//        prodlist_db = new ArrayList<>();
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        startSlide();
        coursesGV = (ExpandableHeightGridView)findViewById(R.id.toprated_list);
//        coursesGV.setExpanded(true);
        courseModelArrayList = new ArrayList<CourseModel>();
        showitems();

        test1 = findViewById(R.id.story1);
        test2 = findViewById(R.id.story2);
        test3 = findViewById(R.id.story3);
        test4 = findViewById(R.id.story4);
        test5 = findViewById(R.id.story5);
        test6 = findViewById(R.id.story6);
        test7 = findViewById(R.id.story7);
        test8 = findViewById(R.id.story8);

        Glide.with(this).load(logourl).into(logo);
        Glide.with(this).load(story1).into(test1);
        Glide.with(this).load(story2).into(test2);
        Glide.with(this).load(story3).into(test3);
        Glide.with(this).load(story4).into(test4);
        Glide.with(this).load(story5).into(test5);
        Glide.with(this).load(story6).into(test6);
        Glide.with(this).load(story7).into(test7);
        Glide.with(this).load(story8).into(test8);


//        Glide.with(this).load(img1).into(image1);
//        Glide.with(this).load(img2).into(image2);
//        Glide.with(this).load(img3).into(image3);

        Glide.with(this).load(cat1).into(category1);
        Glide.with(this).load(cat2).into(category2);
        Glide.with(this).load(cat3).into(category3);
        Glide.with(this).load(cat4).into(category4);
        Glide.with(this).load(cat5).into(category5);
        Glide.with(this).load(cat6).into(category6);


        sessionManager = new SessionManager(getApplicationContext());
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        name = sharedPreferences.getString("name", "");
        phone = sharedPreferences.getString("phone", "");
        mail = sharedPreferences.getString("mail", "");


        cart.setOnClickListener(v -> {
            sessionManager.setlogin(false);
            sessionManager.setUsername("");

            startActivity(new Intent(getApplicationContext(),
                    MainActivity.class));
            finish();
        });

        earn.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, EarnScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        store.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, StoreScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        share.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ShareScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, ProfileScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
    }

    private void showitems() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                produrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("body");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                CourseModel item = new CourseModel(
                                        object.getString("id"),
                                        object.getString("item_code"),
                                        object.getString("url"),
                                        object.getString("brand"),
                                        object.getString("description"),
                                        object.getString("price"),
                                        object.getString("mrp"),
                                        object.getString("rating"),
                                        object.getString("reviews")
                                );

                                if (!object.getString("url").equals("")) {
                                    courseModelArrayList.add(item);

                                }

                            }
                            CourseGVAdapter adapter = new CourseGVAdapter(Dashboard.this, courseModelArrayList);
                            coursesGV.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }




    private void startSlide() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                sliderurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("body");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject object = array.getJSONObject(i);
                                SliderData item = new SliderData(
                                        object.getString("id"),
                                        object.getString("url"),
                                        object.getString("type"),
                                        object.getString("date"),
                                        object.getString("time")
                                );

                                if (!(object.getString("url").equals(""))) {
                                    sliderDataArrayList.add(item);


                                }

                            }
                            adapter = new SliderAdapter(Dashboard.this, sliderDataArrayList);
                            sliderView.setSliderAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();

    }
}