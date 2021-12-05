package com.example.lebonnet;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;


public class ProductCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public Context context;
    public NetworkImageView productImage;
    public TextView productTitle;
    public TextView productPrice;
    public TextView productDescription;
    public TextView productUrlImage;
    public Button productButton;

    public ProductCardViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.getContext();
        context = itemView.getContext();

        productImage = itemView.findViewById(R.id.product_image);
        productTitle = itemView.findViewById(R.id.product_title);
        productPrice = itemView.findViewById(R.id.product_price);
        productDescription = itemView.findViewById(R.id.product_description);
        productUrlImage = itemView.findViewById(R.id.url_image);
        productButton = itemView.findViewById(R.id.product_button);



    }

    void setOnclickListeners(){
        productButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,DetailProductFragment.class);
        intent.putExtra("title",productTitle.getText());
        intent.putExtra("description",productDescription.getText());
        intent.putExtra("price",productPrice.getText());
        intent.putExtra("url",productUrlImage.getText());


        context.startActivity(intent);
    }



}
