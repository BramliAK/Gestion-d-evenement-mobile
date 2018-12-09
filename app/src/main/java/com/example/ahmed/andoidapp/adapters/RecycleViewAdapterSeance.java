package com.example.ahmed.andoidapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ahmed.andoidapp.MapsActivity;
import com.example.ahmed.andoidapp.R;
import com.example.ahmed.andoidapp.ResumeActivity;
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
        final MyViewHolder2 vHolder = new MyViewHolder2(view) ;
        vHolder.view_container1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, MapsActivity .class);
                // sending data process
                i.putExtra("latitude",mData.get(vHolder.getAdapterPosition()).getLatitude());
                i.putExtra("langitude",mData.get(vHolder.getAdapterPosition()).getLongitude());

                context.startActivity(i);

            }
        });




        return vHolder;
    }


    @Override
    public void onBindViewHolder(RecycleViewAdapterSeance.MyViewHolder2 holder, int position) {
        holder.rownamemap.setText(mData.get(position).getNomemplacement());

        holder.Emplacement.setText(mData.get(position).getEmplacement());
        holder.largeur.setText(mData.get(position).getLatitude());
        holder.longeur.setText(mData.get(position).getLongitude());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder2 extends RecyclerView.ViewHolder {

        TextView Emplacement;
        TextView rownamemap;
        TextView largeur;
        TextView longeur;

        LinearLayout view_container1;

        public MyViewHolder2(View itemView) {
            super(itemView);
            view_container1 = itemView.findViewById(R.id.container1);
            rownamemap = itemView.findViewById(R.id.roo);
            Emplacement = itemView.findViewById(R.id.date);
            largeur=itemView.findViewById(R.id.largeur);
            longeur=itemView.findViewById(R.id.longuer);
        }
    }
}
