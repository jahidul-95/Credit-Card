package com.example.jahidul.creditcard;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Jahidul on 02-Mar-18.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {
      private ArrayList<card> cardList=new ArrayList<card>();
    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }
    public CardAdapter (ArrayList<card>cardList){
        this.cardList=cardList;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        card card=cardList.get(position);
        holder.imageView.setImageResource(card.getImageId());
        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    private int lastPosition = -1;

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }
}
