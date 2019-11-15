package co.poligran.sw_recycleview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterEpi extends RecyclerView.Adapter <HolderEpi>{

    private ArrayList<Episode> episodesList;

    public AdapterEpi(ArrayList<Episode> episodesList) {
        this.episodesList = episodesList;
    }


    @NonNull
    @Override
    public HolderEpi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.episode_item_layout, parent, false);

        HolderEpi epiViewHolder = new HolderEpi(contactView);

        return epiViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderEpi holder, int i) {
        Episode epiTmp = episodesList.get(i);

        TextView title = holder.title;
        title.setText(epiTmp.getTitle());


        TextView idNum = holder.id;
        idNum.setText(epiTmp.getId());

        TextView crawl = holder.crawl;
        crawl.setText(epiTmp.getOpening_crawl());
    }

    @Override
    public int getItemCount() {
        return episodesList.size();
    }
}
