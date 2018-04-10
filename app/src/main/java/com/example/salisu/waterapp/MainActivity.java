package com.example.salisu.waterapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.salisu.waterapp.adapters.MainAdapter;
import com.example.salisu.waterapp.model.Drink;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private MainAdapter mAdapter;
    private ArrayList<Drink> mDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView myrecycler = (RecyclerView)findViewById(R.id.main_recycler_view);
        LinearLayoutManager mylayoutManager=new LinearLayoutManager(this);
        myrecycler.setLayoutManager(mylayoutManager);
        mDrinks = new ArrayList<Drink>();
        Drink firstDrink = new Drink();
        firstDrink.comment = "I like water with bubbles most of the time";
        firstDrink.dateandtime = new Date();
        mDrinks.add(firstDrink);
        Drink secondDrink = new Drink();
        secondDrink.comment = "I also like water without bubbles. It depends on my mood I guess ;-)";

        secondDrink.dateandtime = new Date();
        mDrinks.add(secondDrink);

        mAdapter = new MainAdapter(this, mDrinks);
        myrecycler.setAdapter(mAdapter);

    }
}
