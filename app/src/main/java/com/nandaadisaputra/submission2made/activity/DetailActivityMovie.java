package com.nandaadisaputra.submission2made.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nandaadisaputra.submission2made.R;
import com.nandaadisaputra.submission2made.model.Movie;


public class DetailActivityMovie extends AppCompatActivity {
    //Deklarasi View yang akan digunakan
    Movie movie;
    private TextView tvJudul;
    private ImageView ivGambar;
    private TextView tvDeskripsi;
    private TextView tvTanggalrilis;
    private TextView tvGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        movie = getIntent().getParcelableExtra("model");
        assert movie != null;
        tvJudul.setText(movie.getJudul());
        tvDeskripsi.setText(movie.getDeskripsi());
        tvTanggalrilis.setText(movie.getTanggalRilis());
        tvGenre.setText(movie.getGenre());
        Glide.with(this)
                .load(movie.getGambar())
                .into(ivGambar);

    }

    private void initView() {
        //Deklarasi
        tvJudul = findViewById(R.id.tv_title);
        ivGambar = findViewById(R.id.iv_image);
        tvDeskripsi = findViewById(R.id.tv_description);
        tvTanggalrilis = findViewById(R.id.tv_release_date);
        tvGenre = findViewById(R.id.tv_genre);
    }
}
