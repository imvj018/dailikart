package com.example.dailikart;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CourseGVAdapter extends ArrayAdapter<CourseModel> {
    public Context context;
    private ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
    public CourseGVAdapter(@NonNull Context context, ArrayList<CourseModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
    }
    public void setGridData(ArrayList<CourseModel>courseModelArrayList){
        this.courseModelArrayList = courseModelArrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;

        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.toprated_card, parent, false);
        }

        CourseModel courseModel = getItem(position);
        TextView brand = listitemView.findViewById(R.id.brand);
        TextView description = listitemView.findViewById(R.id.description);
        TextView price = listitemView.findViewById(R.id.price);
        TextView mrp = listitemView.findViewById(R.id.mrp);
        TextView profit = listitemView.findViewById(R.id.profit);
        TextView rating = listitemView.findViewById(R.id.rating);
        TextView reviews = listitemView.findViewById(R.id.reviews);
        ImageView image = listitemView.findViewById(R.id.prod_img1);

        brand.setText(courseModel.getBrand());
        description.setText(courseModel.getDesc());
        price.setText(courseModel.getPrice());
        mrp.setText(courseModel.getMrp());
        profit.setText("50% off");
        rating.setText(courseModel.getRating());
        reviews.setText("(" + courseModel.getReviews() + " reviews)");
        String imgurl = courseModel.getUrl();

        return listitemView;
    }
}


