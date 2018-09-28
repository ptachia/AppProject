package com.ptachia.myapplication;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import java.util.List;

public class SpringsAdapter extends RecyclerView.Adapter<SpringsAdapter.MyViewHolder> {

    private static final String BASE_URL = "https://ppc1.herokuapp.com/";
    private List<RetroSpring> springsList;

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView springImg;
        TextView springTitle, springDescribe;

        MyViewHolder(View view){
            super(view);
            springImg = (ImageView) view.findViewById(R.id.spring_item_img);
            springTitle = (TextView) view.findViewById(R.id.spring_item_title);
            springDescribe = (TextView) view.findViewById(R.id.spring_item_describe);
        }
    }

    SpringsAdapter(List<RetroSpring> springsList) {
        this.springsList = springsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                            from(parent.getContext())
                                .inflate(R.layout.spring_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        RetroSpring springItem = springsList.get(position);
        Picasso.
                with(MainActivity.getContext()).
                load(BASE_URL + "img?id=MayanKAY" + springItem.getKayMayan() + ".jpg")
                .resize(270,270)
                .into(holder.springImg, new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap imageBitmap = ((BitmapDrawable)holder.springImg.getDrawable()).getBitmap();
                        RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(MainActivity.getContext().getResources(), imageBitmap);
                        imageDrawable.setCircular(true);
                        imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                        holder.springImg.setImageDrawable(imageDrawable);
                    }

                    @Override
                    public void onError() {
                        System.out.println("rounded image error");
                    }
                });
        holder.springDescribe.setText(springItem.getAbstract()); // Abstract in db Mayan
        holder.springTitle.setText(springItem.getNameMayan()); // NameMayan in db Mayan
    }

    @Override
    public int getItemCount() {
        return springsList.size();
    }
}
