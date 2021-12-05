package com.example.lebonnet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lebonnet.network.ProductEntry;
import com.example.lebonnet.network.ImageRequester;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductCardViewHolder> {


    private List<ProductEntry> productList;
    private ImageRequester imageRequester;


    ProductRecyclerViewAdapter(List<ProductEntry> productList) {
        this.productList = productList;
        imageRequester = ImageRequester.getInstance();
    }


    @NonNull
    @Override
    public ProductCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_card_fragment, parent, false);
        return new ProductCardViewHolder(layoutView);
    }



    @Override
    public void onBindViewHolder(@NonNull ProductCardViewHolder holder, int position) {
        if (productList != null && position < productList.size()) {
            ProductEntry product = productList.get(position);
            holder.productTitle.setText(product.title);
            holder.productPrice.setText(product.price);
            holder.productDescription.setText(product.description);
            holder.productUrlImage.setText(product.url);
            imageRequester.setImageFromUrl(holder.productImage, product.url);
            holder.setOnclickListeners();
        }
    }




    @Override
    public int getItemCount() {
        return productList.size();
    }


}
