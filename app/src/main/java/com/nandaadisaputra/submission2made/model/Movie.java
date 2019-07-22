package com.nandaadisaputra.submission2made.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    //Deklarasi Variable
    private int gambar;
    private String judul, deskripsi, tanggalRilis, genre;

    public Movie() {
    }

    private Movie(Parcel in) {
        gambar = in.readInt();
        judul = in.readString();
        deskripsi = in.readString();
        tanggalRilis = in.readString();
        genre = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(gambar);
        dest.writeString(judul);
        dest.writeString(deskripsi);
        dest.writeString(tanggalRilis);
        dest.writeString(genre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTanggalRilis() {
        return tanggalRilis;
    }

    public void setTanggalRilis(String tanggalRilis) {
        this.tanggalRilis = tanggalRilis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
