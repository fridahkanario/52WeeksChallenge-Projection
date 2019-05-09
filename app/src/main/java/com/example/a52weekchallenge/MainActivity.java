package com.example.a52weekchallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WeeklyCardAdapter adapter;
    private List<WeeklyContainers> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        NumberPicker np = findViewById(R.id.numberPicker);

        String[] numbers = new String[200/5];
        for (int i=0; i<numbers.length; i++)
            numbers[i] = Integer.toString(i*5+5);

        np.setMinValue(0);
        np.setMaxValue(50000000);
        np.setOnValueChangedListener(onValueChangeListener);

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
                            intent.setData(Uri.parse("https://github.com/fridahkanario"));
                            startActivity(intent);
                        }


                        return super.onOptionsItemSelected(item);


                }

    }

