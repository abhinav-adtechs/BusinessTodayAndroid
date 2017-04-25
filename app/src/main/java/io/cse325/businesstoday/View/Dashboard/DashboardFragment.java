package io.cse325.businesstoday.View.Dashboard;

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

import io.cse325.businesstoday.Model.Adapters.DashboardProductsAdapter;
import io.cse325.businesstoday.Model.Adapters.DashboardStatsAdapter;
import io.cse325.businesstoday.Model.Pojos.DashboardStats;
import io.cse325.businesstoday.Model.Pojos.Products;
import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.Feed.MainActivity;


public class DashboardFragment extends Fragment {

    private RecyclerView rvStats ;
    private ArrayList<DashboardStats> statsArrayList = new ArrayList<>();
    private DashboardStatsAdapter statsAdapter ;

    private RecyclerView rvProducts;
    private ArrayList<Products> productsArrayList = new ArrayList<>() ;
    private DashboardProductsAdapter dashboardProductsAdapter ;


    private MainActivity mainActivity ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_main, container, false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainActivity = (MainActivity) getActivity() ;
        uiInit(view) ;

    }

    private void uiInit(View view) {
        rvStats = (RecyclerView) view.findViewById(R.id.rv_fragment_dashboard_main_stats) ;
        rvProducts = (RecyclerView) view.findViewById(R.id.rv_fragment_requests_main_recyclerview_products) ;

        initializeStats() ;
        initializeProducts() ;

    }

    private void initializeStats() {

        statsAdapter = new DashboardStatsAdapter(statsArrayList, mainActivity) ;

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        rvStats.setLayoutManager(layoutManager);
        rvStats.setItemAnimator(new DefaultItemAnimator());
        rvStats.setAdapter(statsAdapter);

        addStatsDataToArray();
    }

    private void initializeProducts() {

        dashboardProductsAdapter = new DashboardProductsAdapter(productsArrayList, mainActivity) ;

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(mainActivity, LinearLayoutManager.HORIZONTAL, false);
        rvProducts.setLayoutManager(layoutManager);
        rvProducts.setItemAnimator(new DefaultItemAnimator());
        rvProducts.setAdapter(dashboardProductsAdapter);

        addProductDataToArray();
    }

    private void addProductDataToArray() {
        Products products ;

        for (int i = 0; i < 7; i++) {
            products = new Products("Macbook Pro 13'", i) ;
            productsArrayList.add(products);
        }

        dashboardProductsAdapter.notifyDataSetChanged();
    }


    void addStatsDataToArray(){

        DashboardStats dashboardStats;

        dashboardStats = new DashboardStats("Current Deals", 750, 1000) ;
        statsArrayList.add(dashboardStats);
        dashboardStats = new DashboardStats("Pending Deals", 5, 10) ;
        statsArrayList.add(dashboardStats);
        dashboardStats = new DashboardStats("Sales", 60, 100) ;
        statsArrayList.add(dashboardStats);

        statsAdapter.notifyDataSetChanged();

    }

}
