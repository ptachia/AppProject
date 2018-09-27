package com.ptachia.myapplication;

import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SpringsAdapter extends RecyclerView.Adapter<SpringsAdapter.MyViewHolder> {

    private List<SpringItem> springsList;

    class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView springImg;
        public TextView springTitle, springDescribe;

        public MyViewHolder(View view){
            super(view);
            springImg = (ImageView) view.findViewById(R.id.spring_item_img);
            springTitle = (TextView) view.findViewById(R.id.spring_item_title);
            springDescribe = (TextView) view.findViewById(R.id.spring_item_describe);
        }
    }

    public SpringsAdapter(List<SpringItem> springsList) {
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SpringItem springItem = springsList.get(position);
        holder.springImg.setImageBitmap(BitmapFactory.decodeFile(springItem.getImgPath()));
        holder.springDescribe.setText(springItem.getShortText());
        holder.springTitle.setText(springItem.getName());
    }

    @Override
    public int getItemCount() {
        return springsList.size();
    }
}
