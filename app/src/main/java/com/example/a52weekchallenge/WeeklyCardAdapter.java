package com.example.a52weekchallenge;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class WeeklyCardAdapter extends RecyclerView.Adapter<WeeklyCardAdapter.MyViewHolder> {

    private Context mContext;
    private List<WeeklyContainers> weeklyContainers;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            overflow = (ImageView) view.findViewById(R.id.overflow);
        }
    }


    public WeeklyCardAdapter(Context mContext, List<WeeklyContainers> weeklyContainers) {
        this.mContext = mContext;
        this.weeklyContainers = weeklyContainers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_weekly_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        WeeklyContainers waterContainers = weeklyContainers.get(position);
        holder.title.setText(waterContainers.getName());
        holder.count.setText(waterContainers.getCapacity() + " songs");

        // loading album cover using Glide library
        Glide.with(mContext).load(waterContainers.getThumbnail()).into(holder.thumbnail);

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }

            private void showPopupMenu(ImageView overflow) {
            }
        });
    }


    @Override
    public int getItemCount() {
        return weeklyContainers.size();
    }
}

