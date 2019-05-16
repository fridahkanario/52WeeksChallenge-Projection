package com.example.a52weekchallenge;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private Button increase, decrease;
    private int minteger;
    private  TextView myinteger;
    private TextView txtTotal;
    private RecyclerView recyclerView;
    private WeekCardAdapter weekCardAdapter;
    private List<WeekCardData> weekCardDataList = new ArrayList<>();
    @TargetApi(Build.VERSION_CODES.O)




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTotal = findViewById(R.id.tv_total_amount);
        recyclerView = findViewById(R.id.recycler_view);
        weekCardAdapter = new WeekCardAdapter(weekCardDataList);
        myinteger = findViewById (R.id.integer_number);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 4);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(weekCardAdapter);

        minteger = Integer.parseInt(myinteger.getText().toString());



        increase = findViewById(R.id.increase);
        decrease = findViewById(R.id.decrease);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(minteger<=500000) {
                minteger = minteger + 50;
                display(minteger);
                changeData();
                WeekDataPrepare(minteger);
            }
            else {
                    Toast.makeText(getApplicationContext(),  "Amount cannot be greater than 500000", Toast.LENGTH_SHORT).show();
            }
            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(minteger>=50) {
                    minteger = minteger - 50;
                    display(minteger);
                    changeData();
                    WeekDataPrepare(minteger);
                }else {
                    Toast.makeText(getApplicationContext(),"Amount cannot be less than 0", Toast.LENGTH_SHORT).show();
                }

            }
        });

        WeekDataPrepare(minteger);



    }
    @SuppressLint("NewApi")
    public void display(int number) {
        myinteger.setText("" + number);
        myinteger.setFocusable(true);
        myinteger.setEnabled(true);
        myinteger.setClickable(true);
        myinteger.setFocusableInTouchMode(true);


    }

    public void changeData(){
        weekCardDataList.clear();
    }



    private void WeekDataPrepare(int num) {

        int total = 0;
        for (int i = 1; i <= 52; i++) {
            total += (num * i);
            WeekCardData data = new WeekCardData("Week " + Integer.toString(i), "Deposit: " + (num * i), "Total: " + total);
            weekCardDataList.add(data);
        }
        weekCardAdapter.notifyDataSetChanged();

        txtTotal.setText("Total amount saved: Ksh." + total);

    }
    NumberPicker.OnValueChangeListener onValueChangeListener =
            new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    int newValue = newVal * 5 + 5;
                }

            };

    NumberPicker.Formatter formatter = new NumberPicker.Formatter(){
        @Override
        public String format(int i) {
            return NumberFormat.getCurrencyInstance(Locale.US).format((long)i).toString();
        }
    };
    public boolean onCreateOptionsMenu(Menu menu) {


        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_twitter) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://twitter.com/Kanario_fridah"));
            startActivity(intent);

        }

        if (id == R.id.action_github) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.addCategory(Intent.CATEGORY_BROWSABLE);
            intent.setData(Uri.parse("https://github.com/fridahkanario/52WeeksChallenge-Projection"));
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);


    }


}

