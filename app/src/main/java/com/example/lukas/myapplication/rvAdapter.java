package com.example.lukas.myapplication;

/**
 * Created by Lukas on 19.11.2016.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder>{

    private List<Data> myData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class WeatherViewHolder extends ViewHolder{
        TextView temp_text;
        TextView temp_city;
        TextView temp_tmrw;
        TextView temp_day_tmrw;
        ImageView temp_image;

        public WeatherViewHolder(View v) {
            super(v);
            this.temp_text = (TextView)itemView.findViewById(R.id.temp_text_id);
            this.temp_city = (TextView)itemView.findViewById(R.id.temp_city_id);
            this.temp_tmrw = (TextView)itemView.findViewById(R.id.temp_tmrw_id);
            this.temp_day_tmrw = (TextView)itemView.findViewById(R.id.temp_day_tmrw_id);
            this.temp_image = (ImageView)itemView.findViewById(R.id.temp_image_id);
        }
    }

    public class RssViewHolder extends ViewHolder{
        TextView rss_headline;
        TextView rss_text;
        TextView rss_Info;

        public RssViewHolder(View v) {
            super(v);
            this.rss_headline = (TextView)itemView.findViewById(R.id.rss_headline_id);
            this.rss_text = (TextView)itemView.findViewById(R.id.rss_text_id);
            this.rss_Info = (TextView)itemView.findViewById(R.id.rss_info_id);
        }
    }

    public rvAdapter(List<Data> myData) {
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
            holder.temp_text.setText(myData.get(i).getTempInCel());
            holder.temp_city.setText(myData.get(i).getTempCity());
            holder.temp_tmrw.setText(myData.get(i).getTempInCelTmrw());
            holder.temp_day_tmrw.setText(myData.get(i).getTempDayTmrw());
            holder.temp_image.setImageResource(myData.get(i).getTempIcon());
        }else{
            RssViewHolder holder = (RssViewHolder) ViewHolder;
            holder.rss_headline.setText(myData.get(i).getRssHeadline());
            holder.rss_text.setText(myData.get(i).getRssText());
            holder.rss_Info.setText(myData.get(i).getRssInfo());
        }
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
