package com.nandaadisaputra.submission2made.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nandaadisaputra.submission2made.R;
import com.nandaadisaputra.submission2made.activity.DetailActivityTv;
import com.nandaadisaputra.submission2made.adapter.TvAdapter;
import com.nandaadisaputra.submission2made.model.Tv;
import com.nandaadisaputra.submission2made.presenter.CollectionInterfaceTv;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment implements CollectionInterfaceTv {
    //Deklarasi Variable
    private TypedArray dataImg;
    private String[] dataNama;
    private String[] dataDesc;
    //Inisialisasi data yang akan digunakan
    private ArrayList<Tv> ntv;
    private TvAdapter adapter;
    //deklarasi variabel reyclerview
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tv, container, false);
        prepare();
        addItem();
        //menampilkan reyclerview yang ada pada file layout dengan id n_movie
        mRecyclerView = rootView.findViewById(R.id.n_tv);
        adapter = new TvAdapter(ntv, getActivity(), this);
        //menset setukuran
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        //membuat adapter baru untuk reyclerview
        mRecyclerView.setAdapter(adapter);
        //menset nilai dari adapter
        mRecyclerView.setHasFixedSize(true);

        return rootView;
    }

    private void addItem() {
        //Inisialisasi ArrayList
        ntv = new ArrayList<>();

        for (int i = 0; i < dataNama.length; i++) {
            Tv tv = new Tv();
            tv.setImg(dataImg.getResourceId(i, -1));
            tv.setNama(dataNama[i]);
            tv.setDesc(dataDesc[i]);
            ntv.add(tv);
        }
    }


    private void prepare() {
        //Ambil data picture dari array data gambar di Strings
        dataImg = getResources().obtainTypedArray(R.array.data_img);
        //Ambil data text dari array di Strings
        dataNama = getResources().getStringArray(R.array.name_data);
        dataDesc = getResources().getStringArray(R.array.data_desc);
    }

    //intent dengan interface
    @Override
    public void intentToDetail(Tv tv) {
        Intent intent = new Intent(getActivity(), DetailActivityTv.class);
        intent.putExtra("model", tv);
        startActivity(intent);
    }

    public interface OnFragmentInteractionListener {
    }
}
