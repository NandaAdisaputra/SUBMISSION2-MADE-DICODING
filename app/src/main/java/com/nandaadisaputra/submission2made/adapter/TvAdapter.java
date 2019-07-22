package com.nandaadisaputra.submission2made.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandaadisaputra.submission2made.R;
import com.nandaadisaputra.submission2made.fragment.TvFragment;
import com.nandaadisaputra.submission2made.model.Tv;
import com.nandaadisaputra.submission2made.presenter.CollectionInterfaceTv;

import java.util.ArrayList;


public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    //Deklarasi Variable
    private ArrayList<Tv> list;
    private Context context;
    private View.OnClickListener listener;
    private View view;
    private CollectionInterfaceTv collectionInterfaceTv;


    public TvAdapter(ArrayList<Tv> list, Context context, TvFragment collectionInterfaceTv) {
        //Inisialisasi data yang akan digunakan
        this.list = list;
        this.context = context;
        this.collectionInterfaceTv = collectionInterfaceTv;
    }

    @NonNull
    @Override
    public TvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inisialisasi Layout Item untuk RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.item_tv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ViewHolder holder, int position) {
        //Deklarasi Variable untuk mendapatkan data dari Strings melalui Array
        //Menampilkan data berdasarkan posisi Item dari RecyclerView
        holder.tvNama.setText(list.get(position).getNama());
        holder.tvDesc.setText(list.get(position).getDesc());
        holder.ivImg.setImageResource(list.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        //Menghitung data / ukuran dari Array
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Deklarasi View yang akan digunakan
        TextView tvNama;
        ImageView ivImg;
        TextView tvDesc;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_name);
            ivImg = itemView.findViewById(R.id.iv_img);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            //onclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    collectionInterfaceTv.intentToDetail(list.get(getAdapterPosition()));
                }
            });
        }
    }
}