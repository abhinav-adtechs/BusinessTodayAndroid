package io.cse325.businesstoday.Model.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Pojos.FeedContent;
import io.cse325.businesstoday.R;

public class FeedContentAdapter extends RecyclerView.Adapter<FeedContentAdapter.FeedViewHolder>{

    private ArrayList<FeedContent> feedContents;

    public FeedContentAdapter(ArrayList<FeedContent> feedContents) {
        this.feedContents = feedContents;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feed_fragment, parent, false);

        return new FeedViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(FeedContentAdapter.FeedViewHolder holder, int position) {
        FeedContent feedContent = feedContents.get(position) ;
        holder.tvProductName.setText(feedContent.getProductName() );
        holder.tvCompanyName.setText(feedContent.getCompanyName());
        holder.tvProductDescription.setText(feedContent.getProductDescription());
    }

    @Override
    public int getItemCount() {
        return feedContents.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder{

        private TextView tvProductName ;
        private TextView tvProductDescription ;
        private TextView tvCompanyName ;
        private ImageView ivProductImage ;

        public FeedViewHolder(View itemView) {
            super(itemView);

            tvProductName = (TextView) itemView.findViewById(R.id.tv_item_feed_fragment_product_name) ;
            tvCompanyName = (TextView) itemView.findViewById(R.id.tv_item_feed_fragment_company_name) ;
            tvProductDescription = (TextView) itemView.findViewById(R.id.tv_feed_fragment_product_description) ;
            ivProductImage = (ImageView) itemView.findViewById(R.id.iv_item_feed_fragment_product_image) ;
        }
    }
}
