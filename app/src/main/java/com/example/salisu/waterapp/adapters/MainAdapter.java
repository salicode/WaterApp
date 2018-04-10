package com.example.salisu.waterapp.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salisu.waterapp.R;
import com.example.salisu.waterapp.model.Drink;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<Drink> mDrinks;
    private Context mContext;
    public static class ViewHolder extends
            RecyclerView.ViewHolder {
        public TextView mCommentTextView;
        public TextView mDateTimeTextView;
        public ImageView mImageView;
        public ViewHolder(View v) {
            super(v);
        }
    }
    public MainAdapter(Context context,
                       ArrayList<Drink> drinks) {
        mDrinks = drinks;
        mContext = context;
    }
    @Override
    public MainAdapter.ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()). inflate(R.
                layout.adapter_main_card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.mDateTimeTextView =
                (TextView)v.findViewById(
                        R.id.main_date_time_textview);
        viewHolder.mCommentTextView =
                (TextView)v.findViewById(
                        R.id.main_comment_textview);
        viewHolder.mImageView =
                (ImageView)v.findViewById(
                        R.id.main_image_view);
        return viewHolder;
    }
    @Override
    public int getItemCount() {
        return mDrinks.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drink currentDrink = mDrinks.get(position);
        holder.mCommentTextView.setText(
                currentDrink.comment);
        holder.mDateTimeTextView.setText(
                currentDrink.dateandtime.toString());
        if (currentDrink.imageUri != null){
            holder.mImageView.setImageURI(
                    Uri.parse(currentDrink.imageUri));
        }
    }


}
