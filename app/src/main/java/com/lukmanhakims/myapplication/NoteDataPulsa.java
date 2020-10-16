package com.lukmanhakims.myapplication;

public class NoteDataPulsa {

    private String nama, jumlah, deskripsi_status;

    public NoteDataPulsa(String nama, String jumlah, String deskripsi_status) {
        this.nama= nama;
        this.jumlah = jumlah;
        this.deskripsi_status= deskripsi_status;

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getDeskripsi_status() {
        return deskripsi_status;
    }

    public void setDeskripsi_status(String deskripsi_status) {
        this.deskripsi_status = deskripsi_status;
    }

}
