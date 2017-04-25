package io.cse325.businesstoday.View.Requests;

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

import io.cse325.businesstoday.Model.Adapters.RequestsAdapter;
import io.cse325.businesstoday.Model.Pojos.Requests;
import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.Feed.MainActivity;


public class RequestsFragment extends Fragment {

    private RecyclerView rvRequests ;
    private ArrayList<Requests> requestsArrayList = new ArrayList<>();
    private RequestsAdapter requestsAdapter ;

    private MainActivity mainActivity ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_requests_main, container, false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity() ;

        uiInit(view) ;
    }

    private void uiInit(View view) {

        rvRequests = (RecyclerView) view.findViewById(R.id.rv_fragment_requests_main_recyclerview) ;

        requestsAdapter = new RequestsAdapter(requestsArrayList, mainActivity) ;


        RecyclerView.LayoutManager lym = new LinearLayoutManager(getContext()) ;
        rvRequests.setLayoutManager(lym);
        rvRequests.setItemAnimator(new DefaultItemAnimator());
        rvRequests.setAdapter(requestsAdapter);


        getData() ;
    }

    private void getData() {

        Requests requests ;

        for (int i = 0; i < 10; i++) {
            requests = new Requests("Samsung Inc.", "Macbook Pro 13'", 20, 7566) ;
            requestsArrayList.add(requests);
        }

        requestsAdapter.notifyDataSetChanged();
    }
}

