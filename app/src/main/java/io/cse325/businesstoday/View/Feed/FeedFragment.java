package io.cse325.businesstoday.View.Feed;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.peekandpop.shalskar.peekandpop.PeekAndPop;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Adapters.FeedContentAdapter;
import io.cse325.businesstoday.Model.Pojos.FeedContent;
import io.cse325.businesstoday.R;



public class FeedFragment extends Fragment {

    private ArrayList<FeedContent> feedArrayList = new ArrayList<>() ;
    private RecyclerView rvFeedContent ;
    private FeedContentAdapter feedContentAdapter = null ;

    private MainActivity mainActivity ;

    private PeekAndPop peekAndPop ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_main, container, false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity();
        uiInit(view) ;
    }

    private void uiInit(View view) {
        rvFeedContent = (RecyclerView) view.findViewById(R.id.rv_fragment_feed_main) ;

        final Dialog dialog = new Dialog(mainActivity) ;
        dialog.setContentView(R.layout.item_dailog_request_form);

        Button btnConfirm = (Button) dialog.findViewById(R.id.btn_item_dailog_request_form_confirm) ;
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity, "Request queued!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        feedContentAdapter = new FeedContentAdapter(mainActivity, feedArrayList, new FeedContentAdapter.ItemOnClickListner() {
            @Override
            public void onClickItem(Integer adapterPos) {

                dialog.show();

            }
        }) ;



        RecyclerView.LayoutManager lym = new LinearLayoutManager(getContext()) ;
        rvFeedContent.setLayoutManager(lym);
        rvFeedContent.setItemAnimator(new DefaultItemAnimator());
        rvFeedContent.setAdapter(feedContentAdapter);

        prepareData() ;
    }

    private void prepareData() {

        FeedContent feedContent ;

        for (int i = 0; i < 20; i++) {
            feedContent = new FeedContent("Macbook Pro 13' 256GB", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, ", "Apple Inc.") ;
            feedArrayList.add(feedContent);
        }
        feedContentAdapter.notifyDataSetChanged();

    }

}
