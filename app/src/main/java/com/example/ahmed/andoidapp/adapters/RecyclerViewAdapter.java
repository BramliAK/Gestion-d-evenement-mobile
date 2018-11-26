package com.example.ahmed.andoidapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.ahmed.andoidapp.R;
import com.example.ahmed.andoidapp.ResumeActivity;
import com.example.ahmed.andoidapp.model.Dateevents;
import com.example.ahmed.andoidapp.model.Event;
import com.example.ahmed.andoidapp.model.Localisations;

import java.util.List;

/**
 * Created by ahmed on 22/11/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private Context mContext ;
    private List<Event> mData ;
    private Bitmap bitmap;

    public RecyclerViewAdapter(Context mContext, List lst) {

        this.mContext = mContext;
        this.mData = lst;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.event_row,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(view) ;

        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, ResumeActivity.class);
                // sending data process
                i.putExtra("id",mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("nom",mData.get(viewHolder.getAdapterPosition()).getNom());
                i.putExtra("description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("prix",mData.get(viewHolder.getAdapterPosition()).getPrix());
                i.putExtra("image",mData.get(viewHolder.getAdapterPosition()).getImage());

                mContext.startActivity(i);

            }
        });




        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvname.setText(mData.get(position).getNom());
        List<Localisations> list=mData.get(position).getLocalisations();
        String emp="";

        holder.tv_lieu.setText(emp);
        holder.tvprix.setText(mData.get(position).getPrix());
        holder.tvcat.setText(mData.get(position).getDescription());

        final String image=mData.get(position).getImage();
        new AsyncTask<Void , Void ,String>(){

            @Override
            protected String doInBackground(Void... voids) {

                return image;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                byte[] decodeString = Base64.decode(s,Base64.DEFAULT);
                Bitmap decode= BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);
                holder.AnimeThumbnail.setImageBitmap(decode);
            }
        }.execute();

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvname,tv_lieu,tvprix,tvcat;
        ImageView AnimeThumbnail;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.container);
            tvname = itemView.findViewById(R.id.rowname);
            tvprix = itemView.findViewById(R.id.prix);
            tv_lieu = itemView.findViewById(R.id.lieu);
            tvcat = itemView.findViewById(R.id.categorie);
            AnimeThumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

}
