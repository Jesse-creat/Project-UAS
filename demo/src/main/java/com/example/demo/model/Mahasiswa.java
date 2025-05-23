package com.example.demo.model;

public class Mahasiswa {
    public Mahasiswa() {
    }    
    private Long id;
    private String nama;
    private Jurusan jurusan;

    // Constructor yang diperlukan
    public Mahasiswa(long id, String nama, Jurusan jurusan) {
        this.id = id;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    // Setter jika dibutuhkan
    public void setId(long id) {
        this.id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }
}
