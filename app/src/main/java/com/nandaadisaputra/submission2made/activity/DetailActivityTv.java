package com.nandaadisaputra.submission2made.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nandaadisaputra.submission2made.R;
import com.nandaadisaputra.submission2made.model.Tv;

public class DetailActivityTv extends AppCompatActivity {
    //Deklarasi View yang akan digunakan
    Tv tv;
    private TextView tvNama;
    private ImageView ivImg;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);
        initView();
        tv = getIntent().getParcelableExtra("model");
        assert tv != null;
        tvNama.setText(tv.getNama());
        tvDesc.setText(tv.getDesc());
        Glide.with(this)
                .load(tv.getImg())
                .into(ivImg);

    }

    private void initView() {
        //Deklarasi
        tvNama = findViewById(R.id.tv_name);
        ivImg = findViewById(R.id.iv_img);
        tvDesc = findViewById(R.id.tv_desc);
    }
}
