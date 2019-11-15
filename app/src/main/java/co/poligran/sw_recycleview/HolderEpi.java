package co.poligran.sw_recycleview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderEpi extends RecyclerView.ViewHolder {


    public TextView title;
    public TextView id;
    public TextView crawl;


    public HolderEpi(@NonNull View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.titleTxt);
        this.id = (TextView) itemView.findViewById(R.id.idTxt);
        this.crawl = (TextView) itemView.findViewById(R.id.crawlTxt);

    }
}
