package com.example.a52weekchallenge;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


//adapter class to inflate the card with data
class WeekCardAdapter extends RecyclerView.Adapter<WeekCardAdapter.MyViewHolder> {

    private List<WeekCardData> cardDataList;

    public WeekCardAdapter(List<WeekCardData> cardDataList) {
        this.cardDataList = cardDataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.week_list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        WeekCardData data= cardDataList.get(i);

        //To set random background color for the cards
//        Random rnd = new Random();
//        int currentColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        //viewHolder.parent.setBackgroundColor(currentColor);

        viewHolder.week_number.setText(data.getWeek_number());
        viewHolder.deposit_amount.setText(String.valueOf(data.getDeposit_amount()));
        viewHolder.total_amount.setText(String.valueOf(data.getTotal_amount()));

    }
    @Override
    public int getItemCount() {
        return cardDataList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView week_number,deposit_amount, total_amount;

        public MyViewHolder(View itemView) {
            super(itemView);
            week_number = itemView.findViewById(R.id.week_number);
            deposit_amount = itemView.findViewById(R.id.deposit_amount);
            total_amount = itemView.findViewById(R.id.total_amount);
        }
    }
}
