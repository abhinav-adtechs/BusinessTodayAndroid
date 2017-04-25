package io.cse325.businesstoday.Model.Adapters;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Pojos.DashboardStats;
import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.Feed.MainActivity;

public class DashboardStatsAdapter extends RecyclerView.Adapter<DashboardStatsAdapter.StatsViewHolder>{

    private ArrayList<DashboardStats> dashboardStats ;
    private MainActivity mainActivity ;

    public DashboardStatsAdapter(ArrayList<DashboardStats> dashboardStats, MainActivity mainActivity) {
        this.dashboardStats = dashboardStats;
        this.mainActivity = mainActivity;
    }

    @Override
    public StatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard_stats, parent, false);

        return new DashboardStatsAdapter.StatsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StatsViewHolder holder, int position) {

        holder.tvTitle.setText(dashboardStats.get(position).getStatTitle());

        setUpChart(holder, position) ;

    }

    private void setUpChart(StatsViewHolder holder, int position) {
        holder.pieChartStats.setDrawHoleEnabled(true);
        holder.pieChartStats.setHoleColor(Color.TRANSPARENT);

        Description description = new Description() ;
        description.setText("");

        holder.pieChartStats.setDescription(description);
        holder.pieChartStats.setCenterText(String.valueOf(dashboardStats.get(position).getStatValue()));
        holder.pieChartStats.setDrawEntryLabels(false);
        holder.pieChartStats.getLegend().setEnabled(false);

        setData(2, dashboardStats.get(position).getStatTotalCapValue(), position, holder) ;
    }

    private void setData(int count, float range, int position, StatsViewHolder holder) {

        ArrayList<PieEntry> pieEntries = new ArrayList<>() ;

            pieEntries.add(new PieEntry((float) (dashboardStats.get(position).getStatValue())));
            pieEntries.add(new PieEntry(range - dashboardStats.get(position).getStatValue()));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, dashboardStats.get(position).getStatTitle()) ;

        ArrayList<Integer> colors = new ArrayList<>() ;
        colors.add(ResourcesCompat.getColor(mainActivity.getResources(), R.color.colorLightBlue500, null));
        colors.add(ResourcesCompat.getColor(mainActivity.getResources(), R.color.colorGrey800, null));

        pieDataSet.setColors(colors);

        PieData pieData = new PieData(pieDataSet) ;

        holder.pieChartStats.setData(pieData);
        holder.pieChartStats.invalidate();

    }

    @Override
    public int getItemCount() {
        return dashboardStats.size();
    }

    public class StatsViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle ;
        private PieChart pieChartStats ;

        public StatsViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_dashboard_stats_title) ;
            pieChartStats = (PieChart) itemView.findViewById(R.id.pc_item_dashboard_stats_chart) ;
        }
    }
}
