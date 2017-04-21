package io.cse325.businesstoday.View.Feed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Adapters.FeedContentAdapter;
import io.cse325.businesstoday.Model.Pojos.FeedContent;
import io.cse325.businesstoday.R;



public class FeedFragment extends Fragment {

    private ArrayList<FeedContent> feedArrayList = new ArrayList<>() ;
    private RecyclerView rvFeedContent ;
    private FeedContentAdapter feedContentAdapter ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed_main, container, false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        uiInit(view) ;
    }

    private void uiInit(View view) {

        rvFeedContent = (RecyclerView) view.findViewById(R.id.rv_fragment_feed_main) ;

        feedContentAdapter = new FeedContentAdapter(feedArrayList) ;
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
