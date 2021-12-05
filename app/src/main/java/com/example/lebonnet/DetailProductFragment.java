package com.example.lebonnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;

public class DetailProductFragment extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.detail_product_fragment);




        String title = "";
        String price = "";
        String description = "";
        String url_image = "";


        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            url_image = extras.getString("url");
            title = extras.getString("title");
            price= extras.getString("price");
            description = extras.getString("description");


        }

        TextView title_detail = (TextView) findViewById(R.id.title_detail);
        title_detail.setText(title);

        TextView description_detail = (TextView) findViewById(R.id.description_detail);
        description_detail.setText(description);

        TextView price_detail = (TextView) findViewById(R.id.price_detail);
        price_detail.setText(price);


        ImageView imageView =  (ImageView) findViewById(R.id.fondo_url);
        Picasso.get().load(url_image).error(R.mipmap.ic_launcher).into(imageView);


    }

}

