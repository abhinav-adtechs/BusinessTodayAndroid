package io.cse325.businesstoday.Model.Adapters;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.peekandpop.shalskar.peekandpop.PeekAndPop;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Pojos.FeedContent;
import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.Feed.FeedFragment;
import io.cse325.businesstoday.View.Feed.MainActivity;

public class FeedContentAdapter extends RecyclerView.Adapter<FeedContentAdapter.FeedViewHolder>{

    private ArrayList<FeedContent> feedContents;
    private ItemOnClickListner itemOnClickListner ;
    private MainActivity mainActivity ;

    private PeekAndPop peekAndPop ;

    public interface ItemOnClickListner{
        void onClickItem(Integer adapterPos) ;
    }

    public FeedContentAdapter(MainActivity mainActivity, ArrayList<FeedContent> feedContents, ItemOnClickListner itemOnClickListner) {
        this.mainActivity = mainActivity ;
        this.feedContents = feedContents;
        this.itemOnClickListner = itemOnClickListner;
    }


    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_feed_fragment, parent, false);

        return new FeedViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final FeedContentAdapter.FeedViewHolder holder, int position) {
        FeedContent feedContent = feedContents.get(position) ;
        holder.tvProductName.setText(feedContent.getProductName() );
        holder.tvCompanyName.setText(feedContent.getCompanyName());
        holder.tvProductDescription.setText(feedContent.getProductDescription());
        holder.ibRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClickListner.onClickItem(holder.getAdapterPosition());
            }
        });

        /*peekAndPop = new PeekAndPop.Builder(mainActivity)
                .peekLayout(R.layout.item_feed_product_pop_view)
                .longClickViews(holder.relativeLayout)
                .build();*/

        /*TextView tvPopupTitle = (TextView) peekAndPop.getPeekView().findViewById(R.id.tv_item_feed_product_prodname) ;*/

    }

    @Override
    public int getItemCount() {
        return feedContents.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout relativeLayout ;
        private TextView tvProductName ;
        private TextView tvProductDescription ;
        private TextView tvCompanyName ;
        private ImageView ivProductImage ;
        private ImageButton ibRequest ;

        public FeedViewHolder(View itemView) {
            super(itemView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl_item_feed_fragment_base_layout) ;
            tvProductName = (TextView) itemView.findViewById(R.id.tv_item_feed_fragment_product_name) ;
            tvCompanyName = (TextView) itemView.findViewById(R.id.tv_item_feed_fragment_company_name) ;
            tvProductDescription = (TextView) itemView.findViewById(R.id.tv_feed_fragment_product_description) ;
            ivProductImage = (ImageView) itemView.findViewById(R.id.iv_item_feed_fragment_product_image) ;
            ibRequest = (ImageButton) itemView.findViewById(R.id.btn_item_feed_fragment_request) ;

        }
    }
}
