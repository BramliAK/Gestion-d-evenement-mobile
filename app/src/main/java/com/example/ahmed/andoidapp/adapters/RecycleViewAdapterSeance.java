package com.example.ahmed.andoidapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.ahmed.andoidapp.R;
import com.example.ahmed.andoidapp.model.Localisations;
import java.util.List;

/**
 * Created by ahmed on 26/11/2018.
 */

public class RecycleViewAdapterSeance extends RecyclerView.Adapter<RecycleViewAdapterSeance.MyViewHolder2> {

    private Context context ;
    private List<Localisations> mData ;


    public RecycleViewAdapterSeance(Context mContext, List<Localisations> lst) {

        this.context = mContext;
        this.mData = lst;
    }



    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;

        LayoutInflater mInflater = LayoutInflater.from(this.context);
        view = mInflater.inflate(R.layout.item_seance,parent,false);
        MyViewHolder2 vHolder = new MyViewHolder2(view) ;





        return vHolder;
    }


    @Override
    public void onBindViewHolder(RecycleViewAdapterSeance.MyViewHolder2 holder, int position) {
        holder.rownamemap.setText(mData.get(position).getNomemplacement());

        holder.Emplacement.setText(mData.get(position).getEmplacement());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView Emplacement;
        TextView rownamemap;

        LinearLayout view_container1;

        public MyViewHolder2(View itemView) {
            super(itemView);
            view_container1 = itemView.findViewById(R.id.container1);
            rownamemap = itemView.findViewById(R.id.roo);
            Emplacement = itemView.findViewById(R.id.date);
        }
    }
}
