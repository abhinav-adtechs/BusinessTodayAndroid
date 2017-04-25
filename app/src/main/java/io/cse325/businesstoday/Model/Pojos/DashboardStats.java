package io.cse325.businesstoday.Model.Pojos;


public class DashboardStats {


    private String StatTitle ;

    private int statValue ;

    private int statTotalCapValue ;


    public DashboardStats(String statTitle, int statValue, int statTotalCapValue) {
        StatTitle = statTitle;
        this.statValue = statValue;
        this.statTotalCapValue = statTotalCapValue;
    }

    public String getStatTitle() {
        return StatTitle;
    }

    public void setStatTitle(String statTitle) {
        StatTitle = statTitle;
    }

    public int getStatValue() {
        return statValue;
    }

    public void setStatValue(int statValue) {
        this.statValue = statValue;
    }

    public int getStatTotalCapValue() {
        return statTotalCapValue;
    }

    public void setStatTotalCapValue(int statTotalCapValue) {
        this.statTotalCapValue = statTotalCapValue;
    }
}
