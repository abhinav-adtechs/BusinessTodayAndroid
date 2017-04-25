package io.cse325.businesstoday.Model.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Pojos.Products;
import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.Feed.MainActivity;

public class DashboardProductsAdapter extends RecyclerView.Adapter<DashboardProductsAdapter.ProductsViewHolder>{

    private ArrayList<Products> productsArrayList ;
    private MainActivity mainActivity ;

    public DashboardProductsAdapter(ArrayList<Products> productsArrayList, MainActivity mainActivity) {
        this.productsArrayList = productsArrayList;
        this.mainActivity = mainActivity;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard_add_new_product, parent, false);

        return new ProductsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {

        if(position != 0){
            holder.ivProductImage.setImageDrawable(mainActivity.getResources().getDrawable(R.mipmap.apple_logo));
            holder.tvProductName.setText(productsArrayList.get(position).getProductName());
        }

    }

    @Override
    public int getItemCount() {
        return productsArrayList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder{

        private TextView tvProductName ;
        private ImageView ivProductImage ;


        public ProductsViewHolder(View itemView) {
            super(itemView);

            tvProductName = (TextView) itemView.findViewById(R.id.tv_item_dashboard_add_new_product_name) ;
            ivProductImage = (ImageView) itemView.findViewById(R.id.iv_item_dashboard_add_new_product_image) ;
        }
    }

}
