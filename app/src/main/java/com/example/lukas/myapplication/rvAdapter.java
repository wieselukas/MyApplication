package com.example.lukas.myapplication;

/**
 * Created by Lukas on 19.11.2016.
 */

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import data.Data;
import data.FeedEntry;

class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder>{

    private List<Data> myData;

    private ItemClickListener clickListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onClick(view, getAdapterPosition());
            }

        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    private class WeatherViewHolder extends ViewHolder{
        TextView temp_text;
        TextView temp_city;
        TextView temp_tmrw;
        TextView temp_day_tmrw;
        ImageView temp_image;

        WeatherViewHolder(View v) {
            super(v);
            this.temp_text = (TextView)itemView.findViewById(R.id.temp_text_id);
            this.temp_city = (TextView)itemView.findViewById(R.id.temp_city_id);
            this.temp_tmrw = (TextView)itemView.findViewById(R.id.temp_tmrw_id);
            this.temp_day_tmrw = (TextView)itemView.findViewById(R.id.temp_day_tmrw_id);
            this.temp_image = (ImageView)itemView.findViewById(R.id.temp_image_id);
        }
    }

    private class RssViewHolder extends ViewHolder{
        TextView rss_headline;
        TextView rss_text;
        TextView rss_Info;
        ImageView rss_image;

        RssViewHolder(View v) {
            super(v);
            this.rss_headline = (TextView)itemView.findViewById(R.id.rss_headline_id);
            this.rss_text = (TextView)itemView.findViewById(R.id.rss_text_id);
            this.rss_Info = (TextView)itemView.findViewById(R.id.rss_info_id);
            this.rss_image = (ImageView)itemView.findViewById(R.id.rss_image_id);
        }
    }

    rvAdapter(List<Data> myData) {
        this.myData = myData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v;
        if(viewType==0) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.weather_view, viewGroup, false);
            return new WeatherViewHolder(v);
        }else {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rss_view, viewGroup, false);
            return new RssViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder ViewHolder, int i) {
        if(myData.get(i).getViewType()==0) {
            WeatherViewHolder holder = (WeatherViewHolder) ViewHolder;
            holder.temp_text.setText(myData.get(i).getContent()+"°C");
            holder.temp_city.setText(myData.get(i).getTitle());
            holder.temp_tmrw.setText(myData.get(i).getInfo()+"°C");
            holder.temp_day_tmrw.setText("Tue");
            holder.temp_image.setImageResource(myData.get(i).getTempIcon());
        }else if(myData.get(i).getViewType()==1) {
            RssViewHolder holder = (RssViewHolder) ViewHolder;
            holder.rss_headline.setText(myData.get(i).getTitle());
            holder.rss_text.setText(myData.get(i).getContent());
            holder.rss_Info.setText(myData.get(i).getInfo());
            new DownloadImageTask(holder.rss_image).execute(myData.get(i).getImgInfo());
        }else{}
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    @Override
    public int getItemViewType(int i) {
        return myData.get(i).getViewType();
    }

}