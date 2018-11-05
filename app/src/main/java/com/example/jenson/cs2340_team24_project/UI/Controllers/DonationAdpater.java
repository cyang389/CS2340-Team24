package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jenson.cs2340_team24_project.R;

import java.util.ArrayList;

public class DonationAdpater extends RecyclerView.Adapter<DonationAdpater.ViewHolder> {
    private ArrayList<String> mLocationnames;
    private Context mContext;

    public DonationAdpater(Context context, ArrayList<String> mLocationnames) {
        this.mLocationnames = mLocationnames;
        this.mContext = context;
    }
    @Override
    public void onBindViewHolder(@NonNull DonationAdpater.ViewHolder holder, final int position) {
        holder.locationName.setText(mLocationnames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mLocationnames.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailDonationActivity.class);
                intent.putExtra("donation_name", mLocationnames.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public DonationAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        DonationAdpater.ViewHolder holder = new DonationAdpater.ViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mLocationnames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView locationName;
        RelativeLayout parentLayout;
        ViewHolder(View itemView) {
            super(itemView);
            locationName = itemView.findViewById(R.id.locationname);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
