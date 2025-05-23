// model/BeliTransaksi.java
package model;

import controller.Perpustakaan;

public class BeliTransaksi implements Transaksi {
    private Perpustakaan perpustakaan;
    private String judul;
    private int jumlah;

    public BeliTransaksi(Perpustakaan perpustakaan, String judul, int jumlah) {
        this.perpustakaan = perpustakaan;
        this.judul = judul;
        this.jumlah = jumlah;
    }

    @Override
    public void proses() {
        perpustakaan.beliBuku(judul, jumlah);
    }
}
