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
import com.nandaadisaputra.submission2made.fragment.MovieFragment;
import com.nandaadisaputra.submission2made.model.Movie;
import com.nandaadisaputra.submission2made.presenter.CollectionInterfaceMovie;

import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    //Deklarasi Variable
    private ArrayList<Movie> list;
    private Context context;
    private View.OnClickListener listener;
    private View view;
    private CollectionInterfaceMovie collectionInterfaceMovie;


    public MovieAdapter(ArrayList<Movie> list, Context context, MovieFragment collectionInterfaceMovie) {
        //Inisialisasi data yang akan digunakan
        this.list = list;
        this.context = context;
        this.collectionInterfaceMovie = collectionInterfaceMovie;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inisialisasi Layout Item untuk RecyclerView
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        //Deklarasi Variable untuk mendapatkan data dari Strings melalui Array
        //Menampilkan data berdasarkan posisi Item dari RecyclerView
        holder.tvJudul.setText(list.get(position).getJudul());
        holder.ivGambar.setImageResource(list.get(position).getGambar());
        holder.tvDeskripsi.setText(list.get(position).getDeskripsi());
        holder.tvGenre.setText(list.get(position).getGenre());
        holder.tvTanggalRilis.setText(list.get(position).getTanggalRilis());
    }

    @Override
    public int getItemCount() {
        //Menghitung data / ukuran dari Array
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //Deklarasi View yang akan digunakan
        TextView tvJudul;
        ImageView ivGambar;
        TextView tvDeskripsi;
        TextView tvGenre;
        TextView tvTanggalRilis;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tv_title);
            ivGambar = itemView.findViewById(R.id.iv_image);
            tvTanggalRilis = itemView.findViewById(R.id.tv_release_date);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvDeskripsi = itemView.findViewById(R.id.tv_description);
            //onclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    collectionInterfaceMovie.intentToDetail(list.get(getAdapterPosition()));
                }
            });
        }
    }
}