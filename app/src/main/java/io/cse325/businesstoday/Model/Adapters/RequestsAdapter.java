package io.cse325.businesstoday.Model.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import io.cse325.businesstoday.Model.Pojos.Requests;
import io.cse325.businesstoday.R;
import io.cse325.businesstoday.View.Feed.MainActivity;


public class RequestsAdapter extends RecyclerView.Adapter<RequestsAdapter.RequestsViewHolder> {

    private ArrayList<Requests> requestsArrayList ;
    private MainActivity mainActivity ;

    public interface ClickCallback{
        void onClickMethodInvoke(Integer position) ;
    }

    public RequestsAdapter(ArrayList<Requests> requestsArrayList, MainActivity mainActivity) {
        this.requestsArrayList = requestsArrayList;
        this.mainActivity = mainActivity;
    }

    @Override
    public RequestsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_requests_individual, parent, false);

        return new RequestsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RequestsViewHolder holder, int position) {

        Requests requests = requestsArrayList.get(position) ;

        holder.tvCompanyName.setText(requests.getCompanyName());
        String descriptionText = requests.getCompanyName() +  " has requested" + requests.getProductQuantity() +  " of the product " + requests.getProductName() + "  at amount " + requests.getProductRate() ;
        holder.tvRequestDescription.setText(descriptionText);

        holder.btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return requestsArrayList.size();
    }

    public class RequestsViewHolder extends RecyclerView.ViewHolder {

        private TextView tvCompanyName;
        private TextView tvRequestDescription;
        private Button btnAccept;
        private Button btnReject;

        public RequestsViewHolder(View itemView) {
            super(itemView);

            tvCompanyName = (TextView) itemView.findViewById(R.id.tv_item_requests_individual_company);
            tvRequestDescription = (TextView) itemView.findViewById(R.id.tv_item_requests_idividual_request_string);
            btnAccept = (Button) itemView.findViewById(R.id.btn_item_requests_individual_accept);
            btnReject = (Button) itemView.findViewById(R.id.btn_item_requests_individual_reject);
        }

    }
}