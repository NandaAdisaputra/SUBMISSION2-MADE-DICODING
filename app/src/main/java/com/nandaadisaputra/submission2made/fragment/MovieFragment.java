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
import com.nandaadisaputra.submission2made.activity.DetailActivityMovie;
import com.nandaadisaputra.submission2made.adapter.MovieAdapter;
import com.nandaadisaputra.submission2made.model.Movie;
import com.nandaadisaputra.submission2made.presenter.CollectionInterfaceMovie;

import java.util.ArrayList;

public class MovieFragment extends Fragment implements CollectionInterfaceMovie {
    //Deklarasi Variable
    private TypedArray dataGambar;
    private String[] dataJudul;
    private String[] dataDeskripsi;
    private String[] dataTanggal;
    private String[] dataGenre;
    //Inisialisasi data yang akan digunakan
    private ArrayList<Movie> nmovie;
    private MovieAdapter adapter;
    //deklarasi variabel reyclerview
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie, container, false);
        prepare();
        addItem();
        //menampilkan reyclerview yang ada pada file layout dengan id n_movie
        mRecyclerView = rootView.findViewById(R.id.n_movie);
        adapter = new MovieAdapter(nmovie, getActivity(), this);
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
        nmovie = new ArrayList<>();

        for (int i = 0; i < dataJudul.length; i++) {
            Movie movie = new Movie();
            movie.setGambar(dataGambar.getResourceId(i, -1));
            movie.setJudul(dataJudul[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            movie.setTanggalRilis(dataTanggal[i]);
            movie.setGenre(dataGenre[i]);
            nmovie.add(movie);
        }
    }


    private void prepare() {
        //Ambil data picture dari array data gambar di Strings
        dataGambar = getResources().obtainTypedArray(R.array.image_data);
        //Ambil data text dari array di Strings
        dataJudul = getResources().getStringArray(R.array.title_data);
        dataDeskripsi = getResources().getStringArray(R.array.data_description);
        dataTanggal = getResources().getStringArray(R.array.release_date_data);
        dataGenre = getResources().getStringArray(R.array.genre_data);
    }

    //intent dengan interface
    @Override
    public void intentToDetail(Movie movie) {
        Intent intent = new Intent(getActivity(), DetailActivityMovie.class);
        intent.putExtra("model", movie);
        startActivity(intent);
    }

    public interface OnFragmentInteractionListener {
    }
}
